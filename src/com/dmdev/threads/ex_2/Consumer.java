package com.dmdev.threads.ex_2;

import java.util.List;

class Consumer implements Runnable {
    private final List<Integer> taskQueue;
    private final Producer prod;

    public Consumer(List<Integer> sharedQueue, Producer prod) {
        this.taskQueue = sharedQueue;
        this.prod = prod;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void consume() throws InterruptedException {
        for (int l = 0; l < 10; l++) {
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    taskQueue.wait(1000);
                    break;
                }
                Thread.sleep(1000);
                int i = (Integer) taskQueue.remove(0);
                System.out.println("Consumed: " + i);
                taskQueue.notifyAll();
            }
        }
    }
}