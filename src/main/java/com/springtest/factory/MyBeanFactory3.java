package com.springtest.factory;

import com.springtest.dao.UserDao;
import com.springtest.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义类 实现工厂 Bean 的规范 FactoryBean<T>
 */
public class MyBeanFactory3 implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        // getObject 方法是规范，所以在 配置文件中不需要指出
        // 可以写一些创建 Bean 之前的业务代码
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
