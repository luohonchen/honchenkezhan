<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="userMenu">
	
	<a href="index/userinfo.action"><img src="themes/ecmoban_meilishuo/images/u2.gif" />用户信息</a>
	<a href="index/prePwd.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />修改密码</a>
	<c:if test="${sessionScope.role == '作者' }">
		<a href="index/preBooks.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />发布书籍</a>
		<a href="index/myBooks.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />我的书籍</a>
		<a href="index/preSections.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />上传章节</a>
	</c:if>
	
	<a href="index/myFav.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />我的收藏</a>
	<a href="index/preCharge.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />用户充值</a>
	<a href="index/myCharge.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />我的充值</a>
	<a href="index/myPays.action"><img src="themes/ecmoban_meilishuo/images/u3.gif" />消费记录</a>
	<a href="index/exit.action" style="background: none; text-align: right; margin-right: 10px;"> 
	<img src="themes/ecmoban_meilishuo/images/bnt_sign.gif" /> </a>
	
</div>
