package andreeva.LR_5;

import java.util.Random;

public class WritingThread extends Thread{
    private GamesI gamesI;

    public WritingThread(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    @Override
    public void run() {
        if (gamesI == null) {
            System.out.println("Объекта не существует");
            return;
        }

        int amountOfMissionsInGame;
        for (int index = 0; index < gamesI.getAmountOfGames(); index++) {
            Random rand = new Random();
            amountOfMissionsInGame = 3 + rand.nextInt(30 - 3 + 1);
            gamesI.setAmountOfMissionsInGame(index, amountOfMissionsInGame);
            System.out.println("WRITE " + amountOfMissionsInGame+ " to   position " + index);
        }
    }
}
