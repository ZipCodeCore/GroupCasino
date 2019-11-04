package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps implements Game {

    Console console = new Console(System.in, System.out);
    boolean running;
    Dice dice;
    boolean puckOn;

    public Craps() {
        dice = new Dice();
        puckOn = false;
        running = false;
    }


    @Override
    public void approachTable(Player currentPLayer) {
        console.println("As you approach the Craps table you hear yelling and shouting");
        console.println("Would you like to play?");
        console.println("(1) Yes");
        console.println("(2) No");

        String input = console.getStringInput(":");

        switch (input) {
            case "1":
                runGame(currentPLayer);
                break;
            case "2":
                console.println("That's too bad");
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

            } else {
                running = playAgain();
            }

        }


    }

    private boolean comeOutRoll() {
        Integer roll = dice.rollDice(2);

        console.println("You roll a " + roll + "!");

        if (roll.equals(2) || roll.equals(3) || roll.equals(12)) {
            console.println("Craps!");
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
    public void exitGame() {

    }
}
