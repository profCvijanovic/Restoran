<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
<link rel="stylesheet"
	  type="text/css"
	  href="../css/style.css"
/>
</head>
<body>
	<h1> DOBRODOSLI ${user.userName} </h1>
	<a href = "../LogOutController">log out</a>
	
	<img src = "../slike/${user.userName}Slika.jpg">
	
	<p> Vas user name je: ${user.userName}</p>
	<p> Vas trenutni balance je:  ${user.balance}</p>
	
	<div>
		<form action="../PrikaziStoloveController" method="post">
			<input type = "submit" value = "PRIKAZI SLOBODNE STOLOVE"> 
		</form>
	</div>
	
</body>
</html>