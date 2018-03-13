package com.zhangyiwen.dubbo.javaproxy;

/**
 * Created by zhangyiwen on 2018/3/13.
 * 测试类
 */
public class TestJavaProxy {

    public static void main(String[] args) throws Exception
    {
        //静态代理
        Subject sub = new StaticSubjectProxy();
        sub.doSomething();
        System.out.println("----------");

        //动态代理
        ProxyHandler proxyHandler = new ProxyHandler();
        Subject sub2 = (Subject)proxyHandler.bind(new RealSubject());
        sub2.doSomething();
    }

}
