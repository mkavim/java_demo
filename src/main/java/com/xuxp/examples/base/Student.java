package com.xuxp.examples.base;

import java.util.StringJoiner;

/**
 * Student 继承 Person,并增加自己的行为和属性
 *
 * @author mkavim
 * @version 1.0.0
 * @date 2020-03-11
 */
public class Student extends Person {
    private int grade;

    public Student(String name, int age, int sex, int grade) {
        super(name, age, sex); // 调用父类的构造器
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 15) {
            this.grade = grade;
        }
        throw new IllegalArgumentException("1=<grade<=15");
    }

    @Override
    public void sayHello() {
        System.out.println("Hi！ My name is " + this.getName() + " I'm a " + this.grade + "student!");
    }

}
