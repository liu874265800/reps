/**
 * 下单支付模块
 */
$(document).ready(function() {
	
	// 获取cookie
	function getCookie(name) {
		var cookies = document.cookie.split(';');
		var value;
		for (var i = 0; i < cookies.length; i++) {
			var cookie = cookies[i].split('=');
			if (cookie[0].trim() == name) {
				value = cookie[1];
				break;
			}
		}
		return value;
	}
	
	var payModel = new Object();
	payModel.init = function() {
		// 初始化购物车
		var shopcart = getCookie("shopcart");
		shopcart = JSON.parse(shopcart);
		// 商品数量
		var count = shopcart.length;
		// 商品总金额
		var all_sum_price = 0;
		// 实际付款(包含运费)
		var payment_price = 0;
		// 加载商品模板
		$.get('http://localhost:8080/mail/js/pay.tmp',function(result){
			// 将购物车中商品显示到购物车页面
			for(var i = 0; i < shopcart.length; i++){
				var payTmp = result;
				var commondity = shopcart[i];
				// 计算总价格
				var sum_price = commondity.count * commondity.price;
				all_sum_price+=sum_price;
				payTmp = payTmp.replace("#{TITLE}",commondity.name).replace("#{PRICE}",commondity.price).replace("#{COUNT}",commondity.count).replace("#{SUM_PRICE}",sum_price);
				// 将购物车中商品显示到下单页面
				$($("#payTable")[0].childNodes[5]).after(payTmp);
			}
			
			// 获取运费
			var sys_item_freprices = $(".sys_item_freprice");
			var sys_item_freprice = 0;
			for(var i = 0; i < sys_item_freprices.length; i++){
				sys_item_freprice += parseInt(sys_item_freprices[i].innerText);
			}
			console.info('---');
			// 计算实际付款
			payment_price = all_sum_price + sys_item_freprice;
			$(".pay-sum")[0].innerText = payment_price;
			$("#J_ActualFee").text(payment_price);
		});
	}
	
	payModel.init();
	
	// 下单支付按钮
	$("#J_Go").bind({click:function(){
		// 收货地址
		
		// 物流方式
		
		// 支付方式
		
		// 订单信息
		var shopcart = getCookie("shopcart");
		
		// 商品价格
		
		// 用户留言
		
		// 提交订单
		$("#data").val(shopcart);
		$("#dataForm").submit();
	}});
	
});

