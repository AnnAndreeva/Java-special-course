package com.LR_6.Threads;

import com.LR_6.GamesI.GamesI;

public class GamesSynchronizer {
    private final GamesI gamesI;
    private volatile int currIndex = 0;
    private volatile boolean isSet = false;

    public GamesSynchronizer(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    public void write(int val) throws InterruptedException {
        synchronized(this.gamesI) {
            if (!this.canWrite()) {
                throw new InterruptedException();
            } else {
                while(this.isSet) {
                    this.gamesI.wait();
                }

                this.gamesI.setAmountOfMissionsInGame(this.currIndex, val);
                this.isSet = true;
                System.out.println("WRITE " + val + " to   position " + this.currIndex);
                this.gamesI.notifyAll();
            }
        }
    }

    private boolean canWrite() {
        return !this.isSet && this.currIndex < this.gamesI.getAmountOfGames() || this.isSet && this.currIndex < this.gamesI.getAmountOfGames() - 1;
    }

    public void read() throws InterruptedException {
        synchronized(this.gamesI) {
            if (!this.canRead()) {
                throw new InterruptedException();
            } else {
                while(!this.isSet) {
                    this.gamesI.wait();
                }

                int val = this.gamesI.getAmountOfMissionsInGame(this.currIndex);
                this.isSet = false;
                System.out.println("READ  " + val + " from position " + this.currIndex);
                ++this.currIndex;
                this.gamesI.notifyAll();
            }
        }
    }

    private boolean canRead() {
        return this.currIndex < this.gamesI.getAmountOfGames();
    }

    public int getSynchNumOfGames() {
        return this.gamesI.getAmountOfGames();
    }
}
