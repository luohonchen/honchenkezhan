$(function() {

$("#booksid").blur(
		function() {
			$("#booksid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#booksid").after("<span id='booksid_msg' style='color: red'>书籍不能为空</span>");
			}
	});

$("#title").blur(
		function() {
			$("#title_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>上传日期不能为空</span>");
			}
	});

$("#hits").blur(
		function() {
			$("#hits_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#hits").after("<span id='hits_msg' style='color: red'>点击数不能为空</span>");
			}
	});

$("#cate").blur(
		function() {
			$("#cate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cate").after("<span id='cate_msg' style='color: red'>是否收费不能为空</span>");
			}
	});

$("#thepre").blur(
		function() {
			$("#thepre_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#thepre").after("<span id='thepre_msg' style='color: red'>上一章不能为空</span>");
			}
	});

$("#thenxt").blur(
		function() {
			$("#thenxt_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#thenxt").after("<span id='thenxt_msg' style='color: red'>下一章不能为空</span>");
			}
	});







$('#sub').click(function(){
var booksid = $("#booksid").val();
var title = $("#title").val();
var contents = $("#contents").val();
var addtime = $("#addtime").val();
var hits = $("#hits").val();
var cate = $("#cate").val();
var thepre = $("#thepre").val();
var thenxt = $("#thenxt").val();
$("#booksid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#hits_msg").empty();
$("#cate_msg").empty();
$("#thepre_msg").empty();
$("#thenxt_msg").empty();
if (booksid == "" || booksid == null) {
	$("#booksid").after("<span id='booksid_msg' style='color: red'>书籍不能为空</span>");
	return false;
}
if (title == "" || title == null) {
	$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>上传日期不能为空</span>");
	return false;
}
if (hits == "" || hits == null) {
	$("#hits").after("<span id='hits_msg' style='color: red'>点击数不能为空</span>");
	return false;
}
if (cate == "" || cate == null) {
	$("#cate").after("<span id='cate_msg' style='color: red'>是否收费不能为空</span>");
	return false;
}
if (thepre == "" || thepre == null) {
	$("#thepre").after("<span id='thepre_msg' style='color: red'>上一章不能为空</span>");
	return false;
}
if (thenxt == "" || thenxt == null) {
	$("#thenxt").after("<span id='thenxt_msg' style='color: red'>下一章不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#booksid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#hits_msg").empty();
$("#cate_msg").empty();
$("#thepre_msg").empty();
$("#thenxt_msg").empty();
});

});
