package io.zipcoder.casino.player;

import io.zipcoder.casino.gameTools.Dice;
import io.zipcoder.casino.gameTools.Card;



public class CrapsPlayer extends Player implements GamblerInterface {
    public Player player;

    public CrapsPlayer(){};

    public CrapsPlayer(Player player){
        this.player = player;
    }

    public Integer roll() {
        Dice dice = new Dice();

        return dice.rollDice();
    }

    public void bet(Double bet) {

    }

    public void betType(String betType) {

    }

    public void cashout() {
        //leave game mid way!
        player.setPlaying(false);
    }

    public void displayAccoutBal() {
        System.out.println(player.getAccount());
    }
}
