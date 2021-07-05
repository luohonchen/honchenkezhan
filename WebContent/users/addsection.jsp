<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			发布章节
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
							<span>发布章节</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addSections.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">章节名称：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="text" placeholder="请输入章节名称" name="title"
										size="25" class="inputBg" id="title" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">我的小说：</td>
									<td align="left" bgcolor="#FFFFFF"><select name="booksid" class="inputBg" id="booksid">
											<c:forEach items="${booksList}" var="books">
												<option value="${books.booksid}">${books.booksname }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">是否收费：</td>
									<td align="left" bgcolor="#FFFFFF"><select name="cate" class="inputBg" id="cate">
											<option value="收费">收费</option>
											<option value="免费">免费</option>
									</select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">章节描述内容：</td>
									<td align="left" bgcolor="#FFFFFF"><script type="text/javascript" src="ckeditor/ckeditor.js"></script> <textarea
											cols="80" name="contents" id="contents" rows="10">在此添加内容 </textarea> <script type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1"
										style="border: none;" value="确认发布" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
