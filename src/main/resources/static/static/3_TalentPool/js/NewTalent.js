$(function() {
	var pType = $("#postName");
	ajaxUtil.sendRequest({
		action: "findPost",
		data: {},
		success: function(rs) {
			if(rs.code == 0) {
				var arr = rs.data.content;
				for(var i = 0; i < arr.length; i++) {
					pType.append("<option value='" + arr[i].name + "'>" + arr[i].name + "</option>");
				}
			} else {
				alert(rs.msg);
			}
		}

	})
});
$(function() {
	var pType = $("#deptName");
	ajaxUtil.sendRequest({
		action: "findDept",
		data: {},
		success: function(rs) {
			if(rs.code == 0) {
				var arr = rs.data.content;
				for(var i = 0; i < arr.length; i++) {
					pType.append("<option value='" + arr[i].name + "'>" + arr[i].name + "</option>");
				}
			} else {
				alert(rs.msg);
			}
		}

	})
});