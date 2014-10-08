<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/main.css" type="text/css" />
<title>List des POI</title>
</head>
<body>

<h1>List des POI!</h1>

<div class="CSSTableGenerator" >
<table>
	<tr >
      <td><c:out value="city" /></td>
      <td><c:out value="name" /></td>
      <td><c:out value="address" /></td>
      <td><c:out value="tel" /></td>
    </tr>
  <c:forEach items="${listPoi}" var="item">
  	<tr class="lovelyrow" onclick="location.href='/tn5arja-poi?id=${item.id}'">
      <td><c:out value="${item.city}" /></td>
      <td><c:out value="${item.name}" /></td>
      <td><c:out value="${item.address}" /></td>
      <td><c:out value="${item.tel}" /></td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>