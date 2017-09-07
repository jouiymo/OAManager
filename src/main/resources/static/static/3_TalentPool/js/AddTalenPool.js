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
	var pType = $("#Emform");
	ajaxUtil.sendRequest({
		action: "findem",
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
$(function() {
	var pType = $("#sources");
	ajaxUtil.sendRequest({
		action: "findso",
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
$(function() {
	var pType = $("#political");
	ajaxUtil.sendRequest({
		action: "findpoli",
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
$(function() {
	var pType = $("#nation");
	ajaxUtil.sendRequest({
		action: "findna",
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
$(function() {
	var pType = $("#bltype");
	ajaxUtil.sendRequest({
		action: "findbl",
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
$(function() {
	var pType = $("#Marital");
	ajaxUtil.sendRequest({
		action: "findma",
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
$(function() {
	var pType = $("#education");
	ajaxUtil.sendRequest({
		action: "finded",
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
$(function() {
	var pType = $("#degree");
	ajaxUtil.sendRequest({
		action: "findde",
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
