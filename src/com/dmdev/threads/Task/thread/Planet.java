package com.dmdev.threads.Task.thread;

import com.dmdev.threads.Task.model.CrystalItem;
import com.dmdev.threads.Task.model.Dump;
import com.dmdev.threads.Task.util.RandomUtil;

public class Planet extends Thread {


    private static final int MIN_CRYSTAL_NUM = 2;
    private static final int MAX_CRYSTAL_NUM = 5;
    private final Dump dump;

    private final Midnight midnight;

    public Planet(Dump dump, Midnight midnight) {
        this.dump = dump;
        this.midnight = midnight;
    }


    @Override
    public void run() {
        try {
            while(true) {
                throwNewCrystalls();
                waitNextMidnight();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void throwNewCrystalls() {
        int countItemsForThrowingToDump = RandomUtil.getNextWithBounds(MAX_CRYSTAL_NUM, MIN_CRYSTAL_NUM);
        synchronized (dump.getLock()) {
            for (int j = 0; j < countItemsForThrowingToDump; j++) {
                CrystalItem robotDetail = CrystalItem.CASHED_VALUES.get(RandomUtil.getNext(CrystalItem.CASHED_VALUES.size()));
                dump.add(robotDetail);
            }
            System.out.println("Planet threw out crystal items. Count: " + countItemsForThrowingToDump);
        }
    }

    private void waitNextMidnight() throws InterruptedException {
        synchronized (midnight.getLock()) {
            midnight.getLock().wait();
        }
    }

    public Dump getDump() {
        return dump;
    }

}
