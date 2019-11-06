package services;

import models.gamecomponents.Card;
import models.gamecomponents.DeckOfCards;

import java.util.Collections;

public class CardService {

    DeckOfCards deckOfCards = new DeckOfCards();// Declare an instance of Deck of Cards.  Make sure Deck of Cards is a collection type Stack


    public DeckOfCards getDeckOfCards() {
        return deckOfCards.;
    }

    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void shuffle(DeckOfCards deck) {
        Collections.shuffle(deck);
    }

    public Card cardOnTop(DeckOfCards deckOfCards) {
        return deckOfCards.pop();    // pop() will not work unless deckOfCards is of collection type Stack
    }

}
