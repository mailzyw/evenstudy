package com.zhangyiwen.dubbo.spi;

/**
 * Created by zhangyiwen on 2018/1/23.
 */
public class ShutdownCommand implements Command{
    public void execute() {
        System.out.println("shutdown...");
    }
}
