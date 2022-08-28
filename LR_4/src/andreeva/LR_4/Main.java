package andreeva.LR_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static andreeva.LR_4.InputOutputGamesDB.*;

public class Main {
    public static void main(String[] args) {
        GamesI[] db = null;

        Scanner scan = new Scanner(System.in);
        String menu, str;
        int length;

        String byteFile = "byteGamesI.byte";
        String textFile = "textGamesI.txt";
        String serializableFile = "serializableGames.bin";

        do {
            System.out.print("ЛР №4 Андреева 6413\n Меню\n\n" +
                    "1) создать базу\n" +
                    "2) задание элемента базы\n" +
                    "3) создать и заполнить базу автоматически\n" +
                    "4) вывести полную информацию базы\n" +
                    "5) найти в базе объекты, функциональный метод которых возвращает одинаковый результат,\n" +
                    "   поместить такие объекты в другой массив\n" +
                    "6) разбить исходный массив на два массива, в которых будут храниться однотипные элементы\n\n" +
                    "7) записать базу в байтовый поток\n" +
                    "8) считать базу из байтового потока\n\n" +
                    "9) записать базу в символьный поток\n" +
                    "10) считать базу из текстового потока\n\n" +
                    "11) сериализовать базу\n"+
                    "12) десериализовать базу\n\n" +
                    "0) выйти\n\n" +
                    "Выберите пункт меню: ");
            menu = scan.nextLine();
            switch (menu) {
                case "1": {
                    System.out.println("1) создание базы");
                    System.out.print("Введите размера базы: ");
                    str = scan.nextLine();
                    length = Integer.parseInt(str);
                    if (length <= 0) {
                        System.out.print("Размер базы должен быть больше 0. По умолчанию будет создана база из 5 элементов.\n");
                        length = 5;
                    }

                    db = new GamesI[length];
                    System.out.print("База данных создана.\n");

                    break;
                }

                case "2": {
                    System.out.println("2) Задание элемента базы");
                    System.out.print("База данных: ");
                    if (db == null) {
                        System.out.println("Не существует.\n");
                    } else {
                        System.out.println("Введите индекс элемента, который хотите изменить(нумерация начинается с нуля):\n");
                        str = scan.nextLine();
                        int index = Integer.parseInt(str);

                        System.out.print("Задайте элемент с индексом " + index + "\n: ");
                        do {
                            System.out.print("Выберите тип элемента:\n" +
                                    "1. GamesSeries - Серия игр\n" +
                                    "2. GamesCollection - Сборник игр\n" +
                                    "Введите номер типа элемента: ");
                            str = scan.nextLine();
                            System.out.println();
                            if (str.equals("1")) { //создание серии книг
                                System.out.print("Введите название серии: ");
                                String title = scan.nextLine();
                                System.out.print("Введите количество игр в серии: ");
                                str = scan.nextLine();
                                int amountGamesInSeries = Integer.parseInt(str);
                                if (amountGamesInSeries <= 0) {
                                    System.out.print("Количество игр в серии должно быть больше 0. По умолчанию количество игр будет 1.\n");
                                    amountGamesInSeries = 1;
                                }
                                System.out.print("Введите количество миссий в прологе каждой игры серии: ");
                                str = scan.nextLine();
                                int amountOfMissionsInPrologue = Integer.parseInt(str);
                                if (amountOfMissionsInPrologue <= 0) {
                                    System.out.print("Количество миссий в прологе каждой игры серии должно быть больше 0. По умолчанию количество миссий будет 1.\n");
                                    amountOfMissionsInPrologue = 1;
                                }
                                db[index] = new GamesSeries(title, amountGamesInSeries, amountOfMissionsInPrologue);
                                System.out.println("Серия игр успешно создана.");
                                System.out.print("Заполните серию игр названиями игр и их количеством миссий.\n");
                                for (int i = 0; i < db[index].getAmountOfGames(); i++) {
                                    System.out.print("Игра с индексом  " + "[" + i + "]" + '\n');
                                    System.out.print("Введите название: ");
                                    String gameTitle = scan.nextLine();
                                    db[index].setGames(index, gameTitle);

                                    System.out.print("Введите количество миссий: ");
                                    str = scan.nextLine();
                                    int amountOfMissions = Integer.parseInt(str);
                                    if (amountOfMissions <= 1) {
                                        System.out.print("Количество миссий в игре  должно быть больше 1. По умолчанию количество миссий будет 2.\n");
                                        amountOfMissions = 2;
                                    }
                                    db[index].setAmountOfMissionsInGame(index, amountOfMissions);
                                }
                                break;
                            } else if (str.equals("2")) {//создание сборника книг
                                System.out.print("Введите название сборника: ");
                                String title = scan.nextLine();
                                System.out.print("Введите количество игр в сборнике: ");
                                str = scan.nextLine();
                                int amountGamesInCollection = Integer.parseInt(str);
                                if (amountGamesInCollection <= 0) {
                                    System.out.print("Количество игр в сборнике должно быть больше 0. По умолчанию количество игр будет 1.\n");
                                    amountGamesInCollection = 1;
                                }
                                System.out.print("Введите количество миссий в прологе каждой игры сборника: ");
                                str = scan.nextLine();
                                int amountOfMissionsInPrologue = Integer.parseInt(str);
                                if (amountOfMissionsInPrologue <= 0) {
                                    System.out.print("Количество миссий в прологе каждой игры должно быть больше 0. По умолчанию количество миссий будет 1.\n");
                                    amountOfMissionsInPrologue = 1;
                                }
                                db[index] = new GamesCollection(title, amountGamesInCollection, amountOfMissionsInPrologue);
                                System.out.println("Сборник игр успешно создан.");
                                System.out.print("Заполните сборник игр названиями игр и их количеством миссий.\n");
                                for (int i = 0; i < db[index].getAmountOfGames(); i++) {
                                    System.out.print("Игра с индексом  " + "[" + i + "]" + '\n');
                                    System.out.print("Введите название: ");
                                    String gameTitle = scan.nextLine();
                                    db[index].setGames(index, gameTitle);

                                    System.out.print("Введите количество миссий: ");
                                    str = scan.nextLine();
                                    int amountOfMissions = Integer.parseInt(str);
                                    if (amountOfMissions <= 1) {
                                        System.out.print("Количество миссий в игре  должно быть больше 1. По умолчанию количество миссий будет 2.\n");
                                        amountOfMissions = 2;
                                    }
                                    db[index].setAmountOfMissionsInGame(index, amountOfMissions);
                                }
                                break;
                            } else {
                                System.out.println("Выбран неверный пункт меню");
                            }
                        } while (true);
                        //вывод
                        for (int i = 0; i < db.length; i++) {
                            System.out.print("[" + i + "] ");
                            if (db[i] == null) {
                                System.out.println("Элемент не задан");
                            } else {
                                System.out.println('-' + db[i].getTitle() + '-');
                            }
                        }
                    }
                    System.out.println();
                    break;
                }

                case "3": {
                    System.out.println("3)  Создание и заполнение базы автоматически");
                    db = createAndFillDbAutomatically();
                    System.out.println("База создана и заполнена автоматически.");
                    break;
                }

                case "4": {
                    System.out.println("4) Вывод полной информацию базы");
                    System.out.print("База данных: ");
                    if (db == null) {
                        System.out.println("Не существует.\n");
                    } else {
                        System.out.println();
                        for (int i = 0; i < db.length; i++) {
                            System.out.print("[" + i + "] ");
                            if (db[i] == null) {
                                System.out.println("Элемента не существует");
                            } else {
                                System.out.println('-' + db[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(db[i]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                }

                case "5": {
                    System.out.println("5) найти в базе объекты, функциональный метод которых возвращает одинаковый результат,\n" +
                            "   поместить такие объекты в другой массив\n");

                    if (db == null) {
                        System.out.print("База данных не существует ");
                    } else {
                        int amountOfCollectionWithSameMissionsAmount = 0;
                        for (int i = 0; i < db.length; i++) {
                            for (int j = i + 1; j < db.length; j++) {
                                try {
                                    if (db[i].getAmountOfMissionsWithoutPrologue() == db[j].getAmountOfMissionsWithoutPrologue()) {
                                        amountOfCollectionWithSameMissionsAmount++;
                                    }
                                } catch (AmountOfMissionsException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (amountOfCollectionWithSameMissionsAmount > 0) {
                            ArrayList<ArrayList<GamesI>> arrayList = new ArrayList<ArrayList<GamesI>>();
                            ArrayList<GamesI> arr = new ArrayList<GamesI>();
                            int k = 0;
                            for (int i = 0; i < db.length; i++) {
                                for (int j = i + 1; j < db.length; j++) {
                                    try {
                                        if (db[i].getAmountOfMissionsWithoutPrologue() == db[j].getAmountOfMissionsWithoutPrologue()) {
                                            if(!arr.contains(db[i])){arr.add(db[i]);}
                                            if(!arr.contains(db[j])){arr.add(db[j]);}
                                        }
                                    } catch (AmountOfMissionsException e) {
                                        e.printStackTrace();
                                    }
                                }
                                arrayList.add(arr);
                            }

                            System.out.println("База успешно разделена");
                            System.out.println("База данных: ");
                            for(int j = 0; j < arrayList.size();j++) {
                                for (int i = 0; i < arr.size(); i++) {
                                    System.out.print("[" + j + "." + i + "] ");
                                    System.out.println('-' + arrayList.get(j).get(i).getTitle() + '-');
                                    System.out.println();
                                    System.out.println(arrayList.get(j).get(i));
                                    System.out.println();
                                }
                            }
                        } else
                            System.out.println("В базе нет объектов, функциональный метод которых возвращает одинаковый результат\n");

                    }
                    break;
                }

                case "6": {
                    System.out.println("разбить исходный массив на два массива, в которых будут храниться однотипные элементы\n");
                    GamesI[] arrSeries, arrCollections;
                    if (db == null) {
                        System.out.print("База данных не существует ");
                    } else {

                        int countSeries = 0;
                        int countCollections = 0;
                        for (int i = 0; i < db.length; i++) {
                            if (db[i] instanceof GamesSeries) {
                                countSeries++;
                            }
                            if (db[i] instanceof GamesCollection) {
                                countCollections++;
                            }
                        }
                        if (countSeries > 0) {
                            arrSeries = new GamesSeries[countSeries];
                            int j = 0;
                            for (int i = 0; i < db.length; i++) {
                                if (db[i] instanceof GamesSeries && j < arrSeries.length) {
                                    arrSeries[j] = db[i];
                                    j++;
                                }
                            }
                            System.out.println("Сформирован список серий игр");
                            System.out.println("Список серий игр: ");
                            for (int i = 0; i < arrSeries.length; i++) {
                                System.out.print("[" + i + "] ");
                                System.out.println('-' + arrSeries[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(arrSeries[i]);
                                System.out.println();
                            }
                        }
                        if (countCollections > 0) {
                            arrCollections = new GamesSeries[countCollections];
                            int j = 0;
                            for (int i = 0; i < db.length; i++) {
                                if (db[i] instanceof GamesCollection && j < arrCollections.length) {
                                    arrCollections[j] = db[i];
                                    j++;
                                }
                            }
                            System.out.println("Сформирован список сборников игр");
                            System.out.println("Список сборников игр: ");
                            for (int i = 0; i < arrCollections.length; i++) {
                                System.out.print("[" + i + "] ");
                                System.out.println('-' + arrCollections[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(arrCollections[i]);
                                System.out.println();
                            }
                        }
                        System.out.println();

                    }
                    break;
                }

                case "7": {
                    System.out.println("7)  записать базу в байтовый поток");
                    if (db == null) {
                        System.out.println("База не задана");
                    } else {
                        FileOutputStream fileOutputStream;
                        try {
                            fileOutputStream = new FileOutputStream(byteFile);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            outputLengthOfGamesIDB(db, bufferedOutputStream);
                            for (GamesI o : db) {
                                o.output(fileOutputStream);
                            }
                            outputGamesIDB(db, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();

                            System.out.println("База успешно записана в байтовый поток");
                        } catch (IOException exc) {
                            System.out.println(exc.getMessage());
                        }
                    }
                    break;
                }
                case "8": {
                    System.out.println("8) считать базу из байтового потока");
                    GamesI[] sDb = null;
                    FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(byteFile);
                        sDb = inputGamesIDB(fileInputStream);
                        fileInputStream.close();

                        System.out.println("База успешно считана из байтового потока");
                    } catch ( IOException exc) {
                        System.out.println(exc.getMessage());
                    }
                    if (sDb == null) {
                        System.out.println("Не существует.\n");
                    } else {
                        System.out.println();
                        for (int i = 0; i < sDb.length; i++) {
                            System.out.print("[" + i + "] ");
                            if (sDb[i] == null) {
                                System.out.println("Элемента не существует");
                            } else {
                                System.out.println('-' + sDb[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(sDb[i]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                }
                case "9": {
                    System.out.println("9) записать базу в символьный поток");
                    if (db == null) {
                        System.out.println("База не задана");
                    } else {
                        FileWriter fileWriter;
                        try {
                            fileWriter = new FileWriter(textFile);
                            writeGamesIDB(db, fileWriter);
                            fileWriter.flush();
                            fileWriter.close();

                            System.out.println("База успешно записана в текстовый поток");
                        } catch (IOException exc) {
                            System.out.println(exc.getMessage());
                        }
                    }
                    break;
                }
                case "10": {
                    System.out.println("10) считать базу из текстового потока");
                    GamesI[] sDb = null;
                    FileReader fileReader;
                    try {
                        fileReader = new FileReader(textFile);
                        sDb = readGamesIDB(fileReader);
                        fileReader.close();

                        System.out.println("База успешно считана из текстового потока");
                    } catch (IOException exc) {
                        System.out.println(exc.getMessage());
                    }
                    if (sDb == null) {
                        System.out.println("Не существует.\n");
                    } else {
                        System.out.println();
                        for (int i = 0; i < sDb.length; i++) {
                            System.out.print("[" + i + "] ");
                            if (sDb[i] == null) {
                                System.out.println("Элемента не существует");
                            } else {
                                System.out.println('-' + sDb[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(sDb[i]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                }
                case "11": {
                    System.out.println("11) сериализовать базу");
                    if (db == null) {
                        System.out.println("операция невозможна: массив не задан");
                    } else {
                        FileOutputStream fileOutputStream;
                        try {
                            fileOutputStream = new FileOutputStream(serializableFile);
                            serializeGamesIDB(db, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();

                            System.out.println("База успешно сериализована");
                        } catch (IOException exc) {
                            System.out.println(exc.getMessage());
                        }
                    }
                    System.out.println("База создана и заполнена автоматически.");
                    break;
                }
                case "12": {
                    System.out.println("12) десериализовать базу");
                    GamesI[] sDb = null;

                    FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(serializableFile);
                        sDb = deserializeGamesIDB(fileInputStream);
                        fileInputStream.close();

                        System.out.println("База успешно десериализована");
                    } catch (IOException exc) {
                        System.out.println(exc.getMessage());
                    }
                    System.out.print("Десериализованная база данных: ");
                    if (sDb == null) {
                        System.out.println("Не существует.\n");
                    } else {
                        System.out.println();
                        for (int i = 0; i < sDb.length; i++) {
                            System.out.print("[" + i + "] ");
                            if (sDb[i] == null) {
                                System.out.println("Элемента не существует");
                            } else {
                                System.out.println('-' + sDb[i].getTitle() + '-');
                                System.out.println();
                                System.out.println(sDb[i]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Выбран неверный пункт меню");
                    break;
            }
            System.out.println();
        } while (!menu.equals("0"));
    }

    public static GamesI[] createAndFillDbAutomatically() {
        int length = 5;
        GamesI[] autoDb = new GamesI[length];
        autoDb[0] = new GamesCollection("Сборник лучших игр 2000-2010", 3, 3);
        autoDb[0].setGames(0, "Half-life 2");
        autoDb[0].setAmountOfMissionsInGame(0, 21);
        autoDb[0].setGames(1, "Oblivion");
        autoDb[0].setAmountOfMissionsInGame(1, 17);
        autoDb[0].setGames(2, "Assasins Creed 2");
        autoDb[0].setAmountOfMissionsInGame(2, 20);

        autoDb[1] = new GamesSeries("Gothic Series", 4, 2);
        autoDb[1].setGames(0, "Gothic");
        autoDb[1].setAmountOfMissionsInGame(0, 11);
        autoDb[1].setGames(1, "Gothic 2");
        autoDb[1].setAmountOfMissionsInGame(1, 14);
        autoDb[1].setGames(2, "Gothic 3");
        autoDb[1].setAmountOfMissionsInGame(2, 15);
        autoDb[1].setGames(3, "Arcania");
        autoDb[1].setAmountOfMissionsInGame(3, 17);

        autoDb[2] = new GamesSeries("The Witcher Series", 3, 5);
        autoDb[2].setGames(0, "The Witcher");
        autoDb[2].setAmountOfMissionsInGame(0, 12);
        autoDb[2].setGames(1, "The Witcher 2");
        autoDb[2].setAmountOfMissionsInGame(1, 15);
        autoDb[2].setGames(2, "The Witcher 3");
        autoDb[2].setAmountOfMissionsInGame(2, 25);

        autoDb[3] = new GamesCollection("Сборник старых рпг с длинным прологом", 3, 5);
        autoDb[3].setGames(0, "The Witcher");
        autoDb[3].setAmountOfMissionsInGame(0, 12);
        autoDb[3].setGames(1, "TitanQuest 2");
        autoDb[3].setAmountOfMissionsInGame(1, 18);
        autoDb[3].setGames(2, "Dragon Ages: Originals");
        autoDb[3].setAmountOfMissionsInGame(2, 20);

        autoDb[4] = new GamesSeries("The Elder Scrolls Series", 3, 3);
        autoDb[4].setGames(0, "Morrowind");
        autoDb[4].setAmountOfMissionsInGame(0, 15);
        autoDb[4].setGames(1, "Oblivion");
        autoDb[4].setAmountOfMissionsInGame(1, 17);
        autoDb[4].setGames(2, "Skyrim");
        autoDb[4].setAmountOfMissionsInGame(2, 18);

        return autoDb;
    }
}
