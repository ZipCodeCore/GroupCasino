import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Decks {
    private ArrayList<Card> cards;

    public Decks(Integer numberOfDecks) {
        this.cards = new ArrayList<>(numberOfDecks*52);
        ArrayList<Card> deckOfCards = buildOneDeck();
        for (int i = 0; i < numberOfDecks; i++) cards.addAll(deckOfCards);
    }

    protected  ArrayList<Card> getCards() {
        return cards;
    }

    protected ArrayList<Card> buildOneDeck() {
        ArrayList<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) deck.add(new Card(-1, rank, suit));
        }
        return deck;
    }
}
