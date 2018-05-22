<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<%@ include file="amaze.jsp" %>

<link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//绑定登录按钮事件
	com.bindLoginEvent();
});
</script>
</head>

<body>

	<div class="login-boxtitle">
		<a href="home.jsp"><img alt="logo" src="../images/logobig.png" /></a>
	</div>

	<div class="login-banner">

		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="../images/big.jpg" />
			</div>

			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>
				<form id="login_form" method="post">
					<div class="login-form">
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i></label> <input
								type="text" name="account" id="user" placeholder="邮箱/手机/用户名">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i></label> <input
								type="password" name="password" id="password"
								placeholder="请输入密码">
						</div>
						<input type="hidden" name="remember" id="remember">
					</div>
				</form>
				<div class="login-links">
					<label for="remember-me"><input id="remember-me"
						type="checkbox">记住密码</label> <a href="find_password.jsp" class="am-fr">忘记密码</a> <a
						href="register.jsp" class="zcnext am-fr am-btn-default">注册</a> <br />
				</div>

				<div class="am-cf">
					<input type="button" id="login_button" value="登 录" class="am-btn am-btn-primary am-btn-sm">
				</div>
				<div class="partner">
					<h3>合作账号</h3>
					<div class="am-btn-group">
						<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
						<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span>
						</a></li>
						<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span>
						</a></li>
					</div>
				</div>

			</div>
		</div>

	</div>

<%@ include file="footer.jsp" %>

</body>
</html>