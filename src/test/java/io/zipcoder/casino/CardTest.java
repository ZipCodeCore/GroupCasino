package io.zipcoder.casino;

import io.zipcoder.casino.card.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void cardConstructorTest(){
        String expectedSuit = "Hearts";
        Integer expectedRank = 11;
        Card card = new Card(expectedSuit, expectedRank);

        Assert.assertEquals("Hearts", card.getSuit());
        Assert.assertEquals(expectedRank, card.getRank());
    }

    @Test
    public void toStringTest(){
        String expectedSuit = "Spades";
        Integer expectedRank = 1;
        Card card = new Card(expectedSuit, expectedRank);
        Assert.assertEquals("Ace of ♠", card.toString());
    }

    @Test
    public void toStringTest1(){
        String expectedSuit = "Hearts";
        Integer expectedRank = 11;
        Card card = new Card(expectedSuit, expectedRank);
        Assert.assertEquals("Jack of ♥", card.toString());
    }

    @Test
    public void toStringTest2(){
        String expectedSuit = "Clubs";
        Integer expectedRank = 10;
        Card card = new Card(expectedSuit, expectedRank);
        Assert.assertEquals("10 of ♣", card.toString());
    }

}
