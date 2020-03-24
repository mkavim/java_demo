package com.xuxp.examples.design.observer;

public interface IObserver {
    int getMask();

    void refresh(Object o);
    void pull(Subject subject);
}
