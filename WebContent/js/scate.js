$(function() {

$("#scatename").blur(
		function() {
			$("#scatename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#scatename").after("<span id='scatename_msg' style='color: red'>类型名称不能为空</span>");
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

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var scatename = $("#scatename").val();
var bcateid = $("#bcateid").val();
var memo = $("#memo").val();
$("#scatename_msg").empty();
$("#bcateid_msg").empty();
$("#memo_msg").empty();
if (scatename == "" || scatename == null) {
	$("#scatename").after("<span id='scatename_msg' style='color: red'>类型名称不能为空</span>");
	return false;
}
if (bcateid == "" || bcateid == null) {
	$("#bcateid").after("<span id='bcateid_msg' style='color: red'>大类不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#scatename_msg").empty();
$("#bcateid_msg").empty();
$("#memo_msg").empty();
});

});
