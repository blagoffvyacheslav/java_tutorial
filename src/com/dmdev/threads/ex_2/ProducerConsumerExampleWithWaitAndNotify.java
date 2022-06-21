package com.dmdev.threads.ex_2;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExampleWithWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> taskQueue = new ArrayList<Integer>();
        int MAX_CAPACITY = 5;
        Producer prod = new Producer(taskQueue, MAX_CAPACITY);
        Thread tProducer = new Thread(prod, "Producer");
        Thread tConsumer = new Thread(new Consumer(taskQueue, prod), "Consumer");
        tProducer.start();
        tConsumer.start();
        tProducer.join();
        tConsumer.join();
    }
}
