package com.LR_6.Threads;

public class ReadingRunnableThread implements Runnable {
    private GamesSynchronizer gamesSynchronizer;

    public ReadingRunnableThread(GamesSynchronizer gamesSynchronizer) {
        this.gamesSynchronizer = gamesSynchronizer;
    }

    public void run() {
        try {
            for(int index = 0; index < this.gamesSynchronizer.getSynchNumOfGames(); ++index) {
                this.gamesSynchronizer.read();
            }
        } catch (InterruptedException var2) {
            System.out.println(var2.getMessage());
            var2.printStackTrace();
        }

    }
}
