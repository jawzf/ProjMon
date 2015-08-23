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
function check()
{
	
	$.ajax({
		url : "techServ",
		type : 'GET',
		datatype: 'json',
		success : function(result) {
			
		},
	complete: function(jqxhr,status)
		{
			console.log(jqxhr.responseText);
			txt=jqxhr.responseText;
		}
	});
	}
jSON=JSON.parse(txt);


</script>




</head>
<body>
<center>
<form action="techServ" method=post>
Enter your Technician ID:<input type="text" name="technicianID"><br>
<input type=button value="Scan for Jobs" id="scanBtn" onClick="check()">
</form>
<div id="infodiv"></div>


</center>

</body>
</html>