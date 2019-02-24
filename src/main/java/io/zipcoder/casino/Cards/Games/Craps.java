package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.DicePlayer;
import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;

public class Craps extends Game {
    private int firstRoll = 0;
    private int point = 0;
    private boolean placedSideBet = false;
    private boolean toWinPassBet = false;
    private boolean toWinPlaceBet = false;
    private boolean toWinLayBet = false;
    private boolean isFirstRoll = true;
    private boolean isOver = false;
    private int placeBetChoice;
    Console console = new Console();
    Profile profile = new Profile();
    private int[] crappedOutRolls = {2, 3, 12};
    private int[] placeNumberRolls = {4, 5, 6, 8, 9, 10};
    private int[] fieldRollWins = {2, 3, 4, 9, 10, 11, 12};
    private int initialBalance = profile.getBalance();
    private int adjustedBalance;
    private int rollSum;
    private int firstRollSum;
    private int buyIn = 5;
    Dice die1 = new Dice();
    Dice die2 = new Dice();
    DicePlayer crapsPlayer = new DicePlayer(Casino.getProfile());

    public Craps() {
    }

    public static void main(String[] args) {
        Craps craps = new Craps();
        craps.playGame();
    }

    public int playGame() {
        System.out.println("Welcome to the craps table!");
        initialLoop:
        while (isFirstRoll) {
            promptBet();
            firstRoll();
        }
        repeatedLoop:
        while (!isOver && !isFirstRoll) {
            promptBet();
            roll();
            evaluate();
        }
        return 0;
    }

    public int firstRoll() {
        roll();
        if (Arrays.stream(crappedOutRolls).anyMatch(i -> i == rollSum) && toWinPassBet) {
            System.out.println("Whomp, whomp, you crapped out.");
            adjustBalance(-buyIn);
            resetPointAndRoll();
        } else if (rollSum == 7 && toWinPassBet || rollSum == 11 && toWinPassBet) {
            System.out.println("You won the Pass bet, keep it up!");
            adjustBalance(buyIn);
            resetPointAndRoll();
        } else if (rollSum == 7 && !toWinPassBet || rollSum == 11 && !toWinPassBet) {
            System.out.println("You lost the Pass bet!");
            adjustBalance(-buyIn);
            resetPointAndRoll();
        } else if (Arrays.stream(crappedOutRolls).anyMatch(i -> i == rollSum) && !toWinPassBet) {
            System.out.println("You won the Don't Pass bet, keep it up!");
            adjustBalance(buyIn);
            resetPointAndRoll();
        } else {
            point = rollSum;
            System.out.println("The point is now " + point + ".\nKeep on rollin', shooter!");
            isFirstRoll = false;
        }
        return point;
    }

    public void resetPointAndRoll() {
        point = 0;
        isFirstRoll = true;
    }

    public void promptBet() {
        if (isFirstRoll) {
            String passChoice = console.getStringInput("Please choose 'Pass' or 'Don't Pass'");
            if (passChoice.equals("Pass")) {
                toWinPassBet = true;
            } else if (passChoice.equals("Don't Pass")) {
                toWinPassBet = false;
            }
        } else if (!placedSideBet) {
            int betChoice = console.getIntegerInput("You have four choices:\n1) Make a Place Bet\n2) Make a Lay Bet\n3) Continue rolling\n4) Quit.");
            betSwitch:
            switch (betChoice) {
                case 1:
                    placedSideBet = true;
                    placeBetChoice = console.getIntegerInput("What number do you want to make a Place Bet for?");
                    if (Arrays.stream(placeNumberRolls).anyMatch(i -> i == placeBetChoice)) {
                        System.out.println("Excellent choice!");
                    } else {
                        placeBetChoice = console.getIntegerInput("Stick to the Place numbers, buddy! Pick from 4, 5, 6, 8, 9 or 10.");
                    }
                    toWinPlaceBet = true;
                    break;
                case 2:
                    toWinLayBet = true;
                    placedSideBet = true;
                    break;
                case 3:
                    break;
                case 4:
                    cashOut();
            }
        }
    }

    public int roll() {
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        rollSum = roll1 + roll2;
        System.out.println(String.format("You rolled a %d and %d totaling %d", roll1, roll2, rollSum));
        return rollSum;
    }

    public void evaluate() {
        if (rollSum == 7 && toWinLayBet) {
            System.out.println("Your Lay bet paid off!");
            adjustBalance(buyIn);
        }
        if (rollSum == 7 && !toWinPassBet) {
            System.out.println("Your Don't Pass bet paid off!");
            adjustBalance(buyIn);
        }
        if (rollSum == 7 && !toWinLayBet) {
            System.out.println("Sorry shooter, it looks like your hot streak has come to an end!");
            adjustBalance(-buyIn);
            resetPointAndRoll();
        }
        if (rollSum == placeBetChoice) {
            System.out.println("Your Place bet paid off!");
            adjustBalance(buyIn);
        }
        if (rollSum == point && !toWinPassBet) {
            System.out.println("Lucky number " + point + "! You hit the point!");
            adjustBalance(buyIn);
        }
    }

    public int adjustBalance(int profitOrLoss) {
        if (profitOrLoss > 0) {
            System.out.println(String.format("You're on a roll and %d zips richer!", profitOrLoss));
        } else if (profitOrLoss < 0) {
            System.out.println(String.format("You only lost %d zips. Play again to win that back and more!", profitOrLoss));
        }
        return adjustedBalance += profitOrLoss;
    }

    public void compareBalance() {
        if (adjustedBalance > initialBalance) {
            System.out.println(String.format("You won %d zips!", adjustedBalance - initialBalance));
        } else if (adjustedBalance < initialBalance) {
            System.out.println(String.format("You lost %d zips!", initialBalance - adjustedBalance));
        } else if (adjustedBalance == initialBalance) {
            System.out.println("You broke even!");
        }
    }

    public void cashOut() {
        String continuePlaying = console.getStringInput("Would you like to continue playing?");
        if (continuePlaying.equals("No")) {
            compareBalance();
            //profile.setBalance(adjustedBalance);
            isOver = true;
        } else if (continuePlaying.equals("Yes")) {
            roll();
        }
    }
}