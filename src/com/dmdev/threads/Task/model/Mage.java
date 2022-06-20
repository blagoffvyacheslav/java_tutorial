package com.dmdev.threads.Task.model;


import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Mage {

    public Map<CrystalItem, Integer> getCrystalItems() {
        return crystalItems;
    }

    private final Map<CrystalItem, Integer> crystalItems = new EnumMap<>(CrystalItem.class);


    public void addCrystalItem(List<CrystalItem> list) {
        list.forEach(detail -> crystalItems.merge(detail, 1, Integer::sum));
    }

    private final String name;

    public Mage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
