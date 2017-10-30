package com.pickcoiner.user;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.core.Controller;

/**
* <p>Title: com.pickcoiner.login.LoginController</p>
* <p>Description: 用户登录控制器</p>
* <p>Company: pickcoiner</p> 
* @Email tomakemyself@163.com
* @Tel 
* @author Dicky Yin
* @version 1.0
* @date 2017-10-29 上午11:17:17
 */
public class LoginController extends Controller {
	
	/**默认进入登录页*/
	public void index(){
		render("login.html");
	}
	
	/** 用户登录方法 */
	public void login(){
		
		String username = getPara("username");
		String pwd = getPara("pwd");
		String checkcode = getPara("checkcode");
		
		if(StringUtils.isBlank(username) || StringUtils.isBlank(pwd)){
			//render("login.html");
			redirect("");
			return;
		}
		
		//登录前3次不用输入验证码
		if(StringUtils.isNoneBlank(checkcode)){
			//验证码不正确返回登录页面
			if(!checkcode.equalsIgnoreCase((String) getSession().getAttribute("ckcode"))){
				redirect("");
			}
		}
		
		//验证用户名与密码s
		
	}
	
}
