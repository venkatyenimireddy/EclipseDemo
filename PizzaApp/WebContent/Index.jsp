<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=orange>
<h1 align=center><b>Welcome Pizza Corner</b></h1>
<p> Pizza corner is very essential place to refresh</p><br>
<a href="UtilController">Place order</a><br>
<a href="OrderDispaly.jsp">Dispaly order</a><br>
<a href="OrderDelete.jsp">Delete order</a><br>
<a href="OrderUpdate.jsp">Update order</a><br>
<a href="/PizzaApp/WebContent/pages/Exit.jsp">Exit</a>
<br>${requestScope.Key }<br>
${requestScope.key1 }

</body>
</html>