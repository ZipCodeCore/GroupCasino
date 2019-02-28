package io.zipcoder.casino.casino;

import io.zipcoder.casino.casino.games.cardgames.cardutilities.Card;
import io.zipcoder.casino.casino.games.cardgames.cardutilities.Deck;
import io.zipcoder.casino.casino.games.cardgames.cardutilities.Rank;
import io.zipcoder.casino.casino.games.cardgames.cardutilities.Suit;
import io.zipcoder.casino.casino.games.cardgames.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoFishPlayerTest {

    @Test
    public void testAddToHand() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        Card expected = testDeck.drawCard();

        // When
        testPlayer.addToHand(expected);
        Card actual = testPlayer.getHand().get(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddMultiple() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        List<Card> expected = testDeck.drawMultipleCards(4);
        List<Card> testSecond = testDeck.drawMultipleCards(4);

        // When
        testPlayer.addToHand(expected);
        testPlayer.addToHand(testSecond);
        List<Card>  actual = testPlayer.getHand();

        // Then
        expected.addAll(testSecond);
        Collections.sort(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetHand() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        List<Card> expected = testDeck.drawMultipleCards(4);

        // When
        testPlayer.setHand(expected);
        List<Card>  actual = testPlayer.getHand();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetHand2() {
        // Given
        List<Card> expected = new ArrayList<>();
        GoFishPlayer testPlayer = new GoFishPlayer();

        // When
        testPlayer.setHand(null);
        List<Card>  actual = testPlayer.getHand();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIncreaseBookCount() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();

        // When
        testPlayer.increaseBookCount();
        int actual = testPlayer.getBookCount();

        // Then
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIncreaseBookCount2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();

        // When
        testPlayer.increaseBookCount();
        testPlayer.increaseBookCount();
        testPlayer.increaseBookCount();
        testPlayer.increaseBookCount();
        int actual = testPlayer.getBookCount();

        // Then
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasCardTrue() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card expected = new Card(Suit.HEARTS, Rank.THREE);

        // When
        testPlayer.addToHand(expected);
        boolean actual = testPlayer.hasCard(expected.getRank().toString().toUpperCase());

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testHasCardFalse() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card cardInHand = new Card(Suit.HEARTS, Rank.ACE);
        Card cardNotInHand = new Card(Suit.DIAMONDS, Rank.THREE);

        // When
        testPlayer.addToHand(cardInHand);
        boolean actual = testPlayer.hasCard(cardNotInHand.getRank().toString());

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testGetCards() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card cardInHand = new Card(Suit.HEARTS, Rank.ACE);
        List<Card> expected = new ArrayList<>();
        expected.add(cardInHand);
        expected.add(cardInHand);

        // When
        testPlayer.addToHand(cardInHand);
        testPlayer.addToHand(cardInHand);
        List<Card> actual = testPlayer.getCards(cardInHand.getRank().toString().toUpperCase());

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(testPlayer.hasCard(cardInHand.getRank().toString().toUpperCase()));
    }

    @Test
    public void testGetCards2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        new Card(Suit.HEARTS, Rank.ACE);
        Card cardInHand =  new Card(Suit.HEARTS, Rank.ACE);
        Card otherCard =  new Card(Suit.HEARTS, Rank.TWO);
        List<Card> expected = new ArrayList<>();
        expected.add(cardInHand);
        List<Card> expectedHand = new ArrayList<>();
        expectedHand.add(otherCard);

        // When
        testPlayer.addToHand(cardInHand);
        testPlayer.addToHand(otherCard);
        List<Card> actual = testPlayer.getCards(cardInHand.getRank().toString());
        List<Card> hand = testPlayer.getHand();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedHand, hand);
        Assert.assertFalse(testPlayer.hasCard(cardInHand.getRank().toString()));
        Assert.assertTrue(testPlayer.hasCard(otherCard.getRank().toString()));
    }

    @Test
    public void testGetRandomCard() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        Card testCard = testDeck.drawCard();
        testPlayer.addToHand(testCard);

        // When
        Card actual = testPlayer.getRandomCard();

        // Then
        Assert.assertEquals(testCard, actual);
    }

    @Test
    public void testGetRandomCard2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        Card testCard = testDeck.drawCard();
        Card otherCard = testDeck.drawCard();
        testPlayer.addToHand(testCard);
        testPlayer.addToHand(otherCard);

        // When
        Card actual = testPlayer.getRandomCard();

        // Then
        Assert.assertTrue(actual.equalRank(testCard) || actual.equalRank(otherCard));
    }

    @Test
    public void testHasBooks() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card cardInHand =  new Card(Suit.HEARTS, Rank.ACE);
        Card otherCard =  new Card(Suit.HEARTS, Rank.TWO);
        Card thirdCard =  new Card(Suit.HEARTS, Rank.THREE);
        Card fourthCard =  new Card(Suit.HEARTS, Rank.FOUR);
        testPlayer.addToHand(cardInHand);
        testPlayer.addToHand(otherCard);
        testPlayer.addToHand(thirdCard);
        testPlayer.addToHand(fourthCard);

        // When
        boolean actual = testPlayer.hasBooks();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testHasBooks2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        testPlayer.addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        boolean actual = testPlayer.hasBooks();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testHasBooks3() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        testPlayer.addToHand(testDeck.drawMultipleCards(52));
        Collections.sort(testPlayer.getHand());
        // When
        boolean actual = testPlayer.hasBooks();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testHasBooks4() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card cardInHand =  new Card(Suit.HEARTS, Rank.ACE);
        Card otherCard =  new Card(Suit.DIAMONDS, Rank.ACE);
        Card thirdCard =  new Card(Suit.SPADES, Rank.ACE);
        Card fourthCard =  new Card(Suit.CLUBS, Rank.ACE);
        testPlayer.addToHand(otherCard);
        testPlayer.addToHand(cardInHand);
        testPlayer.addToHand(thirdCard);
        testPlayer.addToHand(fourthCard);

        // When
        boolean actual = testPlayer.hasBooks();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testGetBooks() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card testCard = new Card(Suit.CLUBS, Rank.QUEEN);
        List<Card> expected = new ArrayList<>();
        expected.add(testCard);
        expected.add(testCard);
        expected.add(testCard);
        expected.add(testCard);

        testPlayer.addToHand(expected);

        // When
        List<Card> actual = testPlayer.getBooks();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBooks2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Deck testDeck = new Deck();
        List<Card> expected = new ArrayList<>();
        expected.addAll(testDeck.drawMultipleCards(52));
        testPlayer.addToHand(expected);
        Collections.sort(expected);

        // When
        List<Card> actual = testPlayer.getBooks();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandSize() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();
        Card testCard = new Card(Suit.DIAMONDS, Rank.FIVE);
        List<Card> testCards = new ArrayList<>();
        testCards.add(testCard);
        testCards.add(testCard);
        testCards.add(testCard);
        testCards.add(testCard);

        testPlayer.addToHand(testCards);

        // When
        int actual = testPlayer.getHandSize();

        // Then
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHandSize2() {
        // Given
        GoFishPlayer testPlayer = new GoFishPlayer();

        // When
        int actual = testPlayer.getHandSize();

        // Then
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }
}
