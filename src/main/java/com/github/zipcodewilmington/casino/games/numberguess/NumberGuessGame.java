package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;


/**
 * Authors: Zack, Nathan
 */

public class NumberGuessGame implements GameInterface {
    private Integer maxNumber;
    private PlayerInterface currentPlayer;
    private Integer betAmount;
    private Integer multiplier;
    private Integer guessNumber;
    private int randomNumber;
    private Scanner scanner = new Scanner(System.in);

    public NumberGuessGame(){
        this.maxNumber = 20;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //print welcome
        printWelcome();


        Boolean quitGame = false;
        while(!quitGame) {

            //print instruction for game
            printInstructions();
            System.out.println("Guess the right number between 0 and 20 to double your bets!\n\n      But WAIT!  Feeling lucky??\n\nIncrease the difficulty and increase your earnings!");

            //print difficulty levels and ask user to choose
            setDifficultyLevel();
            //set multiplier
            setMultiplier(maxNumber);
            //print player's current account balance
            System.out.println("Your current account balance is:   $" + this.currentPlayer.getArcadeAccount().getAccountBalance());
            //ask for a bet amount
            takeBet();
            //subtract bet amount from player's account
            subtractBetFromBalance(betAmount);
            //ask player to chose number from 0 to difficulty lvl
            takeGuess();
            //generate actual number
            pickRandomNumber();
            //compare difference
            Integer guessRange = getGuessRange(guessNumber, randomNumber);
            //calculate amount player won
            Integer payout = calculatePayout(multiplier, guessRange, betAmount);
            //print winnings
            System.out.println("You won:   $"+payout);
            //add winnings to player's account
            addMoneyToBalance(currentPlayer,payout);
            //ask if player wants to play again
            System.out.println("\u001B[36mWould you like to play again?\n" +
                    "1. Yes   2. No");
            Integer input = scanner.nextInt();
            if(input == 2){
                quitGame = true;
            }
        }
    }

    private void printInstructions() {
    }

    private Integer calculatePayout(Integer multiplier, Integer guessRange,Integer betAmount) {
        Integer payout;
        Double percent = 0.0;
        Double multiplierAsDouble = multiplier.doubleValue();
        if (guessRange.equals(0)){
            percent = multiplierAsDouble * 1;
        } else if(guessRange <= 10){
            percent = multiplierAsDouble * 0.8;
        } else if(guessRange <= 25){
            percent = multiplierAsDouble * 0.6;
        } else if(guessRange <= 35){
            percent = multiplierAsDouble * 0.4;
        } else if(guessRange >= 36){
            percent = multiplierAsDouble * 0.0;
        }

        Double payoutAsDouble = percent * betAmount;
        payout = payoutAsDouble.intValue();

        return payout;
    }

    private void pickRandomNumber() {
        Integer random = (int) ((Math.random() * (maxNumber - 0)) + 0);
        this.randomNumber = random;

    }

    private void takeGuess() {
        System.out.println("Pick a number between 0 and " + maxNumber);
        this.guessNumber = scanner.nextInt();

    }

    private void takeBet() {
        System.out.println("How much do you want to bet?");
        this.betAmount = scanner.nextInt();
    }

    private void printWelcome() {
        //TODO
        System.out.println("WELCOME WELCOME WELCOME!!!!!");
    }

    private void setDifficultyLevel() {
        System.out.println("1. Start max at 20 and go for double.\n" +
                "2. Change max to 30 and Triple your bets!\n" +
                "3. Change max to 40 and QUADRUPLE your bets! OH MY!\n" +
                "4. Change max to 50! SEND IT! TO THE MOON!");
        setMaxNumber(scanner.nextInt());
    }


    public Integer getGuessRange(Integer guessedNumber, Integer actualNumber){
        return guessRangePercentage(Math.abs(guessedNumber - actualNumber));
    }

    public Integer guessRangePercentage(Integer range){
        Double percent =  ((range.doubleValue() / this.maxNumber) * 100);
        return percent.intValue();
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }
    public void setMaxNumber(Integer max){
        this.maxNumber = max;
    }

    public void setMultiplier(Integer difficultyLvl) {
        switch(difficultyLvl){
            case 20:
                this.multiplier = 2;
            case 30:
                this.multiplier = 3;
            case 40:
                this.multiplier = 4;
            case 50:
                this.multiplier = 5;
        }
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {

    }


    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        this.currentPlayer.getArcadeAccount().alterAccountBalance((betAmount * -1));
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }
}