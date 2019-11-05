package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Integer balance;
    private ArrayList<String> gameHistory;

    public Player(String name, Integer initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.gameHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void placeBet(Integer amount) {this.balance -= amount;}

    public void changeBalance(Integer amount) {
        this.balance += amount;
    }

    public ArrayList<String> getHistory(){
        return gameHistory;
    }

    public void addHistory(String results){
        gameHistory.add(results);
    }

}
