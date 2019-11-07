package io.zipcoder.casino.Player;

//Class Starts
public class Player {

    protected String ID;
    protected String pwd;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    protected double balance;

    public Player(String ID, String password){
        this.ID = ID;
        this.pwd = password;
        this.balance = 0.0;
    }

    public void addAmount(double balance) {
        this.balance += balance;
    }


}
