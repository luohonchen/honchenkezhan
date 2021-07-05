<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%><jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">
	<jsp:include page="top.jsp"></jsp:include>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="content">
		<div class="header">
			<h1 class="page-title">书籍信息列表</h1>
		</div>
		<div class="main-content">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">发布人</th>
						<th class="text-center">名称</th>
						<th class="text-center">大类</th>
						<th class="text-center">子类</th>
						<th class="text-center">上传日期</th>
						<th class="text-center">状态</th>
						<th class="text-center">点击数</th>
					</tr>
				</thead>
				<c:forEach items="${booksList}" var="books">
					<tr align="center">
						<td class="center">${books.username}</td>
						<td class="center">${books.booksname}</td>
						<td class="center">${books.bcatename}</td>
						<td class="center">${books.scatename}</td>
						<td class="center">${books.addtime}</td>
						<td class="center">${books.status}</td>
						<td class="center">${books.hits}</td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pagination">
				<li>
					<form action="books/queryBooksByCond.action" name="myform" method="post">
						<label>查询条件: <select name="cond" style="width: 100px">
								<option value="usesid">按发布人查询</option>
								<option value="booksname">按名称查询</option>
								<option value="image">按封面查询</option>
								<option value="bcateid">按大类查询</option>
								<option value="scateid">按子类查询</option>
								<option value="addtime">按上传日期查询</option>
								<option value="status">按状态查询</option>
								<option value="hits">按点击数查询</option>
								<option value="contents">按介绍查询</option>
						</select>
						</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp;
						<label><input type="submit" value="查询" class="mws-button green" /> </label>${html }
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
