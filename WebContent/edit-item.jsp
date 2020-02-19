<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
</head>
<body>
<h3>Edit an Item</h3>
<form action="editItemServlet" method="post">
Name: <input type="text" name="name" value="${itemToEdit.name}"> <br>
Rating: <input type="text" name="rating" value="${itemToEdit.rating}"> <br>
Price: <input type="text" name="price" value="${itemToEdit.price}"> <br>
<input type="hidden" name="id" value="${itemToEdit.id}">
<br>
<input type="submit" value="Save Edited Game">
</form>
</body>
</html>