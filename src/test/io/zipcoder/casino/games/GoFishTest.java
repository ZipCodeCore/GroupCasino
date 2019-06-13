package io.zipcoder.casino.games;

import io.zipcoder.casino.Deck;
import io.zipcoder.casino.player.CardGamePlayer;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {

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
    public void check() {
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
    public void createOtherPlayersTest() {
        GoFish goFish = new GoFish();
        Integer expected = 2;
        Integer actual = goFish.createOtherPlayers(expected).size();
        Assert.assertEquals(expected,actual);


    }
}