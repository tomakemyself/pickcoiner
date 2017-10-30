package com.pickcoiner.common.sms;

/**
 * 发送邮件消息
 * com.pickcoiner.common.send.EmailSms.java
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class EmailSms extends SMS {
	private String title;

	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
}
