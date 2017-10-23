const FREQ=10
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
	}
  , templates:{
  		matters:{
			base:{
			    index:base_templates+'/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_matter_modify:base_templates+'/components/modal_matter_modify.html'
			  , modal_matter_enable:base_templates+'/components/modal_matter_enable.html'
			  , modal_matter_disable:base_templates+'/components/modal_matter_disable.html'
			}
		  , view:{}
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

//VALIDATORS
let validators={
	matterUpdate:(data)=>data.get('nombre').match(/\w{3,}/)&&data.get('codigo').match(/\w{3,}/)
}
// FUNCTIONS
get_all_components=()=>{
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

fetch_matters=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/matters/single',(err,data)=>{
			if(err)rj(err)
			resources.models.matters.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS
selectPagination=(t)=>{
    resources.models.matters.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
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
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.matters.pagination.active-1].classList.add('active')
}
main=()=>get_all_components().then(fetch_matters).then()
