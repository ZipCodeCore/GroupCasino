package io.zipcoder.casino.games;

import io.zipcoder.casino.player.CrapsPlayer;

public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer = new CrapsPlayer();
    private Boolean isOn = false;
    private Integer onNumber;
    private Double firstLineBet;
    private Double secondLineBet;
    private Double otherBet;

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

    }

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

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public Integer getOnNumber() {
        return onNumber;
    }

    public void setOnNumber(Integer onNumber) {
        this.onNumber = onNumber;
    }

    public Double getFirstLineBet() {
        return firstLineBet;
    }

    public void setFirstLineBet(Double firstLineBet) {
        this.firstLineBet = firstLineBet;
    }

    public Double getSecondLineBet() {
        return secondLineBet;
    }

    public void setSecondLineBet(Double secondLineBet) {
        this.secondLineBet = secondLineBet;
    }

    public Double getOtherBet() {
        return otherBet;
    }

    public void setOtherBet(Double otherBet) {
        this.otherBet = otherBet;
    }


    public Double calcPayment(Double bet, Double odds) {
        return null;
    }

    public void updateAccount(Double num) {

    }
}
