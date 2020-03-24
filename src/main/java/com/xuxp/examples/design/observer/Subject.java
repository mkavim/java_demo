package com.xuxp.examples.design.observer;

import java.util.Vector;

public class Subject implements ISubject {
    private final int MASK = 1;
    private Vector<IObserver> obervers = new Vector<>();
    private Object data;
    private boolean isChanged;

    public Subject() {
        isChanged = false;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        isChanged = true;
    }

    public void register(IObserver oberver) {
        if (!obervers.contains(oberver)) {
            obervers.add(oberver);
        }
    }

    @Override
    public void unregister(IObserver oberver) {
        obervers.remove(oberver);
    }

    @Override
    public void notifyObservers() {
        if (isChanged) {
            for (IObserver oberver : obervers) {
                oberver.refresh(data);  // 推送
                oberver.pull(this); // 拉取
            }
            isChanged = false;
        }
    }

    @Override
    public int getMask() {
        return MASK;
    }

}
