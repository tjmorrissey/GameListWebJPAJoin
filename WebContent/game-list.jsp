<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game List</title>
</head>
<style>
	table, th, td {
		border: 1px solid black;
		text-align: center;
	}
</style>
<body>
<h2>Game List</h2>

<form method="post" action="navigationServlet">
<table>
<tr>
	<td></td>
	<td>Name</td>
	<td>Rating</td>
	<td>Price</td>
</tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<tr>
		<td><input type="radio" name="id" value="${currentitem.id}"></td>
		<td>${currentitem.name}</td>
		<td>${currentitem.rating}/ 10</td>
		<td>\$${currentitem.price}</td>
	</tr>
</c:forEach>
</table>
<br>
<input type="submit" value = "Edit" name="doThisToItem">
<input type="submit" value = "Delete" name="doThisToItem">
<input type="submit" value = "Add" name="doThisToItem">
</form>
</body>
</html>