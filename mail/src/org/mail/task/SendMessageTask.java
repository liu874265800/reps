package org.mail.task;

import java.util.TimerTask;
import org.mail.service.other.MessageService;
import org.mail.util.LoggerUtil;


/**
 * 发送短信任务
 * @author VIC
 *
 */
public class SendMessageTask extends TimerTask {
	
	private static LoggerUtil logger = LoggerUtil.getLogger(SendMessageTask.class);
	private MessageService messageService = new MessageService();

	@Override
	public void run() {
		logger.info("执行发送短信任务.");
		messageService.sendMessage();
	}

}
