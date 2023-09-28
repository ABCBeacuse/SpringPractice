package com.springtest.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DruidConfigTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dataSourceApplicationContext.xml");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dataSourceApplicationContext.xml");
        Connection connection = applicationContext.getBean("connection", Connection.class);
        System.out.println(connection);
    }
}
