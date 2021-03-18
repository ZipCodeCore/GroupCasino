package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;

public class BeetleDisplay extends Display {

    String[][] beetle = new String[][]{{"\\","0","/"},
            {"⎛","|","⎞"},
            {"⎝","|","⎠"},
            {"/","⏝","\\"}
    };

    public BeetleDisplay() {
    }

    public void rules() {
        setPrintCurrentDisplay("Draw the beetle before your opponent and win big!\nThe rules are simple:\nEach side of the die corresponds to a part of the beetle." +
                "\nIf you roll a number, you get to draw that part.\nIf you roll the same number again, you do not get to add to your beetle." +
                "\nBetween each roll you will add to your wager.\nThe first person to draw a beetle keeps the purse." +
                "\nIf both players complete their beetle on the same set of rolls the wagers are returned." +
                "\n\nWhat to draw for each roll:" +
                "\n1 - head\n2 - body\n3 - left front leg\n4 - right front leg\n5 - left back leg\n6 - right back leg");
    }

    public void drewLeg() {
        setPrintCurrentDisplay("You added a leg to your beetle!");
    }

    public void drewBody() {
        setPrintCurrentDisplay("You drew your beetle's body!");
    }

    public void drewHead() {
        setPrintCurrentDisplay("You drew your beetle's head!");
    }

    public void yourBugIsComplete() {
        setPrintCurrentDisplay("Your beetle is complete!");
    }

    public void opponentsBugisComplete() {
        setPrintCurrentDisplay("Your opponents beetle is complete.");
    }

    public void bothBeetlesComplete() {
        setPrintCurrentDisplay("You both drew beetles. The game is a tie.");
    }

    public void repeatedRollResult() {
        setPrintCurrentDisplay("You already rolled that number.");
    }

    //Beetle Body Parts
    public void getBeetleComplete() {
        //System.out.println(Arrays.deepToString(beetle));
        /*for (String[] row : beetle) {
            System.out.println(Arrays.deepToString(row));*/
        for (int i = 0; i < beetle.length; i++) {
            for (int j = 0; j < beetle[i].length; j++) {
                System.out.print(beetle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getCurrentBeetle() {

    }
}