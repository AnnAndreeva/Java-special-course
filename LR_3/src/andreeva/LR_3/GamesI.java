package andreeva.LR_3;

public interface GamesI {
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
}
