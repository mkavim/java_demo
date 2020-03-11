package com.xuxp.examples;


import java.io.*;

class User implements Serializable {
    private String name;
    private String sex;
    // 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化。
    private transient String idCard;

    public User(String mName, String mSex, String mIdCard) {
        this.name = mName;
        this.sex = mSex;
        this.idCard = mIdCard;
    }

    @Override
    public String toString() {
        return "name=>" + this.name +
                "\nsex=>" + this.sex +
                "\nidCard=>" + this.idCard;
    }
}


/**
 * transient 用法
 */
public class TransientExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("xuxiaoping", "man", "511xxxxxxx");
        System.out.println("save user to use01");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user01"));
        outputStream.writeObject(user);
        outputStream.close();
        System.out.println("save done");

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user01"));
        User userIn = (User) inputStream.readObject();
        System.out.println(userIn.toString());
    }

}