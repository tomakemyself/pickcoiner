
package com.pickcoiner.common.kit;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

/**
 * 邮件发送工具类
 * com.pickcoiner.common.kit.EmailKit.java
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class EmailKit {
	
	private static final String AUTO_HOST = "127.0.0.1";
	private static final Log log = Log.getLog(EmailKit.class);
	
	/**
	 * 系统默认配置信息发送Email到接收人员账号,配置信息见@see SYSConfig.properties
	 * @param toEmail
	 * 		接收人邮箱
	 * @param title
	 * 		邮件标题
	 * @param content
	 * 		邮件内容
	 * @return
	 *		  String result  
	 */
	public static String sendEmail(String toEmail,String title, String content) {
		Prop p = PropKit.use("SysConfig.properties");
		return sendEmail(
				p.get("EMAIL_SERVER"), 
				p.get("EMAIL_SEND_ACCOUNT"),
				p.get("EMAIL_SENDER_NAME"), 
				p.get("EMAIL_SEND_PWD"), 
				toEmail, 
				title, 
				content
		);
	}
	/**
	 * 发送邮件
	 * @param emailServer
	 * 		邮件发送服务器地址
	 * @param fromEmail
	 * 		发送人邮件账号
	 * @param fromName
	 * 		发送人名称
	 * @param password
	 * 		发送人账号密码
	 * @param toEmail
	 * 		接收人
	 * @param title
	 * 		邮件标题
	 * @param content
	 * 		邮件内容支持<span>HTML</span>
	 * @return String
	 * 		发送结果
	 */
	public static String sendEmail(String emailServer, String fromEmail,String fromName
			, String password, String toEmail, String title, String content) {
		
		HtmlEmail email=new HtmlEmail();
		if (StrKit.notBlank(emailServer)) {
			email.setHostName(emailServer.trim());
		}
		else {
			// 默认使用本地 postfix 发送，这样就可以将postfix 的 mynetworks 配置为 127.0.0.1 或 127.0.0.0/8 了
			email.setHostName(AUTO_HOST);
		}
			
		// 如果密码为空，则不进行认证
		if (StrKit.notBlank(password)) {
			email.setAuthentication(fromEmail, password);
		}
		
		email.setCharset("utf-8");	//设置字符编码
		email.setSSL(false);	//关闭SSL安全链接
		
		try {
			email.addTo(toEmail);
			email.setFrom(fromEmail,fromName);
			email.setSubject(title);
			email.setMsg(content);
			return email.send();
		} catch (EmailException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String ret = sendEmail(
				"smtp.aliyun.com",              // 邮件发送服务器地址
				"tomakemyself@aliyun.com",		// 发件邮箱Jiaxiang123
				"Dicky Yin",	//邮件发送人名称
				"a13711305758",		// 发件邮箱密码
				"276105184@qq.com",	// 收件地址
				"pickcoiner",       // 邮件标题
				"测试测试测试");		// 邮件内容
		System.out.println("发送返回值: " + ret);
		/*String ret = sendEmail(
				"smtp.163.com",              // 邮件发送服务器地址
				"deyangreennet@163.com",		// 发件邮箱Jiaxiang123
				"Jiaxiang123",					// 发件邮箱密码
				"276105184@qq.com",		// 收件地址
				"邮件标题",              // 邮件标题
				"content");				// 邮件内容
		System.out.println("发送返回值: " + ret);*/
	}
}
		
		
	
	


