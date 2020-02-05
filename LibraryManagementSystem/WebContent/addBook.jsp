<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加图书</title>
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
			<span>添加图书</span>
		</div>
		<div class="providerAdd">
			<form id="" name="" method="post" action="addBook.do"> 
				<div class="">
					<label for="bookName">图书名字：</label>
					<input type="text" class="text" name="bookName" id="bookName" value="">
					<font color="red"></font>
				</div>
				<div class="">
					<label for="price">图书价格：</label>
					<input type="text" class="text" name="price" id="price" value="">
					<font color="red"></font>
				</div>
				<div class="">
					<label for="author">图书作者：</label>
					<input type="text" class="text" name="author" id="author" value="">
					<font color="red"></font>
				</div>
				<div class="">
					<label for="publisher">出版社：</label>
					<input type="text" class="text" name="publisher" id="publisher" value="">
					<font color="red"></font>
				</div>
				<div class="">
					<label for="publitionDate">出版时间：</label>
					<input type="text" class="text" name="publitionDate" id="publitionDate" value="">
					<font color="red"></font>
				</div>
				<div class="">
					<label for="totalNumber">总数：</label>
					<input type="text" class="text" name="totalNumber" id="totalNumber" value="">
					<font color="red"></font>
				</div>
				<div class="providerAddBtn">
					<input type="submit" name="addBook" id="addBook" value="添加">
				</div>
			</form>
		<!-- 右侧结束 -->
		</div>
	</div>
</section>
<footer class="footer">
	图书管理系统——SXZ制作
</footer>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/time.js"></script>
</html>