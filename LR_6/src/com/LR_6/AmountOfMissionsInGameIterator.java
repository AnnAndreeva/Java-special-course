package com.LR_6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AmountOfMissionsInGameIterator implements Iterator<Integer> {
    private int[] amountOfMissionsInGame;
    private int currPos;

    public AmountOfMissionsInGameIterator(int[] amountOfMissions) {
        this.amountOfMissionsInGame = amountOfMissions;
        currPos = 0;
    }

    @Override
    public boolean hasNext() {
        return currPos < amountOfMissionsInGame.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        int next = amountOfMissionsInGame[currPos];
        currPos++;

        return next;
    }
}
