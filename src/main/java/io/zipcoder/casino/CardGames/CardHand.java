package io.zipcoder.casino.CardGames;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;

public class CardHand {

    ArrayList<Card> userHand = new ArrayList<Card>();

    public CardHand(ArrayList<Card> dealtCards){

        userHand.addAll(dealtCards);
    }

    public String displayHand(){
        //ollections.sort(userHand); TODO - do this later
       return userHand.toString();
    }

    public boolean evaluateHand(String card){

        return userHand.contains(card);
    }

    public void addCardToHand(Card cardToAdd){

        userHand.add(cardToAdd);
    }


    public void removeCardFromHand(Card cardToRemove){

    }

    public void getCardFromDeck(int numberOfCards){


    }


}
