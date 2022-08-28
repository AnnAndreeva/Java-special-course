package com.LR_6.Factories;

import com.LR_6.GamesI.GamesI;
import com.LR_6.GamesI.GamesSeries;

public class GamesSeriesFactory implements GamesIFactory {
    @Override
    public GamesI createInstance() {
        return new GamesSeries();
    }

    @Override
    public GamesI createInstance(String title, int amountOfGames, int amountOfMissionsInPrologue) {
        return new GamesSeries(title, amountOfGames, amountOfMissionsInPrologue);
    }
}
