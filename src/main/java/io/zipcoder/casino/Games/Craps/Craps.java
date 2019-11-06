package io.zipcoder.casino.Games.Craps;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        console.println("Would you like to play?");
        console.delay(500);
        console.println("(1) Yes");
        console.delay(100);
        console.println("(2) No");

        String input = console.getStringInput(":");

        switch (input) {
            case "1":
                runGame(currentPLayer);
                break;
            case "2":
                console.print("That's too bad");
                console.dotDotDot();
                console.newln();
                break;
            default:
                console.println("Invalid Input");
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
        console.println(dice.diceArt(roll1));
        console.delay(500);
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));

        Integer rollVal = roll1 + roll2;
        return rollVal;
    }

    private boolean comeOutRoll(Player currentPlayer) {
        console.println("\nHit Return to Throw the Come-Out Roll");
        Integer roll = roll();
        console.println("You Rolled " + roll + "!");

        if (roll.equals(2) || roll.equals(3) || roll.equals(12)) {
            console.print("Craps");
            console.dotDotDot();
            console.newln();
            currentPlayer.addHistory("You lost $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            return false;
        } else if (roll.equals(7) || roll.equals(11)) {
            console.dotDotDot();
            console.println("Natural Roll! Pass Line Wins!");
            currentPlayer.addHistory("You won $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            returnWinnings(currentPlayer);
            return false;
        } else {
            console.dotDotDot();
            console.println("The point is now " + roll + "!");
            puckVal = roll;
            return true;
        }
    }

    private boolean passRoll(Player currentPlayer) {
        console.println("\nHit Return to Roll the Dice");
        Integer roll = roll();
        console.println("You Rolled a " + roll + "!");

        if (roll.equals(puckVal)) {
            console.dotDotDot();
            console.println("You Hit the Point Value!");
            currentPlayer.addHistory("You won $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            returnWinnings(currentPlayer);
            return false;
        } else if (roll.equals(7)) {
            console.print("Seven-Out! The Pass Line Losses");
            console.dotDotDot();
            console.newln();
            currentPlayer.addHistory("You lost $" + playerBet + " playing Craps ** " + timeFormatter.format(LocalDateTime.now()));
            return false;
        } else {
            return true;
        }
    }

    private boolean playAgain() {
        console.println("Play Again?");
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
            console.println("How much would you like to bet?\t Balance $" + currentPlayer.getBalance());
            Integer betAmount = console.getIntegerInput("$");

            if (currentPlayer.getBalance() >= betAmount && betAmount >= 0) {
                currentPlayer.changeBalance(-1 * betAmount);
                playerBet = betAmount;
                correctVal = true;
            } else {
                console.print("You don't have that much money");
                console.dotDotDot();
                console.delay(1000);
                correctVal = false;
            }
        }
    }

    @Override
    public void returnWinnings(Player currentPlayer) {
        console.println("You won $" + playerBet);
        currentPlayer.changeBalance(playerBet * 2);
        console.println("Your balance is now $" + currentPlayer.getBalance());
        playerBet = 0;
        console.delay(1000);
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }

}
