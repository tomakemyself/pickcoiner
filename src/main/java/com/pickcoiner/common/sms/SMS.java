package com.pickcoiner.common.sms;

public class SMS {
	
	private String reciever;	//接收者
	
	private String content;		//内容
	
	private String date; 	//发送日期

	protected String getReciever() {
		return reciever;
	}

	protected void setReciever(String reciever) {
		this.reciever = reciever;
	}

	protected String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected String getDate() {
		return date;
	}

	protected void setDate(String date) {
		this.date = date;
	}
	
}
