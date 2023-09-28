package com.springtest.beans;

/**
 * 配合 BeanPostProcessor 使用
 */
public class testBean {

    private String name;

    public testBean() {
        System.out.println("testBean 构造器执行");
    }

    public void setName(String name) {
        this.name = name;
    }
}
