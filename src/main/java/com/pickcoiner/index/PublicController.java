package com.pickcoiner.index;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.jfinal.core.Controller;
import com.pickcoiner.common.kit.CheckCodeKit;
import com.pickcoiner.sys.SysConst;

/**
 * 首页公共
 * com.pickcoiner.index.IndexController.java
 * @author Dicky Yin
 * @date 2017-10-24
 */
public class PublicController extends Controller {
	
	public void index(){
		render("index.html");
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
		int w = 100,h = 30;
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
