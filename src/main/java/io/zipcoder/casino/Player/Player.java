package io.zipcoder.casino.Player;

import io.zipcoder.casino.CasinoClasses.Membership;

public abstract class Player {
    String playerName = "";
    Integer balance = 0;
    Integer age;
    Membership player;

    public Integer win(Integer amount){
        Integer amountWon =0;

        return amountWon;
    }

    public Integer lose(Integer amount){
        Integer amountLost = 0;

        return amountLost;
    }
}
