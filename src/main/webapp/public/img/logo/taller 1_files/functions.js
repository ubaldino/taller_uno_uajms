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

let getTextPlain=(url,callback)=>{
    let xhr=new XMLHttpRequest();
    xhr.open('GET',url,true);
    xhr.responseType='text';
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

// Override functions
//https://stackoverflow.com/questions/610406/javascript-equivalent-to-printf-string-format
String.prototype.format=function(){
	let args=arguments;
	if(args.length===1&&args[0]!==null&&typeof args[0]==='object')
		args=args[0];
	return this.replace(/{([^}]*)}/g,function(match,key) {
	  return (typeof args[key]!=="undefined"?args[key]:match);
	});
}

//http://tech.chandrahasa.com/2017/03/08/convert-javascript-date-object-to-yyyy-mm-dd-format/
let formatDate=(date)=>{
    date=new Date(date);
    let mm=date.getMonth()+1
      , dd=date.getDate()
    if(mm<10) mm="0"+mm
    if(dd<10) dd="0"+dd
    return [date.getFullYear(),mm,dd].join('-');
}

Handlebars.registerHelper('formatDate', function(dateTime) {
  return formatDate(dateTime);
});

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