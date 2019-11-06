package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;
import models.hands.KlondikeHand;

public class KlondikePlayer extends Player implements GamblingPlayer {
     Player klondikePlayer;
     Dice dice=new Dice();
     int valueOfDice;
     KlondikeHand hand = new KlondikeHand(dice, valueOfDice);

    public KlondikePlayer(Player player) {
        this.klondikePlayer = player;
    }

    public Double placeBet() {
        return null;
    }

    public Integer rollDice(Dice dice){
        return null;
    }


}
