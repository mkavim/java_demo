package com.xuxp.examples.concurrent.semaphore;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 使用信号量模型实现一个限流器
 */
public class ObjPool<T, R> {

    final List<T> pool;
    final Semaphore semaphore;

    public ObjPool(T[] tArray) {
        pool = new ArrayList<T>();
        int size = tArray.length;
        for (int i = 0; i < size; i++) {
            pool.add(tArray[i]);
        }
        semaphore = new Semaphore(size);
    }

    public static void main(String[] args) {
        String[] messages = new String[10];
        for (int i = 0; i < 10; i++) {
            messages[i] = "obj_" + i;
        }
        ObjPool<String, String> pool = new ObjPool<>(messages);

        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                pool.exec(t -> {
                    System.out.println("当前线程id:" + Thread.currentThread().getId() + ",当前获取到的对象：" + t);
                    return t;
                });
            });
            thread.start();

        }
    }

    R exec(Function<T, R> function) {
        T t = null;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t = pool.remove(0);
            return function.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

}
