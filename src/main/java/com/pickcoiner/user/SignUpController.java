package com.pickcoiner.user;

import com.jfinal.core.Controller;

/**
* <p>Title: com.pickcoiner.user.SignUpController</p>
* <p>Description: 用户注册</p>
* <p>Company: pickcoiner</p> 
* @Email tomakemyself@163.com
* @Tel 138*********
* @author Dicky Yin
* @version 1.0
* @date 2017-10-29 上午11:43:01
 */
public class SignUpController extends Controller {
	
	//进入注册页面
	public void index(){
		render("signup.html");
	}
	
	/**用户注册*/
	public void signup(){
		String username = getPara("username");//用户名
		String pwd = getPara("pwd");//密码
		String pwd2 = getPara("pwd2");
		String email = getPara("email");//邮箱
		String checkcode = getPara("checkcode");//验证码
		String agree = getParaValues("agree")[0];//同意协议
		
		
	}
	
	/**发送验证邮件	 */
	public void sendEmail(){
		
	}

}
