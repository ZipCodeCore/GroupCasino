package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    String username;
    String password;
    Integer age;
    Integer balance;

    public CasinoAccount(String username, String password, Integer age, Integer balance) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.balance = balance;
    }

    public CasinoAccount() {

    }

    public String getUsername() {
        return username;
    }

    public void resetUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void resetPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void ageIncreased() {
        age++;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void addToBalance(Integer amountToAdd) {
        balance += amountToAdd;
    }

    public void reduceBalance(Integer amountToReduce) {
        balance -= amountToReduce;
    }
}
