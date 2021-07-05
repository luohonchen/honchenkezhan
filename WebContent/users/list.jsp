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
			当前位置: <a href="index.jsp">首页</a>
			<code> &gt; </code>
			小说
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree">
				<div class="tit">所有书籍分类</div>
				<dl class="clearfix" style="overflow: hidden;">
					<div class="box1 cate" id="cate">
						<!-- 循环开始 -->
						<c:forEach items="${cateList}" var="bcate" varStatus="status">
							<h1 onclick="tab(${status.index})" style="border-top: none">
								<span class="f_l"><img src="themes/ecmoban_meilishuo/images/btn_fold.gif"
									style="padding-top: 10px; padding-right: 6px; cursor: pointer;"></span> <a
									href="index/bcate.action?id=${bcate.bcateid }" class="  f_l">${bcate.bcatename }</a>
							</h1>
							<ul style="display: none">
								<c:forEach items="${bcate.scateList}" var="scate">
									<a class="over_2" href="index/scate.action?id=${scate.scateid}">${scate.scatename }</a>
									<div class="clearfix"></div>
								</c:forEach>
							</ul>
							<div style="clear: both"></div>
						</c:forEach>
					</div>
					<div style="clear: both"></div>
			</div>

			<div class="blank"></div>
			<script type="text/javascript">
				obj_h4 = document.getElementById("cate").getElementsByTagName(
						"h4")
				obj_ul = document.getElementById("cate").getElementsByTagName(
						"ul")
				obj_img = document.getElementById("cate").getElementsByTagName(
						"img")
				function tab(id) {
					if (obj_ul.item(id).style.display == "block") {
						obj_ul.item(id).style.display = "none"
						obj_img.item(id).src = "themes/ecmoban_meilishuo/images/btn_fold.gif"
						return false;
					} else
						(obj_ul.item(id).style.display == "none")
					{
						obj_ul.item(id).style.display = "block"
						obj_img.item(id).src = "themes/ecmoban_meilishuo/images/btn_unfold.gif"
					}
				}
			</script>

			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>热门小说</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="books">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/detail.action?id=${books.booksid }"><img src="${books.image }"
										alt="${books.booksname}" class="B_blue" /></a></li>
								<li><a href="index/detail.action?id=${books.booksid }" target="_blank" title="${books.booksname}">${books.booksname}</a></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<h3>
						<span>小说列表</span>
					</h3>
					<div class="clearfix goodsBox" style="border: none;">
						<c:forEach items="${booksList}" var="books">
							<div class="goodsItem" style="padding: 10px 3px 15px 2px;">
								<a href="index/detail.action?id=${books.booksid }"><img src="${books.image }" alt="${books.booksname }"
									class="goodsimg" /> </a> <br />
								<p class="f1">
									<a href="index/detail.action?id=${books.booksid }" title="${books.booksname }">${books.booksname }</a>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
