package com.springtest.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target(ElementType.TYPE) 表示该 注解 放到 类 上
 * @Retention(RetentionPolicy.RUNTIME) 控制该注解的存活范围，分为 源码、字节码、运行时
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyComponent {

    // 注解的属性
    String value();
}
