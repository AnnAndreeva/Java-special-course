
import java.util.Random;

public class Game {
    public static final int defaultMin = 0;
    public static final int defaultMax = 1000;

    private int minNumb;
    private int maxNumb;

    public Game(int minNumb, int maxNumb) {
        if (minNumb < defaultMin) {
            throw new IllegalArgumentException("Минимальное число не может быть меньше 0");
        }

        if (maxNumb > defaultMax) {
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

    public int getMin() {
        return minNumb;
    }

    public void setMin(int newMin) {
        if (newMin < defaultMin) {
            throw new IllegalArgumentException("Минимальное число не может быть меньше 0");
        }

        if (newMin > maxNumb) {
            throw new IllegalArgumentException("Максимальное число меньше минимального");
        }

        minNumb = newMin;
    }
    
    public int getMax() {
        return maxNumb;
    }

    public void setMax(int newMax) {
        if (newMax > defaultMax) {
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

