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
			我的收藏
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
							<span>我的收藏</span>
						</h5>
						<div class="blank"></div>
						<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
							<tr align="center">
								<td align="center" bgcolor="#ebf0f7">小说</td>
								<td align="center" bgcolor="#ebf0f7">日期</td>
								<td align="center" bgcolor="#ebf0f7">操作</td>
							</tr>
							<c:forEach items="${favList}" var="fav">
								<tr align="center" bgcolor="#FFFFFF">
									<td align="center"><a href="index/detail.action?id=${fav.booksid}">${fav.booksname}</a></td>
									<td align="center">${fav.addtime}</td>
									<td align="center"><a href="index/deleteFav.action?id=${fav.favid}"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></td>
								</tr>
							</c:forEach>
						</table>
						<div class="blank5"></div>
						${html }
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>



	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
