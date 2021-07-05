<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<div class="footer">
	<div class="foot_con">
		<div class="blank"></div>
		<div class="record">
			&copy; 2019 ${title} 版权所有，并保留所有权利。 &nbsp; <a href="admin/index.jsp" target="_blank">管理员入口</a>
		</div>
	</div>
	<div class="blank10"></div>
</div>
<div class="blank"></div>