$(function() {
	$('#bcateid').change(function() {
		var loc = $("input[name='basepath']").val();
		var id = $(this).val();
		var url = loc + "ajax/getScate.action?id=" + id;
		$.ajax({
			type : "get",
			url : url,
			dataType : "json",
			success : function(json) {
				var ascateid = json.scateid.replace("[", "").replace("]", "").split(",");
				var scatename = json.scatename.replace("[", "").replace("]", "").split(",");
				var myOptions = '<option value="">---请选择小说小类---</option>';
				for (var i = 0; i < ascateid.length; i++) {
					myOptions += '<option value="' + ascateid[i] + '">' + scatename[i] + '</option>';
				}
				$("#scateid").empty();
				$("#scateid").html(myOptions);
			},
			error : function() {
				alert("ajax请求发生错误3");
			}
		});
	});
});