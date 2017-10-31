package com.pickcoiner.user;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.pickcoiner.common.kit.CheckCodeKit;
import com.pickcoiner.sys.SysConst;
import com.pickcoiner.user.validator.SignUpValidator;

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
	@Before(SignUpValidator.class)
	public void signup(){
		String username = getPara("username");//用户名
		String pwd = getPara("pwd");//密码
		String pwd2 = getPara("pwd2");
		String email = getPara("email");//邮箱
		String checkcode = getPara("checkcode");//验证码
		String agree = getParaValues("agree")[0];//是否同意协议
		
		
	}
	
	/**验证码图片*/
	public void ckcode(){
		
		getResponse().setHeader("Pragma", "No-cache"); 
		getResponse().setHeader("Cache-Control", "no-cache"); 
		getResponse().setDateHeader("Expires", 0); 
		getResponse().setContentType("image/jpeg");
		
		String checkcode = CheckCodeKit.generateVerifyCode(4);
		
		HttpSession session = getRequest().getSession(true);
		
		session.removeAttribute(SysConst.CHECK_CODE_NAME);	//删除原来的session验证码
		session.setAttribute(SysConst.CHECK_CODE_NAME, checkcode.toLowerCase());
		
		//生成图片,设定图片大小
		int w = 100,h=30;
		try {
			CheckCodeKit.outputImage(w, h, getResponse().getOutputStream(), checkcode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		renderNull();
		
	}
	
	/**发送验证邮件	 */
	public void sendEmail(){
		
	}

}
