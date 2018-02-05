package com.pickcoiner.common;

import com.jfinal.config.Routes;
import com.pickcoiner.index.PublicController;

public class FrontRoutes extends Routes {

	public void config() {
		
		//setBaseViewPath("/view");	//设置视图默认路径
		
		add("/", PublicController.class); //第三个参数为该Controller的视图存放路径，如果无第三个参数则默认为根路径
	}

}
