package org.mail.task;

import java.util.TimerTask;
import org.mail.service.other.EmailService;
import org.mail.util.LoggerUtil;


/**
 * 发送邮件任务
 * @author VIC
 *
 */
public class SendEmailTask extends TimerTask {
	
	private static LoggerUtil logger = LoggerUtil.getLogger(SendEmailTask.class);
	private EmailService emailService = new EmailService();

	@Override
	public void run() {
		logger.info("执行发送邮件任务.");
		emailService.sendEmail();
	}

}
