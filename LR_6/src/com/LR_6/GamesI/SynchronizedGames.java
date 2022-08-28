package com.LR_6.GamesI;

import com.LR_6.Exceptions.AmountOfMissionsException;
import com.LR_6.GamesI.GamesI;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class SynchronizedGames implements GamesI {
    private final GamesI gamesI;

    public SynchronizedGames(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    public synchronized String getTitle() {
        return this.gamesI.getTitle();
    }

    public synchronized void setTitle(String title) {
        this.gamesI.setTitle(title);
    }

    public synchronized int getAmountOfGames() {
        return this.gamesI.getAmountOfGames();
    }

    public synchronized String getGames(int num) {
        return this.gamesI.getGames(num);
    }

    public synchronized void setGames(int index, String game) {
        this.gamesI.setGames(index, game);
    }

    public synchronized int getAmountOfMissionsInPrologue() {
        return this.gamesI.getAmountOfMissionsInPrologue();
    }

    public synchronized void setAmountOfMissionsInPrologue(int num) {
        this.gamesI.setAmountOfMissionsInPrologue(num);
    }

    public synchronized int getAmountOfMissionsInGame(int index) {
        return this.gamesI.getAmountOfMissionsInGame(index);
    }

    public synchronized int getAmountOfMissions() {
        return this.gamesI.getAmountOfMissions();
    }

    public synchronized void setAmountOfMissionsInGame(int index, int num) {
        this.gamesI.setAmountOfMissionsInGame(index, num);
    }

    public synchronized int getAmountOfMissionsWithoutPrologue() throws AmountOfMissionsException {
        return this.gamesI.getAmountOfMissionsWithoutPrologue();
    }

    public synchronized void output(OutputStream out) {
        this.gamesI.output(out);
    }

    public synchronized void write(Writer out) {
        this.gamesI.write(out);
    }

    @Override
    public Iterator<Integer> iterator() {return gamesI.iterator(); }
}