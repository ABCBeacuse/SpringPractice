package com.springtest.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.Date;

public class TimeLogBeanPostProcessor implements BeanPostProcessor {

    // 因为 postProcessAfterInitialization 之前还会执行 bean 的一些初始化方法，所以这里使用动态代理增强时，使用已经完全初始化的 bean
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Object proxyInstance = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    // 1. 打印当前时间
                    System.out.println(method.getName() + " 执行当前时间 " + new Date());
                    // 2. 执行方法
                    Object result = method.invoke(bean, args);
                    // 3. 打印结束时间
                    System.out.println(method.getName() + " 执行结束时间" + new Date());
                    return result;
                }
        );

        // 将使用动态代理增强后的 代理 对象放到 BeanFactory 的 singletonObjects 中
        return proxyInstance;
    }
}
