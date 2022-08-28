package com.LR_6;

import com.LR_6.Factories.GamesIFactory;
import com.LR_6.Factories.GamesSeriesFactory;
import com.LR_6.GamesI.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;

public class InputOutputGames {
    public InputOutputGames() {
    }

    private static GamesIFactory factory = new GamesSeriesFactory();

    public static void setGamesIFactory(GamesIFactory gamesIFactory) {
        factory = gamesIFactory;
    }

    public static GamesI createInstance() {
        return factory.createInstance();
    }

    public static GamesI createInstance(String title, int amountOfGames, int amountOfMissionsInPrologue) {
        return factory.createInstance(title, amountOfGames, amountOfMissionsInPrologue);
    }

    public static GamesI getSynchronizedGames(GamesI gamesI) {
        return new SynchronizedGames(gamesI);
    }

    public static GamesI getUnmodifiableGamesI(GamesI gamesI) {
        return new UnmodifiableGamesI(gamesI);
    }

    public static void outputGamesI(GamesI o, OutputStream out) {
        o.output(out);
    }

    public static GamesI inputGamesI(InputStream in) {
        DataInputStream inputStream = new DataInputStream(in);

        GamesI o;
        try {
            //String className = inputStream.readUTF();
            String title = inputStream.readUTF();
            int amountOfGames = inputStream.readInt();
            int amountOfMissionsInPrologue = inputStream.readInt();
            /*if (className.equals(GamesCollection.class.getName())) {
                o = new GamesCollection(title, amountOfGames, amountOfMissionsInPrologue);
            } else if (className.equals(GamesSeries.class.getName())) {
                o = new GamesSeries(title, amountOfGames, amountOfMissionsInPrologue);
            } else {
                o = null;
            }*/
            o = createInstance(title, amountOfGames, amountOfMissionsInPrologue);

            if (o != null) {
                int len = (o).getAmountOfGames();

                for(int i = 0; i < len; ++i) {
                    String game = inputStream.readUTF();
                    int amountOfMissionsInGame = inputStream.readInt();
                    (o).setGames(i, game);
                    (o).setAmountOfMissionsInGame(i, amountOfMissionsInGame);
                }
            }
        } catch (IOException var12) {
            var12.printStackTrace();
            o = null;
        }

        return o;
    }

    public static void writeGamesI(GamesI o, Writer out) {
        o.write(out);
    }

    public static GamesI readGamesI(BufferedReader reader) {
        GamesI o = null;

        try {
            while(reader.ready()) {
                //String className = reader.readLine();
                String title = reader.readLine();
                int amountOfGames = Integer.parseInt(reader.readLine());
                int amountOfMissionsInPrologue = Integer.parseInt(reader.readLine());
                /*if (className.equals(GamesCollection.class.getName())) {
                    o = new GamesCollection(title, amountOfGames, amountOfMissionsInPrologue);
                } else if (className.equals(GamesSeries.class.getName())) {
                    o = new GamesSeries(title, amountOfGames, amountOfMissionsInPrologue);
                } else {
                    o = null;
                }*/
                o = createInstance(title, amountOfGames, amountOfMissionsInPrologue);

                if (o != null) {
                    int len = (o).getAmountOfGames();

                    for(int i = 0; i < len; ++i) {
                        String game = reader.readLine();
                        int amountOfMissionsInGame = Integer.parseInt(reader.readLine());
                        (o).setGames(i, game);
                        (o).setAmountOfMissionsInGame(i, amountOfMissionsInGame);
                    }

                    return o;
                }
            }
        } catch (IOException var11) {
            var11.printStackTrace();
            o = null;
        }

        return o;
    }

    public static void serializeGamesI(GamesI o, OutputStream out) {
        try {
            ObjectOutputStream serializer = new ObjectOutputStream(out);
            serializer.writeObject(o);
            serializer.flush();
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
        }

    }

    public static GamesI deserializeGamesI(InputStream in) {
        GamesI o;
        try {
            ObjectInputStream deserializer = new ObjectInputStream(in);
            o = (GamesI)deserializer.readObject();
        } catch (ClassNotFoundException | IOException var4) {
            System.out.println(var4.getMessage());
            o = null;
        }

        return o;
    }

}
