package org.mail.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mail.cache.CacheContext;
import org.mail.common.Constans;
import org.mail.common.RequestResponse;
import org.mail.common.AccessToken;
import org.mail.common.ResponseBody;
import org.mail.service.user.UsersService;
import org.mail.util.MD5Util;
import org.mail.util.StringUtil;

/**
 * 用户登录
 */
@WebServlet("/home/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UsersService usersService = new UsersService();

	/**
	 * 登录ajax验证用户名是否存在
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		ResponseBody responseBody = new ResponseBody();
		boolean exists = usersService.checkedEmail(account);
		if(!exists){
			responseBody.setStatus(-1);
			responseBody.setMessage("邮箱或手机不存在.");	
		}
		response.getWriter().write(responseBody.toJson());
		return;
	}

	/**
	 * 登录
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		// 验证
		ResponseBody responseBody = new ResponseBody();
		if(StringUtil.isEmpty(password) || StringUtil.isEmpty(account)){
			responseBody.setStatus(-1);
			responseBody.setMessage("用户名或密码及验证码不能为空");
			resp.getWriter().write(responseBody.toJson());
			return;
		}
		
		// 开始登录
		String sessionId = req.getSession().getId();
		AccessToken accessToken = usersService.login(sessionId, account, MD5Util.encryptMD5(password));
		if(accessToken.isState()){
			responseBody.setMessage("登录成功");
			req.getSession().setAttribute(Constans.CURRENT_USER_ACCOUNT, accessToken.getAccount());
		}else{
			responseBody.setStatus(-1);
			responseBody.setMessage("登录失败");
		}
		
		// 记住密码(设置cookie)
		if(Boolean.valueOf(remember) && accessToken.isState()){
			RequestResponse.setCookies(accessToken, resp);	
		}
		
		resp.getWriter().write(responseBody.toJson());
	}

}
