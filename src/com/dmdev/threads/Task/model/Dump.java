package com.dmdev.threads.Task.model;

import com.dmdev.threads.Task.model.CrystalItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dump {

    private final Object lock = new Object();

    public List<CrystalItem> getDump() {
        return dump;
    }

    private final List<CrystalItem> dump = new LinkedList<>();

    public Dump() {
    }

    public void add(CrystalItem robotDetail) {
        dump.add(robotDetail);
    }

    public CrystalItem remove(int index) {
        return dump.remove(index);
    }

    public List<CrystalItem> removeAll() {
        List<CrystalItem> crystalItems = new ArrayList<>(dump);
        dump.clear();
        return crystalItems;
    }

    public int size() {
        return dump.size();
    }

    public boolean isNotEmpty() {
        return !dump.isEmpty();
    }

    public Object getLock() {
        return lock;
    }
}