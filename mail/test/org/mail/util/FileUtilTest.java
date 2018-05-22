package org.mail.util;

import java.util.Properties;

import org.junit.Test;

/**
 * 文件工具类测试
 * @author VIC
 *
 */
public class FileUtilTest {
	@Test
	public void test(){
		//Properties properties = FileUtil.loadProperties("/email_config.properties");
		//System.out.println(properties.get("email.from"));
		
		String E_CONTENT = FileUtil.loadFileContent("/config/template/active_account_email.html");    
		System.out.println(E_CONTENT);
	}

}
