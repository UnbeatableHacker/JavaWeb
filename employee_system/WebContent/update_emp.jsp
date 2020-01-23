<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 引入头部信息 -->
	<%@include file="top.jsp" %>
	<h1>修改员工信息页面</h1>
	<!-- <form action="insertEmp.do" method="post"> -->
	<form action="savaOrUpdate.do" method="post">
		<input type="hidden" name="empno" value="${emp.empno }">
		姓名：<input type="text" name="empname" value="${emp.empname }"><br><br>
		性别：<input type="radio" name="empsex" value="1" <c:if test="${emp.empsex == 1 }">checked="checked"</c:if>>男
			<input type="radio" name="empsex" value="0" <c:if test="${emp.empsex == 0 }">checked="checked"</c:if>>女<br><br>
		职位：<input type="text" name="job" value="${emp.job }"><br><br>
		入职时间：<input type="date" name="hiredate" value="${emp.hiredate }"><br><br>
		薪水：<input type="text" name="salary" value="${emp.salary }"><br><br>
		上级领导：<select name="sid">
				<option value="0">--请选择领导--</option>
				<c:forEach items="${leaderAll }" var="e">
					<option value="${e.empno }" <c:if test="${emp.sid == e.empno }">selected="selected"</c:if>>${e.empname }</option>
				</c:forEach>
				</select>
		<br><br>
		部门：<select name="deptno">
			<option value="0">--请选择部门--</option>
			<c:forEach items="${deptAll }" var="d">
				<option value="${d.deptno }" <c:if test="${emp.deptno == d.deptno }">selected="selected"</c:if>>${d.deptname }</option>
			</c:forEach>
		</select>
		<br><br>
		爱好：<input type="checkbox" name="hobby" value="打游戏" <c:if test="${fn:contains(emp.hobby, '打游戏') }">checked="checked"</c:if>>打游戏
			<input type="checkbox" name="hobby" value="听音乐" <c:if test="${fn:contains(emp.hobby, '听音乐') }">checked="checked"</c:if>>听音乐
			<input type="checkbox" name="hobby" value="旅游" <c:if test="${fn:contains(emp.hobby, '旅游') }">checked="checked"</c:if>>旅游<br><br>
		<input type="submit" value="修改"><br><br>
	</form>
</body>
</html>