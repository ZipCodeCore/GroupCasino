package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.CardsAndDice.Card;
import io.zipcoder.casino.CardsAndDice.Deck;
import io.zipcoder.casino.CardsAndDice.Rank;
import io.zipcoder.casino.CardsAndDice.Suit;
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
    @Test
    public void testGetCardBack() {
        //Given
        Card testCard = Deck.getCardBack();

        //When
        String actualBack = Card.printAllCards(testCard);
        String expected =
                        "┏━━━┓\n" +
                        "┃Ƞ  ┃\n" +
                        "┃ Ʉ ┃\n" +
                        "┃  ʗ┃\n" +
                        "┗━━━┛\n";
        //Then
        Assert.assertEquals(expected, actualBack);

    }


}
