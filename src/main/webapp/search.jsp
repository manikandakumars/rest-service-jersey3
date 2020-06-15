<html>
<script >

 function viewPerson(){              
	 
	// alert("test");
	 var num = document.getElementById("search").value;
	 
	alert(num);
     var url =  "<%=request.getContextPath()%>/service/person/"+num+"/get";
     var xmlhttp;
	      if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET", url, false);
		xmlhttp.send("Firefox");
		var result =  xmlhttp.responseText;
		//alert(result);
		var object = JSON.parse(result);
		
		//populate(object);
	   alert(object.name);
	   //document.getElementById("display").textContent="abc";
	   var span = document.getElementById("display");
	   span.innerHTML = "New Span content"; 

 } 
 function populate(object){
	   alert("yetwyu0");
	    document.getElementById("num").value=object.id;
	    document.getElementById("name").value=object.name;
		document.getElementById("age").value=object.age;
 }
 
</script>


<body>
<input type=text id="search" name="search">
<input type="button" value="Search" onclick="viewPerson()">
<p id="diplay">tet</p>
</body>
</html>