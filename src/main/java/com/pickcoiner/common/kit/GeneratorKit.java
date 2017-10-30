package com.pickcoiner.common.kit;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

/**
 * Token与UUID生成工具
 *
 * @author Dicky Yin
 * @date 2017-10-30
 */
public abstract class GeneratorKit {
	
	/**
	 * 获取随机的UUID，每次生成的为唯一标识
	 *       理论上会有重复，实际上基本不可能重复
	 * @return 
	 *         String uuid
	 */
	public synchronized static String generateUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	
	/**
	 * 生成经过Base64编码的UUID的Token 令牌，Token是唯一的
	 * @return
	 *        String token字符串，经过base64编码
	 */
	public static String generateBase64EncodeToken(){
		return Base64.encodeBase64String(generateUUID().getBytes());
	}
	
	/**
	 * 生成指定Base64编码的Token，
	 * @param token
	 *             需要进行Base64编码的Token令牌
	 * @return
	 *        String token字符串，经过base64编码
	 */
	public static String generateBase64EncodeToken(String token){
		return generateBase64EncodeToken(token.getBytes());
	}
	
	public static String generateBase64EncodeToken(byte[] token){
		return Base64.encodeBase64String(token);
	}
	
	/**
	 * 获取Base64解码后的Token令牌
	 * @param arg
	 *            需要解码的Token令牌字符串
	 * @return
	 *         解码后的Token字符串
	 */
	public static String generateBase64DecodeToken(String arg){
		return new String(Base64.decodeBase64(arg));
	}
	
/*	public static void main(String[] args) {
			String token = GeneratorKit.generateBase64EncodeToken();
			System.out.println(token);
			System.out.println(GeneratorKit.generateBase64DecodeToken(token));
			System.out.println(Long.toHexString(System.currentTimeMillis()));
	}*/
}
