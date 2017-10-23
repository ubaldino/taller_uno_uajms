const FREQ=10
	, base_templates='/public/templates/roles'

let resources={
	models:{
		roles:{
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
  		roles:{
			base:{
			    index:base_templates+'/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_role_modify:base_templates+'/components/modal_role_modify.html'
			  , modal_role_enable:base_templates+'/components/modal_role_enable.html'
			  , modal_role_disable:base_templates+'/components/modal_role_disable.html'
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
watch(resources.models.roles.pagination,'active', function(){
    resources.models.roles.pagination.begin=(
        resources.models.roles.pagination.active*resources.models.roles.pagination.freq
    )-resources.models.roles.pagination.freq
    resources.models.roles.pagination.end=(
        resources.models.roles.pagination.active*resources.models.roles.pagination.freq
    )-1
    render_roles_list()
    //resources.models.roles.view=resources.models.roles.data
    console.log("resources.models.roles.pagination.active changed!");
});
watch(resources.models.roles,'data', function(){
	resources.models.roles.view=resources.models.roles.data
	console.log("resources.models.roles.data changed!");
});
watch(resources.models.roles,'view', function(){
    resources.models.roles.pagination.length=
    Math.ceil(resources.models.roles.view.length/resources.models.roles.pagination.freq)
    resources.models.roles.pagination.begin=0
    resources.models.roles.pagination.end=resources.models.roles.pagination.freq-1
    resources.models.roles.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_roles_list();
	console.log("resources.models.roles.view changed!");
});
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.roles.data;
	else
		filter_result=resources.models.roles.data.filter(
			e=>1+e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
		)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.roles.view=filter_result;
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
			Object.keys(resources.templates.roles.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.roles.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.roles.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

fetch_roles=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/roles/single',(err,data)=>{
			if(err)rj(err)
			resources.models.roles.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS
selectPagination=(t)=>{
    resources.models.roles.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
    t.classList.add('active')
}
submitUpdateRole=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('role_modify_'+t.dataset.id);
    data.append('nombre',el.querySelector("input[name=nombre]").value);
    if(validators.roleUpdate(data)){
        sendPost(data,url,(err,data)=>fetch_roles().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
}
//FILTERS
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterRolesState=(t)=>resources.filter.keywords.state=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_roles().then())
	$(t.dataset.parent).modal('hide');
}
//RENDERS
render_roles_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.roles.base.index({
        roles:resources.models.roles.view.slice(
            resources.models.roles.pagination.begin,resources.models.roles.pagination.end
        )
      , pagination:resources.models.roles.pagination
    });
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.roles.pagination.active-1].classList.add('active')
}
main=()=>get_all_components().then(fetch_roles).then()
