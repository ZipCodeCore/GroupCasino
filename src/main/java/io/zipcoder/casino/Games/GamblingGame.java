package io.zipcoder.casino.Games;

import io.zipcoder.casino.Player;

public interface GamblingGame {

    public boolean wager(double amount, Player player);

    public void payOut(double amount, Player player);

    //public void collectMoney();

}
