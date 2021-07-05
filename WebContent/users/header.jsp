<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="themes/ecmoban_meilishuo/style.css" rel="stylesheet" type="text/css" />



<div class="top_nav">
	<div class="block">

		<ul class="top_bav_l">
			<li>&nbsp;</li>
		</ul>

		<div class="header_r">
			<c:if test="${sessionScope.userid == null }">
				<font id="ECS_MEMBERZONE"> 欢迎光临本站，<a href="index/preLogin.action">[用户登录]</a> &nbsp;<a
					href="index/preReg.action">[用户注册]</a></font>
			</c:if>

			<c:if test="${sessionScope.userid != null }">
				<c:if test="${sessionScope.writerid == null }">
					<font id="ECS_MEMBERZONE"> 欢迎光临本站${sessionScope.username }， <a href="index/usercenter.action">[用户中心]</a>&nbsp;<a
						href="index/exit.action">[退出系统]</a>
					</font>
				</c:if>
			</c:if>

		</div>
	</div>
</div>
<div class=" block header_bg" style="margin-bottom: 0px;">
	<div class="clear_f"></div>
	<div class="header_top logo_wrap">
		<a class="logo_new" href="index.jsp"><img src="themes/ecmoban_meilishuo/images/logo.gif" /></a>
		<div class="ser_n">
			<form id="searchForm" class="searchBox" name="searchForm" method="post" action="index/query.action">
				<div class="search-table">
					<span class="cur" data-type="1">&nbsp;</span>
				</div>
				<span class="ipt1"><em class="i_search"></em> <input name="name" type="text" id="" name"" value=""
					class="searchKey" /> </span> <span class="ipt2"> <input type="submit" name="imageField"
					class="fm_hd_btm_shbx_bttn" value="搜 索">
				</span>
			</form>
			<div class="clear_f"></div>
			<ul class="searchType none_f">
			</ul>
		</div>
	</div>
</div>
<div style="clear: both"></div>

<div class="menu_box clearfix">
	<div class="block">
		<div class="menu">
			<a href="index.jsp" class="cur">首页</a> <a href="index/article.action" class="cur">新闻公告</a> <a href="index/all.action"
				class="cur">全部小说</a> <a href="index/allOver.action" class="cur">完本小说</a>
		</div>
	</div>
</div>
<%
	String message = (String) session.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "');");
		out.println("</script>");
	}
	session.removeAttribute("message");
%>