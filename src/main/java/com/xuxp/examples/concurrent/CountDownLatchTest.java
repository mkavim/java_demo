package com.xuxp.examples.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Executor executor= Executors.newFixedThreadPool(2);
        int i =100;
        while (i>0){
            // 计数器初始化为2
            CountDownLatch countDownLatch = new CountDownLatch(2);
            // 查询未对账订单
            executor.execute(()->{
                // 执行业务查询
                countDownLatch.countDown();
            });
            // 查询派送单
            executor.execute(()->{
                // 执行业务查询
                countDownLatch.countDown();
            });
            // 等待两个查询操作结束
            countDownLatch.await();
            System.out.println("executor end");
        }
    }
}
