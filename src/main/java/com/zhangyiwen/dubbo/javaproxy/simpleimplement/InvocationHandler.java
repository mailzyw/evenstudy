package com.zhangyiwen.dubbo.javaproxy.simpleimplement;

import java.lang.reflect.Method;

/**
 * Created by zhangyiwen on 2018/3/13.
 * InvocationHandler
 */
public interface InvocationHandler {

    void invoke(Object proxy,Method method);

}
