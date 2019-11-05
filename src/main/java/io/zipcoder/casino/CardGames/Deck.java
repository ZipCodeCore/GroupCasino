package io.zipcoder.casino.CardGames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private ArrayList<Card> deckOfCardsTemp = new ArrayList<Card>();
    private Stack<Card> deckOfCards = new Stack<Card>();

    public Deck(int numberOfDecks){

        for(int index = 0; index < numberOfDecks; index++) {

            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deckOfCardsTemp.add(new Card(suit, rank));
                }
            }
        }
    }

    public Stack shuffleDeck(){
        Collections.shuffle(deckOfCardsTemp);

        deckOfCards.addAll(deckOfCardsTemp);

        return deckOfCards;
    }


    public void print(){
       // for(Card card : deckOfCards)
            //System.out.println(card.toString());

        //System.out.println(shuffleDeck().toString());
        //System.out.println(deckOfCards.size());
    }

    public void dealCards(int numberOfCards){

    }


    /*public Card drawCard(){
        if (deckOfCards.size() > 0){
            Card drawnCard = deckOfCards.get(deckOfCards.size() - 1);
            deckOfCards.remove(deckOfCards.size() - 1);
            return drawnCard;
        } else
            System.out.println("Deck is empty");

        return null;
    }*/

}




