package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.*;

public class Deck {

    Console console = new Console(System.in,System.out);
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        this.deck = deck;
        for(int i =1; i <= 13; i++){
            CardValue value = CardValue.values()[i];
            for(int j= 0; j < 4;j++){
                Card card= new Card(value, Suit.values()[j]);
                this.deck.add(card);
            }

        }
    }

    public Integer cardsLeft() {
        return deck.size();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card draw(){


        Card drawCard = deck.remove(0);

        return drawCard;

    }
}
