package com.springtest.test;

import com.springtest.beans.OtherBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 的处理器测试
 */
public class ProcessorTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("processorTest.xml");
        OtherBean otherBean = applicationContext.getBean(OtherBean.class);
        System.out.println(otherBean);
    }

    // com.springtest.beans.OtherBean@27a5f880
}
