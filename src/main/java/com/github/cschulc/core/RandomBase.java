package com.github.cschulc.core;

import java.util.List;
import java.util.Random;

public abstract class RandomBase {

    protected final Random random;

    protected final DataHolder dataHolder;

    public RandomBase() {
        random = new Random();
        dataHolder = new DataHolder();
    }

    protected String getRandomElement(List<String> list) {
        int size = list.size();
        return list.get(random.nextInt(size));
    }

    protected int getCount(int min, int max) {
        if (min < 0) min = 0;
        if (max < min) max = min;
        int count = max != min ? random.nextInt(max - min) + min : min;
        return count;
    }
}
