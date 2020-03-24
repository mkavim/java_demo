package com.xuxp.examples.design.observer;

public class Observer implements IObserver {
    private int MASK = 1;

    @Override
    public int getMask() {
        return MASK;
    }

    public void refresh(Object o) {
        System.out.println(o.toString());
    }

    @Override
    public void pull(Subject subject) {
        System.out.println("pull:" + subject.getData().toString());
    }

    @Override
    public boolean equals(Object obj) {
        Observer s = (Observer) (obj);
        return this.MASK == s.getMask();
    }
}
