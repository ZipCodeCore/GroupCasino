package io.zipcoder.casino.Interfaces;

import io.zipcoder.casino.Player;

public interface GamblingGame {

    boolean getWager(double amount, Player player);

    void payOut(double amount, Player player);

}
