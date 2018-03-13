package com.zhangyiwen.dubbo.spi;

import java.util.ServiceLoader;

/**
 * Created by zhangyiwen on 2018/1/23.
 */
public class SpiMainClass {

    public static void main(String[] args) {
        ServiceLoader<Command> serviceLoader = ServiceLoader.load(Command.class);
        for(Command command:serviceLoader){
            command.execute();
        }
    }

}
