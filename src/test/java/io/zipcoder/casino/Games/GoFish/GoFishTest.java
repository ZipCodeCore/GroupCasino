package io.zipcoder.casino.Games.GoFish;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.CardValue;
import io.zipcoder.casino.GamePieces.Suit;
import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {

    Player player;
    GoFish goFish;

    @Before
    public void setup() {

        player = new Player("Test", 500);
        goFish = new GoFish();


    }

    @Test
    public void hasCardTest() {

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(CardValue.ACE, Suit.CLUBS));
        hand.add(new Card(CardValue.JACK, Suit.CLUBS));
        hand.add(new Card(CardValue.NINE, Suit.CLUBS));
        hand.add(new Card(CardValue.FIVE, Suit.CLUBS));
        hand.add(new Card(CardValue.TWO, Suit.CLUBS));

        Assert.assertTrue(goFish.hasCard(hand, CardValue.ACE));
        Assert.assertTrue(goFish.hasCard(hand, CardValue.JACK));
        Assert.assertTrue(goFish.hasCard(hand, CardValue.FIVE));
        Assert.assertFalse(goFish.hasCard(hand, CardValue.EIGHT));

    }

    @Test
    public void removeCardsTest() {
        ArrayList<Card> hand = new ArrayList<>();
        Card ace = new Card(CardValue.ACE, Suit.CLUBS);
        hand.add(ace);
        hand.add(new Card(CardValue.JACK, Suit.CLUBS));
        hand.add(new Card(CardValue.NINE, Suit.CLUBS));
        hand.add(new Card(CardValue.FIVE, Suit.CLUBS));
        hand.add(new Card(CardValue.TWO, Suit.CLUBS));

        goFish.removeCards(hand, CardValue.ACE);

        Assert.assertFalse(hand.contains(ace));

        Card nine = new Card(CardValue.NINE, Suit.CLUBS);
        hand.add(nine);
        goFish.removeCards(hand, CardValue.NINE);

        Assert.assertFalse(hand.contains(nine));

    }

    @Test
    public void checkBookTest() {

        ArrayList<Card> hand = new ArrayList<>();
        Card ace = new Card(CardValue.ACE, Suit.CLUBS);
        hand.add(ace);
        hand.add(new Card(CardValue.ACE, Suit.HEARTS));
        hand.add(new Card(CardValue.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardValue.ACE, Suit.SPADES));
        hand.add(new Card(CardValue.TWO, Suit.CLUBS));
        hand.add(new Card(CardValue.TWO, Suit.DIAMONDS));
        hand.add(new Card(CardValue.TWO, Suit.SPADES));

        goFish.checkBook(hand, true);
        assertFalse(goFish.hasCard(hand, CardValue.ACE));

        hand.add(new Card(CardValue.ACE, Suit.CLUBS));
        hand.add(new Card(CardValue.ACE, Suit.HEARTS));
        hand.add(new Card(CardValue.ACE, Suit.DIAMONDS));
        hand.add(new Card(CardValue.ACE, Suit.SPADES));

        goFish.checkBook(hand, false);

        assertFalse(goFish.hasCard(hand, CardValue.ACE));
        assertTrue(goFish.hasCard(hand, CardValue.TWO));
    }

    @Test
    public void checkHandTest() {
        ArrayList<Card> destHand = new ArrayList<>();
        destHand.add(new Card(CardValue.ACE, Suit.HEARTS));
        destHand.add(new Card(CardValue.ACE, Suit.DIAMONDS));
        destHand.add(new Card(CardValue.TWO, Suit.CLUBS));
        destHand.add(new Card(CardValue.TWO, Suit.DIAMONDS));
        destHand.add(new Card(CardValue.TWO, Suit.SPADES));

        ArrayList<Card> guessHand = new ArrayList<>();
        guessHand.add(new Card(CardValue.THREE, Suit.HEARTS));
        guessHand.add(new Card(CardValue.ACE, Suit.DIAMONDS));
        guessHand.add(new Card(CardValue.FOUR, Suit.CLUBS));
        guessHand.add(new Card(CardValue.FIVE, Suit.DIAMONDS));
        guessHand.add(new Card(CardValue.NINE, Suit.SPADES));

        goFish.checkCard(CardValue.ACE, destHand, guessHand);

        Assert.assertTrue(goFish.hasCard(destHand, CardValue.ACE));
        Assert.assertFalse(goFish.hasCard(guessHand, CardValue.ACE));

    }

    @Test
    public void fishTest() {
        ArrayList<Card> destHand = new ArrayList<>();
        destHand.add(new Card(CardValue.ACE, Suit.HEARTS));
        destHand.add(new Card(CardValue.ACE, Suit.DIAMONDS));
        destHand.add(new Card(CardValue.TWO, Suit.CLUBS));
        destHand.add(new Card(CardValue.TWO, Suit.DIAMONDS));
        destHand.add(new Card(CardValue.TWO, Suit.SPADES));

        goFish.fish(destHand);

        Assert.assertEquals(6, destHand.size());
    }
}