<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Downtime Scheduling</title>
<script src="js/jquery-1.11.1.js"></script>
</head>
<body onLoad="check()" >
<script>
var txt;
var jSON;
var cont;
function check()
{
	
	$.ajax({
		url : "downEidServlet",
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
	
	
		
		var sel=document.getElementById("sID");
			var html = '',i;
			
			for(i = 0; i < jSON.length; i++) {
			       html += "<option value='"+jSON[i].equipID+"'>"+jSON[i].equipID+"</option>";
			   }
			
			
			   sel.innerHTML= html;
			   document.getElementById(cont).appendChild(newDiv);
			   
			   
			   document.getElementById("rd").style.visibility = "visible";
			   document.getElementById("subBtn").style.visibility = "visible";
	
	
	}


</script>
<center>
<h2>Schedule Downtime</h2>

<form name="sched" action="DownServlet" method="post">
<table>

<tr>
<td>EquipmentID:</td><td><select name="eID" id="sID"></select></td>
</tr>
<tr>
<td>From:</td><td><input type="date" name="startDay"></td>
</tr>
<tr>
<td>To:</td><td><input type="date" name="endDay"></td>
</tr>
</table>


<input type=submit value="Schedule" >
</form></center>
</body>
</html>