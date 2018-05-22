package org.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.cache.CacheContext;
import org.mail.common.Constans;
import org.mail.common.RequestResponse;
import org.mail.util.LoggerUtil;

/**
 * 用户登出
 */
@WebServlet("/userLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
	
	private LoggerUtil logger = LoggerUtil.getLogger(UserLogoutServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account = request.getSession().getAttribute("account").toString();
		
		// 删除会话数据
		request.getSession().setAttribute(Constans.CURRENT_USER_ACCOUNT, null);
		request.getSession().removeAttribute(Constans.CURRENT_USER_ACCOUNT);
		
		// 删除缓存数据
		String sessionId = request.getSession().getId();
		CacheContext.removeCache(sessionId);
		
		// 删除cookie数据
		RequestResponse.delCookies(response);
		
		// 注销会话
		request.getSession().invalidate();
		logger.info(account + " 用户退出.");
		response.sendRedirect("home/home.jsp");
		//request.getRequestDispatcher("home/home.jsp").forward(request, response);
		
	}

}
