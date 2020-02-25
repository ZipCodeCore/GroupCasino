package io.zipcoder.casino;

import io.zipcoder.casino.card.Card;
import io.zipcoder.casino.card.Deck;
import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;
import java.util.logging.Logger;


public class DeckTest {

    private static final Logger LOGGER = Logger.getLogger(DeckTest.class.getName());


    @Test
    public void testCreateDeck(){
        Deck deck = new Deck();

        Integer expected = 52;

        deck.createDeck();
        Integer actual = deck.getDeck().size();

        Assert.assertEquals(expected, actual);
        LOGGER.info("\n" + actual);
    }

}
