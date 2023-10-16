package annotation;

import annotation.beans.OtherBean2;
import annotation.config.SpringConfig;
import annotation.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation/applicationContext.xml");
        Object dataSource = applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userDao = applicationContext.getBean("userDao2");
        System.out.println(userDao);
    }

    @Test
    void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl2");
        userServiceImpl.show();
    }

    @Test
    void test2() {
        System.setProperty("spring.profiles.active", "test");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userDao = applicationContext.getBean("userDao2");
        System.out.println(userDao);
    }

    @Test
    void test3() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userServiceMybatis = (UserService) applicationContext.getBean("userServiceMybatis");
        userServiceMybatis.show();
    }

    @Test
    void test4() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        OtherBean2 otherBean2 = applicationContext.getBean(OtherBean2.class);
        System.out.println(otherBean2);
    }
    /*
        annotation.beans.OtherBean2@1c33c17b

        Process finished with exit code 0
     */
}
