package io.zipcoder.casino.games;

import io.zipcoder.casino.player.SlotsPlayer;

public class Slots extends Games implements GamblerGameInterface {
    Integer numOfLines;
    SlotsPlayer slotsPlayer = new SlotsPlayer();
    private Double currentBet;


    public Slots(){}

    @Override
    void nextTurn() {

    }

    @Override
    void endGame() {

    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

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

    public void updateAccount(Double num) {

    }
}
