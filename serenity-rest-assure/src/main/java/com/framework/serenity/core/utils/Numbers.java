package com.framework.serenity.core.utils;

import java.util.Random;

public class Numbers {
    public static String getRandomInt() {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
