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
	
	var doo = document.getElementById("equipid");
	var div = document.getElementById("infodiv").contains(doo);
	
	if(!div){		
			console.log(jSON[0].equipID+jSON[0].address);
			var newDiv=document.createElement('div');
			var html = '<select name=\'equipid\' id=\'equipid\'>',i;
			
			for(i = 0; i < jSON.length; i++) {
			       html += "<option value='"+jSON[i].equipID+"'>"+jSON[i].address+"</option>";
			   }
			
			html += '</select>';
			   newDiv.innerHTML= html;
			   document.getElementById(cont).appendChild(newDiv);
			   
			   document.getElementById("subBtn").style.visibility = "visible";
	}
	
	}


</script>




</head>
<body background="img/bg.jpg" >
<center>
<br><br><br><br><br><br>
<h1 >TECHNICIAN'S TOOL</h1>
<br>
<form name="awesome">
Enter your Technician ID:<input type="text" name="technicianID"><br>
<br><input type=button value="Scan for Jobs" id="scanBtn" onClick="check('infodiv')">
</form>
<form action="resp_serv" method="post">
<div id="infodiv"></div>
<input type=submit value="Job Done" id="subBtn" style="visibility:hidden">
</form>
<%
			String login_msg=(String)request.getAttribute("terror");  
			if(login_msg!=null)
			out.println("<font color=red size=4px>"+login_msg+"</font>");
			request.setAttribute("terror","");
	%>
<br><br><br><br><a href="TechnicianHome.jsp" >Refresh</a>
</center>

</body>
</html>