<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href=".">首页</a>
			<code> &gt; </code>
			<a href="index/all.action">全部小说</a>
			<code> &gt; </code>
			<a href="index/scate.action?id=${books.bcateid }">${books.bcatename }</a>
			<code> &gt; </code>
			<a href="index/scate.action?id=${books.scateid }">${books.scatename }</a>
			<code> &gt; </code>
			${books.booksname }
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

			<div id="goodsInfo" class="clearfix">


				<div class="imgInfo">
					<img src="${books.image}" alt="${books.booksname  }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>

				<div class="textInfo">
					<h1 class="clearfix">${books.booksname }</h1>
					<ul class="ul2 clearfix">
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>小说大类：</strong><a href="index/scate.action?id=${books.bcateid }">${books.bcatename }</a>
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>小说小类：</strong><a href="index/scate.action?id=${books.scateid }">${books.scatename }</a>
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>作者：</strong>${books.username }
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>上架日期：</strong>${books.addtime}
							</dd>
						</li>
						<li class="clearfix" style="width: 100%">
							<dd>
								<strong>点击数：</strong>${books.hits}
							</dd>
						</li>
					</ul>
					<c:if test="${sessionScope.userid != null }">
						<ul class="bnt_ul">
							<li class="clearfix">
								<dd>&nbsp;</dd>
							</li>
							<li class="padd"><a href="index/addFav.action?id=${books.booksid}">我要收藏</a></li>
						</ul>
					</c:if>
				</div>
			</div>
			<div class="blank"></div>


			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>小说描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>${books.contents}</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
			<div class="box">

				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2>小说章节</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>
							<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
								<tbody style="table-layout: fixed;">
									<c:forEach items="${sectionsList}" var="sections" varStatus="status">
										<c:if test="${status.count eq 1 || (status.count-1) % 4 eq 0}">
											<tr align="center" class="tr3 t_one">
										</c:if>
										<td class="tal f10 y-style"><a href="index/readsections.action?id=${sections.sectionsid }"
											target="_blank">${sections.title }&nbsp;(<font color="red">${sections.cate }</font>)
										</a></td>
										<c:if test="${status.count % 4 eq 0 || status.count eq 4}">
											</tr>
										</c:if>
									</c:forEach>
									<tr>
										<td style="height: 8px"></td>
									</tr>
								</tbody>
							</table>
						</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
