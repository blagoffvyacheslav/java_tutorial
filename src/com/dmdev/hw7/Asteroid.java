package com.dmdev.hw7;

public class Asteroid extends SpaceObject {

    private final double weight;

    private final double circumference;

    private final String name;

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
        return "Asteroid{" +
                "name=" + name +
                ", weight=" + weight +
                "}";
    }

    public Asteroid(double weight, double circumference, String name) {
        this.weight = weight;
        this.circumference = circumference;
        this.name = name;
    }
}