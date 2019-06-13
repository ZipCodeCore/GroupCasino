package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardGamesTest {

    @Test
    public void getOdds() {
        Blackjack blackjack = new Blackjack();
        blackjack.setOdds(2.0);

        Double expected = 2.0;
        Double actual = blackjack.odds;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setOdds() {
        Blackjack blackjack = new Blackjack();
        blackjack.setOdds(2.0);

        Double expected = 2.0;
        Double actual = blackjack.odds;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealCard() {
        Blackjack blackjack = new Blackjack();
        blackjack.setOdds(2.0);

        Integer beforeDeal = blackjack.player1.hand.size();
        blackjack.deck.deal(2, blackjack.player1);
        Integer afterDeal = blackjack.player1.hand.size();


        Assert.assertFalse(beforeDeal.equals(afterDeal));
    }
}