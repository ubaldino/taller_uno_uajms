const FREQ=10;

let resources={
	models:{
		users:{
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
  		users:{
			base:{
			    index:'/public/templates/users/index.html'
			  , pagination:'/public/templates/helpers/pagination.html'
			  , modal_user_modify:'/public/templates/users/components/modal_user_modify.html'
			  , modal_user_enable:'/public/templates/users/components/modal_user_enable.html'
			  , modal_user_disable:'/public/templates/users/components/modal_user_disable.html'
			  , modal_user_delete:'/public/templates/users/components/modal_user_delete.html'
			  , modal_user_assign_login:'/public/templates/users/components/modal_user_assign_login.html'
			  , modal_user_modify_login:'/public/templates/users/components/modal_user_modify_login.html'
			}
		  , view:{}
  		}
  	}
  , filter:{
  		keywords:{
  			state:-1
  		  , profile_type:-1
  		  , search:''
  		}
  	}
}

//OBSERVERS
watch(resources.models.users.pagination,'active', function(){
    resources.models.users.pagination.begin=(
        resources.models.users.pagination.active*resources.models.users.pagination.freq
    )-resources.models.users.pagination.freq
    resources.models.users.pagination.end=(
        resources.models.users.pagination.active*resources.models.users.pagination.freq
    )-1
    render_users_list()
    //resources.models.users.view=resources.models.users.data
    console.log("resources.models.users.pagination.active changed!");
});
watch(resources.models.users,'data', function(){
	resources.models.users.view=resources.models.users.data
	console.log("resources.models.users.data changed!");
});
watch(resources.models.users,'view', function(){
    resources.models.users.pagination.length=
    Math.ceil(resources.models.users.view.length/resources.models.users.pagination.freq)
    resources.models.users.pagination.begin=0
    resources.models.users.pagination.end=resources.models.users.pagination.freq-1
    resources.models.users.pagination.active=1
    // new Array().fill(0).map((v,i)=>i+1)
	render_users_list();
	console.log("resources.models.users.view changed!");
});
watch(resources.filter,'keywords', function(){
	console.log('resources.filter.keywords changed!');
	console.log( resources.filter.keywords );
	let filter_result;
	if(resources.filter.keywords.search=='')
		filter_result=resources.models.users.data;
	else
		filter_result=resources.models.users.data.filter(e=>{
			return 3+(
				e.nombre.toLowerCase().indexOf(resources.filter.keywords.search)
			   +e.ap.toLowerCase().indexOf(resources.filter.keywords.search)
			   +e.am.toLowerCase().indexOf(resources.filter.keywords.search)
			)
		})
	if(resources.filter.keywords.profile_type!=-1)
		filter_result=filter_result.filter(e=>e.tipo==resources.filter.keywords.profile_type)
	if(resources.filter.keywords.state!=-1)
		filter_result=filter_result.filter(e=>e.estado==resources.filter.keywords.state)
	resources.models.users.view=filter_result;
    console.log("resources.filter.keywords changed!");
});

//VALIDATORS
let validators={
	assignLogin:(data)=>{
		return data.get('login').match(/\w{3,}/)
		&&data.get('password').match(/\w{3,}/)&&data.get('password')==data.get('retype_password')
	}
}

// FUNCTIONS
get_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.users.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.users.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							if(e!='index') Handlebars.registerPartial(e,data.trim());
							else resources.templates.users.base[e]=Handlebars.compile(data.trim())
							rs2()
						}
					})
				})
			})
		).then(rs).catch(rj);
	})
}

fetch_users=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/api/users/',(err,data)=>{
			if(err)rj(err)
			resources.models.users.data=(err)?undefined:data
			rs()
		})
	})
}

// EVENTS
selectPagination=(t)=>{
    resources.models.users.pagination.active=parseInt(t.firstElementChild.dataset.index);
    document.querySelectorAll("nav#pagination ul li.item-pag").forEach(e=>e.classList.remove('active'))
    t.classList.add('active')
}
filterSearch=(t)=>resources.filter.keywords.search=t.value
filterState=(t)=>resources.filter.keywords.state=t.value
filterProfileType=(t)=>resources.filter.keywords.profile_type=t.value

enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_users().then())
	$(t.dataset.parent).modal('hide');
}

submitModifyLogin=(t)=>{
    let data=new FormData()
      , url=t.dataset.url
    let el=document.getElementById('login_modify_'+t.dataset.id);
    data.append('login',el.querySelector("input[name=login]").value);
    data.append('password',el.querySelector("input[name=password]").value);
    data.append('retype_password',el.querySelector("input[name=retype_password]").value);
    if(validators.assignLogin(data)){
        sendPost(data,url,(err,data)=>fetch_users().then()) 
        $(el).modal('hide')
    }
    else
        alert("revise los campos llenados")
    return false;
}


submitAssignLogin=(t)=>{
	let data=new FormData()
	  , url=t.dataset.url
	let el=document.getElementById('login_assign_'+t.dataset.id);
	data.append('login',el.querySelector("input[name=login]").value);
	data.append('password',el.querySelector("input[name=password]").value);
	data.append('retype_password',el.querySelector("input[name=retype_password]").value);
	if(validators.assignLogin(data)){
		sendPost(data,url,(err,data)=>fetch_users().then())	
		$(el).modal('hide')
	}
	else
		alert("revise los campos llenados")
}

render_users_list=()=>{
	document.querySelector(".col-md-12#index_handlebars").innerHTML=
	resources.templates.users.base.index({
        profiles:resources.models.users.view.slice(
            resources.models.users.pagination.begin,resources.models.users.pagination.end
        )
      , pagination:resources.models.users.pagination
    });
    if(document.querySelectorAll("nav#pagination ul li.item-pag").length)
        document.querySelectorAll("nav#pagination ul li.item-pag")
        [resources.models.users.pagination.active-1].classList.add('active')
}
main=()=>{
	get_all_components().then(fetch_users).then(()=>{})
}
