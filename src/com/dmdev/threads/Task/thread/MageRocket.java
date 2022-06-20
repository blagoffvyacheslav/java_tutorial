package com.dmdev.threads.Task.thread;


import com.dmdev.threads.Task.model.CrystalItem;
import com.dmdev.threads.Task.model.Mage;
import com.dmdev.threads.Task.thread.Midnight;
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
    private final Planet planet;

    public MageRocket(Mage mage, Planet planet, Midnight midnight) {
        this.mage = mage;
        this.planet = planet;
        this.midnight = midnight;
    }

    @Override
    public void run() {
        try {
            while(true) {
                List<CrystalItem> crystals = gatherCrystalsFromPlanet();
                mage.addCrystalItem(crystals);
                Map<CrystalItem, Integer> currentCrystals = mage.getCrystalItems();
                int whiteCrystallsNum = Optional.ofNullable(currentCrystals.get(CrystalItem.WHITE)).orElse(0);
                int redCrystallsNum = Optional.ofNullable(currentCrystals.get(CrystalItem.RED)).orElse(0);

                if (whiteCrystallsNum >= CompetitionConst.AMOUNT_OF_CRYSTALLS && redCrystallsNum >= CompetitionConst.AMOUNT_OF_CRYSTALLS) {
                    planet.planetStop();
                    midnight.midNightStop();
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
        synchronized (planet.getDump().getLock()) {
            if (planet.getDump().size() <= itemsCount) {
                gatheredCrystalsFromPlanet.addAll(planet.getDump().removeAll());
            } else if (planet.getDump().isNotEmpty()) {
                for (int j = 0; j < itemsCount; j++) {
                    CrystalItem removedItems = planet.getDump().remove(RandomUtil.getNext(planet.getDump().size()));
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