package com.xuxp.examples.design.factory;

public interface IReader<T> {
    T read(String in, String encoding);
}
