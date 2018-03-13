package com.zhangyiwen.dubbo.compiler;

/**
 * Created by zhangyiwen on 2018/1/30.
 */
public class Emp {

    private String ename;
    private int eno;

    public Emp() {
        this.ename = "yy";
        this.eno = 1;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    //添加一个自定义方法
    public void printInfo() {
        System.out.println("begin!");
        System.out.println(ename);
        System.out.println(eno);
        System.out.println("over!");
    }
}
