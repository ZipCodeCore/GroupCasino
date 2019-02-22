package io.zipcoder.casino.Players;

import io.zipcoder.casino.Guest;

public abstract class Player{
    private Guest guest;

    public void updateAccountBalance(Double amount){
        guest.updateAccountBalance(amount);
    }
    public Double getAccountBalance(){
        return guest.getAccountBalance();
    }
}
