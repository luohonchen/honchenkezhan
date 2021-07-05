<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
	$(function() {
		var uls = $('.sidebar-nav > ul > *').clone();
		uls.addClass('visible-xs');
		$('#main-menu').append(uls.clone());
	});
</script>
<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
<div class="sidebar-nav">
	<ul>

		<li><a data-target=".legal-menu1" class="nav-header collapsed" data-toggle="collapse">管理员信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu1 nav nav-list collapse">
				<li><a href="admin/createAdmin.action"><span class="fa fa-caret-right"></span>新增管理员信息</a></li>
				<li><a href="admin/getAllAdmin.action"><span class="fa fa-caret-right"></span>管理员信息列表</a></li>
				<li><a href="admin/queryAdminByCond.action"><span class="fa fa-caret-right"></span>管理员信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu2" class="nav-header collapsed" data-toggle="collapse">平台用户信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu2 nav nav-list collapse">
				<li><a href="users/getAllUsers.action"><span class="fa fa-caret-right"></span>平台用户信息列表</a></li>
				<li><a href="users/queryUsersByCond.action"><span class="fa fa-caret-right"></span>平台用户信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu3" class="nav-header collapsed" data-toggle="collapse">新闻公告信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu3 nav nav-list collapse">
				<li><a href="article/createArticle.action"><span class="fa fa-caret-right"></span>新增新闻公告信息</a></li>
				<li><a href="article/getAllArticle.action"><span class="fa fa-caret-right"></span>新闻公告信息列表</a></li>
				<li><a href="article/queryArticleByCond.action"><span class="fa fa-caret-right"></span>新闻公告信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu4" class="nav-header collapsed" data-toggle="collapse">小说大类信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu4 nav nav-list collapse">
				<li><a href="bcate/createBcate.action"><span class="fa fa-caret-right"></span>新增小说大类信息</a></li>
				<li><a href="bcate/getAllBcate.action"><span class="fa fa-caret-right"></span>小说大类信息列表</a></li>
				<li><a href="bcate/queryBcateByCond.action"><span class="fa fa-caret-right"></span>小说大类信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu5" class="nav-header collapsed" data-toggle="collapse">小说子类信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu5 nav nav-list collapse">
				<li><a href="scate/createScate.action"><span class="fa fa-caret-right"></span>新增小说子类信息</a></li>
				<li><a href="scate/getAllScate.action"><span class="fa fa-caret-right"></span>小说子类信息列表</a></li>
				<li><a href="scate/queryScateByCond.action"><span class="fa fa-caret-right"></span>小说子类信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu6" class="nav-header collapsed" data-toggle="collapse">书籍信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu6 nav nav-list collapse">
				<li><a href="books/getAllBooks.action"><span class="fa fa-caret-right"></span>书籍信息列表</a></li>
				<li><a href="books/queryBooksByCond.action"><span class="fa fa-caret-right"></span>书籍信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu7" class="nav-header collapsed" data-toggle="collapse">章节信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu7 nav nav-list collapse">
				<li><a href="sections/getAllSections.action"><span class="fa fa-caret-right"></span>章节信息列表</a></li>
				<li><a href="sections/querySectionsByCond.action"><span class="fa fa-caret-right"></span>章节信息查询</a></li>
			</ul></li>


		<li><a data-target=".legal-menu9" class="nav-header collapsed" data-toggle="collapse">用户充值信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu9 nav nav-list collapse">
				<li><a href="charge/getAllCharge.action"><span class="fa fa-caret-right"></span>用户充值信息列表</a></li>
				<li><a href="charge/queryChargeByCond.action"><span class="fa fa-caret-right"></span>用户充值信息查询</a></li>
			</ul></li>

		<li><a data-target=".legal-menu10" class="nav-header collapsed" data-toggle="collapse">消费记录信息管理<i
				class="fa fa-collapse"></i></a></li>
		<li><ul class="legal-menu10 nav nav-list collapse">
				<li><a href="pays/getAllPays.action"><span class="fa fa-caret-right"></span>消费记录信息列表</a></li>
				<li><a href="pays/queryPaysByCond.action"><span class="fa fa-caret-right"></span>消费记录信息查询</a></li>
			</ul></li>

	</ul>
</div>

