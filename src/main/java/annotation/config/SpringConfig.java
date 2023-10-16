package annotation.config;

import annotation.beans.OtherBean;
import annotation.beans.OtherBean2;
import annotation.imports.MyImportBeanDefinitionRegistrar;
import annotation.imports.MyImportSelector;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration  // 标识当前类是一个配置类（替代配置文件），并且也会被 Spring 容器管理，（因为其源码中存在 @Component）
@ComponentScan(value = {"annotation"}) // value 别名 basePackages, String[] 字符串数组
// 如果只有一个包，可以简写为 @ComponentScan("annotation")
// properties 来源
@PropertySource("classpath:jdbc.properties")
//@Import({OtherBean.class, MyImportSelector.class})
@Import(MyImportBeanDefinitionRegistrar.class)
// 配置 Mapper 扫描范围
@MapperScan("annotation.mapper")
public class SpringConfig {

    // 配置 DruidDataSource 数据源，@Bean 没有提供名称，默认使用方法名
    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driverClass,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String userName,
            @Value("${jdbc.password}") String password
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 配置 SqlSessionFactoryBean (@Bean 参数自动注入 @AutoWired 可以省略)
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
