package io.zipcoder.casino.DiceGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;


public class Craps implements GamblingGame {


    private Dice[] crapsDice;
    private GamblingPlayer crapsPlayer;
    private Console console;
    private boolean continuePlay;
    private Integer turn;
    private Integer targetScore;
    private int sum;

    //------------- Constructor----------------------------

    public Craps(Player player) {

        this.crapsPlayer = new GamblingPlayer(player);
        this.crapsDice = createDice();
        this.console = new Console(System.in, System.out);

    }

    //------------------------------------------------------

    public Dice[] createDice() {
        Dice[] crapsDice = new Dice[2];
        for (int i = 0; i < crapsDice.length; i++) {
            crapsDice[i] = new Dice();
        }
        return crapsDice;
    }


    public void startGame() {

        turn = 0;
        continuePlay = true;
        console.println(checkForChips());
        promptUserForWagerAmount();
        createDice();

        do {
            console.println(crapsRoll());
            console.println(evaluateRoll());
            turn++;
        }
        while (continuePlay == true);

        crapsPlayer.resetPot();
        promptLeaveGame();

    }

    public String checkForChips(){
        if (crapsPlayer.getBalance() < 10){return "You need at least $10.00 to play";}
        else {return "Welcome to Craps!";}
    }



    public String crapsRoll() {

        console.getStringInput("Press enter to roll.");

        for (Dice s : this.crapsDice) { s.rollDice(); }
        sum = crapsDice[0].getValue() + crapsDice[1].getValue();

        String roll = "You rolled a " + sum;
        String target ="        Target Roll: " + targetScore;

        return (turn == 0) ? roll : roll + target;
    }


    public String evaluateRoll() {

        String msg = "";

        if (turn == 0) {

            if (sum == 7 || sum == 11) {
                crapsPlayer.getWinnings();
                msg = "Winner Winner, Chicken Dinner!\n" + crapsPlayer.getPot();
                //console.println("Winner Winner, Chicken Dinner! " );
                continuePlay = false;
            } else if (sum == 2 || sum == 3 || sum == 12) {
                msg = "You've Crapped out!!";
                //console.println("You've Crapped out!!");
                continuePlay = false;
            } else {
                targetScore = sum;
                msg = "Your Target Score is " + targetScore;
                //console.println( "Your Target Score is " + targetScore);
            }

        } else {

            if (sum == 7) {
                msg = "You've Crapped out!!";
                //console.println("You've Crapped out!!");
                continuePlay = false;
            } else if (sum == targetScore) {
                crapsPlayer.getWinnings();
                msg = "Winner Winner, Chicken Dinner!\n" + crapsPlayer.getPot();
                //console.println("Winner Winner, Chicken Dinner! " );
                //console.println("Congratulations, your payout is $" + crapsPlayer.getPot());
                continuePlay = false;
            }
        }

        return msg;
    }


    public void promptUserForWagerAmount() {

        double userWagerAmount = console.getDoubleInput("Your balance is now $ " + crapsPlayer.getBalance()+ "\nHow much would you like to wager?");
        boolean wagerAmountSuccessful = crapsPlayer.placeWager(userWagerAmount);

        while (!wagerAmountSuccessful) {
            userWagerAmount = console.getDoubleInput("Wager exceeds your balance. Please wage a smaller amount.");
            wagerAmountSuccessful = crapsPlayer.placeWager(userWagerAmount);
        }

    }


    public void promptLeaveGame() {

        int userInput = console.getIntegerInput("Your balance is " + crapsPlayer.getBalance() + "\nDo you want to play again? \n" +
                "1. Yes\n" + "2. No");

        if (userInput == 1) {
            startGame();

        }

    }


}
