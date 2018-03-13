package com.zhangyiwen.dubbo.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangyiwen on 2018/3/13.
 * JDK动态代理实现
 * JDK动态代理所用到的代理类在程序调用到代理类对象时才由JVM真正创建
 * JVM根据传进来的"业务实现类对象"以及"方法名",动态地创建了一个代理类的class文件并被字节码引擎执行
 * 然后通过该代理类对象进行方法调用
 */
public class ProxyHandler implements InvocationHandler{

    private Object tar; //被代理的真实角色

    /**
     * 绑定委托对象,并返回代理类
     */
    public Object bind(Object tar){
        this.tar = tar;

        //绑定该类实现的所有接口,取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),tar.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        //在调用具体函数方法前，执行功能处理
        System.out.println("proxy before2");

        result = method.invoke(tar,args);

        //在调用具体函数方法后，执行功能处理
        System.out.println("proxy after2");

        return result;
    }

}
