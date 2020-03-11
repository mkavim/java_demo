package com.xuxp.examples.base;

/**
 * @author mkavim
 * @version 1.0.0
 * @date 2020-03-11
 */
public class Person implements IAction {
    private String name;
    private int age;
    private int sex;
    private String idCard;

    public Person() {

    }

    /**
     * 构造函数
     *
     * @param name
     */
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    public Person(String name, int age, int sex) {
        this(name, age);
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {

            throw new IllegalArgumentException("0 < age < 120");
        }
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        if (sex == 0 || sex == 1) {
            this.sex = sex;
        }
        throw new IllegalArgumentException("sex=1 or sex=0");

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.idCard.equals(this.idCard)
                    && person.name.equals(this.name)
                    && person.age == this.age
                    && person.sex == this.sex;

        }
        return false;
    }

    public void sayHello() {
        System.out.println("Hi！ My name is " + this.name);
    }

    @Override
    public void eat() {
        System.out.println("action eat");
    }

    @Override
    public void walk() {
        System.out.println("action walk");
    }

    @Override
    public void sleep() {
        System.out.println("action sleep");
    }
}
