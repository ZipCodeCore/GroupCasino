package io.zipcoder.casino;

public interface GamblingGame extends Game {
    void takeBet(double amount);

    double payout();

    void play();
}
