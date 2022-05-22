package com.dmdev.hw7;

import java.util.Arrays;

public class Star extends SpaceObject implements WithSatellite {
    private final double weight;

    private final String name;

    private final double circumference;

    private final Satellite[] satelittes;
    private final Planet[] planets;

    public Satellite[] getSatelittes() {
        return satelittes;
    }

    public Planet[] getPlanets() {
        return planets;
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
        return weight * 0.987;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name=" + name +
                ", weight=" + weight +
                "}";
    }

    @Override
    public void getAllSatelittes(){
        System.out.println("У звезды " + name + " " + Arrays.toString(satelittes));
    }

    public Star(double weight, String name, double circumference, Satellite[] satelittes, Planet[] planets) {
        this.weight = weight;
        this.name = name;
        this.circumference = circumference;
        this.satelittes = satelittes;
        this.planets = planets;
    }
}