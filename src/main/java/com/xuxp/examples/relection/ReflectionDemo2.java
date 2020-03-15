package com.xuxp.examples.relection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void morning(String name);
}

/**
 * 反射示例
 */
public class ReflectionDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // 定义一个InvocationHandler实例，它负责实现接口的方法调用；
        // 通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
        // 使用的ClassLoader，通常就是接口类的ClassLoader；
        // 需要实现的接口数组，至少需要传入一个接口进去；
        // 用来处理接口方法调用的InvocationHandler实例。
        //将返回的Object强制转型为接口。
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[]{Hello.class}, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("xuxp");
    }
}