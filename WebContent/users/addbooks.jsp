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
<script type="text/javascript" src="js/jquery-1.3.2.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="js/ajax.js" charset="utf-8"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			发布小说
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
							<span>发布小说</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addBooks.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">小说名称：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="text" placeholder="请输入小说名称" name="booksname"
										size="25" class="inputBg" id="booksname" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">封面：</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="text" placeholder="请选择图片" name="image"
										size="25" class="inputBg" id="image" onclick="selimage();" readonly="readonly" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">小说大类：</td>
									<td align="left" bgcolor="#FFFFFF"><select name="bcateid" class="inputBg" id="bcateid">
											<option value="">---请选择小说大类---</option>
											<c:forEach items="${cateList}" var="bcate">
												<option value="${bcate.bcateid}">${bcate.bcatename }</option>
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">小说小类：</td>
									<td align="left" bgcolor="#FFFFFF"><select name="scateid" class="inputBg" id="scateid">
											<option value="">---请选择小说小类---</option>
									</select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">小说描述：</td>
									<td align="left" bgcolor="#FFFFFF"><script type="text/javascript" src="ckeditor/ckeditor.js"></script> <textarea
											cols="80" name="contents" id="contents" rows="10">在此添加内容 </textarea> <script type="text/javascript">
												CKEDITOR.replace('contents', {
													language : 'zh-cn'
												});
											</script></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="hidden" name="basepath" id="basepath" value="<%=basePath %>"><input type="submit" class="bnt_blue_1"
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
