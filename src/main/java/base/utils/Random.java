package base.utils;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

/**
 * Created by valera on 10.03.17.
 */
public class Random {

    private static XoRoShiRo128PlusRandom gen = new XoRoShiRo128PlusRandom(0);

    public static int getRandom(int min, int max) {
        int len = max - min;
        if (len ==0) return min;
        return min + gen.nextInt(len);
//        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

    public static String getRandomColorCode() {
        return Integer.toHexString(getRandom(1, 16777214));
    }

    public static int getRandomPercent() {
        return getRandom(0, 100);
    }

    public static int getRandomDirection() {
        return getRandom(0, 7);
    }
}
