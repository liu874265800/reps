package org.mail.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求响应辅助类
 * @author VIC
 *
 */
public class RequestResponse {

	public static void setCookies(AccessToken accessToken, HttpServletResponse resp) {
		// 设置cookie
		int expiry = 1000 * 60 * 60 * 24 * 30 * 12 * 10;
		
		Cookie accountCookie = new Cookie(Constans.CURRENT_USER_ACCOUNT, accessToken.getAccount());
		Cookie passwordCookie = new Cookie(Constans.CURRENT_USER_PASSWORD, accessToken.getPassword());
		Cookie tokenCookie = new Cookie(Constans.CURRENT_USER_TOKEN, accessToken.getToken());
		
		accountCookie.setMaxAge(expiry);
		passwordCookie.setMaxAge(expiry);
		tokenCookie.setMaxAge(expiry);
		
		resp.addCookie(accountCookie);
		resp.addCookie(passwordCookie);
		resp.addCookie(tokenCookie);
	}
	
	
	public static AccessToken getAccessTokenFromCookie(HttpServletRequest req) {
		AccessToken accessToken = new AccessToken();
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			if(name.equalsIgnoreCase(Constans.CURRENT_USER_ACCOUNT)){
				accessToken.setAccount(value);
			}else if(name.equalsIgnoreCase(Constans.CURRENT_USER_PASSWORD)){
				accessToken.setPassword(value);
			}else if(name.equalsIgnoreCase(Constans.CURRENT_USER_TOKEN)){
				accessToken.setToken(value);
			}
		}
		return accessToken;
	}
	
	public static void delCookies(HttpServletResponse resp) {
		// 删除cookie
		resp.addCookie(new Cookie(Constans.CURRENT_USER_ACCOUNT, null));
		resp.addCookie(new Cookie(Constans.CURRENT_USER_PASSWORD, null));
		resp.addCookie(new Cookie(Constans.CURRENT_USER_TOKEN, null));
	}

}
