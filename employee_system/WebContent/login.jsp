<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 引入头部信息 -->
	<%@include file="top.jsp" %>
	<h1>用户登录页面</h1>
	<form action="login.do" method="post">
		用户名：<input type="text" name="username"><br><br>
		密    码：<input type="password" name="password"><br><br>
		<input type="submit" value="登录">
		<a href="register.jsp"><input type="button" value="去注册"></a>
	</form>
</body>
</html>