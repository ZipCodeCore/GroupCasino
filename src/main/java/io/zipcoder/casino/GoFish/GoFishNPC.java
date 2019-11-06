package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GoFishNPC extends GoFishPlayer{

    private Player opponent;


    public GoFishNPC (Player opponent) {
        super(opponent);

    }

    public Player getPlayer(){
        return opponent;
    }

    public String chooseCard(CardSet hand) {
        // needs to be fixed - choose a random card from player's hand
        Random rng = new Random();
        ArrayList<Card> cardPicker = new ArrayList<>();
        Set<Card> cardFilter = new TreeSet<>();
        for (Card i : hand.getCards())
            cardFilter.add(i);
        cardPicker.addAll(cardFilter);
        String pickedCard = cardPicker.get(rng.nextInt(cardPicker.size())).getRank();
        //return pickedCard;
        return "K";
    }


}
