<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${Nu au fost gasite elemente in baza de date}</p>
    </c:if>
</body>
</html>