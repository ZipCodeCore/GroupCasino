package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGame extends GameObject {

    CardSet cardSet;
    ArrayList<Player> players;

    public CardSet getNewDeck(int numDecks) {
        return null;
    }
}
