package com.LR_3_dop;

import java.util.Comparator;

public class GamesComparator implements Comparator<GamesI> {
    @Override
    public int compare(GamesI o1, GamesI o2) {
        return o1.compareTo(o2);
    }

    static <T> void sort(T[] objects, Comparator<T> comparator) {
        for (int i = 0; i < objects.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < objects.length; j++) {
                if (comparator.compare(objects[j], objects[maxIndex]) > 0)
                    maxIndex = j;
            }
            T swapBuf = objects[i];
            objects[i] = objects[maxIndex];
            objects[maxIndex] = swapBuf;
        }
    }

}
