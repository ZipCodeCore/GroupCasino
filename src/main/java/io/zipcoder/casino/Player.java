package io.zipcoder.casino;

import io.zipcoder.casino.Interfaces.GamblingPlayer;

public class Player implements GamblingPlayer {

    private String firstName;
    private String lastName;
    private int age;
    private double balance;
    private double initialBalance;
    private double winnings;

    public Player(String firstName, String lastName, int age, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.initialBalance = this.balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
