package org.mail.service.commodity;

import org.mail.common.State;
import org.mail.entity.Commodity;
import org.mail.jdbc.JdbcTemplate;

/**
 * 商品业务类
 * @author VIC
 *
 */
public class CommodityService extends JdbcTemplate<Commodity> {

	public Commodity findCommodityById(String cid) {
		return findByAttribute("select * from COMMODITY where \"id\"=? and \"state\"=?", cid,State.ENABLED.toString());
	}

}
