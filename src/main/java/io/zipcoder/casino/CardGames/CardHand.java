package io.zipcoder.casino.CardGames;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CardHand {

    ArrayList<Card> userHand = new ArrayList<Card>();


    public CardHand(ArrayList<Card> dealtCards){

        userHand.addAll(dealtCards);
    }

    public String displayHand() {

        userHand.sort(Comparator.comparing(Card::getRank));

        return userHand.toString().replace(",", "")
                .replace("[", " ").replace("]", "");
    }

}
