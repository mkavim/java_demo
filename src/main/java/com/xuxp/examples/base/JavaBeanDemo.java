package com.xuxp.examples.base;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class JavaBeanDemo {
    //要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector
    public static void main(String[] args) throws IntrospectionException {
        Logger logger = LoggerFactory.getLogger(JavaBeanDemo.class);
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }
}

