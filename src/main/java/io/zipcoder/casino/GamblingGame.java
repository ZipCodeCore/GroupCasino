package io.zipcoder.casino;

public interface GamblingGame {

    public String startGame();

    public Double setPurse(Double betAmount);

    public Double calculateReward();

    public Double calculateLoss();

    public String endGame();


}
