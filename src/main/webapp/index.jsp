<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script >

 function viewPerson(){              
	 
	 alert("test");
	 //var num = document.getElementById("num").value;
	 
	// alert(num);
     var url =  "<%=request.getContextPath()%>/service/person/getAll";
     var xmlhttp;
	      if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET", url, false);
		xmlhttp.send("Firefox");
		var result =  xmlhttp.responseText;
		alert(result);
		var object = JSON.parse(result);
		
		//populate(object);
	   //alert(object.name);
       
 } 
 function search(){              
	 
	 alert("test");
	 //var num = document.getElementById("num").value;
	 
	// alert(num);
     var url =  "http://localhost:8090/qs/search?st=select all";
     var xmlhttp;
	      if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET", url, false);
		xmlhttp.withCredentials = true;
		xmlhttp.setRequestHeader("Content-Type", "application/json");
		xmlhttp.send("Firefox");
		var result =  xmlhttp.responseText;
		alert(result);
		var object = JSON.parse(result);
		
		//populate(object);
	   //alert(object.name);
       
 }
 function populate(object){
	   alert("yetwyu0");
	    document.getElementById("num").value=object.id;
	    document.getElementById("name").value=object.name;
		document.getElementById("age").value=object.age;
 }
 
 
/* function createCORSRequest(method, url){
	  var xhr = new XMLHttpRequest();
	  if ("withCredentials" in xhr){
	    // XHR has 'withCredentials' property only if it supports CORS
	    xhr.open(method, url, true);
	  } else if (typeof XDomainRequest != "undefined"){ // if IE use XDR
	    xhr = new XDomainRequest();
	    xhr.open(method, url);
	  } else {
	    xhr = null;
	  }
	  alert("Result :"+xhr.responseText);
	  return xhr;
	}

	var request = createCORSRequest( "get", "http://localhost:8090/qs/search?st=select a" );
	if ( request ){
	  // Define a callback function
	  request.onload = function(){};
	  // Send request
	  request.send();
	  var result =  request.responseText;
		alert(result);
	}*/
	$(document).ready(function(){
		searchES()
		function searchES(){
			var settings={
					"async":true,
					"url":"http://localhost:8090/qs/search?st=select a",
					"method":"GET",
					 "headers": { 'Content-Type': 'application/json',
						 		 'Access-Control-Allow-Origin':'*',
						 		 'Access-Control-Allow-Credentials':'true',
						 		 'Access-Control-Allow-Headers':'Content-Type',
						 		 'Access-Control-Allow-Methods':'GET',
						 		 format:"json"}
				}
				$.ajax(settings).done(function(response){
					console.log(response);
				});
		}
		
	});
	
	$(document).ready(function(){
		$("button").click(function(e){
			e.preventDefault();
alert("test");
	$.ajax({
		type: "GET",
		url: "http://localhost:8090/qs/search?st=select a",
		data:{
			format:"json"
		},
		crossDomain:true,
		success:function(result){
			alert(result);
		},
		error:function(result){
			alert('error');
		}
		
	}); 
  });
	});		
</script>


<body>
<h2>Hello World! test</h2><br><Br>
<input type=text placeholder="Enter your search text..."/> <input type=button onclick="viewPerson()" value="search person"><input type=button onclick="search()" value="search">
<input type="button" value="test"/>
</body>
</html>
