package com.pickcoiner.common.kit;

import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * 字符串工具类
 * com.pickcoiner.common.kit.StringKit.java
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class StringKit
{
	//该方法去掉多个关键词的空格
	//如： java jsp会被单独存在数组中
	public static  String[] splitStringBySpace(String sString)
	{
        String[] subString=sString.split("\\s+");
 
        return subString;
        
	}
	
	//拼接字符串，将java jsp php形式的字符串拼接为java|jsp|php形式
	public static  String conactString(String sString)
	{
		String outString = "";
        String[] subString=sString.split("\\s+");
        
        for (int i = 0; i<subString.length; i++)
		{
        	//注意！！！最后不能拼接|符号
        	if (i != (subString.length-1))
			{
        		outString +=subString[i]+"|";
			}
        	else
        	{
        		outString +=subString[i];
        	}
		}
        System.out.println(outString);
        return outString;
        
	}
	
	public static String conactString(String s, String op) 
	{
		s = s+op;
		return s;
	}
	
    //使用String的split 方法  
	//sp为分隔符号，如“,” “|”等
    public static String[] convertStrToArray(String str,String sp){  
        String[] strArray = null;  
        strArray = str.split(sp);  
        return strArray;  
    }   
	
    //将long转为指定格式
    public static String formatNum(long number)
	{
		DecimalFormat dFormat = new DecimalFormat("###,###");

		return dFormat.format(number);
	}
    
    //百分比
    public static String percent(int num, long all)
    {
        NumberFormat nt = NumberFormat.getPercentInstance();  
        //设置百分数精确度2即保留两位小数  
        nt.setMinimumFractionDigits(0);  
        float percent = (float)num/all;  
        return nt.format(percent);
    }
    
    /**
     * 百分比
     * @param num
     * @param all
     * @return
     */
    public static String percent(long num, long all)
    {
        NumberFormat nt = NumberFormat.getPercentInstance();  
        //设置百分数精确度2即保留两位小数  
        nt.setMinimumFractionDigits(0);  
        float percent = (float)num/all;  
        return nt.format(percent);
    }
    
//    public static void main(String args[])
//    {
//        //System.out.println( "截取后的字符串："+getTencentVideoId("https://v.qq.com/x/cover/jzhtr2cgy35ejz0/b00249eiunm.html") );
//     }
    
}
