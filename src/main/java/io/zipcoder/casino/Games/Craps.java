package io.zipcoder.casino.Games;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class Craps implements Game, GamblingGame {

    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Console console = new Console(System.in, System.out);
    private CasinoArt casinoArt = new CasinoArt();
    private Integer playerBet;
    private boolean running;
    private Dice dice;
    private int puckVal;

    public Craps() {
        dice = new Dice();
        running = false;
        playerBet = 0;
    }


    @Override
    public void approachTable(Player currentPLayer) {
        Console.clearScreen();
        console.printFast(casinoArt.getCasinoArt("craps"));
        console.printSlow("As you approach the Craps table you hear yelling and shouting");
        console.dotDotDot();
        console.newln();
        console.printSlow("Would you like to play?\n");
        console.delay(500);
        console.printSlow("(1) Yes\n");
        console.printSlow("(2) No\n");

        String input = console.getStringInput(":");

        switch (input) {
            case "1":
                runGame(currentPLayer);
                break;
            case "2":
                console.printSlow("That's too bad");
                console.dotDotDot();
                console.newln();
                break;
            default:
                console.print("Invalid Input");
                console.dotDotDot();
                console.newln();
                console.delay(2000);
                approachTable(currentPLayer);
                break;
        }
    }

    @Override
    public void runGame(Player currentPlayer) {

        running = true;
        while (running) {

            placeBet(currentPlayer);

            if(comeOutRoll(currentPlayer)) {
                while (passRoll(currentPlayer));
            }

            running = playAgain();
        }
    }

    private Integer roll() {
        console.getStringInput("");
        console.dotDotDot(); console.newln();

        console.delay(500);
        Integer roll1 = dice.rollDice(1);
        console.printFast(dice.diceArt(roll1) + "\n");
        Integer roll2 = dice.rollDice(1);
        console.printFast(dice.diceArt(roll2) + "\n");

        Integer rollVal = roll1 + roll2;
        return rollVal;
    }

    private boolean comeOutRoll(Player currentPlayer) {
        console.printSlow("\nHit Return to Throw the Come-Out Roll\n");
        Integer roll = roll();
        console.printSlow("You Rolled " + roll + "!\n");

        if (roll.equals(2) || roll.equals(3) || roll.equals(12)) {
            console.print("Craps");
            console.dotDotDot();
            console.newln();
            currentPlayer.addHistory("You lost $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            return false;
        } else if (roll.equals(7) || roll.equals(11)) {
            console.dotDotDot();
            console.printSlow("Natural Roll! Pass Line Wins!\n");
            currentPlayer.addHistory("You won $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            returnWinnings(currentPlayer);
            return false;
        } else {
            console.dotDotDot();
            console.printSlow("The point is now " + roll + "!\n");
            puckVal = roll;
            return true;
        }
    }

    private boolean passRoll(Player currentPlayer) {
        console.printSlow("\nHit Return to Roll the Dice\n");
        Integer roll = roll();
        console.printSlow("You Rolled a " + roll + "!\n");

        if (roll.equals(puckVal)) {
            console.dotDotDot();
            console.printSlow("You Hit the Point Value!\n");
            currentPlayer.addHistory("You won $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            returnWinnings(currentPlayer);
            return false;
        } else if (roll.equals(7)) {
            console.printSlow("Seven-Out! The Pass Line Losses");
            console.dotDotDot();
            console.newln();
            currentPlayer.addHistory("You lost $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            return false;
        } else {
            return true;
        }
    }

    private boolean playAgain() {
        console.printSlow("Play Again?\n");
        console.delay(400);
        console.println("(1) Yes");
        console.println("(2) No");
        String input = console.getStringInput(":");

        switch (input) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                console.println("Invalid Input");
                return playAgain();
        }
    }

    @Override
    public void placeBet(Player currentPlayer) {

        boolean correctVal = false;
        while (!correctVal) {
            console.printSlow("How much would you like to bet?\t Balance $" + currentPlayer.getBalance() + "\n");
            Integer betAmount = console.getIntegerInput("$");

            if (currentPlayer.getBalance() >= betAmount && betAmount >= 0) {
                currentPlayer.changeBalance(-1 * betAmount);
                playerBet = betAmount;
                correctVal = true;
            } else {
                console.printSlow("You don't have that much money");
                console.dotDotDot();
                console.delay(1000);
                correctVal = false;
            }
        }
    }

    @Override
    public void returnWinnings(Player currentPlayer) {
        console.printSlow("You won $" + playerBet + "\n");
        currentPlayer.changeBalance(playerBet * 2);
        console.printSlow("Your balance is now $" + currentPlayer.getBalance() + "\n");
        playerBet = 0;
        console.delay(1000);
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }
}
