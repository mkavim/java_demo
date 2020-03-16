package com.xuxp.examples.design.factory;

public class TextFactory extends AbstractFactory {
    @Override
    public IReader create() {
        return new TextReader();
    }
}
