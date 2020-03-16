package com.xuxp.examples.design.factory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader implements IReader<ImageInfo> {
    @Override
    public ImageInfo read(String in, String encoding) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int[] rgb = new int[width * height];
        bufferedImage.getRGB(0, 0, width, height, rgb, width, height);
        ImageInfo info = new ImageInfo();
        info.setWidth(width);
        info.setHeight(height);
        return info;
    }
}
