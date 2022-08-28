package com.LR_6.GamesI;

import com.LR_6.Exceptions.AmountOfMissionsException;

import java.io.OutputStream;
import java.io.Writer;

public interface GamesI  extends Iterable<Integer>{
    String getTitle();

    void setTitle(String var1);

    String getGames(int var1);

    int getAmountOfGames();

    void setGames(int var1, String var2);

    int getAmountOfMissionsInPrologue();

    void setAmountOfMissionsInPrologue(int var1);

    int getAmountOfMissionsInGame(int var1);

    int getAmountOfMissions();

    void setAmountOfMissionsInGame(int var1, int var2);

    int getAmountOfMissionsWithoutPrologue() throws AmountOfMissionsException;

    void output(OutputStream var1);

    void write(Writer var1);
}
