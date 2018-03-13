package com.zhangyiwen.dubbo.javaproxy.simpleimplement;

import java.util.Random;

/**
 * Created by zhangyiwen on 2018/3/13.
 * 真实角色
 */
public class Car implements Moveable{

    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
