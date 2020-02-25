package io.zipcoder.casino.Player;

import io.zipcoder.casino.CasinoClasses.Membership;

public class OU7Player extends Player{
    String playerName = "";
    Integer balance = 0;
    Integer age;
    Membership playerAccount;

    public OU7Player(Membership playerAccount){
        this.playerName = playerAccount.getName();
        this.balance = playerAccount.getBalance();
        this.age = playerAccount.getAge();
        this.playerAccount = playerAccount;
    }
}
