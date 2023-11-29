<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doors</title>
</head>
<body>

	<h1>Create door:</h1>
	
	<p>Insert door:</p>
	<form action="/Doors_SpringMVC/doors/create" method="post">
		Material: <input type="text" name="material"/> <br> <br>
		Height: <input type="number" step="0.01" name="height"/> <br> <br>
		Width: <input type="number" step="0.01"  name="width"/> <br> <br>
		Installation date: <input type="date" name="installationDate"/> <br>
		<input type="submit" value="Create"/>
	</form>


</body>
</html>