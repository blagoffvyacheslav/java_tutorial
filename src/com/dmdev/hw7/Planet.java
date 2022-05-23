package com.dmdev.hw7;

import java.util.Arrays;

public class Planet extends SpaceObject implements WithSatellite {

    private final double weight;

    private final String name;

    private final double circumference;

    private final Satellite[] satelittes;

    public Satellite[] getSatelittes() {
        return satelittes;
    }


    public double getCircumference() {
        return circumference;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getAbsoluteWeight(){
        return weight * 0.968;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name=" + name +
                ", weight=" + weight +
                "}";
    }

    @Override
    public void getAllSatelittes(){
        System.out.println("У планеты " + name + " " + Arrays.toString(satelittes));
    }


    public Planet(double weight, String name, double circumference, Satellite[] satelittes) {
        super(circumference);
        this.weight = weight;
        this.name = name;
        this.circumference = circumference;
        this.satelittes = satelittes;
    }
}