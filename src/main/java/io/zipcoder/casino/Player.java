package io.zipcoder.casino;

public abstract class Player
{
    private String name;
    private Wallet gamblingWallet;

    public Player(String name, Wallet gamblingWallet)
    {
        this.name = name;
        this.gamblingWallet = gamblingWallet;
    }

}
