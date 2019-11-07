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
    public void displayHandTest() {



    }

    @Test
    public void dealHandsTest() {
    }
}