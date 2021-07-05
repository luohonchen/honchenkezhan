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
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			${sections.title }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>${sections.title}</span>
				</h3>
				<div class="boxCenterList">${sections.contents }</div>
				<h3>
					<span style="float: center;"><c:if test="${sections.thepre !='-'}">
							<a href="index/readsections.action?id=${sections.thepre }">上一章</a> &larr; </c:if><a
						href="index/detail.action?id=${sections.booksid }">章节列表</a>
					<c:if test="${sections.thenxt !='-'}"> &rarr; 
							<a href="index/readsections.action?id=${sections.thenxt }">下一章</a>
						</c:if> </span>
				</h3>
			</div>
		</div>
		<div class="blank5"></div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
