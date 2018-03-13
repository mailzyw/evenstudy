package com.zhangyiwen.dubbo.javaproxy;

/**
 * Created by zhangyiwen on 2018/3/13.
 * 静态代理实现类
 * 缺点:每实现一个新的接口,都需要在代理类中新写该接口的实现方法
 */
public class StaticSubjectProxy implements Subject{

    //代理模式的作用是:为其他对象提供一种代理,以控制对这个对象的访问
    Subject subimpl = new RealSubject();

    public void doSomething() {
        System.out.println("before"); //调用目标对象之前可以做相关操作
        subimpl.doSomething();
        System.out.println("after");//调用目标对象之后可以做相关操作
    }
}
