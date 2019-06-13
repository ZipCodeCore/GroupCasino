package io.zipcoder.casino.games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;

public class Craps extends Games implements GamblerGameInterface {


    private CrapsPlayer crapsPlayer = new CrapsPlayer();
    private Player player;
    private Boolean isOn = false;
    private Integer onNumber;
    private Double firstLineBet;
    private Double secondLineBet;
    private Double otherBet;

    public Craps() {
    };

    public Craps(Player player) {
        this.player = player;
    }





    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Double num) {
        this.crapsPlayer.setAccount(num);
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

    public CrapsPlayer getCrapsPlayer() {
        return crapsPlayer;
    }

    public Double calcPayment(Double bet, Double odds) {
        return null;
    }

    @Override
    void nextTurn() {
    }



}
