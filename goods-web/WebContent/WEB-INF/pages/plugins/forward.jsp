<%@ page pageEncoding="UTF-8" %>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<script type="text/javascript">
	window.onload = function() {
		goForward() ;
	}
	function goForward() {
		spanObject = document.getElementById("countSpan") ;
		count = parseInt(spanObject.innerHTML) ;	// 取得当前计数的内容
		count -- ; 
		if (count == 0) {	// 要进行跳转
			window.location = "<%=basePath%>${url}" ;	// 跳转
		} else {
			spanObject.innerHTML = count ;
			setTimeout(goForward,1000) ; 
		}
	}
</script>
<div>${msg}</div>
<div><span id="countSpan">2</span>秒后跳转到其它页面！</div>