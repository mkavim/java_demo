package com.xuxp.examples.base;

import org.junit.Test;

public class StudentTest {

    @Test
    public void sayHello() {
        // 多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
        // Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
        // 比如下面这个例子，实际上调用的是Student的sayHello，而不是Person的sayHello
        Person person = new Student("xx", 18, 1, 1);
        person.sayHello();
    }
}