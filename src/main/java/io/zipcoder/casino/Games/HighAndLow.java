package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class HighAndLow implements Game, GamblingGame{
    private Console console = new Console(System.in, System.out);
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private Dice dice = new Dice();
    private Integer totalBetValue = 0;
    private Player currentPlayer;
    private boolean running = true;
    private boolean didYouBet = true;

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

    public Integer highOrLowBet(){
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
        if((firstRoll > secondRoll && highOrLowBet == 2) || (firstRoll < secondRoll && highOrLowBet == 1)){
            console.println("Congratulations! You've won $%d.00!", totalBetValue);
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You won $%d.00 at High and Low! ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dtf.format(now));
            currentPlayer.changBalance(totalBetValue);
        } else {
            console.println(("Sorry, you've lost. Try again soon!"));
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
            currentPlayer.addHistory(addHistory + dtf.format(now));
        }
    }

    public void showRules(){
        console.println("\n\nA simple game for meager winnings. At High and Low,\n" +
                "you'll only be able to bet $10. Simply roll two dice, and our pit boss will\n" +
                "present to you the sum of the rolls and the chance to bet High or Low.\n" +
                "If you believe the sum of the second roll will be higher, bet high.\n" +
                "Likewise, if you believe the sum of the second roll will be lower, bet low.\n" +
                "Pray for an early 2,3,11, or 12 because they are the easiest to predict against.\n" +
                "Hence why you're only allowed to be $10.\n\n" +
                "What? We're not in the business of giving away money.\n\n");
    }

    @Override
    public void approachTable(Player currentPlayer) {
        console.println("The High and Low table... reputed as the lowest of casino games.\n" +
                "Diminishing returns for the despairing and unfortunate who have fallen too hard on their bad luck.\n" +
                "Desperation permeates from the eyes of those gathered around the moldy table,\n" +
                "gravely placing their hopes to win back ANYTHING from their losses in this last-ditch game of chance.\n" +
                "Have they really sunk that low to be playing this game?\n" +
                "\"Have I?\" you think to yourself as you approach the table.\n\nWhat would you like to do?\n\n");
        while(running) {
        console.println("(1) - Play the game");
        console.println("(2) - Read the rules");
        console.println("(3) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");

            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

    @Override
    public void runGame(Player currentPlayer) {
        while(running) {
            totalBetValue = 0;
            console.println("Welcome to High and Low, %s!\n", currentPlayer.getName());
            placeBet(currentPlayer);
            Integer firstRoll = firstRoll();
            if(didYouBet == true) {
                console.println("Again...");
                placeBet(currentPlayer);

            } else {
                console.println("Sorry, you did not bet the first roll.\n" +
                        "But we'll be nice and still let you guess.");
            }
            Integer highOrLowBet = highOrLowBet();
            Integer secondRoll = secondRoll();

            winOrLose(firstRoll, secondRoll, highOrLowBet);
            exitGame(currentPlayer);
        }
    }

    @Override
    public void exitGame(Player currentPlayer) {
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }

    @Override
    public void placeBet(Player currentPlayer) {
        console.println("At High and Low, you can only bet $10.\nWould you like to bet $10?");
        console.println("(1) - Yes, bet $10.");
        console.println("(2) - No, let it ride.");
        Integer playerInput = console.getIntegerInput(":");
        if(playerInput == 1){
            currentPlayer.placeBet(10);
            totalBetValue += 10;
            didYouBet = true;
        } else {
            didYouBet = false;
        }

    }

    @Override
    public void returnWinnings(Player currentPlayer) {

    }
}