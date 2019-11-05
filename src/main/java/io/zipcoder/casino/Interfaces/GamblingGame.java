package io.zipcoder.casino.Interfaces;

import io.zipcoder.casino.Player;

public interface GamblingGame {

    boolean wager(double amount, Player player);

    void payOut(double amount, Player player);

}
