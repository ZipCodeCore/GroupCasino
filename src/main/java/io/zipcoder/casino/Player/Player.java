package io.zipcoder.casino.Player;

import io.zipcoder.casino.CardGames.CardHand;

public class Player {

    protected String ID;
    protected String pwd;
    protected double balance;


    public void addAmount(double balance) {
        this.balance += balance;
    }

    public Player(String ID, String password){
        this.ID = ID;
        this.pwd = password;
        this.balance = 0.0;
    }


}
