package com.springtest.service.impl;

import com.springtest.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceAwareTest implements UserService, ApplicationContextAware, BeanNameAware, BeanFactoryAware {
    @Override
    public void show() {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory： " + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName： " + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext： " + applicationContext);
    }
}
