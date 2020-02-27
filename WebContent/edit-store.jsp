<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Store</title>
</head>
<body>
<h3>Edit a Store</h3>
<form action="editStoreServlet" method="post">
Store Name: <input type="text" name="storeName" value="${storeToEdit.storeName}"> <br>
Address: <input type="text" name="address" value="${storeToEdit.address}"> <br>
<input type="hidden" name="storeId" value="${storeToEdit.storeId}">
<br>
<input type="submit" value="Save Edited Game">
<br><br><br>
<a href="index.jsp">Main Menu</a>
</form>
</body>
</html>