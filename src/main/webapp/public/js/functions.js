let getJSON=(url,callback)=>{
    let xhr=new XMLHttpRequest();
    xhr.open('GET',url,true);
    xhr.responseType='json';
    xhr.onload=()=>{
        let status=xhr.status;
        (status==200)?callback(null,xhr.response):callback(status);
    };
    xhr.send();
}

let sendPost=(data,url,callback)=>{
	xhr = new XMLHttpRequest();
	xhr.open('POST',url,true);
	xhr.onload=()=>{ 
	    let status=xhr.status;
        (xhr.readyState==4&&status==200)?callback(null,xhr.response):callback(status);
	}
	xhr.send(data);
}



//sendPost({"email":"tomb@raider.com","name":"LaraCroft"})
/*
window.fetch('/menus/api/proceso/assign', {
	method: 'POST',
	body: JSON.stringify({p:'hola'}),
})
.then((data)=>{
	console.log(data)
});
*/
// $(".btn_assign").bind("click",()=>{
// 	if(confirm('Esta seguro de asignar usuario?')){
//         document.getElementById("form_assign_"+this.id).submit();
//     }else{
//         return false;
//     }
// });


// $("table#menus input[name='menu']").bind("click",()=>{
// 	$.getJSON("/api/menus/procesos",(res)=>{
// 		window.menus=res;
// 		menus.reduce((p,n)=>p.concat((n.procesos)?n.procesos:[]),[])
// 		console.log(res);
// 	})
// });



/*
list maclist 'E0:AC:CB:6A:06:E2'
list maclist 'C0:14:3D:CF:29:FF'
list maclist '0C:8B:FD:0D:21:0E'
list maclist '38:1D:D9:10:F5:FD'
list maclist '1C:1E:E3:43:F1:EB'
list maclist '9C:D9:17:A7:C4:9D'
list maclist 'F0:72:8C:BF:9B:B8'
list maclist 'c4:8e:8f:bb:81:9d'
list maclist 'a6:cf:fc:8a:d7:0d'
*/