package com.springtest.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis 的 SqlSessionFactory 交给 Spring 容器管理
 */
public class SqlSessionFactoryTest {
    /**
     * 普通代码
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 静态工厂创建实例
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 实例工厂创建实例
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        System.out.println(sessionFactory);
        // org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@47f6473
    }

    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("sqlSessionFactoryTest.xml");
        SqlSessionFactory sessionFactory = applicationContext.getBean("sqlSessionFactory", SqlSessionFactory.class);
        System.out.println(sessionFactory);
        // org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@4c1909a3
    }
}
