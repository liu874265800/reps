/**
 * 购物车模块
 */
var cartModel = new Object();
/**
 * 购物车在cookie中的名称
 */
cartModel.cartName = 'shopcart';

/**
 * 初始化购物车
 */
cartModel.initCart = function() {
	var shopcart = com.getCookie(cartModel.cartName);
	// 购物车存在则不初始化
	if(null == shopcart || undefined==shopcart){
		// 初始化购物车
		com.setCookie(cartModel.cartName, JSON.stringify(new Array()));
	}
}

/**
 * 根据商品ID从cookie购物车查询商品
 */
cartModel.searchCommodityFromCookie = function(id) {
	var shopcart = com.getCookie(cartModel.cartName);
	shopcart = JSON.parse(shopcart);
	for (var i = 0; i < shopcart.length; i++) {
		var commodity = shopcart[i];
		if (commodity.id == id) {
			return commodity;
		}
	}
	return null;
}

/**
 * 检查商品不在购物车中
 */
cartModel.isNotCommodityInCookie = function(id) {
	return null == cartModel.searchCommodityFromCookie(id);
}

/**
 * 添加商品到购物车
 */
cartModel.addCommondityToShopCart = function(commondity) {
	var shopcart = com.getCookie(cartModel.cartName);
	shopcart = JSON.parse(shopcart);
	var index = shopcart.length;
	shopcart[index] = commondity;
	com.setCookie(cartModel.cartName, JSON.stringify(shopcart));
}

/**
 * 删除购物车中商品
 */
cartModel.delelteCommondityFormShopCart = function(id) {
	var shopcart = com.getCookie(cartModel.cartName);
	shopcart = JSON.parse(shopcart);
	for (var i = 0; i < shopcart.length; i++) {
		var commodity = shopcart[i];
		if (commodity.id == id) {
			shopcart.splice(i,1);
			break;
		}
	}
	com.setCookie(cartModel.cartName, JSON.stringify(shopcart));
}



/**
 * 更新商品到购物车
 */
cartModel.updateCommondityToShopCart = function(commondity, state) {
	var shopcart = com.getCookie(cartModel.cartName);
	shopcart = JSON.parse(shopcart);
	for (var i = 0; i < shopcart.length; i++) {
		var oldCommodity = shopcart[i];
		if (oldCommodity.id == commondity.id) {
			if (state) {
				shopcart[i].count++;
			} else {
				var c = shopcart[i].count;
				c--;
				c = c < 1 ? 1 : c;
				shopcart[i].count = c;
			}
			break;
		}
	}
	com.setCookie(cartModel.cartName, JSON.stringify(shopcart));
}

/**
 * 初始化购物车页面商品列表
 */
cartModel.initList = function() {
	// 初始化购物车
	var shopcart = com.getCookie("shopcart");
	shopcart = JSON.parse(shopcart);
	var count = shopcart.length;
	var all_sum_price = 0;
	// 加载商品模板
	$.get('http://localhost:8080/mail/js/shopcart.tmp',function(result){
		// 将购物车中商品显示到购物车页面
		for(var i = 0; i < shopcart.length; i++){
			var shopcartTmp = result;
			var commondity = shopcart[i];
			// 计算总价格
			var sum_price = commondity.count * commondity.price;
			all_sum_price+=sum_price;
			shopcartTmp = shopcartTmp.replace("#{TITLE}",commondity.name).replace("#{PRICE}",commondity.price).replace("#{COUNT}",commondity.count).replace("#{SUM_PRICE}",sum_price).replace(new RegExp("#{CID}","gm"), commondity.id);
			$(".bundle-main")[0].innerHTML+=shopcartTmp;
		}
		
		$("#J_SelectedItemsCount").text(count);
		$("#J_Total").text(all_sum_price);
		cartModel.bindEvent();
	});
}

/**
 * 获取商品信息构建商品对象
 */
cartModel.getCommondiryFromPage = function(id) {
	var commondity;
	if(null == id){
		commondity = new Object();
		commondity.id = $("#id").val();
		commondity.name = $("#name").val();
		commondity.price = $("#price").val();
		commondity.count = $("#count").val();
	}else{
		commondity = cartModel.searchCommodityFromCookie(id);	
	}
	return commondity;
}

/**
 * 获取购物车中商品数量
 */
cartModel.getCommonditySizeFromShopcart = function() {
	var shopcart = com.getCookie(cartModel.cartName);
	shopcart = JSON.parse(shopcart);
	return shopcart.length;

}

/**
 * 添加或更新商品到购物车
 */
cartModel.addOrUpdateCommondity = function(state,id) {
	// 获取商品
	var commondity = cartModel.getCommondiryFromPage(id);
	// 根据商品id从购物车中查找商品
	var has = cartModel.isNotCommodityInCookie(commondity.id);
	// 不存在则添加
	if (has) {
		cartModel.addCommondityToShopCart(commondity);
	} else {
		// 商品已经在则更新
		cartModel.updateCommondityToShopCart(commondity, state);
	}
	cartModel.updateCartNum();
}

/**
 * 更新页面购物车数量
 */
cartModel.updateCartNum = function() {
	var size = cartModel.getCommonditySizeFromShopcart();
	$("#J_MiniCartNum").text(size);
	$("#cart_num").text(size);
	$(".cart_num").text(size);
}

/**
 * 打印购物车
 */
cartModel.showCommonditys = function() {
	var shopcart = com.getCookie("shopcart");
	shopcart = JSON.parse(shopcart);
	for (var i = 0; i < shopcart.length; i++) {
		var commodity = shopcart[i];
		console.info(commodity.id + " " + commodity.name + " "
				+ commodity.price + " " + commodity.count);
	}
}

/**
 * 绑定事件
 */
cartModel.bindEvent = function() {
	if($("#LikBasket").length > 0){
		$("#LikBasket").on('open.popover.amui', function() {
			// 添加或更新商品到购物车
			cartModel.addOrUpdateCommondity(true,null);
			cartModel.showCommonditys();

		}).popover({
			content : '添加购物车成功',
			theme : 'success'
		});
		// 鼠标移除关闭弹层
		$("#LikBasket").mouseout(function() {
			$("#LikBasket").popover('close');
		});
	}
	

	// 加号
	$("#add").on('open.popover.amui', function() {
		// 添加或更新商品到购物车
		cartModel.addOrUpdateCommondity(true,this.name);
		cartModel.showCommonditys();

	}).popover({
		content : '+1',
		theme : 'success'
	});
	// 鼠标移除关闭弹层
	$("#add").mouseout(function() {
		$("#add").popover('close');
	});

	// 减号
	$("#min").on('open.popover.amui', function() {
		// 添加或更新商品到购物车
		cartModel.addOrUpdateCommondity(false,this.name);
		cartModel.showCommonditys();

	}).popover({
		content : '-1',
		theme : 'success'
	});
	// 鼠标移除关闭弹层
	$("#min").mouseout(function() {
		$("#min").popover('close');
	});
	
	// 删除商品
	$(".delete").bind({click:function(){
		cartModel.delelteCommondityFormShopCart(this.id);
	}});
}