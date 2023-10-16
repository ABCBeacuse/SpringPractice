package annotation.beans;

import annotation.dao.UserDao;
import annotation.service.UserService;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class OtherBean {

    @Bean("dataSource")
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driverClassName,
            // @Autowired UserDao userDao,
            @Qualifier("userDao2") UserDao userDao,
            // @Autowired UserService userService
            @Qualifier("userServiceImpl") UserService userService
    ) {
//        System.out.println(driverClassName);
//        System.out.println(userDao);
//        System.out.println(userService);
        DruidDataSource dataSource = new DruidDataSource();
        // 配置四个参数
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
