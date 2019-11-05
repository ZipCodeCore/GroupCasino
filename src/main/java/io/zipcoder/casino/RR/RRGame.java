package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.RRMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;
import io.zipcoder.casino.Interfaces.Game;

public class RRGame extends DiceGame implements Game {


    private Console console = new Console(System.in, System.out);
    private String name = "Russian Dice Roulette";
//    public static int roll (int numberOfDiceBeingRolled, int numOfSides)
//    {
//        Integer dieRoll1 = 0;
//        for (int i = 1; i <= numberOfDiceBeingRolled; i++) {
//            dieRoll1 += (int) (Math.random() * numOfSides + 1);
//        }
//        return dieRoll1;
//    }
    private Player player;

//    public class RRGamePlayer {
//
//
//
//
//        //RRGamePlayer Constructor
//        public RRGamePlayer(Player player) {
//
//            this.player = player;
//        }
//
//
//    }

    public String getName() {
        return name;
    }

    @Override
    public void startPlay() {
        new RRMenu(this).displayMenu();
        roundOfPlay();
    }

    @Override
    public void endChoice() {

    }

    @Override
    public void roundOfPlay() {
        Integer computerRoll=roll();
        console.println("The House Rolled %d", computerRoll);
        console.println("Your Current Balance Is %d", player.getBalance());
        console.getInput("Press Enter To Roll");
        Integer playerRoll = roll();
        console.println("You Rolled %d", playerRoll);
        if (playerRoll == computerRoll) {
            console.println("You Lost!!!");
            player.setBalance(0);
        }
        else {
            player.setBalance(2*player.getBalance());
            console.println("You Won!!! Your Balance Is Now %d",player.getBalance());
        }


    }


    public int selectTargetNum () {
        return 0;
    }

    public boolean evaluateResult (int target, int roll) {
        return false;
    }


}