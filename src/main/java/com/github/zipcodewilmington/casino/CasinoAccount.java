package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {

    String password;
    String accountName;
    Map<String, String> account;
    Integer accountBalance = 0;

    public CasinoAccount(String password, String accountName) {
        this.password = password;
        this.accountName = accountName;
    }

    public Map<String, String> createAccount() {
        Map<String, String> account = new HashMap<>();
        account.put(password, accountName);
        return account;
    }

    public String getAccount() {
        return account.get(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String playerName) {
        this.accountName = playerName;
    }

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