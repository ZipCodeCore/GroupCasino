package io.zipcoder.casino;

public interface GamblingGame extends Game {

    void wager(double amount);

    void payOut(double amount);

}
