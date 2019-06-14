package io.zipcoder.casino.player;

import java.util.Random;

public class RoulettePlayer extends Player implements GamblerInterface {


    public RoulettePlayer(String name, Double account) {
        super(name, account);
    }

    public void bet(Double bet) {

    }

    public void betType (String betType) {

    }

    public void cashout() {
        System.out.println("Your balance has been cashed" +this.getAccount());

    }

    public void displayAccoutBal() {

    }

    // TODO - Create method for updating current Balance - Arg - int
    // Get current balance using getAccount()
    // Add the argument to currentBalance
    // set the balance using setAccount
}
