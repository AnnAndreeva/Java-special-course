package andreeva.LR_5;

import java.util.Random;

public class WritingRunnableThread implements Runnable{
    private GamesSynchronizer gamesSynchronizer;

    public WritingRunnableThread(GamesSynchronizer gamesSynchronizer) {
        this.gamesSynchronizer = gamesSynchronizer;
    }
    @Override
    public void run() {
        try {
            int amountOfGames;
            for (int index = 0; index < gamesSynchronizer.getSynchNumOfGames(); index++) {
                Random rand = new Random();
                amountOfGames = 3 + rand.nextInt(30 - 3 + 1);
                gamesSynchronizer.write(amountOfGames);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
