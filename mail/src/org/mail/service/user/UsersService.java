package org.mail.service.user;

import java.sql.Timestamp;

import org.mail.cache.CacheContext;
import org.mail.common.Type;
import org.mail.common.AccessToken;
import org.mail.common.State;
import org.mail.entity.Users;
import org.mail.jdbc.JdbcTemplate;
import org.mail.service.other.EmailService;
import org.mail.util.MD5Util;
import org.mail.util.StringUtil;

/**
 * 用户业务类
 * @author VIC
 *
 */
public class UsersService extends JdbcTemplate<Users> {
	
	private EmailService emailService = new EmailService();
	
	public boolean checkedAccount(String account) {
		return exists("select * from users where uemail=? or uphone=?", account,account);
	}

	public boolean checkedEmail(String email) {
		return exists("select * from users where uemail=?", email);
	}
	
	public boolean checkedPhone(String email) {
		return exists("select * from users where uphone=?", email);
	}

	public int registerEmail(String email, String password) {
		 
		int modify = execute("insert into USERS values(USER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)", "example","example",MD5Util.encryptMD5(password),"男",29,"head.jpg",email,"1388888",State.ENABLED.toString(),new Timestamp(System.currentTimeMillis()));
		if(modify>0){
			// 注册用户成功后生成邮件通知内容
			emailService.addRegisterEmail(email,Type.REGISTER.toString());
		}
		return modify;
	}

	public int registerPhone(String phone, String password) {
		
		int modify = execute("insert into USERS values(USER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?)","example","example",MD5Util.encryptMD5(password),"男",28,"head.jpg","example@163.com",phone,State.ENABLED.toString(),new Timestamp(System.currentTimeMillis()));
		
		return modify;
	}

	public AccessToken login(String sessionId, String account, String password) {
		
		Users users = findByAttribute("select * from users where uemail=? or uphone=?", account, account);
		AccessToken accessToken = new AccessToken();
		// 如果账号存在
		if(null != users){
			// 如果用户启用
  			if(users.getSTATE().equals(State.ENABLED.toString())){
				// 如果密码正确
				if(users.getUPASSWORD().equals(password)){
					// 将账号及密码再次MD5后放入缓存中
					String accessTokenString = buildAccessToken(account,password);
					accessToken.setUserId(users.getUSERID());
					accessToken.setSessionId(sessionId);
					accessToken.setAccount(account);
					accessToken.setPassword(password);
					accessToken.setToken(accessTokenString);
					accessToken.setState(true);
					CacheContext.setCache(sessionId, accessToken);
					// 其他逻辑
				}
			}
		}
		return accessToken;
	}
	
	/**
	 * 构建登录访问Token令牌: 用户是否登录就验证令牌是否正确
	 * @param account
	 * @param password
	 * @return
	 */
	public String buildAccessToken(String account,String password){
		return MD5Util.encryptMD5(account + password);
	}

	public boolean findPassword(String email) {
		boolean state = false;
		
		if(checkedEmail(email)){
			// 创建新密码
			String password = StringUtil.generatorString();
			// 找回密码邮件通知内容
			state = emailService.addFindPasswordEmail(email,password,Type.FIND_PASSWORD.toString());
		}
		
		return state;
	}

}
