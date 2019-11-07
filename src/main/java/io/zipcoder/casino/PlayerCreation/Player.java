package io.zipcoder.casino.PlayerCreation;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Integer balance;
    private ArrayList<String> gameHistory;
    Console console = new Console(System.in, System.out);

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

    public void placeBet(Integer amount) {
        this.balance -= amount;
    }

    public void changeBalance(Integer amount) {
        this.balance += amount;
    }

    public ArrayList<String> getHistory() {
        return gameHistory;
    }

    public void addHistory(String results) {
        gameHistory.add(results);
    }

    public String printHistory() {
        StringBuilder sb = new StringBuilder();
        Integer historyCounter = 0;
        for(String history : gameHistory){
            sb.append(gameHistory.get(0));
            sb.append("\n");
        }
        return sb.toString();
    }
}
