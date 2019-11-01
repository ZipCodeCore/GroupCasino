package io.zipcoder.casino;

public interface GamblingGame extends Game {

    double getWager();

    void payOut(double amount);

}
