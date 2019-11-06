package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.RRMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utilities.Console;
import io.zipcoder.casino.Interfaces.Game;

public class RRGame extends DiceGame implements Game {
    public static void main(String[] args) throws InterruptedException {
        Player rrPlayer = new Player("Grace","Bunde",23,500);
        RRGame rrGame = new RRGame(rrPlayer);
        rrGame.startPlay();
    }

    private Console console = new Console(System.in, System.out);
    private String name = "Russian Dice Roulette";
    private Integer userDieNum=0;
    private GameServices gameServices = new GameServices();
    private Player player;

    public RRGame(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    @Override
    public void startPlay() throws InterruptedException {
        // store menu
        RRMenu rrMenu = new RRMenu(this);

           rrMenu.displayMenu();}

    @Override
    public void endChoice() {
        //implements menu whether you want to quit or go again
        String endChoiceInput = console.getInput("You have finished this Russian Roulette Game.\nWould you like to play again? (Y/N)\n");
        if (endChoiceInput.toUpperCase().equals("N")) {
            console.println("Have a good rest of your day.");
            //also, return to the main menu
        } else if (endChoiceInput.toUpperCase().equals("Y")) {
            console.println("That's great!!!");
            roundOfPlay();
        } else {
            console.println("That's not a valid selection. Please choose again.");
            endChoice();
        }

    }
    @Override
    public void roundOfPlay() {
        Integer computerRoll=roll();
        console.println("The House Rolled %d", computerRoll);
        userRollsDice();
        //console.println("Your Current Balance Is %d", this.player.getBalance());

        console.println("You Rolled %d", userDieNum);
        if (userDieNum.equals(computerRoll)) {
            console.println("You Lost!!!");
            //player.setBalance(0);


            //startPlay();
        }
        else {
            gameServices.payOut(this.player.getBalance(), this.player);
            console.println("You Won!!! Your Balance Is Now $%.2f",player.getBalance());
        }
        endChoice();

    }
    public Integer userRollsDice() {
        console.getInput("\nPress Enter to roll the dice\n");
        userDieNum=roll();
        return userDieNum;
    }

    public int selectTargetNum () {
        return 0;
    }

    public boolean evaluateResult (int target, int roll) {
        return false;
    }


}