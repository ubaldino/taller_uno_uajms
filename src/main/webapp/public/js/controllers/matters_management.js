const FREQ=5
	, base_templates='/public/templates/matters'

let resources={
	models:{
		matters:{
			data:{}
		  , view:{} 
          , pagination:{
                freq:FREQ
              , begin:0
              , end:FREQ-1
              , active:1
              , length:-1
            }
		}
	  , items:{
			data:{}
		  , view:{} 
          , pagination:{
                freq:FREQ
              , begin:0
              , end:FREQ-1
              , active:1
              , length:-1
            }
		}
	}
  , templates:{
  		matters:{
			base:{
			    index:base_templates+'/index_management.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_matter_modify:base_templates+'/components/modal_matter_modify.html'
			  , modal_matter_enable:base_templates+'/components/modal_matter_enable.html'
			  , modal_matter_disable:base_templates+'/components/modal_matter_disable.html'
			}
		  , view:{}
		  , el:'.col-md-12#index_handlebars'
  		}
      , items:{
			base:{
			    index:'/public/templates/items/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_item_modify:'/public/templates/items/components/modal_item_modify.html'
			  , modal_item_enable:'/public/templates/items/components/modal_item_enable.html'
			  , modal_item_disable:'/public/templates/items/components/modal_item_disable.html'
			}
		  , view:{}
		  , el:'.col-md-12#index_handlebars_assign'
  		}
  	}
  , filter:{
  		keywords:{
  			state:-1
  		  , search:''
  		}
  	}
}

//OBSERVERS
watch(resources.models.matters.pagination,'active', function(){
    resources.models.matters.pagination.begin=(
        resources.models.matters.pagination.active*resources.models.matters.pagination.freq
    )-resources.models.matters.pagination.freq
    resources.models.matters.pagination.end=(
        resources.models.matters.pagination.active*resources.models.matters.pagination.freq
    )-1
    render_matters_list()
    //resources.models.matters.view=resources.models.matters.data
    console.log("resources.models.matters.pagination.active changed!");
});
watch(resources.models.matters,'data', function(){
	resources.models.matters.view=resources.models.matters.data
	console.log("resources.models.matters.data changed!");
});
watch(resources.models.matters,'view', function(){
    resources.models.matters.pagination.length=
    Math.ceil(resources.models.matters.view.length/resources.models.matters.pagination.freq)
    resources.models.matters.pagination.begin=0
    resources.models.matters.pagination.end=resources.models.matters.pagination.freq-1
    resources.models.matters.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_matters_list();
	console.log("resources.models.matters.view changed!");
});
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.matters.data;
	else
		filter_result=resources.models.matters.data.filter(
			e=>1+e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
		)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.matters.view=filter_result;
    console.log("resources.filter.keywords changed!");
});
// --- watch items
watch(resources.models.items,'data', function(){
	resources.models.items.view=resources.models.items.data
	console.log("resources.models.items.data changed!");
});
watch(resources.models.items,'view', function(){
    resources.models.items.pagination.length=
    Math.ceil(resources.models.items.view.length/resources.models.items.pagination.freq)
    resources.models.items.pagination.begin=0
    resources.models.items.pagination.end=resources.models.items.pagination.freq-1
    resources.models.items.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_items_list();
	console.log("resources.models.items.view changed!");
});

//VALIDATORS
let validators={
	matterUpdate:(data)=>data.get('nombre').match(/\w{3,}/)&&data.get('codigo').match(/\w{3,}/)
}
// FUNCTIONS
get_matters_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.matters.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.matters.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.matters.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

get_items_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.items.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.items.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.items.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

fetch_matters=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/matters',(err,data)=>{
			if(err)rj(err)
			resources.models.matters.data=(err)?undefined:data
			rs()
		})
	})
}

fetch_items=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/items/single',(err,data)=>{
			if(err)rj(err)
			resources.models.items.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS


selectViewManagement=(t)=>{
	console.log(t.value);
	document.querySelector(".col-md-12#index_handlebars_assign").innerHTML='';
	let cmd=t.value.split('::');
	if (cmd[0]=='items') {
		resources.models.items.view=resources.models.matters.view.filter((e)=>{
			return e.codm==cmd[1];
		})[0].items||[]
		render_items_list()
	}
}

selectPagination=(t)=>{
	t.parentElement.querySelectorAll("li.item-pag").forEach(e=>e.classList.remove('active'))
	console.log(t.parentElement.parentElement.id);
	
	if (t.parentElement.parentElement.id.indexOf('matters')>-1) {
	    resources.models.matters.pagination.active=parseInt(t.firstElementChild.dataset.index);
	    console.log('naters')
	}
	else{
	    console.log('items')
		resources.models.items.pagination.active=parseInt(t.firstElementChild.dataset.index);
	}
	t.classList.add('active')
}
submitUpdateMatter=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('matter_modify_'+t.dataset.id);
    data.append('codigo',el.querySelector("input[name=codigo]").value);
    data.append('nombre',el.querySelector("input[name=nombre]").value);
    if(validators.matterUpdate(data)){
        sendPost(data,url,(err,data)=>fetch_matters().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
}
//FILTERS
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterMattersState=(t)=>resources.filter.keywords.state=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_matters().then())
	$(t.dataset.parent).modal('hide');
}
//RENDERS
render_matters_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.matters.base.index({
        matters:resources.models.matters.view.slice(
            resources.models.matters.pagination.begin,resources.models.matters.pagination.end
        )
      , pagination:resources.models.matters.pagination
    });
    if(document.querySelectorAll("nav#pagination_matters ul li.item-pag").length)
        document.querySelectorAll("nav#pagination_matters ul li.item-pag")
        [resources.models.matters.pagination.active-1].classList.add('active')
}

render_items_list=()=>{
	document.querySelector(resources.templates.items.el)
	.innerHTML=resources.templates.items.base.index({
        items:resources.models.items.view.slice(
            resources.models.items.pagination.begin,resources.models.items.pagination.end
        )
      , pagination:resources.models.items.pagination
    });
    if(document.querySelectorAll("nav#pagination_items ul li.item-pag").length)
        document.querySelectorAll("nav#pagination_items ul li.item-pag")
        [resources.models.items.pagination.active-1].classList.add('active')
}


main=()=>get_matters_all_components().then(get_items_all_components)
		.then(fetch_matters).then(fetch_items).then().catch(err=>console.log(err))
