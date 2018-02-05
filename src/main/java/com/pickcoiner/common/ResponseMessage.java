/**
 * 
 */
package com.pickcoiner.common;

/**
 * 异步请求相应Form
 * @author Dicky Yin
 * @date 2018-2-2
 */
public class ResponseMessage {
	/**
	 * 返回字符
	 */
	private String text = null;
	/**
	 * target url
	 */
	private String url = null;
	/**
	 * 主题
	 */
	private String title = null;
	/**
	 * 请求状态，1成功，0失败
	 */
	private int error = 0;
	/**
	 * 本次请求令牌
	 */
	private String token = null;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
