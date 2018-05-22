package org.mail.servlet.order;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mail.common.ShopCartCommodity;
import org.mail.entity.Order;
import org.mail.util.JsonUtil;
import com.google.gson.reflect.TypeToken;

/**
 * 订单Servlet
 * @author VIC
 *
 */
@WebServlet("/person/orderServlet")
public class OrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderService();

	/**
	 * 添加订单
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取订单数据(购物车中商品数据)
		String json = req.getParameter("data");
		
		// 将json数值字符串转换为集合
		Type mtype = new TypeToken<List<ShopCartCommodity>>() {}.getType();
		List<ShopCartCommodity> commodities = JsonUtil.fromJson(json, mtype);
		// 创建订单
		Order order = orderService.addOrder(req.getSession().getId(), commodities);
		req.setAttribute("order", order);
		// 进入确认订单页面
		req.getRequestDispatcher("confirm.jsp").forward(req, resp);
		
	}
}
