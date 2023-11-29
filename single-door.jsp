<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.Doors" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doors</title>
</head>
<body>
	<h1>Doors</h1>
	
	<% Doors d = (Doors)request.getAttribute("doo"); %>
	<% if (d != null) {%>
		<p>Doors id: <%= d.getId() %> </p>
		<p>Doors material: <%= d.getMaterial() %> </p>
		<p>Doors height: <%= d.getHeight() %> </p>
		<p>Doors width: <%= d.getWidth() %> </p>
		<p>Doors installation date: <%= d.getInstallationDate() %> </p>
	<% } %>
	<h4><a href="/Doors_SpringMVC/doors">GO BACK</a></h4>
</body>
</html>