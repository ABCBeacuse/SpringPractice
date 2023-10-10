package com.springtest.test;

import com.springtest.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorTest {
    public static void main(String[] args) {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanPostProcessorTest.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("TimeLogBeanPostProcessor.xml");
        UserDao bean =(UserDao) applicationContext.getBean("testBean");
    }
}
