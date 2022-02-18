<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
td{
	font-size: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>All of Our Games</title>
</head>
<body>
<h1 style="font-size:40px">Title - Price - Rating %</h1>
<form method = "post" action = "navServlet">
<table>

<c:forEach items="${requestScope.allGames}" var="currentitem">
<tr>
	<td ><input type="radio" name="selTitle" value="${currentitem.title}"></td>
	<td >${currentitem.title} - </td><td>${currentitem.price} - </td>
	<td >${currentitem.ratingPercent}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type = "submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>