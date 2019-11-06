package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.RRMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.utilities.Console;
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
        rrMenu.displayMenu();
    }

    @Override
    public void endChoice() {
        //implements menu whether you want to quit or go again

        String endChoiceInput = console.getInput(("\n[DEALER]: You have finished this Russian Roulette Game.\n[DEALER]: Would you like to play again? (Y/N)\n"));

        if (endChoiceInput.toUpperCase().equals("N")) {
            console.printWithDelays("\n[DEALER]: Have a good rest of your day.\n");
            console.sleep(2000);

            //also, return to the main menu
        } else if (endChoiceInput.toUpperCase().equals("Y")) {
            roundOfPlay();

        } else {
            console.println("(That's not a valid selection. Please choose again.)");
            endChoice();
        }

    }
    @Override
    public void roundOfPlay() {
        Integer computerRoll=roll();
        console.println(String.format("\n** The House rolled %d **\n", computerRoll));
        userRollsDice();
        //console.println("Your Current Balance Is %d", this.player.getBalance());

        console.println(String.format("\n** You rolled %d **\n", userDieNum));
        if (userDieNum.equals(computerRoll)) {
            gameServices.wager(player.getBalance(),player);
            console.println("You Lost!!!");

<<<<<<< HEAD


=======
>>>>>>> f14c35b702239b1e47c1f69feb6849f85144c85a
            //player.setBalance(0);

            //startPlay();
        }
        else {
            gameServices.payOut(this.player.getBalance(), this.player);

<<<<<<< HEAD
            console.println(String.format("\n\nYou Won!!! Your Balance Is Now $%.2f\n",player.getBalance()));
    }
=======
            console.println(String.format("You Won!!! Your Balance Is Now $%.2f",player.getBalance()));
        }
>>>>>>> f14c35b702239b1e47c1f69feb6849f85144c85a
        endChoice();

    }
    public Integer userRollsDice() {
        console.getInput("\n(Press Enter to roll the dice): \n");
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