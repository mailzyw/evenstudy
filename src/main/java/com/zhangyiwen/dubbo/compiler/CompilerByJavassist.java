package com.zhangyiwen.dubbo.compiler;

import javassist.*;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Modifier;

/**
 * Created by zhangyiwen on 2018/1/30.
 * Javassist是一款字节码编辑工具,同时也是一个动态类库,它可以直接检查/修改以及创建Java类
 * 以下例子就是创建一个动态类
 */
public class CompilerByJavassist {

    public static void main(String[] args) throws Exception {

        //ClassPool:CtClass对象的容器
        ClassPool pool = ClassPool.getDefault();

        //通过ClassPool生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("com.zhangyiwen.dubbo.compiler.Emp");

        //添加属性
        //首先添加属性 private String ename
        CtField enameField = new CtField(pool.getCtClass("java.lang.String"),"ename",ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);

        //其次添加属性private int eno
        CtField enoField = new CtField(pool.getCtClass("int"), "eno", ctClass);
        enoField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enoField);

        //为属性ename和eno添加getXxx和setXxx方法
        ctClass.addMethod(CtNewMethod.getter("getEname",enameField));
        ctClass.addMethod(CtNewMethod.getter("setEname",enameField));
        ctClass.addMethod(CtNewMethod.getter("getEno",enoField));
        ctClass.addMethod(CtNewMethod.getter("setEno",enoField));

        //添加构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{},ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n").append("ename=\"yy\";\n").append("eno=001;\n}");
        ctConstructor.setBody(buffer.toString());
        //把构造函数添加到新的类中
        ctClass.addConstructor(ctConstructor);

        //添加自定义方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType,"printInfo",new CtClass[]{},ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append("{\nSystem.out.println(\"begin!\");\n")
                .append("System.out.println(ename);\n")
                .append("System.out.println(eno);\n")
                .append("System.out.println(\"over!\");\n").append("}");
        ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);

        //生成一个Class
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        //反射执行方法
        obj.getClass().getMethod("printInfo",new Class[]{}).invoke(obj,new Object[]{});

        //把生成的class写文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/zhangyiwen/workspace_zhangyiwen/evenstudy/Emp.class"));
        fos.write(byteArr);
        fos.close();



    }


}
