package aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 增强类，内部提供增强方法
 */
@Component
// <aop:respect ref="myAdvice">
@Aspect
public class MyAdvice {

    // 这里并不是 MyAdvice 的一个方法，这样写只是一个规范，Spring 可以根据这种规范来找到 切点表达式
    @Pointcut("execution(* aop.service.impl.*.*(..))")
    public void myPointCut() {}

    /**
     * <aop:pointcut id="userServiceShowPointCut" expression="execution(* aop.service.impl.*.*(..))"/>
     * <aop:before method="beforeAdvice" pointcut-ref="userServiceShowPointCut" />
     */
    // 前置通知注解
    // @Before("MyAdvice.myPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("当前的目标对象为： " + joinPoint.getTarget());
        System.out.println("当前的目标方法的参数为： " + joinPoint.getArgs());
        System.out.println("当前 正在处理 的切入点表达式为：" + joinPoint.getStaticPart());
        System.out.println("前置的增强.....");
    }

    // 后置通知注解
    // @AfterReturning("MyAdvice.myPointCut()")
    public void afterReturnAdvice() {
        System.out.println("后置的增强.....");
    }

    // 环绕通知注解
    @Around("MyAdvice.myPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前的增强.....");
        // 环绕通知因为是在目标方法前后执行，所以存在一个参数，该参数代表切入点本身
        // 切入点方法执行可能存在返回值，所有环绕方法的返回值一般为 Object
        Object result = proceedingJoinPoint.proceed();
        System.out.println("环绕后的增强.....");
        return result;
    }

    // 异常通知注解
    @AfterThrowing(value = "MyAdvice.myPointCut()", throwing = "e")
    public void afterThrowingAdvice(Throwable e) {
        System.out.println("异常对象是： " + e + "异常信息是： " + e.getMessage());
        System.out.println("异常抛出通知.....报异常才会执行");
    }

    // 最终通知注解
    @After("MyAdvice.myPointCut()")
    public void afterAdvice() {
        System.out.println("最终的增强.....");
    }

}
