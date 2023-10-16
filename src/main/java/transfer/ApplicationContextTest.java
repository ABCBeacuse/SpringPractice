package transfer;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transfer.config.SpringConfig;
import transfer.service.AccountService;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transfer\\applicationContext.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.transferMoney("jack", "马化腾", 10000.0);
    }

    /**
     * 注解 + xml 配置文件，启动事务
     */
    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transfer\\halfAnnotation.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.transferMoney("马化腾", "jack", 10000.0);
    }

    /**
     * 全注解方式，启动事务
     */
    @Test
    void test1() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.transferMoney("jack", "马化腾", 10000.0);
    }
}
