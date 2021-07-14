package com.github.zipcodewilmington.casino.games;


import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.player.RoulettePlayer;

import java.util.*;

public class Roulette {
    Integer number;
    String color;
    int bet;
    int playerIntSelection;
    String playerStringSelection;
    int playerNumberChoice;
    int playerColumnChoice;
    String playerColorChoice;
    String playerEvenOrOddChoice;
    Map<Integer, String> wheelValues;
    Casino casino = new Casino();
    private RoulettePlayer player;



    public Roulette(RoulettePlayer player) {
        this.player = player;
    }

    public Roulette() {

    }

    public void rouletteWelcomeScreen() {


        System.out.println(
                "  \n" +
                        "                             WELCOME TO ROULETTE \n" +
                        "     ====================================================================|\n" +
                        "   /  |-----------------------------------------------------------------||\n" +
                        "  /   | (3)| (6)| (9)|(12)|(15)|(18)|(21)|(24)|(27)|(30)|(33)|(36)| 2to1||\n" +
                        " /    |----|----|----|----|----|----|----|----|----|----|----|----|-----||\n" +
                        "{ (0) | (2)| (5)| (8)|(11)|(14)|(17)|(20)|(23)|(26)|(29)|(32)|(35)| 2to1||\n" +
                        " \\    |----|----|----|----|----|----|----|----|----|----|----|----|-----||\n" +
                        "  \\   | (1)| (4)| (7)|(10)|(13)|(16)|(19)|(22)|(25)|(28)|(31)|(34)| 2to1||\n" +
                        "   \\  |------------------------------------------------------------=====||\n" +
                        "      ||       EVEN     |    RED    |    BLACK    |       ODD      ||  \n" +
                        "      ||===========================================================||\n" +
                        " ");


        //Take in user input/bet
        System.out.println(
                "Please place your bet on:\n" +
                        "1: a number\n" +
                        "2: a column\n" +
                        "3: evens or odds\n" +
                        "4: a color\n" +
                        "5: quit");
    }

    public void numberToColorValue() {
        Map<Integer, String> wheelValues = new HashMap<Integer, String>();
        for (int i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                wheelValues.put(i, "red");
            } else {
                wheelValues.put(i, "black");
            }
        }
    }

    public int getPlayerIntSelection() { return this.playerIntSelection; }

    public void playerSelection(int playerIntSelection) {
        Scanner keyboardInput = new Scanner(System.in);
        playerIntSelection = keyboardInput.nextInt();
        switch(getPlayerIntSelection()) {
            case 1:
                playerBetsNumber();
            case 2:
                playerBetsColumn();
            case 3:
                playerBetsEvensOdds();
            case 4:
                playerBetsColor();
            case 5:
                casino.mainMenu();
        }
    }
    public void playerBetsNumber() {
        System.out.println("Please select a number 1 - 36");
        Scanner keyboardInput = new Scanner(System.in);
        int playerIntSelection = keyboardInput.nextInt();
        if(playerIntSelection >= 1 && playerIntSelection <= 36) {
            playerNumberChoice = playerIntSelection;
        } else playerBetsNumber();
    }

    public void playerBetsColumn() {
        System.out.println("Please select column 1, 2, or 3");
        Scanner keyboardInput = new Scanner(System.in);
        playerIntSelection = keyboardInput.nextInt();
        if(playerIntSelection >= 1 && playerIntSelection <= 3) {
            playerColumnChoice = playerIntSelection;
        } else playerBetsColumn();
    }

    public void playerBetsEvensOdds() {
        System.out.println("Please select even or odds");
        Scanner keyboardInput = new Scanner(System.in);
        playerStringSelection = keyboardInput.nextLine();
        if(playerStringSelection == "even" || playerStringSelection == "odds") {
            playerEvenOrOddChoice = playerStringSelection;
        } else playerBetsEvensOdds();
    }

    public void playerBetsColor() {
        System.out.println("Please select red or black");
        Scanner keyboardInput = new Scanner(System.in);
        playerStringSelection = keyboardInput.nextLine();
        if(playerStringSelection == "red" || playerStringSelection == "black") {
            playerColorChoice = playerStringSelection;
        } else playerBetsColor();
    }

    public int placeBet() {
        System.out.println("Please place your bet");
        Scanner keyboardInput = new Scanner(System.in);
        bet = keyboardInput.nextInt();
        return bet;
    }



    public void spinWheelGetNumber() {
        List<Integer> numberList = new ArrayList<>(wheelValues.keySet());
        Random random = new Random();
        int size = wheelValues.size();
//        int randomNumber = wheelValues.get(numberList.get(random.nextInt(size)));
    }

}
