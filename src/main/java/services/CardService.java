package services;

import models.gamecomponents.DeckOfCards;
import models.gamecomponents.Card;

import java.util.Stack;

public class CardService {

    DeckOfCards deckOfCards = new DeckOfCards();// Declare an instance of Deck of Cards.  Make sure Deck of Cards is a collection type Stack


    public DeckOfCards getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(Stack<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public DeckOfCards shuffle(DeckOfCards deck) {
        return Collections.shuffle(deck);
    }

    public Card cardOnTop(DeckOfCards deckOfCards) {
        return deckOfCards.pop();    // pop() will not work unless deckOfCards is of collection type Stack
    }
}
