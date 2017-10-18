render_menu_list=()=>{
	getJSON('/menus/api',(err,data)=>{
	    if (err != null) {
	        console.error(err);
	    } else {
	        window.menus=data;
			let pagination=Math.ceil(menus.length/10)
			let menu_list=menus.map(t=>`<tr><td><input type="radio" name="menu" value="${t.codm}"></td><td>${t.nombre}</td></tr>`).join('\n')
			procesos_list=menus.reduce((p,n)=>p.concat((n.procesos)?n.procesos:[]),[]);
			pagination=Array(pagination).fill().map((v,i)=>i+1).map(t=>`<li class="page-item"><a class="page-link" href="#${t}">${t}</a></li>`).join('\n')
			let template=`
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th style="width:10%">#</th>
			      <th style="width:60%">Lista de menus</th>
			    </tr>
			  </thead>
			  <tbody> 
			 	${menu_list}
			  </tbody>  
			</table>
			<div class="col-md-6">
			  <nav aria-label="Page navigation">
			    <ul class="pagination">
			      <li class="page-item">
			        <a class="page-link" href="#P" aria-label="Previous">
			          <span aria-hidden="true">&laquo;</span>
			          <span class="sr-only">Previous</span>
			        </a>
			      </li>
			      ${pagination}
			      <li class="page-item">
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
	    }
	    $("input[name='menu']").bind('click',(evt)=>{
	    	let menu=menus.filter(t=>t.codm==evt.target.value)[0]||{};
	    	getJSON('/procesos/api/single',(err,data)=>{
			    if (err != null) {
			        console.error(err);
			    } else {
			        all_procesos=data;
			        menu.procesos=menu.procesos.map(t=>{t.checked='checked';return t;})
			        all_procesos=menu.procesos.concat(all_procesos).reduce((p,c)=>{
						if(!p.filter(t=>t.codp==c.codp).length)
							p.push(c);
						return p;
					},[])
					all_procesos=all_procesos.map(t=>`<tr><td><input type="checkbox" name="procesos" value="${t.codp}" ${t.checked}></td><td>${t.nombre}</td></tr>`).join('\n')
					document.querySelector("tbody#table_procesos").innerHTML=all_procesos;
					$("input[name='procesos']").bind('change',(evt)=>{
						if(document.querySelector("input[name='menu']:checked")){
					    	let data=new FormData();
							data.append('codm',document.querySelector("input[name='menu']:checked").value);
							data.append('codp',evt.target.value);
							let url=evt.target.checked?'/menus/api/proceso/assign':'/menus/api/proceso/delete';

					    	sendPost(data,url,(err,data)=>{
					    		console.log(data);
							})
						}
				    })
			    }
			});
	    })
	});
}
 

render_procesos_list=()=>{
	getJSON('/procesos/api',(err,data)=>{
	    if (err != null) {
	        console.error(err);
	    } else {
	        window.procesos=data;
			let pagination=Math.ceil(procesos.length/10)
			let proceso_list=procesos.map(t=>`<tr><td><input type="checkbox" name="procesos" value="${t.codp}"></td><td>${t.nombre}</td></tr>`).join('\n')
			procesos_list=procesos.reduce((p,n)=>p.concat((n.procesos)?n.procesos:[]),[]);
			pagination=Array(pagination).fill().map((v,i)=>i+1).map(t=>`<li class="page-item"><a class="page-link" href="#${t}">${t}</a></li>`).join('\n')
			let template=`
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th style="width:10%">#</th>
			      <th style="width:60%">Lista de procesos</th>
			    </tr>
			  </thead>
			  <tbody id="table_procesos">
			    ${proceso_list}
			  </tbody>  
			</table>
			<div class="col-md-6">
			  <nav aria-label="Page navigation">
			    <ul class="pagination">
			      <li class="page-item">
			        <a class="page-link" href="#" aria-label="Previous">
			          <span aria-hidden="true">&laquo;</span>
			          <span class="sr-only">Previous</span>
			        </a>
			      </li>
			      ${pagination}
			      <li class="page-item">
			        <a class="page-link" href="#" aria-label="Next">
			          <span aria-hidden="true">&raquo;</span>
			          <span class="sr-only">Next</span>
			        </a>
			      </li>
			    </ul>
			  </nav>
			</div>
			`;
			document.querySelector(".table-responsive#procesos").innerHTML=template;
	    }
	});



}