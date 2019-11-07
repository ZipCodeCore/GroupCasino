package io.zipcoder.casino.GamePieces;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.CardValue;
import io.zipcoder.casino.GamePieces.Suit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

public class CardTest {

    @Test
    public void constructorTest1(){
        Card card = new Card(CardValue.SEVEN, Suit.SPADES);
        CardValue expectedValue = CardValue.SEVEN;
        CardValue actualValue = card.getCardValue();

        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void ConstructorTest2(){
        Card card = new Card(CardValue.SEVEN,Suit.SPADES);
        Suit expectedSuit = Suit.SPADES;
        Suit actualSuit = card.getSuit();

        Assert.assertEquals(expectedSuit,actualSuit);
    }

    @Test
    public void getSuit() {
        Card card = new Card(null,Suit.DIAMONDS);
        Suit expectedSuit = Suit.DIAMONDS;
        Suit actualSuit = card.getSuit();

        Assert.assertEquals(expectedSuit,actualSuit);

    }

    @Test
    public void setSuit() {
        Card card = new Card(null,null);
        Suit expected = Suit.HEARTS;
        card.setSuit(expected);


        Assert.assertEquals(expected,card.getCardValue());
    }

    @Test
    public void getCardValue() {
        Card card = new Card(CardValue.JACK,null);
        CardValue expectedValue = CardValue.JACK;
        CardValue actualValue = card.getCardValue();

        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void setCardValue() {
    }
}