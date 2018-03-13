package com.zhangyiwen.dubbo.javaproxy;

/**
 * Created by zhangyiwen on 2018/3/13.
 * 真实角色
 */
public class RealSubject implements Subject{
    public void doSomething() {
        System.out.println("call doSomething()...");
    }
}
