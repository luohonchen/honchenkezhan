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
			用户充值
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
							<span>用户充值</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addCharge.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">付款银行:</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><select class="inputBg" id="s" style="width: 171">
											<option value="中国工商银行">中国工商银行</option>
											<option value="中国农业银行">中国农业银行</option>
											<option value="中国建设银行">中国建设银行</option>
											<option value="中国交通银行">中国交通银行</option>
											<option value="招商银行">招商银行</option>
											<option value="支付宝">支付宝</option>
									</select></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">卡号:</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="text" placeholder="请输入卡号" name="name"
										size="25" class="inputBg" id="name" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">支付密码:</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="password" placeholder="请输入支付密码" name="cond"
										size="25" class="inputBg" id="cond" /></td>
								</tr>
								<tr>
									<td width="15%" align="right" bgcolor="#FFFFFF">充值金额:</td>
									<td width="85%" align="left" bgcolor="#FFFFFF"><input type="text" placeholder="请输入充值金额" name="money"
										size="25" class="inputBg" id="money" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="hidden" name="basepath" id="basepath"
										value="<%=basePath%>"><input type="submit" class="bnt_blue_1" style="border: none;" value="确认充值" /></td>
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
