$(function() {

$("#usesid").blur(
		function() {
			$("#usesid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usesid").after("<span id='usesid_msg' style='color: red'>发布人不能为空</span>");
			}
	});

$("#booksname").blur(
		function() {
			$("#booksname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#booksname").after("<span id='booksname_msg' style='color: red'>名称不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
			}
	});

$("#bcateid").blur(
		function() {
			$("#bcateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bcateid").after("<span id='bcateid_msg' style='color: red'>大类不能为空</span>");
			}
	});

$("#scateid").blur(
		function() {
			$("#scateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#scateid").after("<span id='scateid_msg' style='color: red'>子类不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var usesid = $("#usesid").val();
var booksname = $("#booksname").val();
var image = $("#image").val();
var bcateid = $("#bcateid").val();
var scateid = $("#scateid").val();
var contents = $("#contents").val();
$("#usesid_msg").empty();
$("#booksname_msg").empty();
$("#image_msg").empty();
$("#bcateid_msg").empty();
$("#scateid_msg").empty();
$("#contents_msg").empty();
if (usesid == "" || usesid == null) {
	$("#usesid").after("<span id='usesid_msg' style='color: red'>发布人不能为空</span>");
	return false;
}
if (booksname == "" || booksname == null) {
	$("#booksname").after("<span id='booksname_msg' style='color: red'>名称不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>封面不能为空</span>");
	return false;
}
if (bcateid == "" || bcateid == null) {
	$("#bcateid").after("<span id='bcateid_msg' style='color: red'>大类不能为空</span>");
	return false;
}
if (scateid == "" || scateid == null) {
	$("#scateid").after("<span id='scateid_msg' style='color: red'>子类不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usesid_msg").empty();
$("#booksname_msg").empty();
$("#image_msg").empty();
$("#bcateid_msg").empty();
$("#scateid_msg").empty();
$("#contents_msg").empty();
});

});
