package com.xuxp.examples.design.observer;

public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        IObserver oberver = new Observer();
        subject.register(oberver);
        subject.setData("xuxp..");
        // 通知观察者
        subject.notifyObservers();
    }
}
