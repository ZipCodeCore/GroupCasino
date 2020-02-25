package io.zipcoder.casino.Player;

import io.zipcoder.casino.CasinoClasses.Membership;

public class CrapsPlayer extends Player implements GamblerAttributes{

    String playerName = "";
    Integer balance = 0;
    Integer age;
    Membership playerAccount;

    public CrapsPlayer(Membership playerAccount){

        this.playerName = playerAccount.getName();
        this.balance = playerAccount.getBalance();
        this.age = playerAccount.getAge();
        this.playerAccount = playerAccount;
    }

}
