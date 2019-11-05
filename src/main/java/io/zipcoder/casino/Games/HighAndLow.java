package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameMenu;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;


public class HighAndLow {
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    private Player currentPlayer;
    private boolean running;

    public void runHighOrLow(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        while(running)

        console.println("Welcome to High and Low!\n");
        Integer firstRoll = firstRoll();
        Integer highOrLowBet = doYouWantToBet();
        Integer secondRoll = secondRoll();

        winOrLose(firstRoll, secondRoll, highOrLowBet);
        Integer playAgainInput = playAgain();
        playAgainOrMain(playAgainInput);
    }

    public Integer firstRoll(){
        Integer roll = dice.rollDice(2);
        console.println("The first result of the first roll is %d", roll);
        return roll;
    }

    public Integer doYouWantToBet(){
        console.println("Do you want to bet High or Low?");
        console.println("(1) - High");
        console.println("(2) - Low");
        Integer playerBet = console.getIntegerInput(":");
        return playerBet;
    }

    public Integer secondRoll(){
        Integer roll = dice.rollDice(2);
        console.println("The result of the second roll is %d", roll);
        return roll;
    }

    public void winOrLose(Integer firstRoll, Integer secondRoll, Integer highOrLowBet){
        if(firstRoll > secondRoll && highOrLowBet == 2){
            console.println("Congratulations! You've won!");
        } else if (firstRoll < secondRoll && highOrLowBet == 1){
            console.println("Congratulations! You've won!");
        } else {
            console.println(("Sorry, you've lost. Try again soon!"));
        }
    }

    public Integer playAgain(){
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public void playAgainOrMain(Integer playAgainInput){
        switch (playAgainInput){
            case 1:
                runHighOrLow(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }

}
