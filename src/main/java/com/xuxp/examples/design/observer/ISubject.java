package com.xuxp.examples.design.observer;

public interface ISubject {

    void register(IObserver oberver);

    void unregister(IObserver oberver);

    void notifyObservers();

    int getMask();
}
