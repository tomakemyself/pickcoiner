package com.pickcoiner.user;

import com.jfinal.config.Routes;

public class UserRoutes extends Routes {

	public void config() {
		setBaseViewPath("/view/user");	//设置视图默认路径
		add("/signup", SignUpController.class,"/"); //第三个参数为该Controller的视图存放路径，如果无第三个参数则默认为根路径
	}

}
