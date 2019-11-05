package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameMenu;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;


public class HighAndLow implements Game{
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    private Player currentPlayer;
    private boolean running;

    public void runHighOrLow(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    public Integer firstRoll(){
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The first result of the first roll is %d", sumOfRolls);
        return sumOfRolls;
    }

    public Integer doYouWantToBet(){
        console.println("Do you want to bet High or Low?");
        console.println("(1) - High");
        console.println("(2) - Low");
        Integer playerBet = console.getIntegerInput(":");
        return playerBet;
    }

    public Integer secondRoll(){
        Integer roll = dice.rollDice(1);
        console.println(dice.diceArt(roll));
        Integer roll2 = dice.rollDice(1);
        console.println(dice.diceArt(roll2));
        Integer sumOfRolls = roll + roll2;
        console.println("The result of the second roll is %d", sumOfRolls);
        return sumOfRolls;
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

    public void showRules(){
        console.println("A simple game for meager winnings. At High and Low,\n" +
                "you'll only be able to bet $1. Our pit boss will roll two dice and\n" +
                "present to you the sum of the rolls and the chance to bet High or Low.\n" +
                "If you believe the sum of the second roll will be higher, bet high.\n" +
                "Likewise, if you believe the sum of the second roll will be lower, bet low.\n" +
                "Pray for an early 2,3,11, or 12 because they are the easiest to predict again.\n" +
                "Hence why you're only allowed to be $1.\n\n" +
                "What? We're not in the business of giving away money.");
    }

    @Override
    public void approachTable(Player currentPlayer) {
        console.println("Small winnings at the High and Low table.\n" +
                "Desperation lies deep in the eyes of those " +
                "looking to buy back their losses. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Read the rules");
        console.println("(3) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while(running) {
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    showRules();
                    approachTable(currentPlayer);
                    running = false;
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    @Override
    public void runGame(Player currentPlayer) {
        while(running)
            console.println("Welcome to High and Low!\n");
            Integer firstRoll = firstRoll();
            Integer highOrLowBet = doYouWantToBet();
            Integer secondRoll = secondRoll();

            winOrLose(firstRoll, secondRoll, highOrLowBet);
            exitGame(currentPlayer);

    }

    @Override
    public void exitGame(Player currentPlayer) {
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runHighOrLow(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }
}