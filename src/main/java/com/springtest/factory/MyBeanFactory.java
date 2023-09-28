package com.springtest.factory;

import com.springtest.dao.UserDao;
import com.springtest.dao.impl.UserDaoImpl;

/**
 * 静态工厂方式
 */
public class MyBeanFactory {

    /**
     * 静态方法
     *
     * 返回一个 Bean 实例，交给 Spring 容器管理
     * @return
     */
    public static UserDao userDao(String name, String age) {
        return new UserDaoImpl();
    }
}
