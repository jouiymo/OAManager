$(function() {
	var pType = $("#type");
	ajaxUtil.sendRequest({
		action: "findpo",
		data: {},
		success: function(rs) {
			if(rs.code == 0) {
				var arr = rs.data;
				for(var i = 0; i < arr.length; i++) {
					pType.append("<option value='" + arr[i].id + "'>" + arr[i].name + "</option>");
				}
			} else {
				alert(rs.msg);
			}
		}

	})
});