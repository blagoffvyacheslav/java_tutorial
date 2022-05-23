package com.dmdev.hw7;

public class Satellite extends SpaceObject {
    private final double weight;

    private final String name;

    private final double circumference;


    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getAbsoluteWeight(){
        return weight * 0.997;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "name=" + name +
                ", weight=" + weight +
                "}";
    }

    public double getCircumference() {
        return circumference;
    }

    public Satellite(double weight, String name, double circumference) {
        super(circumference);
        this.weight = weight;
        this.name = name;
        this.circumference = circumference;
    }
}