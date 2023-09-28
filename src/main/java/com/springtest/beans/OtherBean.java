package com.springtest.beans;

import com.springtest.anno.MyComponent;

/**
 * 使用注解方式来将 Bean 交给 Spring 管理
 */
@MyComponent("otherBean")
public class OtherBean {
}
