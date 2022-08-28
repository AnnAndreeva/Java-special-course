package andreeva.LR_5;

public class ReadingRunnableThread implements Runnable{
    private GamesSynchronizer gamesSynchronizer;

    public ReadingRunnableThread(GamesSynchronizer gamesSynchronizer) {
        this.gamesSynchronizer = gamesSynchronizer;
    }

    @Override
    public void run() {
        try {
            for (int index = 0; index < gamesSynchronizer.getSynchNumOfGames(); index++) {
                gamesSynchronizer.read();
            }
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
