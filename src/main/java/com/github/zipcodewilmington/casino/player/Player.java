package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class Player implements PlayerInterface {
    private String name;
    private int balance;

    public Player(String name) {
        this.name = name;
        this.balance = 1000;
    }

    public Player() {
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public int getPlayerBalance() {
        return balance;
    }

    public void setPlayerBalance(int balance) {
        this.balance = balance;
    }


    public CasinoAccount getArcadeAccount() {
        return null;
    }

    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
