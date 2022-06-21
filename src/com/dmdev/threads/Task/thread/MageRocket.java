package com.dmdev.threads.Task.thread;


import com.dmdev.threads.Task.model.CrystalItem;
import com.dmdev.threads.Task.model.Mage;
import com.dmdev.threads.Task.model.Dump;
import com.dmdev.threads.Task.util.CompetitionConst;
import com.dmdev.threads.Task.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MageRocket extends Thread {

    private static final int MIN_CRYSTAL_NUM = 2;
    private static final int MAX_CRYSTAL_NUM = 5;
    private final Midnight midnight;
    private final Mage mage;
    private final Dump dump;

    public MageRocket(Mage mage, Dump dump, Midnight midnight) {
        this.mage = mage;
        this.dump = dump;
        this.midnight = midnight;
    }

    @Override
    public void run() {
        try {
            while (midnight.stop) {
                List<CrystalItem> crystals = gatherCrystalsFromPlanet();
                mage.addCrystalItem(crystals);
                Map<CrystalItem, Integer> currentCrystals = mage.getCrystalItems();
                int whiteCrystallsNum = Optional.ofNullable(currentCrystals.get(CrystalItem.WHITE)).orElse(0);
                int redCrystallsNum = Optional.ofNullable(currentCrystals.get(CrystalItem.RED)).orElse(0);
                if (whiteCrystallsNum >= CompetitionConst.AMOUNT_OF_CRYSTALLS && redCrystallsNum >= CompetitionConst.AMOUNT_OF_CRYSTALLS) {
                    synchronized (midnight.getLock()) {
                        midnight.stop = false;
                        midnight.getLock().wait(100000);
                        System.out.println("Stopping...");
                    }
                    break;
                } else {
                    waitNextMidnight();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<CrystalItem> gatherCrystalsFromPlanet() {
        int itemsCount = RandomUtil.getNextWithBounds(MAX_CRYSTAL_NUM, MIN_CRYSTAL_NUM);
        List<CrystalItem> gatheredCrystalsFromPlanet = new ArrayList<>(MAX_CRYSTAL_NUM);
        synchronized (dump.getLock()) {
            if (dump.size() <= itemsCount) {
                gatheredCrystalsFromPlanet.addAll(dump.removeAll());
            } else if (dump.isNotEmpty()) {
                for (int j = 0; j < itemsCount; j++) {
                    CrystalItem removedItems = dump.remove(RandomUtil.getNext(dump.size()));
                    gatheredCrystalsFromPlanet.add(removedItems);
                }
            }
            System.out.printf("%s mage gathered next items: %s\n", mage.getName(), gatheredCrystalsFromPlanet);
        }

        return gatheredCrystalsFromPlanet;
    }

    private void waitNextMidnight() throws InterruptedException {
        synchronized (midnight.getLock()) {
            midnight.getLock().wait();
        }
    }

    public Mage getMage() {
        return mage;
    }
}