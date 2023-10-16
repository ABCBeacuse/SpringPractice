package aop;

import aop.config.SpringConfig;
import aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show1();
    }

    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop\\applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show1();
    }

    @Test
    void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop\\applicationContextAdviceTest.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show2();
    }
}
