package io.zipcoder.casino.CardGames;

import java.util.ArrayList;

public class CardHand {

    ArrayList<Card> userHand = new ArrayList<Card>();

    public CardHand(ArrayList<Card> dealtCards){

        userHand.addAll(dealtCards);
    }

    public String displayHand(){
       return userHand.toString();
    }

    public void evaluateHand(){}

    public void addCardToHand(Card cardToAdd){

        userHand.add(cardToAdd);
    }


    public void removeCardFromHand(Card cardToRemove){

    }

    public void getCardFromDeck(int numberOfCards){


    }


}
