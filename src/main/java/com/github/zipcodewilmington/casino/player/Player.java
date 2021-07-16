package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class Player {
    public String name;
    public static int balance;
    CasinoAccount casinoAccount;

    public Player(String name) {
        this.name = name;
        this.balance = 1000;
    }

    public Player() {
    }

    public String getPlayerName() {
        return casinoAccount.getAccountName();
    }

    public static int getPlayerBalance() {
        return balance;
    }

    public void setPlayerBalance(int balance) {
        this.balance = balance;
    }
}

//blackjackPlayer.getArcadeAccount.getBalance();
//PlayerInterface playerBlackJack;

//return casinoAccount
//setArcadeAccount(CasinoAccount casinoAccount) { this.casinoAccount = casinoAccount; }