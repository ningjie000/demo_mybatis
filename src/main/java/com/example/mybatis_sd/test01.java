package com.example.mybatis_sd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: NJ
 * @Description:sprring事物分类
 *               声明式事物
 *               编程式事物
 *               spring事务原理
 *               aop技术，使用环绕通知进行拦截
 *
 *               spring事务注意事项
 *               不能使用try
 *               因为要将异常抛出给外层
 *
 *               垂直拆分，水平拆分
 *               垂直根据业务划分数据库
 *
 *               一个项目中有多个数据源（连接不同库的jdbc）（无线大）具体数目根据内存
 *
 *               项目中如何划分 分包，通过注解
 *               分包根据业务存放到一个保重，类似一个jar
 *
 *               aop拦截注解
 *
 *               springboot 1.5没有默认指向主数据源会报错
 *               springboot 2.0 不会报错
 *
 *               多数据源报错两个事物错误？？需要指定事务管理器
 *
 *               传统分布式事务解决 分布式事务管理
 *               jta+atomikos
 *
 * @Date: 2019/5/5
 */
public class test01 {

    public static void main(String[] args) {
//        // InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
//// 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用
//        InvocationHandler handler = new InvocationHandlerImpl(..);
//
//// 通过 Proxy 为包括 Interface 接口在内的一组接口动态创建代理类的类对象
//        Class clazz = Proxy.getProxyClass(classLoader, new Class[] { Interface.class, ... });
//
//// 通过反射从生成的类对象获得构造函数对象
//        Constructor constructor = clazz.getConstructor(new Class[] { InvocationHandler.class });
//
//// 通过构造函数对象创建动态代理类实例
//        Interface Proxy = (Interface)constructor.newInstance(new Object[] { handler });
//
        String str = "asd,";
String[] sre = str.split(",");
for(String s : sre){
    System.out.println(s);

}
    }



}
