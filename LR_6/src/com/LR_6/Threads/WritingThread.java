package com.LR_6.Threads;

import com.LR_6.GamesI.GamesI;

import java.util.Random;

public class WritingThread extends Thread {
    private GamesI gamesI;

    public WritingThread(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    public void run() {
        if (this.gamesI == null) {
            System.out.println("Объекта не существует");
        } else {
            for(int index = 0; index < this.gamesI.getAmountOfGames(); ++index) {
                Random rand = new Random();
                int amountOfMissionsInGame = 3 + rand.nextInt(28);
                this.gamesI.setAmountOfMissionsInGame(index, amountOfMissionsInGame);
                System.out.println("WRITE " + amountOfMissionsInGame + " to   position " + index);
            }

        }
    }
}