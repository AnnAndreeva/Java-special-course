package andreeva.LR_4;
import java.io.*;

public class GamesCollection implements GamesI, Serializable{
    private String titleOfGamesCollection;
    private String[] gamesInCollection;
    private int[] amountOfMissionsInGame;
    private int amountOfMissionsInPrologue;

    public GamesCollection() {
        this.titleOfGamesCollection = "Название отсутствует";
        this.gamesInCollection = new String[1];
        this.amountOfMissionsInGame = new int[this.gamesInCollection.length];
        this.amountOfMissionsInPrologue = 1;
    }

    public GamesCollection(String titleOfGamesCollection, int amountOfGames, int amountOfMissionsInPrologue) {
        this.titleOfGamesCollection = titleOfGamesCollection;
        this.gamesInCollection = new String[amountOfGames];
        this.amountOfMissionsInGame = new int[this.gamesInCollection.length];
        this.amountOfMissionsInPrologue = amountOfMissionsInPrologue;
    }

    public String getTitle() {
        return this.titleOfGamesCollection;
    }

    public void setTitle(String title) {
        this.titleOfGamesCollection = title;
    }

    public String getGames(int i) {
        return this.gamesInCollection[i];
    }

    public int getAmountOfGames() {
        return this.gamesInCollection.length;
    }

    public void setGames(int i, String game) {
        this.gamesInCollection[i] = game;
    }

    public int getAmountOfMissionsInPrologue() {
        return this.amountOfMissionsInPrologue;
    }

    public void setAmountOfMissionsInPrologue(int amountOfMissionsInPrologue) {
        this.amountOfMissionsInPrologue = amountOfMissionsInPrologue;
    }

    public int getAmountOfMissionsInGame(int i) {
        return this.amountOfMissionsInGame[i];
    }

    public int getAmountOfMissions() {
        return this.amountOfMissionsInGame.length;
    }

    public void setAmountOfMissionsInGame(int i, int amountOfMissionsInGame) {
        this.amountOfMissionsInGame[i] = amountOfMissionsInGame;
    }

    public int getAmountOfMissionsWithoutPrologue() throws AmountOfMissionsException {
        int sum = 0;

        for(int i = 0; i < this.amountOfMissionsInGame.length; ++i) {
            if (this.amountOfMissionsInGame[i] < this.amountOfMissionsInPrologue) {
                throw new AmountOfMissionsException("Ошибка в списке количества миссий. Общее количества миссий не может быть меньше количества миссий в прологе");
            }

            sum += this.amountOfMissionsInGame[i];
        }

        return sum - this.amountOfMissionsInPrologue * this.amountOfMissionsInGame.length;
    }

    public void output(OutputStream out){
        DataOutputStream outputStream = new DataOutputStream(out);
        try {
            outputStream.writeUTF(getClass().getName());
            outputStream.writeUTF(titleOfGamesCollection);
            outputStream.writeInt(gamesInCollection.length);
            outputStream.writeInt(amountOfMissionsInPrologue);

            for (int i = 0; i < gamesInCollection.length; i++) {
                outputStream.writeUTF(gamesInCollection[i]);
                outputStream.writeInt(amountOfMissionsInGame[i]);
            }
            outputStream.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void write(Writer out){
        PrintWriter printWriter = new PrintWriter(out);

        printWriter.println(getClass().getName());
        printWriter.println(titleOfGamesCollection);
        printWriter.println(gamesInCollection.length);
        printWriter.println(amountOfMissionsInPrologue);

        for (int i = 0; i < gamesInCollection.length; i++) {
            printWriter.println(gamesInCollection[i]);
            printWriter.println(amountOfMissionsInGame[i]);
        }
        printWriter.flush();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Название сборника игр: ").append(this.titleOfGamesCollection).append('\n');
        stringBuilder.append("Количество игр в сборнике: ").append(this.gamesInCollection.length).append('\n');

        try {
            stringBuilder.append("Общее количество миссий без учета миссий в прологе: ").append(this.getAmountOfMissionsWithoutPrologue()).append('\n');
            stringBuilder.append("Количество миссий в прологе игры: ").append(this.amountOfMissionsInPrologue).append('\n');
            stringBuilder.append("Информация об играх:\n");

            for(int i = 0; i < this.gamesInCollection.length; ++i) {
                stringBuilder.append(i).append(") Название: ").append(this.gamesInCollection[i]).append(". Количество миссий: ").append(this.amountOfMissionsInGame[i]).append(".").append("\n");
            }
        } catch (AmountOfMissionsException var3) {
            stringBuilder.append(var3.getMessage()).append('\n');
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == this.getClass()) {
            GamesCollection newGamesCollection = (GamesCollection)o;
            boolean equals = false;
            if (!this.titleOfGamesCollection.equals(newGamesCollection.getTitle())) {
                return false;
            } else if (this.amountOfMissionsInPrologue != newGamesCollection.getAmountOfMissionsInPrologue()) {
                return false;
            } else {
                int i;
                for(i = 0; this.gamesInCollection[i].equals(newGamesCollection.getGames(i)); ++i) {
                }

                if (i != this.gamesInCollection.length) {
                    return false;
                } else {
                    int k;
                    for(k = 0; this.amountOfMissionsInGame[k] == newGamesCollection.getAmountOfMissionsInGame(k); ++k) {
                    }
                    if (k == this.amountOfMissionsInGame.length) {
                        equals = true;
                    }
                    return equals;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}