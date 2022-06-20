package com.dmdev.threads.Task;

import com.dmdev.threads.Task.model.Dump;
import com.dmdev.threads.Task.model.Mage;
import com.dmdev.threads.Task.thread.MageRocket;
import com.dmdev.threads.Task.thread.Planet;
import com.dmdev.threads.Task.thread.Midnight;
import com.dmdev.threads.Task.util.ThreadUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Dump dump = new Dump();
        Midnight midnight = new Midnight();
        Planet planet = new Planet(dump, midnight);
        MageRocket firebenderRocket = new MageRocket(new Mage("Firebender"), planet, midnight);
        MageRocket airbenderRocket = new MageRocket(new Mage("Airbender"), planet, midnight);

        ThreadUtil.startThreads(midnight, planet, firebenderRocket, airbenderRocket);
        ThreadUtil.joinThreads(midnight, planet, firebenderRocket, airbenderRocket);

        viewStatistic(firebenderRocket.getMage(), airbenderRocket.getMage());
    }


    private static void viewStatistic(Mage firebender, Mage airbender) {
        System.out.println("----------------");
        System.out.println(firebender.getName() + " " + firebender.getCrystalItems());
        System.out.println(airbender.getName() + " " + airbender.getCrystalItems());
    }
}