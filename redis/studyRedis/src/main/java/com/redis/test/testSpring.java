package com.redis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 测试spring
 * @authorHmLzp
 * @create 2019 - 02 - 17 14:53
 */
public class testSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("application.xml");
        context.registerShutdownHook();
        context.start();
        Date date = (Date)context.getBean("date");
        System.out.println(date);
    }
}
