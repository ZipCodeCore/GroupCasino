package io.zipcoder.casino.Player;

import io.zipcoder.casino.CardGames.CardHand;

public class Player {

    String ID;
    String pwd;
    double balance;
    public CardHand cardHand;



    public Player(String ID, String password){
        this.ID = ID;
        this.pwd = password;
        this.balance = 0.0;
        //this.cardHand = new CardHand();
    }


}
