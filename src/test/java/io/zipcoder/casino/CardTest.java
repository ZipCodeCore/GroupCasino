package io.zipcoder.casino;

import org.junit.Test;

import static io.zipcoder.casino.Card.Rank.*;
import static io.zipcoder.casino.Card.Suit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CardTest
{

    @Test
    public void cardValues()
    {
        // GIVEN
        Card testAce = new Card(ACE, SPADES);
        Card.Rank expectedRank = ACE;
        Card.Suit expectedSuit = SPADES;
        Integer expectedVal = 11;

        // WHEN

        Card.Rank actualRank = testAce.rank();
        Card.Suit actualSuit = testAce.suit();
        Integer actualVal = testAce.rank().getRankValue();

        // THEN

        assertEquals(expectedRank, actualRank);
        assertEquals(expectedSuit, actualSuit);
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void cardRankingJack()
    {
        // GIVEN
        Card testAce = new Card(JACK, DIAMONDS);
        Card.Rank expectedRank = JACK;
        Card.Suit expectedSuit = DIAMONDS;
        Integer expectedVal = 10;

        // WHEN

        Card.Rank actualRank = testAce.rank();
        Card.Suit actualSuit = testAce.suit();
        Integer actualVal = actualRank.getRankValue();

        // THEN

        assertEquals(expectedRank, actualRank);
        assertEquals(expectedSuit, actualSuit);
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void cardRankingDeuce()
    {
        // GIVEN
        Card testAce = new Card(DEUCE, CLUBS);
        Card.Rank expectedRank = DEUCE;
        Card.Suit expectedSuit = CLUBS;
        Integer expectedRankVal = 2;

        // WHEN

        Card.Rank actualRank = testAce.rank();
        Card.Suit actualSuit = testAce.suit();
        Integer actualVal = actualRank.getRankValue();

        // THEN

        assertEquals(expectedRank, actualRank);
        assertEquals(expectedSuit, actualSuit);
        assertEquals(expectedRankVal, actualVal);
    }
}