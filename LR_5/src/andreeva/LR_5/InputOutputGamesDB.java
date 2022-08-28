package andreeva.LR_5;

import java.io.*;

import static andreeva.LR_5.InputOutputGames.inputGamesI;
import static andreeva.LR_5.InputOutputGames.readGamesI;

public class InputOutputGamesDB {
    public static void outputGamesIDB(GamesI[] db, OutputStream out) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        outputLengthOfGamesIDB(db, bufferedOutputStream);
        for (GamesI o : db) {
            o.output(out);
        }
    }

    public static void outputLengthOfGamesIDB(GamesI[] db, BufferedOutputStream bufferedOutputStream) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(bufferedOutputStream);
            dataOutputStream.writeInt(db.length);
            dataOutputStream.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static int getLengthOfGamesIDBBytes(InputStream in) {
        int length = -1;
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(in);
            length = dataInputStream.readInt();
            if (length == -1) {
                throw new IOException("Не удалось считать длину из байтового потока");
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return length;
    }

    public static GamesI[] inputGamesIDB(InputStream in) {
        final int length = getLengthOfGamesIDBBytes(in);
        GamesI[] db = new GamesI[length];
        DataInputStream inputStream = new DataInputStream(in);
        for (int i = 0; i < length; ++i) {
            db[i] = inputGamesI(in);
        }
        return db;
    }

    public static void writeGamesIDB(GamesI[] db, Writer out) {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        writeLengthGamesIDBText(db, bufferedWriter);
        for (GamesI o : db) {
            o.write(out);
        }
    }
    private static void writeLengthGamesIDBText(GamesI[] db, BufferedWriter bufferedWriter) {
        PrintWriter printer = new PrintWriter(bufferedWriter);
        printer.println(db.length);
        printer.flush();
    }

    private static int getLenOfSerArrFromText(BufferedReader bufferedReader) {
        int length = -1;
        try {
            length = Integer.parseInt(bufferedReader.readLine());
            if (length == -1) {
                throw new IOException("Не удалось считать длину из текстового потока");
            }
        } catch (IOException | NumberFormatException exc) {
            System.out.println(exc.getMessage());
        }
        return length;
    }

    public static GamesI[] readGamesIDB(Reader in) {
        BufferedReader bufferedReader = new BufferedReader(in);
        final int length = getLenOfSerArrFromText(bufferedReader);
        GamesI[] db = new GamesI[length];
        for (int i = 0; i < length; i++) {
            db[i] = readGamesI(bufferedReader);
        }
        return db;
    }

    public static void serializeGamesIDB(GamesI[] db, OutputStream out){
        ObjectOutputStream serializer;
        try {
            serializer = new ObjectOutputStream(out);
            serializer.writeObject(db);
            serializer.flush();
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static GamesI[] deserializeGamesIDB(InputStream in){
        GamesI[] db;
        ObjectInputStream deserializer;
        try {
            deserializer = new ObjectInputStream(in);
            db = (GamesI[]) deserializer.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            System.out.println(exc.getMessage());
            db = null;
        }
        return db;
    }

    public static GamesI[] getSynchronizedGamesI(GamesI[] db) {
        for(int i=0; i<db.length; i++){
            db[i] = new SynchronizedGames(db[i]);
        }
        return db;
    }
}

