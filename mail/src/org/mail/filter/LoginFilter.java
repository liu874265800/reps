package org.mail.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mail.cache.CacheContext;
import org.mail.common.AccessToken;
import org.mail.common.Constans;
import org.mail.common.RequestResponse;
import org.mail.service.user.UsersService;
import org.mail.util.LoggerUtil;

/**
 * 登录过滤器: 
 * 1. 所有用户私有页面及请求需要登录访问
 * 2. 记住密码则自动登录
 */
@WebFilter(urlPatterns={"/home/*","/person/*"})
public class LoginFilter implements Filter {

	private LoggerUtil logger = LoggerUtil.getLogger(LoginFilter.class);
	private UsersService usersService = new UsersService();
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String requestUrl = req.getRequestURI();
		logger.info(requestUrl);
		
		// 从缓存获取访问临牌
		AccessToken accessToken = CacheContext.getCache(req.getSession().getId(), AccessToken.class);
		// 私有请求
		if(requestUrl.indexOf("person/")>=0){
			if(null != accessToken && accessToken.isState()){
				// 已登录
				chain.doFilter(req, resp);
			}else{
				// 未登录
				resp.sendRedirect("../home/login.jsp");
			}
		}else{
			// 公共请求
			if(null != accessToken && accessToken.isState()){
				// 已登录
				chain.doFilter(request, response); 
			}else{
				// 未登录则获取cookie尝试登录
				accessToken = RequestResponse.getAccessTokenFromCookie(req);
				// 有保存过cookie
				if(null != accessToken && !accessToken.isState()){
					// 使用cookie信息登录
					accessToken = usersService.login(req.getSession().getId(), accessToken.getAccount(), accessToken.getPassword());
					if(accessToken.isState()){
						req.getSession().setAttribute(Constans.CURRENT_USER_ACCOUNT, accessToken.getAccount());
						// 登录成功重新设置cookie
						RequestResponse.setCookies(accessToken, resp);
					}
				}
				// 公共请求不登录也可以访问
				chain.doFilter(req, resp);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
