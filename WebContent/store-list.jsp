<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store List</title>
</head>
<style>
	table, th, td {
		border: 1px solid black;
		text-align: center;
	}
</style>
<body>
<h2>Store List</h2>

<form method="post" action="navigationStoreServlet">
<table>
<tr>
	<td></td>
	<td>Store Name</td>
	<td>Address</td>
</tr>
<c:forEach items="${requestScope.allStores}" var="currentstore">
	<tr>
		<td><input type="radio" name="storeId" value="${currentstore.storeId}"></td>
		<td>${currentstore.storeName}</td>
		<td>${currentstore.address}</td>
	</tr>
</c:forEach>
</table>
<br>
<input type="submit" value = "Edit" name="doThisToStore">
<input type="submit" value = "Delete" name="doThisToStore">
<input type="submit" value = "Add" name="doThisToStore">
<br><br><br>
<a href="viewAllItemsServlet">View the Game list</a>
<br><br><br>
<a href="index.jsp">Main Menu</a>
</form>
</body>
</html>