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
    private boolean winGame;
    private Integer turn;
    private Integer targetScore;
    private int sum;
    //------------- Constructor----------------------------
    public Craps(Player player) {
        this.crapsPlayer = new GamblingPlayer(player);
        this.crapsDice = createDice();
        this.console = new Console(System.in, System.out);
        this.continuePlay = true;
        this.turn = 0;


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
        console.println("Welcome to Craps!");
        promptUserForWagerAmount();
        turn = 0;
        continuePlay = true;
        do {
            createDice();
            crapsRoll();
            evaluateRoll();
            turn++;
        }
        while (continuePlay == true);
        promptLeaveGame();
    }



    public void crapsRoll() {
        console.getStringInput("Press enter to roll.");
        for (Dice s : this.crapsDice) {
            s.rollDice();
        }
        sum = crapsDice[0].getValue() + crapsDice[1].getValue();
        console.println("You rolled a " + sum);
    }

    public void evaluateRoll() {

        if (turn == 0) {
            if (sum == 7 || sum == 11) {
                crapsPlayer.getWinnings();
                console.println("Winner Winner, Chicken Dinner! " );
                continuePlay = false;

            } else if (sum == 2 || sum == 3 || sum == 12) {
                console.println("You've Crapped out!!");
                continuePlay = false;

            } else {
                targetScore = sum;
                console.println( "Your Target Score is " + targetScore);

            }
        } else {
            if (sum == 7) {
                console.println("You've Crapped out!!");
                continuePlay = false;
            } else if (sum == targetScore) {

                crapsPlayer.getWinnings();

                console.println("Winner Winner, Chicken Dinner! " );
                console.println("Congratulations, your payout is $" + crapsPlayer.getPot());

                continuePlay = false;
            }


        }
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
    public void displayResults() {


    }


    public void distributeWinnings() {
    }
}
