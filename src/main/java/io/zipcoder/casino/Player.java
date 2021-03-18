package io.zipcoder.casino;

public class Player{

    private String name;
    private Double wallet;
    private Double currentBet = 0.0;

    public Player(String name, Double initialDeposit) {
        this.name = name;
        this.wallet = initialDeposit;
    }


    public String getName() {
        return name;
    }


    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double deposit) {
        this.wallet = wallet + deposit;
    }


    public Double makeBet(Double betAmount) {
        currentBet += betAmount;
        wallet = wallet - betAmount;
        return currentBet;
    }

    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

}
