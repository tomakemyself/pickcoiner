package com.pickcoiner.common.kit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
/**
 * 请求类工具
 *
 * @author Dicky Yin
 * @date 2017-10-28
 */
public class ServletKit {
	
	/**
	 * 获取指定名称的Cookie对象
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookieObject(HttpServletRequest request,String name)
    {
        Cookie cookies[] = request.getCookies();
        if(cookies != null)
        {
            Cookie arr$[] = cookies;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                Cookie cookie = arr$[i$];
                if(cookie.getName().equals(name))
                    return cookie;
            }

        }
        return null;
    }
	
	/**
	 * 获取Cookie值
	 * @param request
	 * @param name
	 * @param defaultValue	默认值
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,String name, String defaultValue)
    {
        Cookie cookie = getCookieObject(request,name);
        return cookie == null ? defaultValue : cookie.getValue();
    }
	
	/**
	 * 获取Cookie值
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,String name)
    {
        return getCookie(request,name,null);
    }
}
