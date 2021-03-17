package io.zipcoder.casino;

public interface GamblingGame {

    public String startGame();

    public String acceptBetFrom();

    public String calculateReward();

    public String calculateLoss();

    public String endGame();


}
