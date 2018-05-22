package org.mail.servlet.order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mail.cache.CacheContext;
import org.mail.common.AccessToken;
import org.mail.common.ShopCartCommodity;
import org.mail.common.State;
import org.mail.entity.Order;
import org.mail.entity.OrderDetails;
import org.mail.entity.Users;
import org.mail.jdbc.JdbcTemplate;
import org.mail.util.DateUtil;

/**
 * 订单业务类
 * @author VIC
 *
 */
public class OrderService extends JdbcTemplate<Order> {
	
	
	private OrderDetailsService orderDetailsService = new OrderDetailsService(); 

	/**
	 * 添加订单
	 * @param id
	 * @param commodities
	 * @return
	 */
	public Order addOrder(String sessionId, List<ShopCartCommodity> commodities) {
		
		// 构建订单
		Order order = new Order();
		Date currentDate = new Date();
		order.setCREATE_TIME(currentDate);
		// 订单号格式：SHOP20180518时间戳
		String orderNumber = "SHOP" + DateUtil.getCurrentDateYYYYMMDDString() + System.currentTimeMillis();
		order.setO_NUMBER(orderNumber);
		float sumPrice = culSumPrice(commodities);
		order.setO_PRICE(sumPrice);
		order.setO_STATE(State.NOTPAY.toString());
		AccessToken accessToken = CacheContext.getCache(sessionId, AccessToken.class);
		order.setU_ID(accessToken.getUserId());
		
		// 保存订单
		int modify = execute("insert into orders values(ORDER_SEQ.nextval,?,?,?,?,?)",
				order.getO_PRICE(), new Timestamp(order.getCREATE_TIME().getTime()), order.getO_STATE(), order.getU_ID(), order.getO_NUMBER());
		
		// 添加订单成功
		if(modify > 0){
			// 获取订单ID
			order = findByAttribute("select * from orders where O_ID = (select max(O_ID) from orders)");
			// 添加订单详情列表
			List<OrderDetails> orderDetailss = buildOrderDetails(order,commodities);
			modify = orderDetailsService.batchAddOrderDetails(orderDetailss);
		}
		
		return order;
	}

	/**
	 * 根据订单及商品构建订单详情对象
	 * @param order
	 * @param commodities
	 * @return
	 */
	private List<OrderDetails> buildOrderDetails(Order order, List<ShopCartCommodity> commodities) {
		List<OrderDetails> orderDetailss = new ArrayList<OrderDetails>();
		for(ShopCartCommodity shopCartCommodity : commodities){
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setC_ID(shopCartCommodity.getId());
			orderDetails.setC_NUMBER(shopCartCommodity.getCount());
			orderDetails.setC_PRICE(shopCartCommodity.getPrice());
			orderDetails.setO_ID(order.getO_ID());
			orderDetails.setSTATE(State.NOTPAY.toString());
			orderDetails.setCREATE_TIME(new Timestamp(order.getCREATE_TIME().getTime()));
			orderDetailss.add(orderDetails);
		}
		return orderDetailss;
	}

	/**
	 * 获取订单总金额
	 * @param commodities
	 * @return
	 */
	private float culSumPrice(List<ShopCartCommodity> commodities) {
		float sum_price = 0;
		for(ShopCartCommodity shopCartCommodity : commodities){
			sum_price+= shopCartCommodity.getPrice() + shopCartCommodity.getCount();
		}
		return sum_price;
	}

}
