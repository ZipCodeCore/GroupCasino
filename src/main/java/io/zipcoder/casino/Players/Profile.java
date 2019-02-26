package io.zipcoder.casino.Players;

public class Profile {
    private String name;
    private boolean gambler;
    private Integer balance;

    public Profile(String name, boolean canGamble) {
        this.name = name;
        this.gambler = canGamble;
        this.balance = 500;
    }

    public Profile() {
        this.name = "Dealer";
        this.gambler = true;
        this.balance = 1000;
    }

    public String getName() {
        return name;
    }

    public boolean isGambler() {
        return gambler;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
