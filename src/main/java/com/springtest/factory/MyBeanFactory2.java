package com.springtest.factory;

import com.springtest.dao.UserDao;
import com.springtest.dao.impl.UserDaoImpl;

/**
 * 实例工厂方式
 */
public class MyBeanFactory2 {

    /**
     * 实例方法
     * <p>
     * 返回一个 Bean 实例，交给 Spring 容器管理
     *
     * @return
     */
    public UserDao userDao(String name) {
        return new UserDaoImpl();
    }
}
