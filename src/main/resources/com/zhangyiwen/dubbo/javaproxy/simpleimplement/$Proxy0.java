package com.zhangyiwen.dubbo.javaproxy.simpleimplement;
import java.lang.reflect.Method;
import com.zhangyiwen.dubbo.javaproxy.simpleimplement.InvocationHandler;
public class $Proxy0 implements com.zhangyiwen.dubbo.javaproxy.simpleimplement.Moveable {
    public $Proxy0(InvocationHandler h) {
        this.h = h;
    }
    private InvocationHandler h;
    @Override
    public void move() {
        try{
            Method md = com.zhangyiwen.dubbo.javaproxy.simpleimplement.Moveable.class.getMethod("move");
            h.invoke(this,md);
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}