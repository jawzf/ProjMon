<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">

var txt;
var jSON;
var cont;
function check(conta)
{
	cont=conta;
	var id=document.awesome.technicianID.value;
	$.ajax({
		url : "techServ?tID="+id,
		type : 'GET',
		datatype: 'json',
		success : function(result) {
			
		},
	complete: function(jqxhr,status)
		{
			console.log(jqxhr.responseText);
			txt=jqxhr.responseText;
			txt = txt.substring(0, txt.length - 2);
			txt=txt+']';
			console.log(txt);
			
			jSON=JSON.parse(txt);
			createSel();
		}
	});
	}
	
function createSel()
{
	
	console.log(jSON[0].equipID+jSON[0].address);
	var newDiv=document.createElement('div');
	var html = '<select name=\'equipid\'>',i;
	
	for(i = 0; i < jSON.length; i++) {
	       html += "<option value='"+jSON[i].equipID+"'>"+jSON[i].address+"</option>";
	   }
	
	html += '</select>';
	   newDiv.innerHTML= html;
	   document.getElementById(divname).appendChild(newDiv);
	   
	   document.getElementById("subBtn").style.visibility = "visible";
	
	
	}


</script>




</head>
<body>
<center>
<h2>Technician's Tool</h2>
<form name="awesome">
Enter your Technician ID:<input type="text" name="technicianID"><br>
<input type=button value="Scan for Jobs" id="scanBtn" onClick="check('infodiv')">
</form>
<form action=respServ method=post>
<div id="infodiv"></div>
<input type=submit value="Job Done" id="subBtn" style="visibility:hidden">
</form>

</center>

</body>
</html>