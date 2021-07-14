package com.github.zipcodewilmington.casino.player;

public class Player {
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

}
