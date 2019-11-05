package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;

import java.util.Scanner;

public class CrapsGame extends DiceGame implements Game {

    private String name = "Craps";
    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
    //    private int numberOfRolls;      //an integer from 1-4
    private Integer setThePointRoll;    //saves your first roll to try to match with later rolls
    private Integer currentRoll;        //any roll after the first
    Scanner scanner = new Scanner(System.in);
    String r;
    Integer counter;


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
        setThePointRoll = DiceGame.roll(2);
        if (winOnFirst(setThePointRoll) == true) {
            System.out.println(String.format("You rolled a %d Congratulations! You are already a winner!!!", currentRoll));
            calculatePayout();
        } else if (loseOnFirst(setThePointRoll) == true) {
            System.out.println(String.format("You rolled a %d and lost on the first roll. This is unfortunate.....", currentRoll));
        } else {
            for (int i = 0; i < 3; i++) {
                currentRoll = DiceGame.roll(2);
                if (winOnSubsequent(currentRoll, setThePointRoll) == true) {
                    System.out.println(String.format("Hooray! You rolled a %f You won!!", currentRoll)); //if time, map a custom answer depending on whether you won on the first, second, or third roll
                    calculatePayout();
                    break;
                } else if (loseOnSubsequent(currentRoll) == true) {
                    System.out.println(String.format("You rolled a %d It appears that the odds were not in your favor today. Better luck next time.....", currentRoll));
                    break;
                } else {
                    System.out.println(String.format("You rolled a %d", currentRoll));
                }
            }
        }
    }

    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {
        System.out.println("You have finished this game of Craps. Would you like to play again? (Y/N)");
        if (scanner.next().toUpperCase().equals("N")) {
            System.out.println("Have a good rest of your day.");
            //also, return to the main menu
        } else if (scanner.next().toUpperCase().equals("Y")) {
            System.out.println("That's great!!!");
            startPlay();
        } else {
            System.out.println("That's not a valid selection. Please choose again.");
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

    public String userRollsDice() {
        System.out.println("\nPress r to roll the dice\n");
        String r = scanner.next().toLowerCase();
        counter++;
        return r;
    }

        public Integer RollPointNum (String r){
            if (r.equals("r")) {
                setThePointRoll = DiceGame.roll(2);
                return setThePointRoll;
            }
        else notR();
    }

    public void notR () {
        if( r != "r"){
            System.out.println("Invalid choice!");
           userRollsDice();

        }
    }
}

