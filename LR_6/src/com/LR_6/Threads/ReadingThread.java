package com.LR_6.Threads;

import com.LR_6.GamesI.GamesI;

import java.io.PrintStream;

public class ReadingThread extends Thread {
    private GamesI gamesI;

    public ReadingThread(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    public void run() {
        if (this.gamesI == null) {
            System.out.println("Объекта не существует");
        } else {
            for(int index = 0; index < this.gamesI.getAmountOfGames(); ++index) {
                PrintStream var10000 = System.out;
                int var10001 = this.gamesI.getAmountOfMissionsInGame(index);
                var10000.println("READ  " + var10001 + " from position " + index);
            }

        }
    }
}
