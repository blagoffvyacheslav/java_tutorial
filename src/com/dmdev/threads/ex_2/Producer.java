package com.dmdev.threads.ex_2;

import java.util.List;

class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> sharedQueue, int size) {
        this.taskQueue = sharedQueue;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        int counter = 0;
//        while (true)
//        {
//            try
//            {
//                produce(counter++);
//            }
//            catch (InterruptedException ex)
//            {
//                ex.printStackTrace();
//            }
//        }
    }

    private void produce() throws InterruptedException {
//        int i = 0;
        for (int i = 0; i < 10; i++) {
            synchronized (taskQueue) {
                while (taskQueue.size() == MAX_CAPACITY) {
                    System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                    taskQueue.wait();
                }
                if (i==5){
                    break;
                }
                Thread.sleep(1000);
                taskQueue.add(i);
                System.out.println("Produced: " + i);
                taskQueue.notifyAll();
            }
//            i++;
        }
    }
}
