package io.zipcoder.casino.CardGames;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> deckOfCards = new Stack<Card>();

    public Deck(int numberOfDecks){

        for(int index = 0; index < numberOfDecks; index++) {

            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deckOfCards.add(new Card(suit, rank));
                }
            }
        }
    }

    public Stack shuffleDeck(){
        Collections.shuffle(deckOfCards);

        return deckOfCards;
    }


    public void print(){

        System.out.println(shuffleDeck().toString());
        System.out.println(deckOfCards.size());
        System.out.println(drawCard());
        System.out.println(drawCard());
    }

    public void dealCards(int numberOfCards){

        for(int index = 0; index < numberOfCards; index++){

        }


    }


    public Card drawCard(){
        if (!deckOfCards.isEmpty()){
            Card drawnCard = deckOfCards.pop();
            return drawnCard;

        } else
            System.out.println("Deck is empty");

        return null;
    }

}




