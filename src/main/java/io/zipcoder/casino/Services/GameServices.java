package io.zipcoder.casino.Services;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Player;

public class GameServices implements GamblingGame {

    // need to instantiate this in each game. Call it via gameServices.wager(), etc.

    public boolean wager(double amount, Player player) {
        double balance = player.getBalance();
        if (amount > balance) {
            return false;
        } else {
            player.setBalance(balance - amount);
            return true;
        }
    }

    public void payOut(double amount, Player player) {
        player.setBalance(player.getBalance() + amount);
    }

    public void deposit(double amount, Player player) {
        payOut(amount, player);
        player.setInitialBalance(player.getInitialBalance() + amount);
    }

    public Double withdraw(Player player) {
        double withdrawal = player.getBalance();
        if (wager(player.getBalance(), player)) {
            return withdrawal;
        } else {
            return null;
        }
    }
}
