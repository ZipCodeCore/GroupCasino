package io.zipcoder.casino.games;

import io.zipcoder.casino.player.RoulettePlayer;

public class Roulette extends Games implements GamblerGameInterface {
    String betType; //   red/back - odd / even / number
    RoulettePlayer roulettePlayer = new RoulettePlayer();
    private Double currentBet;



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
        return null;
    }

    public void updateAccount(Integer num) {
        //add or remove money from the balance
    }

    public Double getCurrentBet() {

        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double calcPayment(Double bet, Double odds) {

        return null;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

}
