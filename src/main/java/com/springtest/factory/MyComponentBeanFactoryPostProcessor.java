package com.springtest.factory;

import com.springtest.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

public class MyComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        // 通过扫描工具去扫描指定包及其子包下的所有类，收集使用 @MyComponent 的注解的类
        Map<String, Class> stringClassMap = BaseClassScanUtils.scanMyComponentAnnotation("com.springtest.beans");
        // stringClassMap 格式 {otherBean=class com.springtest.beans.OtherBean}

        // 遍历 Map，组装 BeanDefinition 进行注册
        stringClassMap.forEach((beanName, clazz) -> {
            BeanDefinition definition = new RootBeanDefinition();
            definition.setBeanClassName(clazz.getName());
            // 注册
            beanDefinitionRegistry.registerBeanDefinition(beanName, definition);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
