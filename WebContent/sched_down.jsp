<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Downtime Scheduling</title>
</head>
<body >
<center>
<h2>Schedule Downtime</h2>

<form name="sched" action="DownServlet" method="post">
<table>

<tr>
<td>EquipmentID:</td><td><input type="text" name="eID"></td>
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