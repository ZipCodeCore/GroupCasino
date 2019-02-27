package io.zipcoder.casino.blackjack;

import java.util.ArrayList;
import java.util.List;
;
import java.util.Stack;

public class Deck {
    //create a field of type List<Card> named cards
    private Stack<Card> deckOfCards;
    private int numberOfCards;
    private String faceType;
    private Card cards[];

    //create an empty constructor
    //in the body of the constructor initialize
    // the list to a new ArrayList<Card>
    // call the method generate to generate a deck of card

    public Deck() {
        List<Card> deckOfCards = new ArrayList<Card>();
    }
        // create a method named generate that takes in no params
        // and return nothing
        // this method will generate all 52 cards
    public void generate() {

        this.cards = new Card[52];
        for (int i = 0; i < cards.length ; i++) {

        }
        }
        // create a method named add that takes a
        // card and add it to the list cards
        // it does not return anything
    public void addCardToHand(Card card) {
        deckOfCards.add(card);

    }
        //create a method named draw that takes in
        //no param and return a card
        //the method will remove a card from the list
        // at index 0
        public Card draw() {
            deckOfCards.remove(0);
            return draw();
        }
        //create a method called shuffle
        //no return, no param
        // it will call the method shuffle from
        // the Collections class
    public void shuffle(){

    }
}