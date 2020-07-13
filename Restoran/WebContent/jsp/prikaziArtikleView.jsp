<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>artikli</title>
<link rel="stylesheet"
	  type="text/css"
	  href="css/style.css"
/>
</head>
<body>
	
	<h1>Izvolite vas meni</h1>
	<div class ="divStolovi">
		<img src = "slike/${user.userName}Slika.jpg">
		
		<p> Vas user name je: ${user.userName}</p>
		<p> Vas trenutni balance je:  ${user.balance}</p>
	</div>
	
	<div class ="divStolovi">
		<form action="NapraviRacunController">
			<table border = 1>
				<tr>
					<th> IME ARTIKLA</th>
					<th> CENA</th>	
					<th> POPUST</th>
					<th> KOLICINA</th>	
				</tr>
				<c:forEach var = "artikal" items="${sviArtikliIzBaze}">
					<tr>
						<td>${artikal.ime}</td>
						<td>${artikal.cena}</td>
						<td>${artikal.popust}</td>
						<td>
							<select name = "kolicina">
								<c:forEach var = "i" begin="0" end = "${artikal.kolicinaNaStanju}">
									<option value="${i}">${i}</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="checkbox" name = "check" value="${artikal.idArtikal}"></td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach var = "sto" items="${stolovi}">
				<input type="hidden" name = "idStolova" value="${sto}">
			</c:forEach>
			<input type="submit" value ="NAPRAVI RACUN">
		</form>
	</div>
	
	
	

</body>
</html>