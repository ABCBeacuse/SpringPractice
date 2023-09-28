package com.springtest.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 自定义的 Bean 工厂的后处理器
 * （在 ApplicationContext 中的 beanFactory 中的 BeanDefinitionMap 填充完毕之后，Bean 实例创建之前 执行）
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("自定义的 Bean 工厂后处理器执行");

        // 可以拿到 BeanFactory ( 实际的运行类型为 DefaultListableBeanFactory，已实现 ConfigurableListableBeanFactory 接口的 getBeanDefinition)
        // BeanDefinition userDaoBeanDefinition = configurableListableBeanFactory.getBeanDefinition("userDao");
        // 将 本身为 userDao 的 BeanDefinition 中的 className 改为 userServiceImpl，则根据该 BeanDefinition 创建的 Bean 实例就会是 UserServiceImpl
        // userDaoBeanDefinition.setBeanClassName("com.springtest.service.impl.UserServiceImpl");

        // 创建一个 BeanDefinition 对象，BeanDefinition 是接口，一般使用其实现类 RootBeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        // 配置一些 BeanDefinition 的基本信息
        beanDefinition.setBeanClassName("com.springtest.dao.impl.PersonDaoImpl");

        // 将该 BeanDefinition 注册到 BeanFactory 中的 BeanDefinitionMap 中
        // ConfigurableListableBeanFactory 是一个接口，其实现子类 DefaultListableBeanFactory 存在注册 BeanDefinition 的方法
        // 当前 configurableListableBeanFactory 的运行类型为 DefaultListableBeanFactory.class
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
        beanFactory.registerBeanDefinition("personDao", beanDefinition);
    }
}
