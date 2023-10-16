package aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * <advisor> 标签使用的通知类，通过实现特定接口，来配置 特定类型通知
 * <p>
 * MethodInterceptor 接口，有着配置 环绕通知 的规范
 */
public class MyAdvice3 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前 .....");
        // 执行自己的方法，并返回结果
        Object result = methodInvocation.getMethod().invoke(methodInvocation.getThis(), methodInvocation.getArguments());
        System.out.println("环绕后 .....");
        return result;
    }
}
