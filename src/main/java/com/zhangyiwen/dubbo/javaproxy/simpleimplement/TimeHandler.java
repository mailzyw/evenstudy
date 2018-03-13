package com.zhangyiwen.dubbo.javaproxy.simpleimplement;

import java.lang.reflect.Method;

/**
 * Created by zhangyiwen on 2018/3/13.
 * TimeHandler
 */
public class TimeHandler implements InvocationHandler{

    private Object target;  //被代理的真实角色

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    public void invoke(Object proxy, Method method) {
        try {
            long starttime = System.currentTimeMillis();
            System.out.println("汽车开始行驶....");
            method.invoke(target);
            long endtime = System.currentTimeMillis();
            System.out.println("汽车结束行驶....  汽车行驶时间："
                    + (endtime - starttime) + "毫秒！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
