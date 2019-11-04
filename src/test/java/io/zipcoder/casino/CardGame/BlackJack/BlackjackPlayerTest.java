package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.CardGame.Cards.Suit;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlackjackPlayerTest {

    Player player;
    Deck deck;
    ArrayList<Card> cards;
    Card card1;
    Card card2;



    @Before
    public void setUp(){
        player = new Player("Delenda", 100);
        deck = new Deck(10);
        cards = new ArrayList<>();
        card1 = new Card(Face.FOUR, Suit.CLUBS);
        card2 = new Card(Face.JACK, Suit.DIAMONDS);
        cards.add(card1);
        cards.add(card2);

    }



    @Test
    public void bet() {

        //GIVEN
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(this.player);
        double expected = 90;



        //WHEN
        blackjackPlayer.bet(10);
        double actual = blackjackPlayer.getBlackjackPlayerWallet();

        //THEN
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void collect() {

        //GIVEN
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(this.player);
        double expected = 110;

        //WHEN
        blackjackPlayer.collect(10);
        double actual = blackjackPlayer.getBlackjackPlayerWallet();


        //THEN
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void hit() {
        //GIVEN
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(this.player);
        blackjackPlayer.setHand(deck.deal(2));
        int expected = 3;

        //WHEN
        blackjackPlayer.hit(deck);
        int actual = blackjackPlayer.numberOfCardsInHand();

        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleDown() {
    }

    @Test
    public void split() {
    }

    @Test
    public void testSumOfHand() {
        //GIVEN
        BlackjackPlayer blackjackPlayer = new BlackjackPlayer(this.player);
        blackjackPlayer.setHand(cards);
        int expected = 14;

        //WHEN
        int actual = blackjackPlayer.sumOfHand();


        //THEN
        Assert.assertEquals(expected, actual);
    }


}