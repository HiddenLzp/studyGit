package com.lzp.springboot.service.impl;

import com.lzp.springboot.service.TimeService;
import com.lzp.springboot.utils.JodeTimeUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 18 11:04
 */
@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public String getCurrentTime() {
        return JodeTimeUtils.getCurrentTime();
    }

    @Override
    public Integer diffDay(String begin, String end) {
        return JodeTimeUtils.diffDay(begin,end);
    }

    @Override
    public Integer diffDay(Date begin, Date end) {
        return JodeTimeUtils.diffDay(begin,end);
    }

    @Override
    public Integer cutDownNewYear() {
        //记录新年还有多少天
        LocalDate localDate = new LocalDate();
        Days days = JodeTimeUtils.daysToNewYear(localDate);
        System.out.println("距离新年还有："+days.getDays()+"天!");
        return days.getDays();
    }

    @Override
    public String addDays(Integer days) {
        return JodeTimeUtils.forwardDayToString(days);
    }
}
