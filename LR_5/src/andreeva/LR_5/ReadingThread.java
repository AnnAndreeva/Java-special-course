package andreeva.LR_5;

public class ReadingThread extends Thread{
    private GamesI gamesI;

    public ReadingThread(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    @Override
    public void run() {
        if (gamesI == null) {
            System.out.println("Объекта не существует");
            return;
        }

        for (int index = 0; index < gamesI.getAmountOfGames(); index++) {
            System.out.println("READ  " + gamesI.getAmountOfMissionsInGame(index) + " from position " + index);
        }
    }
}
