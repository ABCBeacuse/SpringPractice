package aop.processor;

import aop.advice.MyAdvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟 Spring 的 AOP 思想
 */
// @Component
public class MockAopBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    // 这里使用 postProcessAfterInitialization，因为 Bean 的生命周期走到 这里时，Bean 实例基本创建完毕
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // 目的：对 UserServiceImpl 中的 show1 和 show2 方法进行增强，增强方法存在于 MyAdvice 中
        // 问题1：筛选 service.impl 包下的所有的类的所有方法都可以进行增强，解决方案：if-else
        // 问题2：MyAadvice 怎么获取到？ 解决方案：从 Spring 容器中获得 MyAdvice
        // 仅对 aop.service.impl 包下的类
        if (bean.getClass().getPackage().getName().equals("aop.service.impl")) {
            Object beanProxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (Object proxy, Method method, Object[] args) -> {
                        MyAdvice myAdvice = applicationContext.getBean(MyAdvice.class);
                        // 增强对象的增强方法（暂时注释掉，防止报错）
                        // myAdvice.beforeAdvice();
                        // 自己触发方法
                        Object result = method.invoke(bean, args);
                        // 增强对象的增强方法
                        myAdvice.afterAdvice();
                        return result;
                    });
            return beanProxy;
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 从 Spring 容器中自动注入 applicationContext 对象
        this.applicationContext = applicationContext;
    }
}
