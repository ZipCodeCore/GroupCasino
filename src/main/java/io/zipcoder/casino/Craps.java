package io.zipcoder.casino;

import io.zipcoder.casino.Players.DicePlayer;
import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;

//  private void listBets() {
//        System.out.println(String.format("You have placed the following bets:\n"));
//    }

public class Craps {
    private int firstRoll;
    private int point;
    private boolean placedSideBet = false;
    private boolean toWinPassBet;
    private boolean toWinPlaceBet;
    private boolean toWinLayBet;
    //private boolean isHardWays;
    private boolean isFirstRoll;
    private boolean isOver;
    Console console = new Console();
    DicePlayer dicePlayer = new DicePlayer();
    private int[] crappedOutRolls = {2, 3, 12};
    //private int initialBalance = User.getBalance();
    private int adjustedBalance;
    private int nextRoll;
    private int buyIn = 5;
    Dice die1 = new Dice();
    Dice die2 = new Dice();4
    //Casino.getProfile();

    //public void play();
    //public void playGame();
    //public void cashIn();

    public void main(String[] args) {
        System.out.println("Welcome to the craps table!");
        while (!isOver) {
            promptBet();
            roll();
            evaluate();
            cashOut();
        }
    }

    public void promptBet() {
        if (isFirstRoll == true) {
            String passChoice = console.getStringInput("Please choose 'Pass' or 'Don't Pass'");
            if (passChoice.equals("Pass")) {
                toWinPassBet = true;
            } else if (passChoice.equals("Don't Pass")) {
                toWinPassBet = false;
            }
        } else {
            if (placedSideBet == false) {
                int betChoice = console.getIntegerInput("You have four choices:\n1) Make a Place Bet\n2) Make a Lay Bet\n3) Continue rolling\n4) Quit.");
                switch (betChoice) {
                    case 1:
                        toWinPlaceBet = true;
                        break;
                    case 2:
                        toWinLayBet = true;
                        break;
                    case 3:
                        break;
                    case 4:
                        cashOut();
                }
            }
        }
    }

    public void roll() {
        int initialSum = die1.roll() + die2.roll();
        if (isFirstRoll == true) {
            firstRoll = initialSum;
            isFirstRoll = false;
        } else {
            point = initialSum;
        }
        System.out.println(String.format("You rolled a %d and %d totaling %d", die1.roll(), die2.roll(), initialSum));
    }

    public void evaluate() {
        if (Arrays.stream(crappedOutRolls).anyMatch(i -> i == firstRoll)) {
            adjustBalance(-buyIn);
            isOver = true;
        } else if (firstRoll == 7 || firstRoll == 11 && toWinPassBet) {
            adjustBalance(buyIn);
            System.out.println("You won a Pass bet, keep it up!");
        }
        switch (nextRoll) {
            case 7:
                if (toWinPlaceBet) {
                    System.out.println("Your Place bet paid off! You won $5!");
                    adjustBalance(buyIn);
                } else {
                    System.out.println("Sorry shooter, it looks like your hot streak has come to an end!");
                    cashOut();
                    isOver = true;
                }
            default:
                if (nextRoll == point && toWinLayBet) {
                    System.out.println("Your Lay bet paid off! You won $5!");
                    adjustBalance(buyIn);
                } else {
                    break;
                }
        }
    }

    public int adjustBalance(int profitOrLoss) {
        if (profitOrLoss > 0) {
            System.out.println(String.format("You're on a roll and $%d richer!", profitOrLoss));
        } else if (profitOrLoss < 0) {
            System.out.println(String.format("You only lost $%d. Play again to win that back and more!", profitOrLoss));
        }
        return adjustedBalance + profitOrLoss;
    }

    public void compareBalance() {
        if (adjustedBalance > initialBalance) {
            System.out.println(String.format("You won $%d!", adjustedBalance - initialBalance));
        } else if (adjustedBalance < initialBalance) {
            System.out.println(String.format("You lost $%d!", initialBalance - adjustedBalance));
        } else if (adjustedBalance == initialBalance) {
            System.out.println("You broke even!");
        }
    }

    public void cashOut() {
        String continuePlaying = console.getStringInput("Would you like to continue playing?");
        if (continuePlaying.equals("No")) {
            compareBalance();
            profile.setBalance(adjustedBalance);
            isOver = true;
        } else {
            roll();
        }
    }
}