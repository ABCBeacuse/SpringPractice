package aop;

import aop.config.SpringConfig;
import aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop\\applicationContextAdvisorTest.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show1();
    }

    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop\\AnnotationAopApplicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show2();
    }

    @Test
    void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show2();
    }
}
