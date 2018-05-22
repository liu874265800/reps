package org.mail.util;

import org.junit.Test;

/**
 * 邮件工具类测试
 * @author VIC
 *
 */
public class MailUtilTest {
	
	@Test
	public void testMailUtil(){
		MailParameter parameter = new MailParameter();
		parameter.setContent("content");
		parameter.setEmails("13711707705@163.com");
		parameter.setFrom("13711707705@163.com");
		parameter.setHost("smtp.163.com");
		parameter.setPassword("xxxx");
		parameter.setTitle("Title");
		parameter.setUsername("13711707705");
		boolean state = MailUtil.send(parameter);
		System.out.println(state);

	}

}
