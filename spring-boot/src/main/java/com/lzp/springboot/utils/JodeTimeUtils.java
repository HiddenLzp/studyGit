package com.lzp.springboot.utils;

import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * 处理时间工具类
 *
 * @authorHmLzp
 * @create 2019 - 02 - 18 10:11
 */
public class JodeTimeUtils {
    //1秒 java以毫秒为单位
    public static final long SECOND = 1000;
    //一分钟
    public static final long MINUTE = SECOND * 60;
    //一小时
    public static final long HOUR = MINUTE * 60;
    //一天
    public static final long DAY  = HOUR * 24;
    //一周
    public static final long WEEK = DAY * 7;
    //一年
    public static final long YEAR = DAY * 365;
    //时间格式
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_TIME_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    private static final Map<Integer, String> WEEK_DAY = new HashMap<>();
    static{
        WEEK_DAY.put(7,"星期六");
        WEEK_DAY.put(1,"星期天");
        WEEK_DAY.put(2,"星期一");
        WEEK_DAY.put(3,"星期二");
        WEEK_DAY.put(4,"星期三");
        WEEK_DAY.put(5,"星期四");
        WEEK_DAY.put(6,"星期五");

    }

    /**
     * 获取当前系统时间
     * @return  yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime(){
        DateTime dateTime = new DateTime();
        return dateTime.toString(FORMAT_TIME);
    }

    /**
     * 获取当前系统时间按照指定格式返回
     * @param pattern String 类型
     * @return
     */
    public static String getCurrentTimePattern(String pattern) {
        DateTime dateTime = new DateTime();
        return dateTime.toString(pattern);
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate() {
        DateTime dateTime = new DateTime();
        return dateTime.toString(FORMAT_DATE);
    }

    public static String getCurrentDate(String pattern) {
        DateTime dateTime = new DateTime();
        return dateTime.toString(pattern);
    }

    /**
     *  按照时区转换时间
     * @param date
     * @param timeZone 时区
     * @param parrent
     * @return
     */
    public static String format(Date date, TimeZone timeZone,String parrent) {
        if(date == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(parrent);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }

    /**
     *  获取指定时间
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   小时
     * @param minute 分钟
     * @param seconds 秒
     * @return
     */
    public static String getPointTime(Integer year, Integer month, Integer day,Integer
                                      hour,Integer minute,Integer seconds) {
        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds);
        String date = dateTime.toString(FORMAT_TIME);
        return date;
    }

    public static String getPointTime(Integer year, Integer month, Integer day,Integer
            hour,Integer minute,Integer seconds,String parrent) {
        DateTime dateTime = new DateTime(year, month, day, hour, minute, seconds);
        String date = dateTime.toString(parrent);
        return date;
    }

    /**
     * 获取指定日期
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getPointDate(Integer year, Integer month, Integer day) {
        LocalDate dt = new LocalDate(year, month, day);
        String date = dt.toString(FORMAT_DATE);
        return date;
    }

    public static String getPointDate(Integer year, Integer month, Integer day,String parrent) {
        LocalDate dt = new LocalDate(year, month, day);
        String date = dt.toString(parrent);
        return date;
    }

    /**
     * 获取当前是一周星期几  待定
     * @return
     */
    public static String getWeek() {
        DateTime dt = new DateTime();
        String week = "";
        /*switch (dt.getDayOfWeek()) {
            case DateTimeContants.SUNDAY;
        }*/
        return week;
    }

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String format(Date date) {
        if(date == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
        return sdf.format(date);
    }

    /**
     * 获取当前时间前几天时间，按照指定格式返回
     * @param days
     * @param format
     * @return
     */
    public static String formatDay(Integer days,String format) {
        DateTime dt = new DateTime();
        DateTime dateTime = dt.minusDays(days);
        return dateTime.toString(format);
    }

    public static String forwardDayToString(Integer days) {
        DateTime dt = new DateTime();
        DateTime dateTime = dt.minusDays(-days);
        return dateTime.toString(FORMAT_TIME);
    }

    public static Date forwardDayToDate(Integer days) {
        DateTime dt = new DateTime();
        DateTime dateTime = dt.minusDays(days);
        return dateTime.toDate();
    }

    /**
     *
     * @param start 开始  Date类型
     * @param end 结束    Date类型
     * @return 返回参数的绝对值
     */
    public static Integer diffDay(Date start , Date end) {
        if(start == null || end == null) {
            return 0;
        }
        DateTime dateTimeStart = new DateTime(start);
        DateTime dateTimeEnd = new DateTime(end);
        int days = Days.daysBetween(dateTimeStart, dateTimeEnd).getDays();
        return Math.abs(days);
    }

    /**
     *  计算时间区间
     * @param start String 类型
     * @param end   String 类型
     * @return
     */
    public static Integer diffDay(String start, String end) {

        DateTime startTime = new DateTime(start);
        DateTime endTime = new DateTime(end);
        Period period = new Period(startTime,endTime, PeriodType.days());
        return period.getDays();
    }

    /**
     * 距离新年剩余天数
     * @param fromDate
     * @return
     */
    public static Days daysToNewYear(LocalDate fromDate) {
        LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
        return Days.daysBetween(fromDate ,newYear);
    }

}
