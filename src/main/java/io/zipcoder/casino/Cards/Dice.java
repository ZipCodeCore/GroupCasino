package io.zipcoder.casino.Cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dice {
    private static final HashMap<Integer, String[]> stringRepresentations= new HashMap<>();
    static {
        stringRepresentations.put(1, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503        \u2503", "\u2503   \u2B24   \u2503",
                "\u2503        \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
        stringRepresentations.put(2, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503     \u2B24 \u2503", "\u2503        \u2503",
                "\u2503 \u2B24     \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
        stringRepresentations.put(3, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503     \u2B24 \u2503", "\u2503   \u2B24   \u2503",
                "\u2503 \u2B24     \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
        stringRepresentations.put(4, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2503        \u2503",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
        stringRepresentations.put(5, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2503   \u2B24   \u2503",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
        stringRepresentations.put(6, new String[]{"\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2503 \u2B24  \u2B24 \u2503",
                "\u2503 \u2B24  \u2B24 \u2503", "\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u251B"});
    }


    public Dice() {
    }

    public int roll() {
        return (int)(Math.random()*6 + 1);
    }

//    public static String getDieString(Integer dieNumber) {
//        StringBuilder dieRepresentation = new StringBuilder();
//        for (String row: stringRepresentations.get(dieNumber)) {
//            dieRepresentation.append(row + "\n");
//        }
//        return dieRepresentation.toString();
//    }

    public static String getDiceString(Integer... diceNumbers) {
        StringBuilder allDicePrinted = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int number : diceNumbers) {
                allDicePrinted.append(stringRepresentations.get(number)[i]);
            }
            allDicePrinted.append("\n");
        }
        return allDicePrinted.toString();
    }

    public static String getDiceStringWithSpace(int... diceNumbers) {
        StringBuilder allDicePrinted = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int number : diceNumbers) {
                allDicePrinted.append(stringRepresentations.get(number)[i] + "     ");
            }
            allDicePrinted.append("\n");
        }
        return allDicePrinted.toString();
    }


}

