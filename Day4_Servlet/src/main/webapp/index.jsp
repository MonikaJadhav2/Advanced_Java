<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<%
	for (int i = 1; i <= 30; i++) {
		// out.println(i);
	%>
	<h1>
		Welcome ... = <%=i%></h1>
	<%
	}
	%>



</body>
</html>