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
	<!-- 引入头部信息 -->
	<%@include file="top.jsp" %>
	<h1>添加员工页面</h1>
	<!-- <form action="insertEmp.do" method="post"> -->
	<form action="savaOrUpdate.do" method="post">
		姓名：<input type="text" name="empname"><br><br>
		性别：<input type="radio" name="empsex" value="1" checked="checked">男
			<input type="radio" name="empsex" value="0">女<br><br>
		职位：<input type="text" name="job"><br><br>
		入职时间：<input type="date" name="hiredate"><br><br>
		薪水：<input type="text" name="salary"><br><br>
		上级领导：<select name="sid">
				<option value="0">--请选择领导--</option>
				<c:forEach items="${map.empAll }" var="e">
					<option value="${e.empno }">${e.empname }</option>
				</c:forEach>
				</select>
		<br><br>
		部门：<select name="deptno">
			<option value="0">--请选择部门--</option>
			<c:forEach items="${map.deptAll }" var="d">
				<option value="${d.deptno }">${d.deptname }</option>
			</c:forEach>
		</select>
		<br><br>
		爱好：<input type="checkbox" name="hobby" value="打游戏">打游戏
			<input type="checkbox" name="hobby" value="听音乐">听音乐
			<input type="checkbox" name="hobby" value="旅游">旅游<br><br>
		<input type="submit" value="添加"><br><br>
	</form>
</body>
</html>