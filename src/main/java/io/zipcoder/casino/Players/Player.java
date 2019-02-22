package io.zipcoder.casino.Players;

import io.zipcoder.casino.Guest;

public abstract class Player{
    private Guest guest;

    public void addFunds(Double amount){
        guest.addFunds(amount);
    }
    public void removeFunds(Double amount){
        guest.removeFunds(amount);
    }
    public Double getAccountBalance(){
        return guest.getAccountBalance();
    }
}
