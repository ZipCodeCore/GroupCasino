package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.games.GoFish;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class GoFishTest {
    GoFish goFish = new GoFish();
    GoFishPlayer mainplayer = new GoFishPlayer();
    GoFishPlayer otherPlayer = new GoFishPlayer();


    @Test
    public void nextTurn() {

    }

    @Test
    public void endGame() {
    }

    @Test
    public void getResults() {
    }

    @Test
    public void display() {
    }

    @Test
    public void checkCondition() {

    }

    @Test
    public void goFish() {
    }

    @Test
    public void getCurrentBet() {
    }

    @Test
    public void setCurrentBet() {
    }

    @Test
    public void inputNumPlayers() {

    }

    @Test
    public void createPlayersTestMain() {
        Deck deck = new Deck();
        deck.deal(5,mainplayer);
        Integer expected = 5;
        Integer actual = mainplayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createPlayersTestOther() {
        Deck deck = new Deck();
        otherPlayer.setHand(new ArrayList<Card>(1));
        deck.deal(10,otherPlayer);
        Integer expected = 10;
        Integer actual = otherPlayer.getHand().size();
        Assert.assertEquals(expected,actual);
    }

}