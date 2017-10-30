package com.pickcoiner.common.kit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 * com.pickcoiner.common.kit.TimeKit.java
 * @author Dicky Yin
 * @date 2017-10-26
 */
public class TimeKit
{
	private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_CN = "秒";
    private static final String ONE_MINUTE_CN = "分钟";
    private static final String ONE_HOUR_CN = "小时";
    private static final String ONE_DAY_CN = "天";
    private static final String ONE_MONTH_CN = "月";
    private static final String ONE_YEAR_CN = "年";

    private static final String ONE_AGO = "前";

    /**
     * @author jiaxiang 2017年9月5日
     * @describe    相对于当前时间
     * @param date
     * @return
     * @returnType String
     */
    public static String format(Date date) {
        if(date == null)
            date = new Date();
        long delta = new Date().getTime() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_CN + ONE_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_CN + ONE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_CN + ONE_AGO;
        }
        if (delta < 48L * ONE_HOUR) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_CN + ONE_AGO;
        }
        if (delta < 12L * 4L * ONE_WEEK) {
            long months = toMonths(delta);
            return (months <= 0 ? 1 : months) + ONE_MONTH_CN + ONE_AGO;
        } else {
            long years = toYears(delta);
            return (years <= 0 ? 1 : years) + ONE_YEAR_CN + ONE_AGO;
        }
    }

    /**
     * @author jiaixang 2017年9月5日
     * @describe    相对于某个时间， 计算时间差
     * @param date
     * @param ofDate 最后时间
     * @return
     * @returnType String
     */
    public static String formatOfDate(Date date, Date ofDate) {
        if(date == null)
            date = new Date();
        if(ofDate == null)
            ofDate = new Date();
        long delta = ofDate.getTime() - date.getTime();
        delta = Math.abs(delta);
        long s = toSeconds(delta);
        long min = toMinutes(delta);
        long hour = toHours(delta);
        long day = toDays(delta);
        long month = toMonths(delta);
        long year = toYears(delta);
        if(year > 0)
            return year+"年";
        if(month > 0)
            return month+"个月";
        if(day > 0)
            return day+"天";
        if(hour > 0)
            return hour+"个小时";
        if(min > 0)
            return min +"分钟";
        return s + ONE_SECOND_CN;
    }
    
    public static String getStringDate() {
    	   Date currentTime = new Date();
    	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    	   String dateString = formatter.format(currentTime);
    	   return dateString;
    	}

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }
}
