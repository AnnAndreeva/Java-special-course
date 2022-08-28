package com.LR_6;

import com.LR_6.Factories.GamesIFactory;
import com.LR_6.Factories.GamesSeriesFactory;
import com.LR_6.GamesI.GamesI;
import com.LR_6.GamesI.SynchronizedGames;
import com.LR_6.GamesI.UnmodifiableGamesI;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class InputOutputGamesDB {
    public InputOutputGamesDB() {
    }

    public static GamesI[] getSynchronizedGamesI(GamesI[] db) {
        for(int i = 0; i < db.length; ++i) {
            db[i] = new SynchronizedGames(db[i]);
        }
        return db;
    }

    public static GamesI[] getUnmodifiableGamesI(GamesI[] db) {
        for(int i = 0; i < db.length; ++i) {
            db[i] = new UnmodifiableGamesI(db[i]);
        }
        return db;
    }

    public static void outputGamesIDB(GamesI[] db, OutputStream out) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        outputLengthOfGamesIDB(db, bufferedOutputStream);
        GamesI[] var3 = db;
        int var4 = db.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            GamesI o = var3[var5];
            o.output(out);
        }

    }

    public static void outputLengthOfGamesIDB(GamesI[] db, BufferedOutputStream bufferedOutputStream) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
            dataOutputStream.writeInt(db.length);
            dataOutputStream.flush();
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
        }

    }

    public static int getLengthOfGamesIDBBytes(InputStream in) {
        int length = -1;

        try {
            DataInputStream dataInputStream = new DataInputStream(in);
            length = dataInputStream.readInt();
            if (length == -1) {
                throw new IOException("Не удалось считать длину из байтового потока");
            }
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
        }

        return length;
    }

    public static GamesI[] inputGamesIDB(InputStream in) {
        int length = getLengthOfGamesIDBBytes(in);
        GamesI[] db = new GamesI[length];
        new DataInputStream(in);

        for(int i = 0; i < length; ++i) {
            db[i] = InputOutputGames.inputGamesI(in);
        }

        return db;
    }

    public static void writeGamesIDB(GamesI[] db, Writer out) {
        BufferedWriter bufferedWriter = new BufferedWriter(out);
        writeLengthGamesIDBText(db, bufferedWriter);
        GamesI[] var3 = db;
        int var4 = db.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            GamesI o = var3[var5];
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
        } catch (NumberFormatException | IOException var3) {
            System.out.println(var3.getMessage());
        }

        return length;
    }

    public static GamesI[] readGamesIDB(Reader in) {
        BufferedReader bufferedReader = new BufferedReader(in);
        int length = getLenOfSerArrFromText(bufferedReader);
        GamesI[] db = new GamesI[length];

        for(int i = 0; i < length; ++i) {
            db[i] = InputOutputGames.readGamesI(bufferedReader);
        }

        return db;
    }

    public static void serializeGamesIDB(GamesI[] db, OutputStream out) {
        try {
            ObjectOutputStream serializer = new ObjectOutputStream(out);
            serializer.writeObject(db);
            serializer.flush();
        } catch (IOException var4) {
            System.out.println(var4.getMessage());
        }

    }

    public static GamesI[] deserializeGamesIDB(InputStream in) {
        GamesI[] db;
        try {
            ObjectInputStream deserializer = new ObjectInputStream(in);
            db = (GamesI[])deserializer.readObject();
        } catch (ClassNotFoundException | IOException var4) {
            System.out.println(var4.getMessage());
            db = null;
        }

        return db;
    }

}
