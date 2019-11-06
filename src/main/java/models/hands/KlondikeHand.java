package models.hands;

import models.gamecomponents.Dice;

import java.util.ArrayList;
import java.util.TreeMap;

public class KlondikeHand extends Hand {
    String typeOfHand;
    TreeMap<Dice, Integer> diceHand;

    public KlondikeHand(Dice dice, Integer diceValue) {
        this.diceHand = new TreeMap<Dice, Integer>();
    }

    public String setTypeOfHand() {
        return null;
    }

    public void addToHand(Dice dice, Integer diceValue) {
        this.diceHand.put(dice, diceValue);
    }



}
