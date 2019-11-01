package io.zipcoder.casino.Interfaces;

public interface GamblingGame extends Game {

    double getWager();

    void payOut(double amount);

}
