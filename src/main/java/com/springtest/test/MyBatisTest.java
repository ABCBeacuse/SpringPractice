package com.springtest.test;

import com.springtest.mapper.AccountMapper;
import com.springtest.pojo.Account;
import com.springtest.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        // 来源于官方文档
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springMybatis.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.show();
    }

    @Test
    void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("loadProperties.xml");
    }
}
