package services;

import models.gamecomponents.Card;

import java.util.ArrayList;

public class CardService {

    public Card takeTopCard(ArrayList<Card> deckOfCards) {

        // Find the top card in a deck of cards
        Card card = deckOfCards.get(deckOfCards.size() - 1);
        // Removes card from the top
        deckOfCards.remove(card);
        // Returns that card to be called by the Hand that a play/dealer may hold
        return card;
    }

}