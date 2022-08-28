package com.LR_6.Factories;

import com.LR_6.GamesI.GamesI;

public interface GamesIFactory {
    GamesI createInstance();

    GamesI createInstance(String title, int amountOfGames, int amountOfMissionsInPrologue);
}
