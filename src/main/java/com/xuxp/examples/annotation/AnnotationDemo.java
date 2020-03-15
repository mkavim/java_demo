package com.xuxp.examples.annotation;

import java.lang.reflect.Field;

public class AnnotationDemo {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person(-1);
        check(person);

    }

    static void check(Person person) throws IllegalAccessException {
        for (Field field : person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(person);
                System.out.println(value);
                if (value instanceof Integer) {
                    int v = (Integer) value;
                    if (v < range.min() || v > range.max()) {
                        throw new IllegalArgumentException("invalid args");
                    }
                }
            }
        }

    }
}

class Person {
    @Range(min = 1, max = 20)
    public int age;

    public Person(int age) {
        this.age = age;
    }


}