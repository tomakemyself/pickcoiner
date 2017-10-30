package com.pickcoiner.common.kit;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;

/**
 * 短信验证码发送
 * com.pickcoiner.common.kit.SMSCodeKit.java
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class SMSCodeKit {
	
	private static final Log log = Log.getLog(SMSCodeKit.class);
	
	public static String sendSMSCode(String phone,String content){
		Prop p = PropKit.use("SysConfig.properties");
		return sendSMSCode(
				p.get("SMS_SERVER_HOST"),
				p.get("SMS_SERVER_PORT"),
				phone,
				content
		);
	}
	
	public static String sendSMSCode(String server, String port, String phone, String content){
		String code="";
		log.error("sendSMSCode error");
		return code;
	}
}
