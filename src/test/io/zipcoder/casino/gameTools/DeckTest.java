package io.zipcoder.casino.gameTools;

import io.zipcoder.casino.player.CardGamePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.gameTools.Suit.Clubs;

public class DeckTest {

    @Test
    public void shuffle() {
        Deck testDeck = new Deck();

        Card beforeShuffle = testDeck.getDeck().peek();
        testDeck.shuffle();
        Card afterShuffle = testDeck.getDeck().peek();
        Assert.assertFalse(beforeShuffle.equals(afterShuffle));
    }
    @Test
    public void shuffleNotWorking() {
        Deck testDeck = new Deck();
        Card beforeShuffle = testDeck.getDeck().peek();
        Card afterShuffle = testDeck.getDeck().peek();
        Assert.assertFalse(!beforeShuffle.equals(afterShuffle));
    }

    @Test
    public void deal5() {
        CardGamePlayer testPlayer = new GoFishPlayer();
        Integer numCards = 5;
        Deck deck = new Deck();
        ArrayList<Card> testStartingHand = deck.deal(numCards,testPlayer);
        Integer expected = 5;
        Integer actual = testStartingHand.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deal2() {
        CardGamePlayer testPlayer = new GoFishPlayer();
        Integer numCards = 2;
        Deck deck = new Deck();
        ArrayList<Card> testStartingHand = deck.deal(numCards,testPlayer);
        Integer expected = 2;
        Integer actual = testStartingHand.size();
        Assert.assertEquals(expected,actual);
    }

    @Test //DO
    public void dealNegative() {
        CardGamePlayer testPlayer = new GoFishPlayer();
        Integer numCards = -2;
        Deck deck = new Deck();
        ArrayList<Card> testStartingHand = deck.deal(numCards,testPlayer);
        Assert.assertNull(testStartingHand);
    }

    @Test
    public void dealSingleCard1() {

        CardGamePlayer testPlayer = new GoFishPlayer();
        ArrayList<Card>testHand = new ArrayList<Card>(2);
        Deck deck = new Deck();
        testPlayer.setHand(testHand);
        deck.dealSingleCard(testPlayer);
        Integer expected = 1;
        Integer actual = testPlayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void dealSingleCard2() {
        CardGamePlayer testPlayer = new GoFishPlayer();
        ArrayList<Card>testHand = new ArrayList<Card>(2);
        Deck deck = new Deck();
        testPlayer.setHand(testHand);
        deck.dealSingleCard(testPlayer);
        Integer expected = 1;
        Integer actual = testPlayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }
}