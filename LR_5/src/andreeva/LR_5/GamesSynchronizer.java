package andreeva.LR_5;

public class GamesSynchronizer {
    private final GamesI gamesI;
    private volatile int currIndex = 0;
    private volatile boolean isSet = false;

    public GamesSynchronizer(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    void write(int val) throws InterruptedException {
        synchronized (gamesI) {
            if (!canWrite()) {
                throw new InterruptedException();
            }
            while (isSet) {
                gamesI.wait();
            }

            gamesI.setAmountOfMissionsInGame(currIndex, val);
            isSet = true;
            System.out.println("WRITE " + val + " to   position " + currIndex);

            gamesI.notifyAll();
        }
    }

    private boolean canWrite() {
        return (!isSet && currIndex < gamesI.getAmountOfGames() || (isSet && currIndex < gamesI.getAmountOfGames() - 1));
    }

    void read() throws InterruptedException {
        int val;
        synchronized (gamesI) {
            if (!canRead()) {
                throw new InterruptedException();
            }
            while (!isSet) {
                gamesI.wait();
            }

            val = gamesI.getAmountOfMissionsInGame(currIndex);
            isSet = false;
            System.out.println("READ  " + val + " from position " + currIndex);
            currIndex++;

            gamesI.notifyAll();
        }
    }

    private boolean canRead() {
        return currIndex < gamesI.getAmountOfGames();
    }

    int getSynchNumOfGames() {
        return gamesI.getAmountOfGames();
    }
}
