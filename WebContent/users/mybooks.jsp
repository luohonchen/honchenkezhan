<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			用户中心
			<code> &gt; </code>
			我的小说
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">
						<h5>
							<span>我的小说</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr align="center">
								<th align="center" bgcolor="#FFFFFF">名称</th>
								<th align="center" bgcolor="#FFFFFF">大类</th>
								<th align="center" bgcolor="#FFFFFF">子类</th>
								<th align="center" bgcolor="#FFFFFF">上传日期</th>
								<th align="center" bgcolor="#FFFFFF">状态</th>
								<th align="center" bgcolor="#FFFFFF">点击数</th>
								<th align="center" bgcolor="#FFFFFF">操作</th>
							</tr>
							<c:forEach items="${booksList}" var="books">
								<tr align="center" bgcolor="#FFFFFF">
									<td align="center">${books.booksname}</td>
									<td align="center">${books.bcatename}</td>
									<td align="center">${books.scatename}</td>
									<td align="center">${books.addtime}</td>
									<td align="center">${books.status}</td>
									<td align="center">${books.hits}</td>
									<td align="center"><c:if test="${books.status eq '连载中'}">
											<a href="index/over.action?id=${books.booksid}">完本</a>&nbsp;&nbsp;</c:if></td>
								</tr>
							</c:forEach>
						</table>
						<div class="blank5"></div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
