package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.RoulettePlayer;

import java.util.Random;
import java.util.Scanner;

public class Roulette extends Games implements GamblerGameInterface {
    String betType; //   red/back - odd / even / number
    private RoulettePlayer roulettePlayer;
    private Double currentBet;

    public Roulette(RoulettePlayer roulettePlayer) {
        this.roulettePlayer = roulettePlayer;
    }

    @Override
    void nextTurn() {

    }

    @Override
    void endGame() {
        // end game and go back to main menu

    }

    @Override
    boolean getResults() {
        // determine win or loose
        return false;
    }

    @Override
    public void display(String output) {

        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        //calculate payment amount to be payed based on the position
        return bet + odds * bet;
    }

    public void updateAccount(Integer num) {
        //add or remove money from the balance
        this.roulettePlayer.setAccount((double)(num));
    }

    public Double getCurrentBet() {

        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double calcPayment(Double bet, Double odds) {
        //no of odds aganist = n(1 + odds)
        return bet + odds * bet;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

    public void play() {

        // Get Bet Amount
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bet Amount : ");
        sc.nextInt();

        // Set Current Bet on a bettable place like 0,1,2,3,... or Even/Odd or Red/Black or 1st/2nd/3rd 12, etc


        // Calculate the odds based on the position.

        // Deduct the current bet from the account balance

        // Generate a random number where the ball is going to fall - Range should be 0 to 36

        // Identify if the position of bet is winning position

        // Update the Account Balance

    }

}
