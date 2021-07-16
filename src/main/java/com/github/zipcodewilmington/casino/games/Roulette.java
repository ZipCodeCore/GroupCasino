package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import com.github.zipcodewilmington.casino.player.Player;
import com.github.zipcodewilmington.casino.player.RoulettePlayer;

import java.util.*;

public class Roulette implements GameInterface{


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
    RoulettePlayer roulettePlayer;
    PlayerInterface roulettePlayerAccount;



    public Roulette(RoulettePlayer roulettePlayer) {
        this.roulettePlayer = roulettePlayer;
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


    public int getPlayerIntSelection() { return playerIntSelection; }

    public void playerSelection() {
        Scanner keyboardInput = new Scanner(System.in);
        playerIntSelection = keyboardInput.nextInt();
        switch(getPlayerIntSelection()) {
            case 1:
                playerBetsNumber();
                placeBet();
                getWinningsByNumber();
                break;
            case 2:
                playerBetsColumn();
                placeBet();
                getWinningsByColumn();
                break;
            case 3:
                playerBetsEvensOdds();
                placeBet();
                getWinningsByEvenOdds();
                break;
            case 4:
                playerBetsColor();
                placeBet();
                getWinningsByColor();
                break;
            case 5:
                casino.run();
        }
    }
    public int playerBetsNumber() {
        System.out.println("Please select a number 1 - 36");
        Scanner keyboardInput = new Scanner(System.in);
        int playerIntSelection = keyboardInput.nextInt();
        if(playerIntSelection >= 1 && playerIntSelection <= 36) {
            playerNumberChoice = playerIntSelection;
        } else playerBetsNumber();
        return playerNumberChoice;
    }

    public int playerBetsColumn() {
        System.out.println("Please select column 1, 2, or 3");
        Scanner keyboardInput = new Scanner(System.in);
        playerIntSelection = keyboardInput.nextInt();
        if(playerIntSelection >= 1 && playerIntSelection <= 3) {
            playerColumnChoice = playerIntSelection;
        } else playerBetsColumn();
        return playerColumnChoice;
    }

    public String playerBetsEvensOdds() {
        System.out.println("Please select even or odds");
        Scanner keyboardInput = new Scanner(System.in);
        playerStringSelection = keyboardInput.next();
        if(playerStringSelection.equals("even") || playerStringSelection.equals("odds")) {
            playerEvenOrOddChoice = playerStringSelection;
        } else playerBetsEvensOdds();
        return playerEvenOrOddChoice;
    }

    public String playerBetsColor() {
        System.out.println("Please select red or black");
        Scanner keyboardInput = new Scanner(System.in);
        playerStringSelection = keyboardInput.next();
        if(playerStringSelection.equals("red") || playerStringSelection.equals("black")) {
            playerColorChoice = playerStringSelection;
        } else playerBetsColor();
        return playerColorChoice;
    }

    public int placeBet() {
        System.out.println("Please place your bet");
        Scanner keyboardInput = new Scanner(System.in);
        bet = keyboardInput.nextInt();
        return bet;
    }



    public int spinWheelGetNumber() {
        Map<Integer, String> wheelValues = new HashMap<Integer, String>();
        for (Integer i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                wheelValues.put(i, "red");
            } else {
                wheelValues.put(i, "black");
            }
        }
        List<Integer> numberList = new ArrayList<>(wheelValues.keySet());
        Random random = new Random();
        int size = wheelValues.size();
        int randomNumber = numberList.get(random.nextInt(size));
        return randomNumber;
    }

    public String spinWheelGetColor() {
        Map<Integer, String> wheelValues = new HashMap<Integer, String>();
        for (Integer i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                wheelValues.put(i, "red");
            } else {
                wheelValues.put(i, "black");
            }
        }
        int numberValue = spinWheelGetNumber();
        return wheelValues.get(numberValue);
    }

    public int getWinningsByNumber() {
        int winningNumber = spinWheelGetNumber();
        if (winningNumber == playerNumberChoice) {
            bet = bet * 35;
            System.out.printf("You win! $%d has been added to your balance", bet);
        } else {
            bet = 0 - bet;
            System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
        }
        return bet;
    }

    public int getWinningsByColumn() {
        int winningNumber = spinWheelGetNumber();

        Integer[] column1Arr = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
        Integer[] column2Arr = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
        Integer[] column3Arr = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};

        if(playerColumnChoice == 1) {
            if(Arrays.asList(column1Arr).contains(winningNumber)){
                bet = bet*2;
                System.out.printf("You win! $%d has been added to your balance", bet);
            } else {
                bet = 0 - bet;
                System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
            }
        }
        if(playerColumnChoice == 2) {
            if(Arrays.asList(column2Arr).contains(winningNumber)) {
                bet = bet*2;
                System.out.printf("You win! $%d has been added to your balance", bet);
            } else {
                bet = 0 - bet;
                System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
            }
        }
        if(playerColumnChoice == 3) {
            if(Arrays.asList(column3Arr).contains(winningNumber)) {
                bet = bet*2;
                System.out.printf("You win! $%d has been added to your balance", bet);
            } else {
                bet = 0 - bet;
                System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
            }
        }
        return bet;
    }

    public int getWinningsByEvenOdds() {
        int winningNumber = spinWheelGetNumber();
        if(playerEvenOrOddChoice.equals("even")) {
            if(winningNumber % 2 == 0) {
                bet = bet;
                System.out.printf("You win! $%d has been added to your balance", bet);
            } else {
                bet = 0 - bet;
                System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
            }
        } else if(playerEvenOrOddChoice.equals("odds")) {
            if(winningNumber % 2 != 0) {
                bet = bet;
                System.out.printf("You win! $%d has been added to your balance", bet);
            } else {
                bet = 0 - bet;
                System.out.printf("Bad luck. The number was %d. Try again?", winningNumber);
            }
        }
        return bet;
    }

    public int getWinningsByColor() {
        String winningColor = spinWheelGetColor();
        if(playerColorChoice.equals(winningColor)) {
            bet = bet;
            int newBalance = roulettePlayerAccount.getArcadeAccount().getPlayerBalance();
            newBalance = bet;
            System.out.printf("You win! $%d has been added to your balance\n" + "Your remaining balance is: ", bet, newBalance);
        } else {
            bet = 0 - bet;
            System.out.printf("Bad luck. The color was %s. Try again?", winningColor);
        }
        return bet;
    }

    public void playRoulette() {
        Scanner keyboardInput = new Scanner(System.in);
        rouletteWelcomeScreen();
        playerSelection();
        keyboardInput.nextLine();
        playRoulette();
    }

    public void add(PlayerInterface player) {

    }


    public void remove(PlayerInterface player) {

    }

    public void run() { playRoulette();

    }
}
