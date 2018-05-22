package org.mail.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.mail.task.SendEmailTask;
import org.mail.task.SendMessageTask;
import org.mail.util.LoggerUtil;

/**
 * 
 * @author VIC
 *
 */
@WebListener
public class SystemListener implements ServletContextListener {
	
	private static LoggerUtil logger = LoggerUtil.getLogger(SystemListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("系统监听器停止");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("系统监听器启动");
		// 定时发送邮件任务
		Timer emailTimer = new Timer();
//		emailTimer.schedule(new SendEmailTask(), 10000, 50000);
		
		// 定时发送短信任务
		Timer messageTimer = new Timer();
//		messageTimer.schedule(new SendMessageTask(), 10000, 30000);
	}

}
