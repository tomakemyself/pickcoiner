package com.pickcoiner.user;

import com.pickcoiner.user.model.User;

/**
 *
 * @author Dicky Yin
 * @date 2017-11-10
 */
public class UserService {
	public static final UserService me = new UserService();
	
	private static final User user = new User().dao();
	
	/**
	 * 查找是否存在该用户，找到则返回true，没找到返回false
	 * */
	public boolean findUser(String username){
		return user.findFirst("select id from pc_user where username=?", username).getId()==null ? false : true;
	}
	
	
}
