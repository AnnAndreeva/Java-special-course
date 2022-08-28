package com.LR_6.GamesI;

import com.LR_6.Exceptions.AmountOfMissionsException;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class UnmodifiableGamesI implements GamesI{
    private final GamesI gamesI;

    public UnmodifiableGamesI(GamesI gamesI) {

        this.gamesI = gamesI;
    }

    public String getTitle() {
        return this.gamesI.getTitle();
    }

    public  void setTitle(String title) {
        throw new UnsupportedOperationException("Неподдерживаемая операция: невозможно изменить название");
    }

    public  int getAmountOfGames() {
        return this.gamesI.getAmountOfGames();
    }

    public  String getGames(int num) {
        return this.gamesI.getGames(num);
    }

    public void setGames(int index, String game) {
        throw new UnsupportedOperationException("Неподдерживаемая операция: невозможно изменить игру");
    }

    public int getAmountOfMissionsInPrologue() {
        return this.gamesI.getAmountOfMissionsInPrologue();
    }

    public void setAmountOfMissionsInPrologue(int num) {
        throw new UnsupportedOperationException("Неподдерживаемая операция: невозможно изменить количество миссий в прологе");
    }

    public int getAmountOfMissionsInGame(int index) {
        return this.gamesI.getAmountOfMissionsInGame(index);
    }

    public int getAmountOfMissions() {
        return this.gamesI.getAmountOfMissions();
    }

    public void setAmountOfMissionsInGame(int index, int num) {
        throw new UnsupportedOperationException("Неподдерживаемая операция: невозможно изменить количество миссий");
    }

    public int getAmountOfMissionsWithoutPrologue() throws AmountOfMissionsException {
        return this.gamesI.getAmountOfMissionsWithoutPrologue();
    }

    public void output(OutputStream out) {
        this.gamesI.output(out);
    }

    public void write(Writer out) {
        this.gamesI.write(out);
    }

    @Override
    public Iterator<Integer> iterator() {return gamesI.iterator(); }
}
