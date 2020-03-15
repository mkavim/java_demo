package com.xuxp.examples.relection;

import com.xuxp.examples.base.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射示例
 */
public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        printClassInfo(Person.class);
        printClassInfo("".getClass()); // 通过getClass获取实例的类型
        printClassInfo(int.class);
        printClassInfo(String[].class);

        // 利用反射获取实例中的属性值
        Object p = new Person("xxx");

        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        // 获取私有变量
        f.setAccessible(true);
        Object name = f.get(p);
        System.out.println(name);
        f.set(p, "xuxp");
        System.out.println(f.get(p));
        // 调用方法
        Method m = c.getMethod("setName", String.class);
        System.out.println(m.invoke(p, "xuxiaoping"));
        System.out.println(f.get(p));


    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }
}
