package com.dmdev.hw7;

import static java.lang.Math.PI;

public abstract class SpaceObject {

    public boolean isWeightEqual(SpaceObject object) {
        return getAbsoluteWeight() == object.getAbsoluteWeight();
    }

    public double calcDiameter() {
        return this.getCircumference()/PI;
    }

    public abstract double getAbsoluteWeight();
    public abstract double getCircumference();

}