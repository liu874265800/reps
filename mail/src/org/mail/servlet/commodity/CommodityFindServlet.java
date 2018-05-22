package org.mail.servlet.commodity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mail.entity.Commodity;
import org.mail.service.commodity.CommodityService;

@WebServlet("/home/commodityFindServlet")
public class CommodityFindServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CommodityService commodityService = new CommodityService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		Commodity commodity = commodityService.findCommodityById(cid);
		if(null != commodity){
			req.setAttribute("commodity", commodity);
			req.getRequestDispatcher("introduction.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("notfound.jsp");
		}
	}

}
