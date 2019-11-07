package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GoFishNPC extends GoFishPlayer{

    public GoFishNPC (Player opponent) {
        super(opponent);
    }

    public String chooseCard(CardSet hand) {
        Random rng = new Random();
        ArrayList<Card> cards = hand.getCards();
        Card chosenCard = cards.get(rng.nextInt(cards.size()));
        return chosenCard.getRank();
    }
}
