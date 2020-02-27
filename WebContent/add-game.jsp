<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Add a new Game</title>
</head>
<body>
<form action="addGameServlet" method="post">
<h3>Add New Game</h3>
Name: <input type="text" name ="name"> <br />
Rating: <input type="text" name ="rating"> <br />
Price: <input type="text" name ="price"> <br />
<br>
Select a Store:
<select name="stores">
	<option selected value="base">-- Select Store --</option>
	<c:forEach items="${requestScope.allStores}" var="store">
		<option value="${store.storeId}">${store.storeName}</option>
	</c:forEach>
</select>

<br><br>
<input type="submit" value="Add Game">
</form>
<br>
<a href="viewAllItemsServlet">View the Game list</a>
<br>
<a href="viewAllStoreServlet">View List of Stores</a>
<br><br><br>
<a href="index.jsp">Main Menu</a>
</body>
</html>