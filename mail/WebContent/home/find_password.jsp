<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>忘记密码</title>
<!-- <link rel="stylesheet" type="text/css" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css"> -->
	
<%@ include file="amaze.jsp" %>
	
<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	com.bindFindPasswordEvent();
});
</script>
</head>

<body>


	<%-- 顶部导航栏 --%>
	<%@ include file="top_nav.jsp"%>

	<div class="clear"></div>

	<div style="text-align: center;">
		<div class="user-email" style="margin-top: 10%; margin-bottom: 10%;">
				<label for="email"><i class="am-icon-envelope-o"></i></label> <input
					type="text" name="email" id="email" placeholder="请输入邮箱账号" required />
				<input type="button" id="find_button" value="找回密码"
					class="am-btn am-btn-primary am-btn-sm">
			</div>
	</div>


	<%@ include file="footer.jsp"%>


</body>
</html>
