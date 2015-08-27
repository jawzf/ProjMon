<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Controller</title>
</head>
<script src="js/jquery-1.11.1.js"></script>
<script>
var txt;
var jSON;
var cont;
function check(conta)
{
	cont=conta;
	$.ajax({
		url : "DbControllerServlet",
		type : 'GET',
		datatype: 'json',
		success : function(result) {
			
		},
	complete: function(jqxhr,status)
		{
			console.log(jqxhr.responseText);
			txt=jqxhr.responseText;
			txt = txt.substring(0, txt.length - 1);
			txt=txt+']';
			console.log("txt"+txt);
			
			jSON=JSON.parse(txt);
			createSel();
		}
	});
	}
	
function createSel()
{
	var doo = document.getElementById("jobs");
	var div = document.getElementById("infodiv").contains(doo);
	if(!div)
	{	
			
			
			var newDiv=document.createElement('div');
			var html = '<select multiple name=\'equipid\' id=\'jobs\'>',i;
			
			for(i = 0; i < jSON.length; i++) {
			       html += "<option value='"+jSON[i].equipID+"'>"+jSON[i].equipID+"</option>";
			   }
			
			html += '</select>';
			   newDiv.innerHTML= html;
			   document.getElementById(cont).appendChild(newDiv);
			   
			   
			   document.getElementById("rd").style.visibility = "visible";
			   document.getElementById("subBtn").style.visibility = "visible";
	}
	
	}


</script>


</head>
<body background="img/bg.jpg" style="color:white">
<br><br><br>
<center>
<h1>DATABASE CONTROLLER</h1>
	<input type=button value="     Get EIds     " id="scanBtn" onClick="check('infodiv')"><br>
	<form action="dbStatServlet" method="post">
	<div id="infodiv"></div>
	
	<div id="rd" style="visibility:hidden">
	<input name="status" type=radio value="UP" >UP</option>
	<input name="status" type=radio value="DOWN" >DOWN</option>
	
	<br>
	</div>
	<input type=submit value="Assign" id="subBtn" style="visibility:hidden">
	</form>
	
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="DbControllerServlet" method=post>
	<input type=submit value="SOFT RESET DB">
	</form><br><br><br><br>
	<a href="TechnicianHome.jsp" target="_blank">Technician Home</a>
	|<a href="LoginForm.jsp" target="_blank">Monitor UI</a>
	|<a href="Intro.jsp" target="_blank">Monitor Config</a>
	</center>
	
	

</body>
</html>