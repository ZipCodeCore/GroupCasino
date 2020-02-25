package io.zipcoder.casino;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

public class DeckTest {

    private static final Logger LOGGER = Logger.getLogger(DeckTest.class.getName());
    @Test
    public void newDeckTest(){
        ArrayList<Card> deck = Deck.newDeck();
        Collections.sort(deck);

        for(Card card : deck){
            System.out.println(card);
        }
    }
}
