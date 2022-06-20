package com.dmdev.threads.Task.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getNextWithBounds(int high, int low) {
        return RANDOM.nextInt(high - low) + low;
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }

}