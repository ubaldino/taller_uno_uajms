const FREQ=10;

let resources={
	models:{
		users:{}
	}
  , templates:{
  		users:{
  			base:'/public/templates/users/index.html'
  		  , view:[]
		  , modals:{
				base:{
				    modal_user_create:'/public/templates/users/components/modal_user_create.html'
				  , modal_user_modify:'/public/templates/users/components/modal_user_modify.html'
				  , modal_user_enable:'/public/templates/users/components/modal_user_enable.html'
				  , modal_user_disable:'/public/templates/users/components/modal_user_disable.html'
				  , modal_user_delete:'/public/templates/users/components/modal_user_delete.html'
				  , modal_user_assign_login:'/public/templates/users/components/modal_user_assign_login.html'
				  , modal_user_modify_login:'/public/templates/users/components/modal_user_modify_login.html'
				}
			}
  		}
  	}
}

//VALIDATORS
let validators={
	assignLogin:(data)=>{
		return data.get('login').match(/\w{3,}/)
		&&data.get('password').match(/\w{3,}/)
		&&data.get('password')==data.get('retype_password')
	}
}

//OBSERVERS
watch(resources.models.users,'data', function(){
	render_users_list();
	console.log("resources.models.users.data changed!");
});

// FUNCTIONS
get_component=()=>{
	return new Promise((rs,rj)=>{
		getTextPlain(resources.templates.users.base,(err,data)=>{
			if(err)rj(err)
			else{
				resources.templates.users.base=Handlebars.compile(data.trim())
				rs()
			}
		})
	})	
}

get_all_components=()=>{
	return new Promise((rs,rj)=>{
		Promise.all(
			Object.keys(resources.templates.users.modals.base).map(e=>{
				return new Promise((rs2,rj2)=>{
					getTextPlain(resources.templates.users.modals.base[e],(err,data)=>{
						if(err)rj2(err)
						else{
							Handlebars.registerPartial(e,data.trim());
							resources.templates.users.modals.base[e]=Handlebars.compile(data.trim())
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
			console.log(data)
			resources.models.users.data=(err)?undefined:data
			resources.models.users.data=(err)?undefined:data
			resources.models.users.pagination={length:Math.ceil(resources.models.users.data.length/FREQ)}
			rs(data)
		})
	})
}

prepare_view=()=>{
	return new Promise((rs,rj)=>{
		resources.templates.users.view=resources.models.users.data.map(e=>resources.templates.users.base(e))
		rs();
	})
}




// EVENTS
enableDisableForm=(t)=>{
	sendPost(new FormData(),t.dataset.url,(err,data)=>fetch_users().then())
	$(t.dataset.parent).modal('hide');
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
	else{
		alert("revise los campos llenados")
	}
	return false;
}

render_users_list=()=>{
	prepare_view().then(()=>{
		document.querySelector("table#users tbody").innerHTML=[
			resources.templates.users.view.join('')
		].join('');
		document.getElementById('modals').innerHTML=resources.templates.users.modals.base.modal_user_create;
	})
}
main=()=>{
	get_component().then(get_all_components).then(fetch_users).then(()=>{})
}