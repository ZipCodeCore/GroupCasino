package io.zipcoder.casino.player;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishPlayerTest {
    GoFishPlayer goFishPlayer = new GoFishPlayer();
    ArrayList<Card> hand = new ArrayList<Card>(1);


    @Test
    public void endturn() {
    }

    @Test
    public void getHand() {
        Deck deck = new Deck();
        deck.deal(1,goFishPlayer);
        Integer expected = 1;
        Integer actual = goFishPlayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getHand1() {
        Deck deck = new Deck();
        deck.deal(52,goFishPlayer);
        Integer expected = 52;
        Integer actual = goFishPlayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setHand() {
    }

    @Test
    public void getAccount() {
    }
}