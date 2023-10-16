package aop.cglib;

/**
 * 用来配合 cglib 模拟思想代码的 通知类（增强类）
 */
public class MyAdvice {

    public void before() {
        System.out.println("before....");
    }

    public void after() {
        System.out.println("after....");
    }
}
