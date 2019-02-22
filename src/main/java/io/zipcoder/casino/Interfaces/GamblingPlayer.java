package io.zipcoder.casino.Interfaces;

public interface GamblingPlayer {

    public Double takePlayersMoney(Double amount);
    public Double givePlayerMoney(Double amount);
    public Double checkCurrentBalance();

}
