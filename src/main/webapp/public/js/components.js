render_menu_list=()=>{
	getJSON('/menus/api',  function(err, data) {
	    if (err != null) {
	        console.error(err);
	    } else {
	        window.menus=data;
			let pagination=Math.ceil(menus.length/10)
			let menu_list=menus.map(t=>`<li class="page-item"><a class="page-link" href="#${t.codm}">${t.nombre}</a></li>`).join('\n')
			procesos_list=menus.reduce((p,n)=>p.concat((n.procesos)?n.procesos:[]),[]);
			pagination=Array(pagination).fill().map((v,i)=>i+1).map(t=>`<li class="page-item"><a class="page-link" href="#${t}">${t}</a></li>`).join('\n')
			let template=`
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
			`;
			document.querySelector("ul.pagination.procesos").innerHTML=template;
	    }
	});
}

render_proceso_list=()=>{
	getJSON('/procesos/api/',  function(err, data) {
	    if (err != null) {
	        console.error(err);
	    } else {
	        window.menus=data;
			let pagination=Math.ceil(menus.length/10)
			let menu_list=menus.map(t=>`<li class="page-item"><a class="page-link" href="#${t.codm}">${t.nombre}</a></li>`).join('\n')
			procesos_list=menus.reduce((p,n)=>p.concat((n.procesos)?n.procesos:[]),[]);
			pagination=Array(pagination).fill().map((v,i)=>i+1).map(t=>`<li class="page-item"><a class="page-link" href="#${t}">${t}</a></li>`).join('\n')
			let template=`
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
			`;
			document.querySelector("ul.pagination.procesos").innerHTML=template;
	    }
	});
}
