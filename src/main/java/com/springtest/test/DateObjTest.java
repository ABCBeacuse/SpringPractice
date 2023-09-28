package com.springtest.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建一个日期类型 Date 交给 Spring 容器管理
 */
public class DateObjTest {
    /**
     * 一般代码
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        String context = "2023-09-26 10:11:32";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(context);
        System.out.println(date);
    }


    /**
     * 从 spring 容器中取出
     */
    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dateObject.xml");
        Date date = applicationContext.getBean("currentDate", Date.class);
        System.out.println(date);
        // Sun Oct 01 10:20:11 CST 2023
    }
}
