package com.LR_6.GamesI;

import com.LR_6.AmountOfMissionsInGameIterator;
import com.LR_6.Exceptions.AmountOfMissionsException;
import com.LR_6.Exceptions.InvalidIndexException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;

public class GamesSeries implements GamesI {
    private String titleOfGamesSeries;
    private String[] gamesInSeries;
    private int[] amountOfMissionsInGame;
    private int amountOfMissionsInPrologue;

    public GamesSeries() {
        this.titleOfGamesSeries = "Название отсутствует";
        this.gamesInSeries = new String[1];
        this.amountOfMissionsInGame = new int[this.gamesInSeries.length];
        this.amountOfMissionsInPrologue = 1;
    }

    public GamesSeries(String titleOfGamesSeries, int amountOfGames, int amountOfMissionsInPrologue) {
        this.titleOfGamesSeries = titleOfGamesSeries;
        this.gamesInSeries = new String[amountOfGames];
        this.amountOfMissionsInGame = new int[this.gamesInSeries.length];
        this.amountOfMissionsInPrologue = amountOfMissionsInPrologue;
    }

    public String getTitle() {
        return this.titleOfGamesSeries;
    }

    public void setTitle(String title) {
        this.titleOfGamesSeries = title;
    }

    public String getGames(int i) {
        if (i >= 0 && i < this.gamesInSeries.length) {
            return this.gamesInSeries[i];
        } else {
            throw new InvalidIndexException("Задан неверный индекс.");
        }
    }

    public int getAmountOfGames() {
        return this.gamesInSeries.length;
    }

    public void setGames(int i, String game) {
        if (i >= 0 && i < this.gamesInSeries.length) {
            this.gamesInSeries[i] = game;
        } else {
            throw new InvalidIndexException("Задан неверный индекс.");
        }
    }

    public int getAmountOfMissionsInPrologue() {
        return this.amountOfMissionsInPrologue;
    }

    public void setAmountOfMissionsInPrologue(int amountOfMissionsInPrologue) {
        this.amountOfMissionsInPrologue = amountOfMissionsInPrologue;
    }

    public int getAmountOfMissionsInGame(int i) {
        if (i >= 0 && i < this.gamesInSeries.length) {
            return this.amountOfMissionsInGame[i];
        } else {
            throw new InvalidIndexException("Задан неверный индекс.");
        }
    }

    public int getAmountOfMissions() {
        return this.amountOfMissionsInGame.length;
    }

    public void setAmountOfMissionsInGame(int i, int amountOfMissionsInGame) {
        if (i >= 0 && i < this.gamesInSeries.length) {
            this.amountOfMissionsInGame[i] = amountOfMissionsInGame;
        } else {
            throw new InvalidIndexException("Задан неверный индекс.");
        }
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

    public void output(OutputStream out) {
        DataOutputStream outputStream = new DataOutputStream(out);

        try {
            outputStream.writeUTF(this.getClass().getName());
            outputStream.writeUTF(this.titleOfGamesSeries);
            outputStream.writeInt(this.gamesInSeries.length);
            outputStream.writeInt(this.amountOfMissionsInPrologue);

            for(int i = 0; i < this.gamesInSeries.length; ++i) {
                outputStream.writeUTF(this.gamesInSeries[i]);
                outputStream.writeInt(this.amountOfMissionsInGame[i]);
            }

            outputStream.flush();
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
        }

    }

    public void write(Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.println(this.getClass().getName());
        printWriter.println(this.titleOfGamesSeries);
        printWriter.println(this.gamesInSeries.length);
        printWriter.println(this.amountOfMissionsInPrologue);

        for(int i = 0; i < this.gamesInSeries.length; ++i) {
            printWriter.println(this.gamesInSeries[i]);
            printWriter.println(this.amountOfMissionsInGame[i]);
        }

        printWriter.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Название серии игр: ").append(this.titleOfGamesSeries).append('\n');
        stringBuilder.append("Количество игр в серии: ").append(this.gamesInSeries.length).append('\n');

        try {
            stringBuilder.append("Общее количество миссий без учета миссий в прологе: ").append(this.getAmountOfMissionsWithoutPrologue()).append('\n');
            stringBuilder.append("Количество миссий в прологе игры: ").append(this.amountOfMissionsInPrologue).append('\n');
            stringBuilder.append("Информация об играх:\n");

            for(int i = 0; i < this.gamesInSeries.length; ++i) {
                stringBuilder.append(i).append(") Название: ").append(this.gamesInSeries[i]).append(". Количество миссий: ").append(this.amountOfMissionsInGame[i]).append(".").append("\n");
            }
        } catch (AmountOfMissionsException var3) {
            stringBuilder.append(var3.getMessage()).append('\n');
        }

        return stringBuilder.toString();
    }

    public boolean equals(Object o) {
        if (o != null && o.getClass() == this.getClass()) {
            GamesSeries newGamesSeries = (GamesSeries)o;
            boolean equals = false;
            if (!this.titleOfGamesSeries.equals(newGamesSeries.getTitle())) {
                return false;
            } else if (this.amountOfMissionsInPrologue != newGamesSeries.getAmountOfMissionsInPrologue()) {
                return false;
            } else {
                int i;
                for(i = 0; this.gamesInSeries[i].equals(newGamesSeries.getGames(i)); ++i) {
                }

                if (i != this.gamesInSeries.length) {
                    return false;
                } else {
                    int k;
                    for(k = 0; this.amountOfMissionsInGame[k] == newGamesSeries.getAmountOfMissionsInGame(k); ++k) {
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

    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new AmountOfMissionsInGameIterator(this.amountOfMissionsInGame);
    }
}

