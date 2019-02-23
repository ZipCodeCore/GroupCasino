package io.zipcoder.casino.Models;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Models.Card.Suit.HEARTS;
import static io.zipcoder.casino.Models.Card.Suit.SPADES;
import static io.zipcoder.casino.Models.Card.Suit.DIAMONDS;
import static io.zipcoder.casino.Models.Card.Suit.CLUBS;

import static io.zipcoder.casino.Models.Card.Integer.ACE;
import static io.zipcoder.casino.Models.Card.Integer.TWO;
import static io.zipcoder.casino.Models.Card.Integer.THREE;
import static io.zipcoder.casino.Models.Card.Integer.FOUR;
import static io.zipcoder.casino.Models.Card.Integer.FIVE;
import static io.zipcoder.casino.Models.Card.Integer.SIX;
import static io.zipcoder.casino.Models.Card.Integer.SEVEN;
import static io.zipcoder.casino.Models.Card.Integer.EIGHT;
import static io.zipcoder.casino.Models.Card.Integer.NINE;
import static io.zipcoder.casino.Models.Card.Integer.TEN;
import static io.zipcoder.casino.Models.Card.Integer.JACK;
import static io.zipcoder.casino.Models.Card.Integer.QUEEN;
import static io.zipcoder.casino.Models.Card.Integer.KING;


import static org.junit.Assert.*;

public class CardTest {




    @Test
    public void getValue() {
        Card card = new Card(HEARTS,FIVE);
        Card.Integer actual = card.getValue();
        Assert.assertEquals(FIVE, actual);
    }



    @Test
    public void setValue() {
        Card card = new Card();
        Card.Integer actual = card.setValue(TWO);
        Assert.assertEquals(TWO, actual);
    }

    @Test
    public void setCardSuit() {
        Card card = new Card();
        Card.Suit actual = card.setCardSuit(DIAMONDS);
        Assert.assertEquals(DIAMONDS, actual);

    }

    @Test
    public void getCardSuit() {
        Card card = new Card(HEARTS,FIVE);
        Card.Suit actual = card.getCardSuit();
        Assert.assertEquals(HEARTS, actual);
    }


}