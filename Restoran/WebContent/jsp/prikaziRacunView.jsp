<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>racun</title>
<link rel="stylesheet"
	  type="text/css"
	  href="../css/style.css"
/>
</head>
<body>
	
	<h1>OVO JE VAS RACUN</h1>
	<div class ="divStolovi">
		<img src = "../slike/${user.userName}Slika.jpg">
		
		<p> Vas user name je: ${user.userName}</p>
		<p> Vas trenutni balance je:  ${user.balance}</p>
	</div>
	
	<div class ="divStolovi">
		<form action="../PlatiRacunController">
			<table border = 1>
				<tr>
					<th> IME ARTIKLA</th>
					<th> CENA ARTIKLA</th>	
					<th> KOLICINA</th>
					<th> POPUST</th>	
				</tr>
				<c:forEach var = "stavke" items="${racun.stavke}">
					<tr>
					<td>${stavke.artikal.ime}</td>
					<td>${stavke.artikal.cena}</td>
					<td>${stavke.kolicina}</td>
					<td>${stavke.artikal.popust}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value ="PLATI RACUN">
		</form>
		<br><br>
		<a href = "userPage.jsp" > <button>ODABERI PONOVO</button></a><br>
		<br><br>
		RACUN BEZ BAKSISA: ${racun.racunZaStavke}<br>
		BAKSIS: ${racun.baksis}<br>
		TOTAL: ${racun.total}<br>
		<br><br>
		ZAUZETI STOLOVI:<br>
		<c:forEach var = "stolovi" items="${racun.izabraniStolovi}">
			 - ${stolovi.brojStola}<br>
		</c:forEach>
		
	</div>
	
	
	

</body>
</html>