package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Rank;
import io.zipcoder.casino.Cards.Suit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test

    public void testCardConstructor() {
        //Given
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card testCard = new Card(suit,rank);

        //When
        Rank actualRank = testCard.getRank();
        Suit actualSuit = testCard.getSuit();

        //Then
        Assert.assertEquals(rank,actualRank);
        Assert.assertEquals(suit,actualSuit);

    }

    @Test
    public void testCardSetMethod() {
        //Given
        Rank rank = Rank.FIVE;
        Suit suit = Suit.SPADES;
        Card testCard = new Card(suit,rank);

        //When
        Rank actualRank = testCard.getRank();
        Suit actualSuit = testCard.getSuit();
        String expected = rank.toString().toLowerCase() + " of "+suit.toString().toLowerCase();
        //Then
        Assert.assertEquals(expected,testCard.toString());
        Assert.assertEquals(suit,actualSuit);

    }


}
