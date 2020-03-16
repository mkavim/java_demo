package com.xuxp.examples.design.factory;

import java.io.File;
import java.io.FileInputStream;

public class TextReader implements IReader<String> {
    @Override
    public String read(String in, String encoding) {
        String result = null;

        try {
            File file = new File(in);
            long len = file.length();
            FileInputStream inputStream = new FileInputStream(in);
            // 这里只适合读取小文件
            byte[] buff = new byte[(int) len];
            inputStream.read(buff);
            result = new String(buff, encoding);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
