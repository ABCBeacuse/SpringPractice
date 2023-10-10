package com.springtest.beans;

import com.springtest.dao.TestBean;
import com.springtest.dao.UserDao;
import org.springframework.beans.factory.InitializingBean;

/**
 * 配合 BeanPostProcessor 使用
 */
public class testBean implements InitializingBean, TestBean {

    private String name;

    public testBean() {
        System.out.println("testBean 构造器执行");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("testbean 的初始化方法执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 的 afterPropertiesSet 方法");
    }

    @Override
    public void show() {
        System.out.println("show 方法执行");
    }
}
