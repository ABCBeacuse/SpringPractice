package com.springtest.test;

import com.springtest.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
    public static void main(String[] args) {
        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建一个读取器（读取 xml 文件）, 并绑定 bean 工厂
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 读取 .xml 配置文件
        reader.loadBeanDefinitions("beans.xml");

        // 根据 beans.xml 中的 id，通过工厂来获取 id 对应的实例对象
        UserService userService = (UserService) beanFactory.getBean("userService");

        System.out.println(userService);
        // com.springtest.service.impl.UserServiceImpl@725bef66
        // 成功通过 bean 工厂拿到实例
    }
}
