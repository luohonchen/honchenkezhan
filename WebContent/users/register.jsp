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
<title>${title}</title>
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/u.js" charset="UTF-8"></script>
<script language="javascript" type="text/javascript" src="laydate/laydate.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="UTF-8"></script>
</head>
<%
	String message = (String) session.getAttribute("msg");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	request.removeAttribute("msg");
%>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			用户注册
		</div>
	</div>
	<div class="blank"></div>
	<div class="block">
		<div class="box">
			<div class="box_1">
				<h3>
					<span>用户注册</span>
				</h3>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr valign="top">
						<td bgcolor="#FFFFFF" align="center">
							<form action="index/register.action" method="post" name="myform">
								<table width="60%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">用户名：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input type="text" name="username" size="25"
											class="inputBg" id="username" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">密码：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="password" type="password" size="25"
											class="inputBg" id="password" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">姓名：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="realname" type="text" size="25"
											class="inputBg" id="realname" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">性别：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><select name="sex" id="sex" class="inputBg">
												<option value="男">男</option>
												<option value="女">女</option>
										</select></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">出生日期：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="birthday" type="text" size="25"
											class="inputBg" id="birthday" /></td>  
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">联系方式：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><input name="contact" type="text" size="25"
											class="inputBg" id="contact" /></td>
									</tr>
									<tr>
										<td width="28%" align="right" bgcolor="#FFFFFF">注册类型：</td>
										<td width="76%" align="left" bgcolor="#FFFFFF"><select name="role" id="role" class="inputBg">
												<option value="读者">读者</option>
												<option value="作者">作者</option>
										</select></td>
									</tr>
									<tr>
										<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1"
											style="border: none;" value="确认注册" /></td>
									</tr>

								</table>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="blank5"></div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
