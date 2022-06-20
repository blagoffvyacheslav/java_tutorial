package com.dmdev.threads.Task.thread;

import com.dmdev.threads.Task.util.MidnightConst;

public class Midnight extends Thread {

    boolean stop = true;

    private final Object lock = new Object();

    public void midNightStop(){
        stop = false;
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        int i = 0;
        while(stop){
            synchronized (lock) {
                try {
                    System.out.printf("----------------\nMidnight %s started\n", (i + 1));
                    lock.notifyAll();
                    lock.wait(MidnightConst.MIDNIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}