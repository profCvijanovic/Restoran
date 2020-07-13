<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user table</title>
<link rel="stylesheet"
	  type="text/css"
	  href="css/style.css"
/>
</head>
<body>
	
<h1> TABELA SVIH USERA </h1>
	<div class= "slikaAdmin">
		<a href = "jsp/adminPage.jsp">	
			<img src="slike/admin.jpg" alt = "admin slika"/>
		</a>
	</div>
	
	<div>
		<table border="1" class = "prvaTabela">
			<tr>
				<th>ID</th>
				<th>USER NAME</th>
				<th>BALANCE</th>
				<th>DODAJ BALANCE</th>
			</tr>
 			<c:forEach var = "u" items="${listaUsera}">
 			
 			<c:url var = "dodajNovac" value="jsp/dodajBalance.jsp">
				<c:param name="idOdUsera" value="${u.idUser}"/>
			</c:url>
				<tr>
					<td>${u.idUser}</td>
					<td>${u.userName}</td>
					<td>${u.balance}</td>
					<td><a href ="${dodajNovac}" >dodaj</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	
	
	
</body>
</html>