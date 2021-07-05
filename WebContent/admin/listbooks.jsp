<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<c:forEach items="${booksList}" var="books">
					<tr align="center">
						<td>${books.username}</td>
						<td>${books.booksname}</td>
						<td>${books.bcatename}</td>
						<td>${books.scatename}</td>
						<td>${books.addtime}</td>
						<td>${books.status}</td>
						<td>${books.hits}</td>
						<td><c:if test="${books.status eq '待审核'}">
								<a href="books/status.action?id=${books.booksid}">通过审核</a>&nbsp;&nbsp;</c:if> <a
							href="books/deleteBooks.action?id=${books.booksid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i
								class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">${html }</div>
		</div>
	</div>
</body>
</html>
