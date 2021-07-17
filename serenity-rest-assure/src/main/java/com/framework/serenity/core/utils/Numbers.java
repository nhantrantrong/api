package com.framework.serenity.core.utils;

import java.util.Random;

/**
 * @author trantrongnhan
 * <p>
 * Class implementations for common functions relating to Number handling
 */
public class Numbers {
    /**
     * Get random of int String
     */
    public static String getRandomInt() {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
