<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=orange>
<form action="PizzaController">
Enter name:<input type="text" name="cname"><br>
Enter address:<input type="text" name="caddress"><br>
Enter phone:<input type="text" name="cmobile"><br>
<br><b>Enter preferred toppings</b>
<select name="top">
<c:forEach var="choice" items="${requestScope.toppings }">
<option value="${choice.key }">${choice.value }</option>
</c:forEach>
</select>
<input type="submit" value=submit>
</form>
<a href="Index.jsp">Home</a><br>
<a href="/pages/Exit.jsp">Exit</a><br>
</body>
</html>