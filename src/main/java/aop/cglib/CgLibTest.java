package aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 创建代理对象，思想模拟代码
 * <p>
 * cglib 基于父类（目标类）生成 Proxy 代理对象
 */
public class CgLibTest {
    public static void main(String[] args) {
        // 目标对象
        Target target = new Target();
        // 通知对象（增强对象）
        MyAdvice myAdvice = new MyAdvice();

        // 编写 cglib 代码
        Enhancer enhancer = new Enhancer();
        // 设置父类，因为 cglib 是基于 父类 生成代理对象（代理对象就是 Target 的子类）
        enhancer.setSuperclass(Target.class);
        // MethodInterceptor 为 CallBack 的子接口
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            // Interceptor 就相当于 JDK 的 Proxy 的 invoke 方法
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 前置增强
                myAdvice.before();
                // 执行目标方法
                Object result = method.invoke(target, objects);
                // 后置增强
                myAdvice.after();
                return result;
            }
        });
        // enhancer 生成代理对象（就是 Target 的子对象）
        Target proxy = (Target) enhancer.create();

        // 测试
        proxy.show();
    }
}

/*
before....
show....
after....

Process finished with exit code 0
 */
