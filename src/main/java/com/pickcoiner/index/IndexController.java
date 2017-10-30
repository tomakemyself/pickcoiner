package com.pickcoiner.index;

import com.jfinal.core.Controller;

/**
 * 首页公共
 * com.pickcoiner.index.IndexController.java
 * @author Dicky Yin
 * @date 2017-10-24
 */
public class IndexController extends Controller {
	
	public void index(){
		render("index.html");
		
	}
}
