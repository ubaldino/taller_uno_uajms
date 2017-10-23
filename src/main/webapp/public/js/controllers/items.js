const FREQ=10
	, base_templates='/public/templates/items'

let resources={
	models:{
		items:{
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
  		items:{
			base:{
			    index:base_templates+'/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_item_modify:base_templates+'/components/modal_item_modify.html'
			  , modal_item_enable:base_templates+'/components/modal_item_enable.html'
			  , modal_item_disable:base_templates+'/components/modal_item_disable.html'
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
watch(resources.models.items.pagination,'active', function(){
    resources.models.items.pagination.begin=(
        resources.models.items.pagination.active*resources.models.items.pagination.freq
    )-resources.models.items.pagination.freq
    resources.models.items.pagination.end=(
        resources.models.items.pagination.active*resources.models.items.pagination.freq
    )-1
    render_items_list()
    //resources.models.items.view=resources.models.items.data
    console.log("resources.models.items.pagination.active changed!");
});
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
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.items.data;
	else
		filter_result=resources.models.items.data.filter(
			e=>1+e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
		)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.items.view=filter_result;
    console.log("resources.filter.keywords changed!");
});

//VALIDATORS
let validators={
	itemUpdate:(data)=>data.get('nombre').match(/\w{3,}/)
}
// FUNCTIONS
get_all_components=()=>{
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
selectPagination=(t)=>{
    resources.models.items.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
    t.classList.add('active')
}
submitUpdateItem=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('item_modify_'+t.dataset.id);
    data.append('nombre',el.querySelector("input[name=nombre]").value);
    if(validators.itemUpdate(data)){
        sendPost(data,url,(err,data)=>fetch_items().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
}
//FILTERS
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterItemsState=(t)=>resources.filter.keywords.state=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_items().then())
	$(t.dataset.parent).modal('hide');
}
//RENDERS
render_items_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.items.base.index({
        items:resources.models.items.view.slice(
            resources.models.items.pagination.begin,resources.models.items.pagination.end
        )
      , pagination:resources.models.items.pagination
    });
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.items.pagination.active-1].classList.add('active')
}
main=()=>get_all_components().then(fetch_items).then()
