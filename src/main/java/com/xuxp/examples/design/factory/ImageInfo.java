package com.xuxp.examples.design.factory;

public class ImageInfo {
    private int height;
    private int width;
    private int r[][];
    private int b[][];
    private int g[][];

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getR() {
        return r;
    }

    public void setR(int[][] r) {
        this.r = r;
    }

    public int[][] getB() {
        return b;
    }

    public void setB(int[][] b) {
        this.b = b;
    }

    public int[][] getG() {
        return g;
    }

    public void setG(int[][] g) {
        this.g = g;
    }

    public void setRGB(int[] rgb) {
        r = new int[height][width];
        g = new int[height][width];
        b = new int[height][width];
        int pos = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                r[i][j] = (rgb[pos + j] & 0xff0000) >> 16;
                g[i][j] = (rgb[pos + j] & 0x00ff00) >> 8;
                b[i][j] = (rgb[pos + j] & 0x0000ff);
            }
        }
    }

    @Override
    public String toString() {
        return "width:" + width + ",height" + height;
    }
}
