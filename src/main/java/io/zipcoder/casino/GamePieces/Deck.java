package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.*;

public class Deck {
    Console console;
    ArrayList<Card> deck = new ArrayList<>();
    public  Deck(Console console){
        this.console = console;
    }
    public void createDeck(){
        for(Card card : deck){
            deck.add(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card draw(){
        Card drawCard = deck.remove(0);
        console.println(drawCard.toString());
        return drawCard;
    }
}
