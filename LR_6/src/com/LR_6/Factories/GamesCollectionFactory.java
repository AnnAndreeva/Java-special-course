package com.LR_6.Factories;

import com.LR_6.GamesI.GamesCollection;
import com.LR_6.GamesI.GamesI;

public class GamesCollectionFactory implements GamesIFactory {
    @Override
    public GamesI createInstance() {
        return new GamesCollection();
    }

    @Override
    public GamesI createInstance(String title, int amountOfGames, int amountOfMissionsInPrologue) {
        return new GamesCollection(title, amountOfGames, amountOfMissionsInPrologue);
    }
}
