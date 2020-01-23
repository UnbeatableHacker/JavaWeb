<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${user ! empty }">
			你好，${user.username }，<a href="logout.do">退出</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">请登录</a>
			<a href="register.jsp">注册</a>
		</c:otherwise>
	</c:choose>
</body>
</html>