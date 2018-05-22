<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.concurrent.atomic.AtomicInteger"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>首页</title>

<%@ include file="amaze.jsp"%>

<%@ include file="resources.jsp"%>

</head>

<body>
	<%-- 顶部导航栏 --%>
	<%@ include file="top_nav.jsp"%>

	<%-- 轮播海报图片 --%>
	<%@ include file="banner.jsp"%>
	
	<%-- 分类导航 --%>
	<%@ include file="classifild_navgiaction.jsp" %>
	
	<%-- 商品 --%>
	<%@ include file="shopmain.jsp" %>

	<!--引导 -->
	<%@ include file="navCir.jsp" %>

	<!--菜单 -->
	<%@ include file="right_nav_menu.jsp" %>
	
	<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript " src="../basic/js/quick_links.js "></script>
</body>

</html>