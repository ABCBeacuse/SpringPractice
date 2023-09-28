package com.springtest.test;

import com.springtest.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "dev");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("labelTest.xml");
        // 根据 beanName 获取容器中的 Bean 实例, 需要手动强转
        UserService userService = (UserService) applicationContext.getBean("userService");
        // 根据 Bean 类型去容器中匹配对应的 Bean 实例，如果存在多个匹配 Bean 则报错
        UserService userService1 = applicationContext.getBean(UserService.class);
        // 根据 beanName 获取容器中的 Bean 实例，指定 Bean 的 Type 类型
        UserService userService2 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        System.out.println(userService1);
        System.out.println(userService2);

    }
}
