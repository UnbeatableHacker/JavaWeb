<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表显示页面</title>
</head>
<body>
	<!-- 引入头部信息 -->
	<%@include file="top.jsp" %>
	<h1>员工列表显示页面</h1>
	
	<form action="queryEmpAll.do" method="post">
		姓名：<input type="text" name="empname">
		部门：<select name="deptno">
			<option value="0">--请选择部门--</option>
			<c:forEach items="${map.deptAll }" var="d">
				<option value="${d.deptno }">${d.deptname }</option>
			</c:forEach>
			</select> 
		<input type="submit" value="搜索">			
	</form>
	
	<form action="deleteMore.do" method="post">
	<table>
		<tr>
			<td colspan="10">
				<a href="toAddEmp.do"><input type="button" value="添加"></a>
				<input type="submit" value="批删">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>职位</td>
			<td>入职时间</td>
			<td>薪水</td>
			<td>上级领导</td>
			<td>部门</td>
			<td>爱好</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${map.page.list }" var="e">
		<tr>
			<td><input type="checkbox" name="empno" value="${e.empno }"></td>
			<td>${e.empno}</td>
			<td>${e.empname}</td>
			<td>${e.empsex==1?"男":"女"}</td>
			<td>${e.job}</td>
			<td>${e.hiredate}</td>
			<td>${e.salary}</td>
			<td>${e.leader}</td>
			<td>${e.deptname}</td>
			<td>${e.hobby}</td>
			<td>
				<a href="deleteEmp.do?empno=${e.empno}"><input type="button" value="删除"></a>
				<a href="queryEmpById.do?empno=${e.empno}"><input type="button" value="修改"></a>
			</td>
		</tr>
		</c:forEach>
		<tr><td colspan="10">
			<a href="?pageNum=${map.page.firstPage }">【首页】</a>
			<a href="?pageNum=${map.page.previousPage }">【上一页】</a>
			<!-- 显示页码，法一，一般在中间 -->
			<c:forEach begin="${map.page.startPage }" step="1" end="${map.page.endPage }" var="i">
				<a href="?pageNum=${i }">${i }</a>
			</c:forEach>
			<a href="?pageNum=${map.page.nextPage }">【下一页】</a>
			<a href="?pageNum=${map.page.lastPage }">【尾页】</a>
			<!-- 显示页码，法二，一般在结尾 -->
			<select>
				<c:forEach begin="${map.page.startPage }" step="1" end="${map.page.endPage }" var="i">
					<option value="${i }">${i }</option>
				</c:forEach>
			</select>
			<input type="button" value="跳转">
		</td></tr>
	</table>
	</form>
	
</body>
</html>