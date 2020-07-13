<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>slobodni stolovi</title>
<link rel="stylesheet"
	  type="text/css"
	  href="css/style.css"
/>
</head>
<body>
	
	<h1>Odaberite sto koji zelite</h1>
	<div class ="divStolovi">
		<img src = "slike/${user.userName}Slika.jpg">
		
		<p> Vas user name je: ${user.userName}</p>
		<p> Vas trenutni balance je:  ${user.balance}</p>
	</div>
	
	<div class ="divStolovi">
		<form action="OdaberiArtikalController">
			<table border = 1>
				<tr>
					<th> BROJ STOLA</th>
					<th> IZABERI</th>		
				</tr>
				<c:forEach var = "sto" items="${slobodniStolovi}">
					<tr>
						<td>${sto.brojStola}</td>
						<td> <input type="checkbox" name = "idStola" value="${sto.idStola}"></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value ="REZERVISI STO">
		</form>
	</div>
	
	
	

</body>
</html>