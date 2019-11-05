package io.zipcoder.casino;

import java.util.ArrayList;

public class Player {

    private String name;
    private Integer balance;
    private ArrayList<String> gameHistory;

    public Player(String name, Integer initialBalance) {
        this.name = name;
        this.balance = initialBalance;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void changBalance(Integer amount) {
        this.balance += amount;
    }

}
