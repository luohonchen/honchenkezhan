$(function() {

$("#bcatename").blur(
		function() {
			$("#bcatename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bcatename").after("<span id='bcatename_msg' style='color: red'>大类名称不能为空</span>");
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
var bcatename = $("#bcatename").val();
var memo = $("#memo").val();
$("#bcatename_msg").empty();
$("#memo_msg").empty();
if (bcatename == "" || bcatename == null) {
	$("#bcatename").after("<span id='bcatename_msg' style='color: red'>大类名称不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#bcatename_msg").empty();
$("#memo_msg").empty();
});

});
