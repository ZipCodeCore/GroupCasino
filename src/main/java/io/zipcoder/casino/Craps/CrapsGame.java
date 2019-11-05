package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import java.util.Scanner;

public class CrapsGame extends DiceGame implements Game {

    public static void main(String[] args) {
        Player player = new Player ("Jeff","Smith", 28, 300.00);
        CrapsGame crapsGame = new CrapsGame(10.00,50.00,player);
        crapsGame.startPlay();
    }

    private String name = "Craps";
    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
    //    private int numberOfRolls;      //an integer from 1-4
    private Integer setThePointRoll;    //saves your first roll to try to match with later rolls
    private Integer currentRoll;        //any roll after the first
    String r;
    Integer counter;
    Console console = new Console(System.in, System.out);


    //Craps Game Constructor
    public CrapsGame(double minBet, double maxBet, Player player) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        CrapsPlayer newPlayer = new CrapsPlayer(player);
    }

    public String getName() {
        return name;
    }

    @Override
    //creates dice and runs a roundOfPlay
    public void startPlay() {
        new CrapsMenu(this).displayMenu();
        roundOfPlay();
        endChoice();
    }

    @Override
    //runs a new game of craps
    public void roundOfPlay() {
        userRollsDiceSetPoint();
        if (winOnFirst(setThePointRoll) == true) {
            winningMessageFirstRoll();
            calculatePayout();
        } else if (loseOnFirst(setThePointRoll) == true) {
            losingMessageFirstRoll();
        } else {
            displayPointRoll(setThePointRoll);
            for (int i = 0; i < 3; i++) {
                userRollsDiceCurrentPoint();
                displayCurrentRoll(currentRoll);
                if (winOnSubsequent(currentRoll, setThePointRoll) == true) {
                    System.out.println(String.format("Hooray! You rolled a %d. You won!!", currentRoll)); //if time, map a custom answer depending on whether you won on the first, second, or third roll
                    calculatePayout();
                    break;
                } else if (loseOnSubsequent(currentRoll) == true) {
                    System.out.println(String.format("You rolled a %d. It appears that the odds were not in your favor today. Better luck next time.....", currentRoll));
                    break;
                }
            }
        }
    }

    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {
        String endChoiceInput = console.getInput("You have finished this game of Craps. Would you like to play again? (Y/N)\n");
        if (endChoiceInput.toUpperCase().equals("N")) {
            console.println("Have a good rest of your day.");
            //also, return to the main menu
        } else if (endChoiceInput.toUpperCase().equals("Y")) {
            console.println("That's great!!!");
            startPlay();
        } else {
            console.println("That's not a valid selection. Please choose again.");
            endChoice();
        }
    }

    public boolean winOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 7 || setThePointRoll == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loseOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 2 || setThePointRoll == 3 || setThePointRoll == 12) {
            return true;
        } else {
            return false;
        }
    }


    public boolean winOnSubsequent(Integer currentRoll, Integer setThePointRoll) {
        if (currentRoll.equals(setThePointRoll)) {
            return true;
        }
        return false;

    }

    public boolean loseOnSubsequent(Integer currentRoll) {
        if (currentRoll == 7) {
            return true;
        }
        return false;
    }

    public Integer calculatePayoutMultiplier() {
        //catch statements
        return null;
    }

    public double calculatePayout() {
        //multiplier * initial wager + initial wager
        return 0.0;
    }

    public void userRollsDiceSetPoint() {
        console.getInput("\nPress Enter to roll the dice\n");
        tossPointRoll();
    }

    public void userRollsDiceCurrentPoint() {
        console.getInput("\nPress Enter to roll the dice\n");
        tossCurrentRoll();
    }


    public Integer tossPointRoll() {
        setThePointRoll = DiceGame.roll(2);
        return setThePointRoll;
    }

    public void displayPointRoll(Integer setThePointRoll) {
        System.out.println(String.format("You have rolled a %d on your first roll", setThePointRoll));
    }

    public void displayCurrentRoll(Integer currentRoll) {
        System.out.println(String.format("You have rolled a %d for this roll", currentRoll));
    }

    public void winningMessageFirstRoll() {
        System.out.println(String.format("You rolled a %d on the first roll!  Congratulations!! You are a winner!!!", setThePointRoll));
    }

    public void losingMessageFirstRoll() {
        System.out.println(String.format("You rolled a %d and have lost on the first roll! This is unfortunate..... :( ", setThePointRoll));
    }

    public Integer tossCurrentRoll() {
        currentRoll = DiceGame.roll(2);
        return currentRoll;
    }
}


