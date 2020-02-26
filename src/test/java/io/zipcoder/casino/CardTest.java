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
        Integer expectedSuitValue = 1;

        // WHEN

        Card.Rank actualRank = testAce.rank();
        Card.Suit actualSuit = testAce.suit();
        Integer actualVal = testAce.rank().getRankValue();
        Integer actualSuitValue = testAce.suit().getSuitValue();

        // THEN

        assertEquals(expectedRank, actualRank);
        assertEquals(expectedSuit, actualSuit);
        assertEquals(expectedVal, actualVal);
        assertEquals(expectedSuitValue, actualSuitValue);
    }

    @Test
    public void cardRankingJack()
    {
        // GIVEN
        Card testJack = new Card(JACK, DIAMONDS);
        Card.Rank expectedRank = JACK;
        Card.Suit expectedSuit = DIAMONDS;
        Integer expectedVal = 10;

        // WHEN

        Card.Rank actualRank = testJack.rank();
        Card.Suit actualSuit = testJack.suit();
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
        Card testDeuce = new Card(DEUCE, CLUBS);
        Card.Rank expectedRank = DEUCE;
        Card.Suit expectedSuit = CLUBS;
        Integer expectedRankVal = 2;

        // WHEN

        Card.Rank actualRank = testDeuce.rank();
        Card.Suit actualSuit = testDeuce.suit();
        Integer actualVal = actualRank.cardValue();

        // THEN

        assertEquals(expectedRank, actualRank);
        assertEquals(expectedSuit, actualSuit);
        assertEquals(expectedRankVal, actualVal);
    }

    @Test
    public void cardString()
    {
        // GIVEN

        Card testAce = new Card(ACE, SPADES);
        Card testQueen = new Card(QUEEN, HEARTS);
        Card testTen = new Card(TEN, DIAMONDS);
        String expectedAce = "ACE of SPADES(11)";
        String expectedQueen = "QUEEN of HEARTS(40)";
        String expectedTen = "TEN of DIAMONDS(30)";

        // WHEN

        String actualAce = testAce.toString();
        String actualQueen = testQueen.toString();
        String actualTen = testTen.toString();

        // THEN

        assertEquals(expectedAce, actualAce);
        assertEquals(expectedQueen, actualQueen);
        assertEquals(expectedTen, actualTen);
    }

    @Test
    public void comparingCards()
    {
        // GIVEN

        Card testAce = new Card(ACE, SPADES);
        Card testJack = new Card(JACK, CLUBS);
        Card testEightSpades = new Card(EIGHT, SPADES);
        Card testEightHearts = new Card(EIGHT, HEARTS);

        Integer expectedFirstCompare = 1;
        Integer expectedSecondCompare = -1;
        Integer expectedThirdCompare = 1;
        // WHEN

        Integer actualFirstCompare = testAce.compareTo(testJack);
        Integer actualSecondCompare = testJack.compareTo(testAce);
        Integer actualThirdCompare = testEightSpades.compareTo(testEightHearts);

        // THEN

        assertEquals(expectedFirstCompare, actualFirstCompare);
        assertEquals(expectedSecondCompare, actualSecondCompare);
        assertEquals(expectedFirstCompare, actualThirdCompare);
    }
}