const FREQ=10;
let args={menues:{},processes:{}}

fetch_only_processes=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/procesos/api/single',(err,data)=>{
			if(err)rj(err)
			args.processes.data=(err)?undefined:data
			args.processes.data=(err)?undefined:data
			args.processes.pagination={length:Math.ceil(args.processes.data.length/FREQ)}
			rs(data)
		})
	})
}
fetch_menues=()=>{
	return new Promise((rs,rj)=>{
		getJSON('/menus/api',(err,data)=>{
			if(err)rj(err)
			args.menues.data=(err)?undefined:data
			args.menues.pagination={length:Math.ceil(args.menues.data.length/FREQ)}
			rs()	
		})
	})
}
onchangeProcesses=(t)=>{
	if(document.querySelector("input[name='menu']:checked")){
    	let data=new FormData();
		data.append('codm',document.querySelector("input[name='menu']:checked").value);
		data.append('codp',t.value);
		let url=t.checked?'/menus/api/proceso/assign':'/menus/api/proceso/delete';
    	sendPost(data,url,(err,data)=>{
    		fetch_menues().then(fetch_only_processes).then(()=>{
    			console.log("data: UPDATED")
    		})
		})
	}
}
onchangeMenu=(t)=>{
	let selected_menu=args.menues.data.filter(e=>e.codm==t.value)[0]||{};
	if (selected_menu.procesos) {
		selected_menu.procesos=selected_menu.procesos.map(e=>{e.checked='checked';return e;})
		args.processes.current.data=selected_menu.procesos.concat(args.processes.data).reduce((p,c)=>{
			if(!p.filter(e=>e.codp==c.codp).length)
				p.push(c);
			return p;
		},[])
	}
	else{
		args.processes.current.data=args.processes.data;
	}
	args.processes.current.tpl=args.processes.current.data.slice(0,FREQ).map(t=>{
		return `<tr><td><input onchange="onchangeProcesses(this);" type="checkbox" name="procesos" value="${t.codp}" ${t.checked}></td><td>${t.nombre}</td></tr>`
	}).join('\n')
	document.querySelector("nav#nav_procesos li.page-item.active").classList.remove('active')
	document.querySelectorAll("nav#nav_procesos li.page-item")[1].classList.add('active')
	document.querySelector("tbody#table_procesos").innerHTML=args.processes.current.tpl;
}

onclickNavManager=(t)=>{
	let index=undefined;
	if(t.firstElementChild.getAttribute('href')=='#P'){
		let current=t.parentElement.querySelector("li.page-item.active")
	  	  , previous=current.previousElementSibling;
		if(!previous.classList.contains('nav')){
			current.classList.remove('active');
			previous.classList.add('active');
			index=parseInt(previous.firstElementChild.getAttribute('href').replace('#',''))
		}
	}
	else if(t.firstElementChild.getAttribute('href')=='#N'){
		let current=t.parentElement.querySelector("li.page-item.active")
	  	  , next=current.nextElementSibling;
		if(!next.classList.contains('nav')){
			current.classList.remove('active');
			next.classList.add('active');
			index=parseInt(next.firstElementChild.getAttribute('href').replace('#',''))
		}
	}
	if(index){
		let min=(index*FREQ)-FREQ
		  , max=(index*FREQ)-1;
		args.processes.current.tpl=args.processes.current.data.slice(min,max).map(t=>{
			return `<tr><td><input onchange="onchangeProcesses(this);" type="checkbox" name="procesos" value="${t.codp}"></td><td>${t.nombre}</td></tr>`
		})
		args.processes.current.tpl=args.processes.current.tpl
		.concat(new Array(FREQ-args.processes.current.tpl.length).fill('<tr><td><pre></pre></td><td><pre></pre></td></tr>'))
		
		document.querySelector("tbody#table_procesos").innerHTML=args.processes.current.tpl.join('\n');
	}
}

render_menu_list=()=>{
	//fetch data
	fetch_menues()
	.then(fetch_only_processes)
	//prepare object data
	.then(()=>{
		return new Promise((rs,rj)=>{
			args.menues.current={}
			args.menues.current.tpl=args.menues.data.map(t=>{
				return `<tr><td>
					<input type="radio" name="menu" value="${t.codm}" onchange="onchangeMenu(this);">
				</td><td>${t.nombre}</td></tr>`
			})
			args.menues.current.tpl=args.menues.current.tpl
			.concat(new Array(FREQ-args.menues.current.tpl.length).fill('<tr><td><pre></pre></td><td><pre></pre></td></tr>'))
			let active='active';
			args.menues.pagination.tpl=Array(args.menues.pagination.length).fill().map((v,i)=>i+1).map(t=>{
				t=`<li class="page-item ${active}" ><a class="page-link" href="#${t}">${t}</a></li>`
				active='';
				return t;
			}).join('\n')
			rs()
		}) 
	})
	.then(()=>{
		return new Promise((rs,rj)=>{
			args.processes.current={}
			args.processes.current.data=args.processes.data;
			args.processes.current.tpl=args.processes.data.slice(0,FREQ).map(t=>{
				return `<tr><td><input onchange="onchangeProcesses(this);" type="checkbox" name="procesos" value="${t.codp}"></td><td>${t.nombre}</td></tr>`
			})
			args.processes.current.tpl=args.processes.current.tpl
			.concat(new Array(FREQ-args.processes.current.tpl.length).fill('<tr><td><pre></pre></td><td><pre></pre></td></tr>'))
			let active='active';
			args.processes.pagination.tpl=Array(args.processes.pagination.length).fill().map((v,i)=>i+1).map(t=>{
				t=`<li class="page-item ${active}"><a class="page-link" href="#${t}">${t}</a></li>`;
				active='';
				return t;
			}).join('\n')
			rs()

		}) 
	})
	//render templates
	.then(()=>{
		let current_tpl=args.menues.current.tpl.join('\n');
		let template=`
		<table class="table table-bordered table-striped">
		  <thead>
		    <tr>
		      <th style="width:10%">#</th>
		      <th style="width:60%">Lista de menus</th>
		    </tr>
		  </thead>
		  <tbody> 
		 	${current_tpl}
		  </tbody>  
		</table>
		<div class="col-md-6">
		  <nav aria-label="Page navigation">
		    <ul class="pagination">
		      <li class="page-item nav" onclick="onclickNavManager(this);">
		        <a class="page-link" href="#P" aria-label="Previous">
		          <span aria-hidden="true">&laquo;</span>
		          <span class="sr-only">Previous</span>
		        </a>
		      </li>
		      ${args.menues.pagination.tpl}
		      <li class="page-item nav" onclick="onclickNavManager(this);">
		        <a class="page-link" href="#N" aria-label="Next">
		          <span aria-hidden="true">&raquo;</span>
		          <span class="sr-only">Next</span>
		        </a>
		      </li>
		    </ul>
		  </nav>
		</div>
		`;
		document.querySelector(".table-responsive#menues").innerHTML=template;

		current_tpl=args.processes.current.tpl.join('\n');
		template=`
		<table class="table table-bordered table-striped">
		  <thead>
		    <tr>
		      <th style="width:10%">#</th>
		      <th style="width:60%">Lista de procesos</th>
		    </tr>
		  </thead>
		  <tbody id="table_procesos">
		    ${current_tpl}
		  </tbody>  
		</table>
		<div class="col-md-6">
		  <nav aria-label="Page navigation" id="nav_procesos">
		    <ul class="pagination">
		      <li class="page-item nav" onclick="onclickNavManager(this);">
		        <a class="page-link" href="#P" aria-label="Previous">
		          <span aria-hidden="true">&laquo;</span>
		          <span class="sr-only">Previous</span>
		        </a>
		      </li>
		      ${args.processes.pagination.tpl}
		      <li class="page-item nav" onclick="onclickNavManager(this);">
		        <a class="page-link" href="#N" aria-label="Next">
		          <span aria-hidden="true">&raquo;</span>
		          <span class="sr-only">Next</span>
		        </a>
		      </li>
		    </ul>
		  </nav>
		</div>
		`;
		document.querySelector(".table-responsive#procesos").innerHTML=template;
	})
}
