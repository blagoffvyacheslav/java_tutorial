package com.dmdev.hw7;

import static java.lang.Math.PI;

public abstract class SpaceObject {

    private final double circumference;

    protected SpaceObject(double circumference) {
        this.circumference = circumference;
    }

    public boolean isWeightEqual(SpaceObject object) {
        return getAbsoluteWeight() == object.getAbsoluteWeight();
    }

    public double calcDiameter() {
        return this.circumference/PI;
    }

    public abstract double getAbsoluteWeight();
}