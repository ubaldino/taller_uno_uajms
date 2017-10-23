const FREQ=10
	, base_templates='/public/templates/parallels'

let resources={
	models:{
		parallels:{
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
  		parallels:{
			base:{
			    index:base_templates+'/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_parallel_modify:base_templates+'/components/modal_parallel_modify.html'
			  , modal_parallel_enable:base_templates+'/components/modal_parallel_enable.html'
			  , modal_parallel_disable:base_templates+'/components/modal_parallel_disable.html'
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
watch(resources.models.parallels.pagination,'active', function(){
    resources.models.parallels.pagination.begin=(
        resources.models.parallels.pagination.active*resources.models.parallels.pagination.freq
    )-resources.models.parallels.pagination.freq
    resources.models.parallels.pagination.end=(
        resources.models.parallels.pagination.active*resources.models.parallels.pagination.freq
    )-1
    render_parallels_list()
    //resources.models.parallels.view=resources.models.parallels.data
    console.log("resources.models.parallels.pagination.active changed!");
});
watch(resources.models.parallels,'data', function(){
	resources.models.parallels.view=resources.models.parallels.data
	console.log("resources.models.parallels.data changed!");
});
watch(resources.models.parallels,'view', function(){
    resources.models.parallels.pagination.length=
    Math.ceil(resources.models.parallels.view.length/resources.models.parallels.pagination.freq)
    resources.models.parallels.pagination.begin=0
    resources.models.parallels.pagination.end=resources.models.parallels.pagination.freq-1
    resources.models.parallels.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_parallels_list();
	console.log("resources.models.parallels.view changed!");
});
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.parallels.data;
	else
		filter_result=resources.models.parallels.data.filter(
			e=>1+e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
		)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.parallels.view=filter_result;
    console.log("resources.filter.keywords changed!");
});

//VALIDATORS
let validators={
	parallelUpdate:(data)=>data.get('nombre').match(/\w{3,}/)
}
// FUNCTIONS
get_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.parallels.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.parallels.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.parallels.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

fetch_parallels=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/parallels/single',(err,data)=>{
			if(err)rj(err)
			resources.models.parallels.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS
selectPagination=(t)=>{
    resources.models.parallels.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
    t.classList.add('active')
}
submitUpdateParallel=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('parallel_modify_'+t.dataset.id);
    data.append('nombre',el.querySelector("input[name=nombre]").value);
    if(validators.parallelUpdate(data)){
        sendPost(data,url,(err,data)=>fetch_parallels().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
}
//FILTERS
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterParallelsState=(t)=>resources.filter.keywords.state=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_parallels().then())
	$(t.dataset.parent).modal('hide');
}
//RENDERS
render_parallels_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.parallels.base.index({
        parallels:resources.models.parallels.view.slice(
            resources.models.parallels.pagination.begin,resources.models.parallels.pagination.end
        )
      , pagination:resources.models.parallels.pagination
    });
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.parallels.pagination.active-1].classList.add('active')
}
main=()=>get_all_components().then(fetch_parallels).then()
