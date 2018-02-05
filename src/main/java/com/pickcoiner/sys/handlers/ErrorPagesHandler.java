package com.pickcoiner.sys.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.handler.Handler;
import com.jfinal.i18n.I18n;
import com.jfinal.log.Log;
import com.pickcoiner.common.kit.ServletKit;
import com.pickcoiner.sys.SysConst;

/**
 * 错误页面的代处理句柄,包含用户直接访问静态页面的过滤拦截
 * @author Dicky Yin
 * @date 2017-10-28
 */
public class ErrorPagesHandler extends Handler {
	
	private static final Log log = Log.getLog(ErrorPagesHandler.class);
	
	/**
	 * 主要解决Error页面国际化资源找不到的问题
	 */
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] aflag) {
		//log.error("访问目标地址："+target);
		//log.error("param_locale："+request.getParameter(SysConst.LOCALE_PARA_NAME));
		//log.error("cookie_locale："+ServletKit.getCookie(request, SysConst.LOCALE_PARA_NAME));
		
		//解决Error页面国际化资源找不到的问题
		if(StringUtils.isNotBlank(request.getParameter(SysConst.LOCALE_PARA_NAME))){
			request.setAttribute(SysConst.I18N_RES_NAME, I18n.use(request.getParameter(SysConst.LOCALE_PARA_NAME)));
		}else if(StringUtils.isNotBlank(ServletKit.getCookie(request, SysConst.LOCALE_PARA_NAME))){
			request.setAttribute(SysConst.I18N_RES_NAME, I18n.use(ServletKit.getCookie(request, SysConst.LOCALE_PARA_NAME)));
		}else{
			request.setAttribute(SysConst.I18N_RES_NAME, I18n.use());
		}
		
		next.handle(staticExtSkip(target), request, response, aflag);	//必须要,模式类似于chain
	}
	
	/**
	 * 用户直接访问静态页面则被拦截,并去掉访问后缀
	 */
	public String staticExtSkip(String target){
		String result = target;
		for(String ext:SysConst.FILTER_URL_EXT){
			if(target.lastIndexOf(ext) != -1){
				result=target.substring(0, target.lastIndexOf(ext));
			}
		}
		return result;
	}

}
