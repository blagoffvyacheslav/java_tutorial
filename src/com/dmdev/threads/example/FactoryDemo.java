package com.dmdev.threads.example;

import com.dmdev.threads.example.model.RobotDetail;
import com.dmdev.threads.example.model.Scientist;
import com.dmdev.threads.example.thread.Factory;
import com.dmdev.threads.example.thread.Night;
import com.dmdev.threads.example.thread.ScientistAssistant;
import com.dmdev.threads.example.util.RandomUtil;
import com.dmdev.threads.example.util.ThreadUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactoryDemo {

    public static void main(String[] args) throws InterruptedException {
        Night night = new Night();
        Factory factory = new Factory(night, getInitialRobotDetailsInDump());
        ScientistAssistant badScientistAssistant = new ScientistAssistant(new Scientist("Плохой ученый"), factory.getDump(), night);
        ScientistAssistant goodScientistAssistant = new ScientistAssistant(new Scientist("Хороший ученый"), factory.getDump(), night);

        ThreadUtil.startThreads(night, factory, badScientistAssistant, goodScientistAssistant);
        ThreadUtil.joinThreads(night, factory, badScientistAssistant, goodScientistAssistant);

        viewStatistic(badScientistAssistant.getScientist(), goodScientistAssistant.getScientist());
    }

    private static List<RobotDetail> getInitialRobotDetailsInDump() {
        return IntStream.range(0, 20)
                .map(value -> RandomUtil.getNext(RobotDetail.CASHED_VALUES.size()))
                .mapToObj(RobotDetail.CASHED_VALUES::get)
                .collect(Collectors.toList());
    }

    private static void viewStatistic(Scientist firstScientist, Scientist secondScientist) {
        System.out.println("----------------");
        System.out.println(firstScientist.getName() + " " + firstScientist.buildRobots().size());
        System.out.println(secondScientist.getName() + " " + secondScientist.buildRobots().size());
    }
}