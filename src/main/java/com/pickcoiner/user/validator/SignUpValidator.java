package com.pickcoiner.user.validator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.pickcoiner.common.ResponseMessage;
import com.pickcoiner.sys.validator.BaseValidator;

/**
 * @author Dicky Yin
 * @date 2017-10-31
 */
public class SignUpValidator extends BaseValidator {
	
	private static final String MSG_KEY = "res_msg";
	
	/**
	 * 校验数据
	 * */
	protected void validate(Controller me) {
		//校验输入的信息是否为空
		validateRequiredString("username", MSG_KEY, "请输入用户名");
		validateRequiredString("password", MSG_KEY, "请输入密码");
		validateRequiredString("confirmpassword", MSG_KEY, "重复密码不能为空");
		validateEqualField("password", "confirmpassword", MSG_KEY, "两次输入密码不一致");
		validateRequiredString("checkcode", MSG_KEY, "验证码不能为空");
		validateRequiredString("agree", MSG_KEY, "必须同意协议");
		validateEmail("email", MSG_KEY, "请输入正确的邮箱");
	}

	protected void handleError(Controller me) {
		ResponseMessage rm = new ResponseMessage();
		rm.setText(me.getAttrForStr(MSG_KEY));
		me.renderJson(JSON.toJSONString(rm));
		//me.render("signup.html");
	}

}
