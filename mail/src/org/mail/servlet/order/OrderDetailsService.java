package org.mail.servlet.order;

import java.lang.reflect.Field;
import java.util.List;
import org.mail.entity.OrderDetails;
import org.mail.jdbc.JdbcTemplate;

/**
 * 订单详情业务类
 * @author VIC
 *
 */
public class OrderDetailsService extends JdbcTemplate<OrderDetails> {

	/**
	 * 批量添加订单商品
	 * @param o_ID
	 * @param commodities
	 * @return
	 */
	public int batchAddOrderDetails(List<OrderDetails> orderDetailss) {
		int modify = 0;
		// 将集合转换为二维参数数组
		Object[][] args = listToArray(orderDetailss);
		// 批量添加订单详情记录
		modify = batchInsert("insert into ORDER_DETAILS values(ORDER_DETAILS_SEQ.nextval,?,?,?,?,?,?)", args);
		return modify;
	}

	/**
	 * 将订单详情集合转换为二维数组
	 * @param orderDetails
	 * @return
	 */
	private Object[][] listToArray(List<OrderDetails> orderDetailss) {
		Object[][] args = new Object[orderDetailss.size()][];
		for(int i = 0; i < orderDetailss.size(); i++){
			OrderDetails tmpOrderDetails  = orderDetailss.get(i);
			args[i] = objectToArray(tmpOrderDetails);
		}
		return args;
	}

	/**
	 * 将订单详情转换为数组
	 * @param orderDetails
	 * @return
	 */
	private Object[] objectToArray(OrderDetails orderDetails) {
		
		Field[] fields = orderDetails.getClass().getDeclaredFields();
		Object[] datas = new Object[fields.length-1];
		
		try{
			int index = 0;
			for(int i=0 ; i < fields.length;i++){
				fields[i].setAccessible(true);
				
				Object value = fields[i].get(orderDetails);
				if(null != value){
					datas[index] = value;
					index++;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

}
