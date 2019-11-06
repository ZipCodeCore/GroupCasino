package services;

import models.gamecomponents.Dice;
import models.hands.KlondikeHand;
import java.util.Random;

public class DiceService {

    public void createDie(){
        Dice dice = new Dice();
    }

    public Integer rollDice(Dice dice) {
        Random randomNum = new Random();
        Integer valueOfDice =  1 + randomNum.nextInt(6);
        return valueOfDice;
    }

    public void addToHand(Dice dice, Integer valueOfDice, KlondikeHand hand) {
        hand.addToHand(dice, valueOfDice);
    }

}
