$(function(){
	$(selectall).on("click",function(){
		$(":checkbox[id='gid']").each(function(){
			$(this).prop("checked",$(selectall).prop("checked")) ;
		}) ;
	}) ;
	$(deleteBtn).on("click",function(){
		gid = "" ;
		$(":checkbox[id='gid']").each(function(){
			if ($(this).prop("checked") == true) {
				gid += $(this).val() + "," ;
			}
		}) ;
		if (gid == "") { 
			operateAlert(false,"","您还未选择任何要删除的数据！") ;
		} else {
			window.location = jsDeleteUrl + "?ids=" + gid ;
		}
	}) ;
})