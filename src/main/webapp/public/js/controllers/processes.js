const FREQ=10
	, base_templates='/public/templates/processes'

let resources={
	models:{
		processes:{
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
  		processes:{
			base:{
			    index:base_templates+'/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_process_modify:base_templates+'/components/modal_process_modify.html'
			  , modal_process_enable:base_templates+'/components/modal_process_enable.html'
			  , modal_process_disable:base_templates+'/components/modal_process_disable.html'
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
watch(resources.models.processes.pagination,'active', function(){
    resources.models.processes.pagination.begin=(
        resources.models.processes.pagination.active*resources.models.processes.pagination.freq
    )-resources.models.processes.pagination.freq
    resources.models.processes.pagination.end=(
        resources.models.processes.pagination.active*resources.models.processes.pagination.freq
    )-1
    render_processes_list()
    //resources.models.processes.view=resources.models.processes.data
    console.log("resources.models.processes.pagination.active changed!");
});
watch(resources.models.processes,'data', function(){
	resources.models.processes.view=resources.models.processes.data
	console.log("resources.models.processes.data changed!");
});
watch(resources.models.processes,'view', function(){
    resources.models.processes.pagination.length=
    Math.ceil(resources.models.processes.view.length/resources.models.processes.pagination.freq)
    resources.models.processes.pagination.begin=0
    resources.models.processes.pagination.end=resources.models.processes.pagination.freq-1
    resources.models.processes.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_processes_list();
	console.log("resources.models.processes.view changed!");
});
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.processes.data;
	else
		filter_result=resources.models.processes.data.filter(
			e=>1+e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
		)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.processes.view=filter_result;
    console.log("resources.filter.keywords changed!");
});

//VALIDATORS
let validators={
	roleUpdate:(data)=>data.get('nombre').match(/\w{3,}/)
}
// FUNCTIONS
get_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.processes.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.processes.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.processes.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

fetch_processes=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/processes/single',(err,data)=>{
			if(err)rj(err)
			resources.models.processes.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS
selectPagination=(t)=>{
    resources.models.processes.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
    t.classList.add('active')
}
submitUpdateRole=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('role_modify_'+t.dataset.id);
    data.append('nombre',el.querySelector("input[name=nombre]").value);
    if(validators.roleUpdate(data)){
        sendPost(data,url,(err,data)=>fetch_processes().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
}
//FILTERS
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterProcessesState=(t)=>resources.filter.keywords.state=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_processes().then())
	$(t.dataset.parent).modal('hide');
}
//RENDERS
render_processes_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.processes.base.index({
        processes:resources.models.processes.view.slice(
            resources.models.processes.pagination.begin,resources.models.processes.pagination.end
        )
      , pagination:resources.models.processes.pagination
    });
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.processes.pagination.active-1].classList.add('active')
}
main=()=>get_all_components().then(fetch_processes).then()
