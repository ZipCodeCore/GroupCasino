package io.zipcoder.casino;

public class Player {
    private String name;
    private double wallet;

    public Player(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet(){
        return wallet;
    }
}
