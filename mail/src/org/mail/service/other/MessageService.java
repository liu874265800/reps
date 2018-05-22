package org.mail.service.other;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.mail.common.State;
import org.mail.common.Type;
import org.mail.entity.Message;
import org.mail.jdbc.JdbcTemplate;
import org.mail.util.LoggerUtil;
import org.mail.util.SmsUtil;

/**
 * 短信业务类
 * @author VIC
 *
 */
public class MessageService extends JdbcTemplate<Message> {
	
	private LoggerUtil logger = LoggerUtil.getLogger(MessageService.class);
	
	public int addRegisterMessage(String phone, String code){
		String insertSql = "insert into message values(MSG_SEQ.nextval,?,?,?,?,?,?,?,?,?)";
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		int modify = execute(insertSql, "title",code,phone,currentTimestamp,State.WAIT.toString(),Type.REGISTER.toString(),currentTimestamp,"SYSTEM",State.ENABLED.toString());
		return modify;
	}

	public void sendMessage() {
		
		// 查询所有等待发送的邮件
		List<Message> waitMessages = searchMessageByState(State.WAIT.toString());
		logger.info("查询到等待发送短信数量: " + waitMessages.size());
		// 发送方式1: 循序发送
		List<Integer> messageIds = new ArrayList<Integer>();
		for(Message message : waitMessages){
			SmsUtil.sendMessage(message.getM_CONTENT(), message.getM_PHONE());
			messageIds.add(message.getM_ID());
			logger.info(" 发送给 " + message.getM_PHONE() + "短信");
		}
				
		if(messageIds.size()>0){
			// 更新所有已经发送过的邮件状态为send状态
			String in = messageIds.toString().replaceAll("\\[", "(").replaceAll("\\]", ")");
			String updateSql = "update message set M_SEND_STATE=? where M_ID in " + in;
			int modify = execute(updateSql, State.SEND.toString());
			logger.info("更新已发送的短信状态数量: " + modify);
		}
	}

	private List<Message> searchMessageByState(String state) {
		String searchSql = "select * from MESSAGE where M_SEND_STATE=?";
		return quary(searchSql, state);
	}

}
