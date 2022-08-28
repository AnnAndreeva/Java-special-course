package com.LR_7;

import java.util.Random;

public class Game {
    public static final int DEFAULT_MIN_NUMB = 0;
    public static final int DEFAULT_MAX_NUMB = 1000;

    private int minNumb;
    private int maxNumb;

    public Game(int minNumb, int maxNumb) {
        if (minNumb < DEFAULT_MIN_NUMB) {
            throw new IllegalArgumentException("Минимальное число не может быть меньше 0");
        }

        if (maxNumb > DEFAULT_MAX_NUMB) {
            throw new IllegalArgumentException("Максимальное число не может быть больше 1000");
        }

        if (maxNumb < minNumb) {
            throw new IllegalArgumentException("Максимальное число меньше минимального");
        }

        this.minNumb = minNumb;
        this.maxNumb = maxNumb;
    }

    private static int getRandInt(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Максимальное число меньше минимального");
        }

        Random rand = new Random();
        return min + rand.nextInt(max - min + 1);
    }

    public int getMinNumb() {
        return minNumb;
    }

    public void setMinNumb(int newMin) {
        if (newMin < DEFAULT_MIN_NUMB) {
            throw new IllegalArgumentException("Минимальное число не может быть меньше 0");
        }

        if (newMin > maxNumb) {
            throw new IllegalArgumentException("Максимальное число меньше минимального");
        }

        minNumb = newMin;
    }

    public int getMaxNumb() {
        return maxNumb;
    }

    public void setMaxNumb(int newMax) {
        if (newMax > DEFAULT_MAX_NUMB) {
            throw new IllegalArgumentException("Максимальное число не может быть больше 1000");
        }

        if (newMax < minNumb) {
            throw new IllegalArgumentException("Максимальное число меньше минимального");
        }

        maxNumb = newMax;
    }

    public int guess() {
        return getRandInt(minNumb, maxNumb);
    }
}
