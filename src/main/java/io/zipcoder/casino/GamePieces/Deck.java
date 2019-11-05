package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.*;

public class Deck {
    Console console = new Console(System.in,System.out);
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        this.deck = deck;
        for(int i =0; i < 13; i++){
            CardValue value = CardValue.values()[i];
            for(int j= 0; j < 4;j++){
                Card card= new Card(value, Suit.values()[j]);
                this.deck.add(card);
            }
        }
    }



    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card draw(){
        Card drawnCard = deck.remove(0);

        console.println(drawnCard.toString());
        return drawnCard;
    }
}
