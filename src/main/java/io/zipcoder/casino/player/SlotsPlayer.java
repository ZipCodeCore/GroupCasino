package io.zipcoder.casino.player;

public class SlotsPlayer extends Player implements GamblerInterface {

    public  Player player;


    public SlotsPlayer(){

    }
    public SlotsPlayer(Player player){
     this.player = player;
    }


    public void bet(Double bet) {

    }

    public void betType (String betType) {

    }

    public void cashout() {

    }

    @Override
    public Double getAccount() {
        return super.getAccount();
    }


    public void displayAccoutBal() {

    }
}
