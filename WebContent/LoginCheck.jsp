<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Check</title>
</head>
<body>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
if(username.equals("admin")&& password.equals("admin"))
		{
			response.sendRedirect("serviceHome.jsp");
		}
else
{
	response.sendRedirect("Error.jsp");
}
%></body>
</html>