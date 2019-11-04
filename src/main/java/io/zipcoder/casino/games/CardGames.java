package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.Deck;

abstract class CardGames extends Games {
    Deck deck;

    public CardGames() {
        this.deck = new Deck();
    }

    public Card dealCard () {
        return null;
    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }
}
//////
