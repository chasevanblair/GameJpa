<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter changes to game entry</title>
</head>
<body>
<h1 style=font-size:40px>Enter your changes for ${requestScope.gameToEdit}</h1>
<form action="editGameServlet" method="post" >
	<input type = "hidden" name = "title" value = "${requestScope.gameToEdit}">
	Price (do not include '$'): <input type = "text" name = "price"><br/>
	Rating % (do not include '%'): <input type = "text" name = "rating"><br/>
	<input type="submit" value="Save Changes" class="btn btn-primary">
</form>
</body>
</html>