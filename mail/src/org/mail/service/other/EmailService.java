package org.mail.service.other;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.mail.common.State;
import org.mail.entity.Email;
import org.mail.jdbc.JdbcTemplate;
import org.mail.util.DateUtil;
import org.mail.util.FileUtil;
import org.mail.util.LoggerUtil;
import org.mail.util.MailParameter;
import org.mail.util.MailUtil;

/**
 * 邮件业务类
 * @author VIC
 *
 */
public class EmailService extends JdbcTemplate<Email> {
	
	private static LoggerUtil logger = LoggerUtil.getLogger(EmailService.class);

	/**
	 * 添加注册邮件
	 * @param email
	 * @param emailType
	 * @return
	 */
	public boolean addRegisterEmail(String email, String emailType) {
		
		String insertSql = "insert into EMAIL values(EMAIL_SEQ.nextval,?,?,?,?,?,?,?,?,?)";                        
		String E_TITLE = "2018商城-注册成功";                         
		String E_CONTENT = FileUtil.loadFileContent("/config/template/active_account_email.html");
		String E_EMAIL = email;                         
		Date E_SEND_TIME  = new Timestamp(System.currentTimeMillis());
		Date CREATE_TIME = E_SEND_TIME;                     
		String CREATOR = "SYSTEM";                         
		String E_SEND_STATE = State.WAIT.toString();                         
		String STATE = State.ENABLED.toString();                         
		String E_TYPE = emailType; 
		E_CONTENT = E_CONTENT.replaceAll("TITLE", E_TITLE).replaceAll("USERNAME", email).replaceAll("EMAIL", "2018show@shop.com").replaceAll("TIME", DateUtil.formatYYYYMMDD(CREATE_TIME));
		int modify = execute(insertSql, E_TITLE,E_CONTENT,E_EMAIL,E_SEND_TIME,CREATE_TIME,CREATOR,E_SEND_STATE,STATE,E_TYPE);
		return modify > 0;
	}

	/**
	 * 根据状态查询邮件
	 * @param state
	 * @return
	 */
	public List<Email> searchEmailByState(String state) {
		String searchSql = "select * from EMAIL where E_SEND_STATE=?";
		return quary(searchSql, state);
	}

	/**
	 * 发送所有WAIT状态的邮件
	 */
	public void sendEmail() {
		// 加载邮件服务器配置
		EmailConfig emailConfig = EmailConfig.getInstance();
		// 查询所有等待发送的邮件
		List<Email> waitEmails = searchEmailByState(State.WAIT.toString());
		logger.info("查询到等待发送邮件数量: " + waitEmails.size());
		// 发送方式1: 循序发送
		List<Integer> emailIds = new ArrayList<Integer>();
		for(Email email : waitEmails){
			MailParameter parameter = new MailParameter();
			parameter.setContent(email.getE_CONTENT());
			parameter.setEmails(email.getE_EMAIL());
			parameter.setFrom(emailConfig.getFrom());
			parameter.setHost(emailConfig.getHost());
			parameter.setPassword(emailConfig.getPassword());
			parameter.setTitle(email.getE_TITLE());
			parameter.setUsername(emailConfig.getUsername());
			emailIds.add(email.getE_ID());
			boolean state = MailUtil.send(parameter);
			logger.info(emailConfig.getFrom() + " 发送给 " + email.getE_EMAIL() + " 状态: " + state);
		}
		
		if(emailIds.size()>0){
			// 更新所有已经发送过的邮件状态为send状态
			String in = emailIds.toString().replaceAll("\\[", "(").replaceAll("\\]", ")");
			String updateSql = "update email set E_SEND_STATE=? where E_ID in " + in;
			int modify = execute(updateSql, State.SEND.toString());
			logger.info("更新已发送的邮件状态数量: " + modify);
		}
	}

	public boolean addFindPasswordEmail(String email, String password, String emailType) {
		
		String insertSql = "insert into EMAIL values(EMAIL_SEQ.nextval,?,?,?,?,?,?,?,?,?)";                        
		String E_TITLE = "2018商城-找回密码";                         
		String E_CONTENT = FileUtil.loadFileContent("/config/template/find_password_email.html");                         
		String E_EMAIL = email;                         
		Date E_SEND_TIME  = new Timestamp(System.currentTimeMillis());
		Date CREATE_TIME = E_SEND_TIME;                     
		String CREATOR = "SYSTEM";                         
		String E_SEND_STATE = State.WAIT.toString();                         
		String STATE = State.ENABLED.toString();                         
		String E_TYPE = emailType; 
		E_CONTENT = E_CONTENT.replaceAll("TITLE", E_TITLE).replaceAll("USERNAME", email).replaceAll("PASSWORD", password).replaceAll("TIME", DateUtil.formatYYYYMMDD(CREATE_TIME));
		int modify = execute(insertSql, E_TITLE,E_CONTENT,E_EMAIL,E_SEND_TIME,CREATE_TIME,CREATOR,E_SEND_STATE,STATE,E_TYPE);
		return modify > 0;
	}

}
