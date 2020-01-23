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
	<h1>用户注册页面</h1>
	<form action="register.do" method="post">
		用户名：<input type="text" name="username"><br><br>
		密    码：<input type="text" name="password"><br><br>
		邮    箱：<input type="text" name="email"><br><br>
		<input type="submit" value="注册">
		<a href="login.jsp"><input type="button" value="去登录"></a>
	</form>
</body>
</html>