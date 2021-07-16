package com.github.zipcodewilmington.casino;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    static String password;
    static String accountName;
    static Map<String, String> account;
    int accountBalance = 1000;

    public CasinoAccount(String password, String accountName) {
        this.password = password;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

//    public Map<String, String> createAccount() {
//        Map<String, String> account = new HashMap<>();
//        account.put(password, accountName);
//        return account;
//    }

    public static String getAccount() {
        return account.get(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getAccountName() {
        return accountName;
    }

    public void setAccountName(String playerName) {
        this.accountName = playerName;
    }

    public int getPlayerBalance() { return accountBalance; }

}
//    String password;
//    Player newPlayer;
//
//    public CasinoAccount(String password, Player newPlayer) {
//        this.password = password;
//        this.newPlayer = newPlayer;
//    }
//
//    public void createNewPlayer() {
//        Map<String, Player> accounts = new HashMap<>();
//        accounts.put(password, newPlayer);
//    }