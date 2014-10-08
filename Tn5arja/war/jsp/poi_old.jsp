<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/main.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<%
// Récupération du message d'erreur
String erreur = (String) request.getAttribute("erreur");
// Affichage du message s'il existe
if (erreur != null) { %>
<strong>Erreur : <%= erreur %></strong>
<%
} %>
<div class="CSSTableGenerator" >
<table>
	<tr>
      <td>city</td>
      <td>name</td>
      <td>address</td>
      <td>tel</td>
    </tr>
  
  <tr>
      <td>${poi.city}</td>
      <td>${poi.name}</td>
      <td>${poi.address}</td>
      <td>${poi.tel}</td>
    </tr>
</table>
</div>
</body>
</html>