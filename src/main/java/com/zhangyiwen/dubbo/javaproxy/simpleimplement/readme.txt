#JDK动态代理的简易实现

实现功能:通过Proxy的newProxyInstance返回代理对象
1.声明一段源码(动态产生代理)
2.编译源码(JDK Compiler API),产生新的类(代理类)
3.将这个类load到内存中,产生一个新的对象(代理对象)
4.return代理对象

#比较
1.静态代理是通过在代码中显式定义一个业务实现类一个代理，在代理类中对同名的业务方法进行包装，用户通过代理类调用被包装过的业务方法；
2.JDK动态代理是通过接口中的方法名，在动态生成的代理类中调用业务实现类的同名方法；
3.CGlib动态代理是通过继承业务类，生成的动态代理类是业务类的子类，通过重写业务方法进行代理；