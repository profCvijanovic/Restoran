<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin page</title>
<link rel="stylesheet"
	  type="text/css"
	  href="../css/style.css"
/>
</head>
<body>
	<%
		User user = (User)session.getAttribute("user");
	%>
	<h1> DOBRODOSLI ADMIN </h1>
	<a href = "../LogOutController">log out</a>
	<div class= "slikaAdmin">
		<img src="../slike/admin.jpg" alt = "admin slika"/>
	</div>
	<% 
		int broj = 7;
		int drugiBroj = -1;
		int zbir;
		String ime;
		
	%>
	
	<%! 
		public int zbir(int br1, int br2){
			return br1 + br2;
		} 
	%>
	<%=zbir(2,5) %>
	<table border="1" class = "prvaTabela">
		<tr>
			<th>ID</th>
			<th>IME</th>
		</tr>
		<%
			for(int i = 1 ; i < broj ; i++){
			ime = "Ime" + i;
			zbir = i;
	    %>
	    
	    <tr>
			<th><%=i %></th>
			<th><%=ime %></th>
		</tr>
	    
		<%
			}
		%>
		
		<tr>
			<th><%=user.getIdUser() %></th>
			<th><%=user.getUserName() %></th>
		</tr>
	</table>
		
		<br><br>
	
	<div>
		<form action="../AdminUserController" method="get">
			<input type="submit" value="PRIKAZI SVE USERE">
		</form>
		
	
	</div>
		<a href = "../html_fajlovi/dodajArtikal.html">
			<button> DODAJ ARTIKAL</button>
		</a>
		<br>
		<a href = "../html_fajlovi/dodajSto.html">
			<button> DODAJ STO</button>
		</a>

</body>
</html>