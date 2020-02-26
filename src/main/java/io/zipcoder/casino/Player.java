package io.zipcoder.casino;

public abstract class Player
{
    public String name;
    public Integer gamblingWallet;

    public Player(String name, Integer gamblingWallet)
    {
        this.name = name;
        this.gamblingWallet = gamblingWallet;
    }

}
