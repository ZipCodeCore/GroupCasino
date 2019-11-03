package io.zipcoder.casino.GamePieces;

import java.util.ArrayList;
import java.util.*;

public class Deck {

    ArrayList<Card> deck = new ArrayList<>();

    public void createDeck(){
        for(Card card : deck){
            deck.add(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card draw(){

        return null;
    }
}
