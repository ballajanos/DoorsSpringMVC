<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.example.Doors" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Doors Page</h1>
	<% ArrayList<Doors> doors = (ArrayList<Doors>) request.getAttribute("doors"); %>
	<p>Number of doors: <%= doors.size() %></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Material</th>
			<th>Height</th>
			<th>Width</th>
			<th>Installation Date</th>
		</tr>
		<%for(Doors d: doors) {%>
			<tr>
				<td><a href="doors/<%= d.getId() %>"><%= d.getId() %></a></td>
				<td><%= d.getMaterial() %></td>
				<td><%= d.getHeight() %></td>
				<td><%= d.getWidth() %></td>
				<td><%= d.getInstallationDate() %></td>
			</tr>
		<% } %>
	</table>
	
	<p><a href="doors/create">Create</a></p>
</body>
</html>