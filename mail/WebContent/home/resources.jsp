<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 其他脚本,样式 --%>
<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
<link href="../css/hmstyle.css" rel="stylesheet" type="text/css"/>
<link href="../css/skin.css" rel="stylesheet" type="text/css" />

<script src="../js/common.js"></script>
<script src="../js/shopcart.js"></script>

<script type="text/javascript">

// 初始化购物车及显示购物车商品数量
$(document).ready(function() {
	cartModel.initCart();
	cartModel.updateCartNum();
});

</script>
