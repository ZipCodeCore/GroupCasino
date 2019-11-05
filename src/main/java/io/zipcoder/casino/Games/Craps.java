package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps implements Game, GamblingGame {

    private Console console = new Console(System.in, System.out);
    private boolean running;
    private Dice dice;
    private boolean puckOn;
    private int puckVal;

    public Craps() {
        dice = new Dice();
        puckOn = false;
        running = false;
    }


    @Override
    public void approachTable(Player currentPLayer) {
        console.println("As you approach the Craps table you hear yelling and shouting");
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

            if(comeOutRoll()) {
                do {

                    placeBet(currentPlayer);

                } while (passRoll());
            }
            running = playAgain();
        }
    }

    private Integer roll() {
        console.getStringInput("");
        console.dotDotDot(); console.newln();

        console.delay(500);
        Integer roll1 = dice.rollDice(1);
        dice.diceArt(roll1);
        console.delay(500);
        Integer roll2 = dice.rollDice(1);
        dice.diceArt(roll2);

        Integer rollVal = roll1 + roll2;
        return rollVal;
    }

    private boolean comeOutRoll() {
        console.println("\nHit Return to Throw the Come-Out Roll");
        Integer roll = roll();
        console.println("You Rolled " + roll + "!");

        if (roll.equals(2) || roll.equals(3) || roll.equals(12)) {
            console.print("Craps");
            console.dotDotDot();
            console.newln();
            return false;
        } else if (roll.equals(7) || roll.equals(11)) {
            console.dotDotDot();
            console.println("Natural Roll! Pass Line Wins!");
            return false;
        } else {
            console.dotDotDot();
            console.println("The point is now " + roll + "!");
            puckOn = true;
            puckVal = roll;
            return true;
        }
    }

    private boolean passRoll() {
        console.println("\nHit Return to Roll the Dice");
        Integer roll = roll();
        console.println("You Rolled a " + roll + "!");

        if (roll.equals(puckVal)) {
            console.dotDotDot();
            console.println("You Hit the Point Value!");
            return false;
        } else if (roll.equals(7)) {
            console.print("Seven-Out! The Pass Line Losses");
            console.dotDotDot();
            console.newln();
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

    }

    @Override
    public void returnWinnings(Player currentPlayer) {

    }

    @Override
    public void exitGame(Player currentPlayer) {

    }
}
