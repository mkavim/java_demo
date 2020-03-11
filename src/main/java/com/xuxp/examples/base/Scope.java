package com.xuxp.examples.base;

public class Scope {

    public static void add(Integer i) {
        i = i + 1;
    }

    /**
     * 传入引用类型，在函数内部改变对象的值，会产生影响
     */
    public static void addAge(Person person) {
        person.setAge(person.getAge() + 1);
    }

    public static void main(String[] args) {
        // Integer i = 10;
        // System.out.println(i); // 10
        // Scope.add(i);
        // System.out.println(i); // 10

        //  引用类型
        Person person = new Student("x", 18, 1, 1);
        System.out.println(person.getAge()); //18
        Scope.addAge(person);
        System.out.println(person.getAge()); //19
        Scope.addAge(person);
        System.out.println(person.getAge()); //20
    }
}
