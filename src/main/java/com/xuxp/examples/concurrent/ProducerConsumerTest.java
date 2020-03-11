package com.xuxp.examples.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Thread producer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "producer");
        Thread consumer = new Thread(new Consumer(taskQueue), "consumer");
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        private final List<Integer> sharedQueue;
        private final int MAX_CAMPCITY;

        public Producer(List<Integer> sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.MAX_CAMPCITY = size;
        }

        @Override
        public void run() {
            int counter = 0;
            while (true) {
                try {
                    producer(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void producer(int i) throws InterruptedException {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == MAX_CAMPCITY) {
                    System.out.println("queue is filling...");
                    sharedQueue.wait();
                }
                Thread.sleep(1000);
                sharedQueue.add(i);
                System.out.println("producer " + i);
                sharedQueue.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable {
        private final List<Integer> sharedQueue;

        public Consumer(List<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consumer() throws InterruptedException {
            synchronized (sharedQueue) {
                while (sharedQueue.isEmpty()) {
                    System.out.println("queue is empty " + Thread.currentThread().getName());
                    sharedQueue.wait();
                }
                Thread.sleep(1000);
                int i = (Integer) sharedQueue.remove(0);
                System.out.println("consumer " + i);
                sharedQueue.notifyAll();
            }
        }
    }
}
