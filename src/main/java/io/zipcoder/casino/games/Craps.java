package io.zipcoder.casino.games;

import io.zipcoder.casino.player.CrapsPlayer;

public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer = new CrapsPlayer();
    private Boolean isOn = false;
    private Integer onNumber;
    private Integer firstLineBet;
    private Integer secondLineBet;
    private Integer otherBet;

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

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

    public Integer getFirstLineBet() {
        return firstLineBet;
    }

    public void setFirstLineBet(Integer firstLineBet) {
        this.firstLineBet = firstLineBet;
    }

    public Integer getSecondLineBet() {
        return secondLineBet;
    }

    public void setSecondLineBet(Integer secondLineBet) {
        this.secondLineBet = secondLineBet;
    }

    public Integer getOtherBet() {
        return otherBet;
    }

    public void setOtherBet(Integer otherBet) {
        this.otherBet = otherBet;
    }




}
