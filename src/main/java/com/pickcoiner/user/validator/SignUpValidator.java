package com.pickcoiner.user.validator;

import com.jfinal.core.Controller;
import com.pickcoiner.sys.validator.BaseValidator;

/**
 *
 * @author Dicky Yin
 * @date 2017-10-31
 */
public class SignUpValidator extends BaseValidator {

	/**
	 * 校验数据
	 * */
	protected void validate(Controller me) {
		//校验输入的信息是否为空
		validateRequiredString("username", "usernameMsg", "请输入用户名");
		validateRequiredString("password", "pwdMsg", "请输入密码");
		validateEmail("email", "emailMsg", "请输入正确的邮箱");
	}

	
	protected void handleError(Controller me) {
		me.render("signup.html");
	}

}
