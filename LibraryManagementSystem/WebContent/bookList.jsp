<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css"/>
</head>
<body>

<!-- 头部 -->
<header class="publicHeader">
	<h1>图书馆管理系统</h1>
	
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span>
			<span style='color:#fff21b'>
				<c:choose>
					<c:when test='${empty user }'>用户</c:when>
					<c:otherwise>${user.userName }</c:otherwise>
				</c:choose>
			</span>
			,欢迎你！
		</p>
	</div>
</header>

<!-- 时间 -->
<section class="publicTime">
	<span id="time">2015年1月1日11:11 星期一</span>
	<a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>

<!-- 主体内容 -->
<section class="publicMian">
	<!-- 左侧 -->
	<div class="left">
		<h2 class="leftH2"><span class="span1"></span>操作列表 <span></span></h2>
		<nav>
			<ul class="list">
				<li><a href="lookupBook.jsp">图书查询</a></li>
				<li><a href="borrowBook.jsp">图书借阅</a></li>
				<li><a href="returnBook.jsp">图书归还</a></li>
				<li><a href="addBook.jsp">添加图书</a></li>
				<li><a href="delectBook.jsp">图书删除</a></li>
				<li><a href="userLogin.jsp">用户登录</a></li>
				<li><a href="userRegister.jsp">用户注册</a></li>
				<li><a href="userCancellation.jsp">用户注销</a></li>
				<li><a href="administratorsRegister.jsp">管理员注册</a></li>
				<li><a href="administratorsCancellation.jsp">管理员注销</a></li>
				<li><a href="exitSystem.do">退出系统</a></li>
			</ul>
		</nav>
	</div>
	<!-- 右侧 -->
	<div class="right">
		<div class="location">
			<strong>您现在所在位置：</strong>
			<span>图书查阅--查阅结果</span>
		</div>
		<!-- 列表显示 -->
		<div class="providerAdd">
			<div>
				<p>查阅结果：</p><br><br>
				<table border="1">
					<tr align="center">
						<td></td>
						<td>书号</td>
						<td>书名</td>
						<td>作者</td>
						<td>出版社</td>
						<td>出版时间</td>
						<td>书籍总数</td>
						<td>可借数量</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${books }" var="b">
					<tr align="center">
						<td><input type="checkbox" name="bookId" value="${b.bookId }"></td>
						<td>${b.bookId }</td>
						<td>${b.bookName }</td>
						<td>${b.author }</td>
						<td>${b.publisher }</td>
						<td>${b.publitionDate }</td>
						<td>${b.totalNumber }</td>
						<td>${b.totalNumber - b.boorrowedNum }</td>
						<td>
							<c:choose>
							<c:when test="${empty user }">
							<a href="userLogin.jsp"><input type="button" value="借阅"></a>
							</c:when><c:otherwise>
							<a href="borrowBook.do?bookId=${b.bookId }&userId=${user.userId }"><input type="button" value="借阅"></a>
							</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
	</div>
</section>
<footer class="footer">
	图书管理系统——SXZ制作
</footer>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/time.js"></script>
</html>