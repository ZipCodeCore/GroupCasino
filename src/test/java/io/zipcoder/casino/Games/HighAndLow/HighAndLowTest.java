package io.zipcoder.casino.Games.HighAndLow;

import io.zipcoder.casino.Games.HighAndLow.HighAndLow;
import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Test;

public class HighAndLowTest {

    @Test
    public void firstRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.firstRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }

    @Test
    public void secondRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.firstRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }

    @Test
    public void enoughBalanceTest1(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,0);
        Assert.assertFalse(highAndLow.enoughBalance());
        }


    @Test
    public void enoughBalanceTest2(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,Integer.MAX_VALUE);
        Assert.assertTrue(highAndLow.enoughBalance());
    }

    @Test
    public void returnWinnings1(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,60);
        Integer totalBetValue = 40;
        Integer expected = 100;
        highAndLow.returnWinnings(currentPlayer, totalBetValue);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void returnWinnings2(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,100);
        Integer totalBetValue = 100;
        Integer expected = 200;
        highAndLow.returnWinnings(currentPlayer, totalBetValue);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }
}
