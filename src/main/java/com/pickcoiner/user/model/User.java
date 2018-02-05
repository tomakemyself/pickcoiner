package com.pickcoiner.user.model;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 *
 * @author Dicky Yin
 * @date 2017-11-2
 */
@SuppressWarnings("serial")
public class User extends Model<User> implements IBean {
	public final static User dao =new User().dao();
	
	public Integer getId(){
		return getInt("id");
	}
	
	public void setId(int id){
		set("id", id);
	}
	
	public String getUserName(){
		return getStr("username");
	}
	
	public void setUserName(String username){
		set("username", username);
	}
}
