function AjaxUtil () {
	this.BASE = "http://localhost:8099/";
	this.MODEL = "get";
	this.sendRequest =function  (opt) {
		$.ajax({
			type:this.MODEL,
			dataType:"json",
			data:opt.data,
			url:this.BASE + opt.action,
			complete:function  (xh,state) {
				if(state == "success"){
					var json = JSON.parse(xh.responseText);
					opt.success(json);
					return;
				}
				console.log("读取数据失败！");
			}
		})
	}
}
var ajaxUtil = new AjaxUtil();