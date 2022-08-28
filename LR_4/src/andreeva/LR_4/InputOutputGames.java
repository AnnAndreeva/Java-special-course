package andreeva.LR_4;

import java.io.*;

public class InputOutputGames {
    public static void outputGamesI(GamesI o, OutputStream out) {
        o.output(out);
    }

    public static GamesI inputGamesI(InputStream in) {
        GamesI o;
        DataInputStream inputStream = new DataInputStream(in);

        try {
            String className = inputStream.readUTF();
            String title = inputStream.readUTF();
            int amountOfGames = inputStream.readInt();
            int amountOfMissionsInPrologue = inputStream.readInt();

            if (className.equals(GamesCollection.class.getName())) {
                o = new GamesCollection(title, amountOfGames, amountOfMissionsInPrologue);
            } else if (className.equals(GamesSeries.class.getName())) {
                o = new GamesSeries(title, amountOfGames, amountOfMissionsInPrologue);
            } else o = null;
            if (o != null) {
                final int len = o.getAmountOfGames();
                String game;
                int numOfPages;
                for (int i = 0; i < len; i++) {
                    game = inputStream.readUTF();
                    int amountOfMissionsInGame = inputStream.readInt();

                    o.setGames(i, game);
                    o.setAmountOfMissionsInGame(i, amountOfMissionsInGame);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
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
            while (reader.ready()) {
                String className = reader.readLine();
                String title = reader.readLine();
                int amountOfGames = Integer.parseInt(reader.readLine());
                int amountOfMissionsInPrologue = Integer.parseInt(reader.readLine());

                if (className.equals(GamesCollection.class.getName())) {
                    o = new GamesCollection(title, amountOfGames, amountOfMissionsInPrologue);
                } else if (className.equals(GamesSeries.class.getName())) {
                    o = new GamesSeries(title, amountOfGames, amountOfMissionsInPrologue);
                } else o = null;
                if (o != null) {
                    final int len = o.getAmountOfGames();
                    String game;
                    int numOfPages;
                    for (int i = 0; i < len; i++) {
                        game = reader.readLine();
                        int amountOfMissionsInGame = Integer.parseInt(reader.readLine());

                        o.setGames(i, game);
                        o.setAmountOfMissionsInGame(i, amountOfMissionsInGame);
                    }
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            o = null;
        }
        return o;
    }

    public static void serializeGamesI (GamesI o, OutputStream out){
        ObjectOutputStream serializer;
        try {
            serializer = new ObjectOutputStream(out);
            serializer.writeObject(o);
            serializer.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
    public static GamesI deserializeGamesI(InputStream in){
        GamesI o;
        ObjectInputStream deserializer;
        try {
            deserializer = new ObjectInputStream(in);
            o = (GamesI) deserializer.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
            o = null;
        }
        return o;
    }

}

