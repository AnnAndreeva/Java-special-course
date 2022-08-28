package andreeva.LR_5;

import java.io.OutputStream;
import java.io.Writer;

public class SynchronizedGames implements GamesI{
    private final GamesI gamesI;

    public SynchronizedGames(GamesI gamesI) {
        this.gamesI = gamesI;
    }

    @Override
    public synchronized String getTitle() {
        return gamesI.getTitle();
    }

    @Override
    public synchronized void setTitle(String title) {
        gamesI.setTitle(title);
    }

    @Override
    public synchronized int getAmountOfGames() {
        return gamesI.getAmountOfGames();
    }

    @Override
    public synchronized String getGames(int num){
        return gamesI.getGames(num);
    }

    @Override
    public synchronized void setGames(int index, String game){
        gamesI.setGames(index, game);
    }

    @Override
    public synchronized int getAmountOfMissionsInPrologue() {
        return gamesI.getAmountOfMissionsInPrologue();
    }

    @Override
    public synchronized void setAmountOfMissionsInPrologue(int num) {
        gamesI.setAmountOfMissionsInPrologue(num);
    }

    @Override
    public synchronized int getAmountOfMissionsInGame(int index) {
        return gamesI.getAmountOfMissionsInGame(index);
    }

    @Override
    public synchronized int  getAmountOfMissions() {
        return gamesI.getAmountOfMissions();
    }

    @Override
    public synchronized void setAmountOfMissionsInGame(int index, int num) {
        gamesI.setAmountOfMissionsInGame(index, num);
    }

    @Override
    public synchronized int getAmountOfMissionsWithoutPrologue() throws AmountOfMissionsException {
       return gamesI.getAmountOfMissionsWithoutPrologue();
    }

    @Override
    public synchronized void output(OutputStream out) {
        gamesI.output(out);
    }

    @Override
    public synchronized void write(Writer out) {
        gamesI.write(out);
    }
}
