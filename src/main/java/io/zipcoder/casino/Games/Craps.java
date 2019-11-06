package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;

public class Craps implements Game, GamblingGame {

    private Console console = new Console(System.in, System.out);
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
        console.println("\n" +
                "                                                      \n" +
                "                                                      \n" +
                "  ,----..                                             \n" +
                " /   /   \\                     ,-.----.               \n" +
                "|   :     :  __  ,-.           \\    /  \\              \n" +
                ".   |  ;. /,' ,'/ /|           |   :    |  .--.--.    \n" +
                ".   ; /--` '  | |' | ,--.--.   |   | .\\ : /  /    '   \n" +
                ";   | ;    |  |   ,'/       \\  .   : |: ||  :  /`./   \n" +
                "|   : |    '  :  / .--.  .-. | |   |  \\ :|  :  ;_     \n" +
                ".   | '___ |  | '   \\__\\/: . . |   : .  | \\  \\    `.  \n" +
                "'   ; : .'|;  : |   ,\" .--.; | :     |`-'  `----.   \\ \n" +
                "'   | '/  :|  , ;  /  /  ,.  | :   : :    /  /`--'  / \n" +
                "|   :    /  ---'  ;  :   .'   \\|   | :   '--'.     /  \n" +
                " \\   \\ .'         |  ,     .-./`---'.|     `--'---'   \n" +
                "  `---`            `--`---'      `---`                \n" +
                "                                                      \n");
        console.println("              _______.\n" +
                "   ______    | .   . |\\\n" +
                "  /     /\\   |   .   |.\\\n" +
                " /  '  /  \\  | .   . |.'|\n" +
                "/_____/. . \\ |_______|.'|\n" +
                "\\ . . \\    /  \\ ' .   \\'|\n" +
                " \\ . . \\  /    \\____'__\\|\n" +
                "  \\_____\\/\n\n");
        console.print("As you approach the Craps table you hear yelling and shouting");
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
            return false;
        } else if (roll.equals(7) || roll.equals(11)) {
            console.dotDotDot();
            console.println("Natural Roll! Pass Line Wins!");
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
            returnWinnings(currentPlayer);
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

        boolean correctVal = false;
        while (!correctVal) {
            console.println("How much would you like to bet?\t Balance " + currentPlayer.getBalance());
            Integer betAmount = console.getIntegerInput(":");

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
        console.println("You won " + playerBet * 2);
        currentPlayer.changeBalance(playerBet * 2);
        console.println("Your balance is now " + currentPlayer.getBalance());
        playerBet = 0;
        console.delay(1000);
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }
}
