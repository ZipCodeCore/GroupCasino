package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {
    //GoFish goFish = new GoFish();

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

    @Test
    public void runGoFishGameStart() {

    }
}