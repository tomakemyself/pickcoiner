package com.pickcoiner.sys;

/**
 * 系统参数
 *
 * @author Dicky Yin
 * @date 2017-10-28
 */
public abstract class SysConst {
	
	//global 全局部分
	
	/**
	 * 系统核心配置，jdbc,email,uploadpath等
	 */
	public static final String CORE_CONFIG_RES="SysConfig.properties";
	/**测试用*/
	public static final String CORE_CONFIG_RES_DEV="SysConfig_Dev.properties";
	/** 站点根路径*/
	public static final String BASE_PATH="BASE_PATH";
	/**4O4页面路径*/
	public static final String ERROR_404VIEW_PATH="error/404.html";
	/**500页面路径*/
	public static final String ERROR_500VIEW_PATH="error/500.html";
	/**设置视图模板文件后缀名*/
	public static final String VIEW_TYPE_EXT=".html";
	/**Freemarker property文件*/
	public static final String FREEMARKER_RESNAME="freemarker.properties";
	//验证码
	public static final String CHECK_CODE_NAME="checkcode";
	//the end
	
	
	//handler部分
	/**要过滤的URL访问后缀*/
	public static final String[] FILTER_URL_EXT = {".html",".ftl"};
	//handler部分
	
	
	//国际化部分
	/**国际化，默认语种*/
	public static final String LOCALE_PARA_NAME = "_locale";
	/** freemarker调用参数名称*/
	public static final String I18N_RES_NAME = "_res";
	//the end
	
}
