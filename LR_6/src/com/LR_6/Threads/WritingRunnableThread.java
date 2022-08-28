package com.LR_6.Threads;

import java.util.Random;

public class WritingRunnableThread implements Runnable {
    private GamesSynchronizer gamesSynchronizer;

    public WritingRunnableThread(GamesSynchronizer gamesSynchronizer) {
        this.gamesSynchronizer = gamesSynchronizer;
    }

    public void run() {
        try {
            for(int index = 0; index < this.gamesSynchronizer.getSynchNumOfGames(); ++index) {
                Random rand = new Random();
                int amountOfGames = 3 + rand.nextInt(28);
                this.gamesSynchronizer.write(amountOfGames);
            }
        } catch (InterruptedException var4) {
            System.out.println(var4.getMessage());
            var4.printStackTrace();
        }

    }
}
