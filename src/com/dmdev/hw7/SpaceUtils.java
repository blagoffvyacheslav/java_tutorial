package com.dmdev.hw7;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static boolean isStar(SpaceObject object) {
        return object instanceof Star;
    }

    public static double calcGravity(SpaceObject object) {
        return object.getAbsoluteWeight()*9.99;
    }
}
