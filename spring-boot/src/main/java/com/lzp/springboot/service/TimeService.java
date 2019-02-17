package com.lzp.springboot.service;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 时间Service
 *
 * @authorHmLzp
 * @create 2019 - 02 - 17 22:36
 */
public class TimeService {

    @Autowired
    private DateTime dateTime;

    public static void main(String[] args) {
        //输出当前时间 2019-02-17T22:39:24.023+08:00
        DateTime dateTimes = new DateTime();
        System.out.println(dateTimes);

        //格式化输出   2019-02-17 22:40:52 下午 星期日
        String formatDatetimes = dateTimes.toString("yyyy-MM-dd HH:mm:ss a EE");
        System.out.println(formatDatetimes);

        //解析文本格式时间
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTimeTwo = DateTime.parse("2019-02-17 22:22:52",format);
        String formatDatetimeTwo = dateTimeTwo.toString("yyyy-MM-dd HH:mm:ss a");
        System.out.println(formatDatetimeTwo);

        //在某个日期上加上90天
        DateTime nowTime = new DateTime();
        String addTime = nowTime.plusDays(90).toString("yyyy-MM-dd HH:mm:ss a");
        System.out.println(addTime);

        //记录新年还有多少天
        LocalDate localDate = new LocalDate();
        Days days = daysToNewYear(localDate);
        System.out.println("距离新年还有："+days.getDays()+"天!");

        //计算时间区间
        DateTime begin = new DateTime("2018-10-31");
        DateTime end = new DateTime("2019-01-25");

        //区间毫秒数
        Duration duration = new Duration(begin,end);
        long millis = duration.getMillis();
        System.out.println("区间毫秒数:"+millis);

        //区间天数
        Period period =new Period(begin,end,PeriodType.days());
        int days1 = period.getDays();
        System.out.println("区间天数:"+days1);

        //计算特定时间 是否在该区间内
        Interval interval = new Interval(begin,end);
        boolean contains = interval.contains(new DateTime("2019-02-17"));
        System.out.println("该时间是不是在区间内："+contains);


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

    /**
     * 距离某个时间 多少天后
     * @param dateTime
     * @param days
     * @return
     */
    public static String manyLater(DateTime dateTime,int days) {
        String s = dateTime.plusDays(days).toString("yyyy-MM-dd HH:mm:ss a");
        return s;
    }

}
