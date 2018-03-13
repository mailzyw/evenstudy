package com.zhangyiwen.dubbo.javaproxy.simpleimplement;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by zhangyiwen on 2018/3/13.
 * Proxy
 */
public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler handler) throws Exception {
        String rt = "\n";
        String rx = "    ";
        String methodStr = "";

        for(Method m:infce.getMethods()){
            methodStr +=
                    "@Override" + rt + rx +
                            "public void " + m.getName() + "() {" + rt + rx +
                            "    try{" + rt + rx +
                            "        Method md = " + infce.getName() + ".class.getMethod(\""+ m.getName() + "\");" + rt + rx +
                            "        h.invoke(this,md);" + rt + rx +
                            "    } catch (Exception e) { " + rt + rx +
                            "        e.printStackTrace();" + rt + rx +
                            "    }" + rt + rx +
                            "}" ;
        }

        String str =
                "package com.zhangyiwen.dubbo.javaproxy.simpleimplement;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "import com.zhangyiwen.dubbo.javaproxy.simpleimplement.InvocationHandler;" +  rt+
                        "public class $Proxy0 implements " + infce.getName() + " {" + rt +
                        "    public $Proxy0(InvocationHandler h) {" + rt +
                        "        this.h = h;" + rt +
                        "    }" + rt +
                        "    private InvocationHandler h;" + rt+
                        "    " + methodStr + rt +
                        "}" ;

        //产生代理类的java文件
        String filename = System.getProperty("user.dir") +"/src/main/resources/com/zhangyiwen/dubbo/javaproxy/simpleimplement/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str);

        //编译
        //拿到编译器
        JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileMgr = complier.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileMgr.getJavaFileObjects(filename);
        //编译任务
        JavaCompiler.CompilationTask t = complier.getTask(null, fileMgr, null, null, null, units);
        //进行编译
        t.call();
        fileMgr.close();

        //load到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("com.zhangyiwen.dubbo.javaproxy.simpleimplement.$Proxy0");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(handler);
    }

}
