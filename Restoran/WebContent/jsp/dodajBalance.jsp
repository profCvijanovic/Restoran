<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dodaj balance</title>
<link rel="stylesheet"
	  type="text/css"
	  href="../css/style.css"
/>
</head>
<body>
<h1> DODAJ BALANCE </h1>
	<div class= "slikaAdmin">
		<a href = "adminPage.jsp">	
			<img src="../slike/admin.jpg" alt = "admin slika"/>
		</a>
	</div>
	
	<form action="../DodajBalanceController">
	
				<input type = "hidden" name = "idUser" value="${param.idOdUsera}">
		BALANCE:<input type="text" name = "balance">
				<input type="submit" value="DODAJ">
	</form>
</body>
</html>