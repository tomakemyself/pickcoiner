/**
 * 
 */
package com.pickcoiner.user.model;

import com.jfinal.plugin.activerecord.Model;

/**
 *
 * @author Dicky Yin
 * @date 2017-11-2
 */
@SuppressWarnings("serial")
public class BaseUser extends Model<BaseUser> {
	public final static BaseUser dao =new BaseUser();
}
