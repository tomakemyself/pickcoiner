package com.pickcoiner.user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.i18n.I18n;
import com.pickcoiner.common.ResponseMessage;
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
	
	public final static UserService service = UserService.me;
	
	//进入注册页面
	public void index(){
		render("signup.html");
	}
	
	/**用户注册*/
	@SuppressWarnings("unused")
	@Before(SignUpValidator.class)
	public void reg(){
		String username = getPara("username");//用户名
		String password = getPara("pwd");//密码
		String confirmpassword = getPara("confirmpassword");
		String email = getPara("email");//邮箱
		String checkcode = getPara("checkcode");//验证码
		String agree = getParaValues("agree")[0];//是否同意协议
		ResponseMessage msg = new ResponseMessage();
		
		if(!getAttrForStr(SysConst.CHECK_CODE_NAME).equalsIgnoreCase(checkcode)){//验证码
			msg.setText(I18n.use().get("signup_checkcode_error"));
			
			return ;
		}
		
		if(!service.findUser(getPara("username"))){
			msg.setText(I18n.use().get(""));//已经存在该用户
		}else{
			msg.setText(I18n.use().get(""));
			msg.setError(1);
			msg.setUrl("");//注册成功后跳转的地址
		}
	}
	
	/**
	 * 检查当前用户名是否已经被注册
	 */
	public void checkUser(){
		renderJson("flag", service.findUser(getPara("username")) ? "Y" : "N");
	}

}
