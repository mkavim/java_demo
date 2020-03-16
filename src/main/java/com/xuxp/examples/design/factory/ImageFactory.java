package com.xuxp.examples.design.factory;

public class ImageFactory extends AbstractFactory {
    @Override
    public IReader create() {
        return new ImageReader();
    }
}
