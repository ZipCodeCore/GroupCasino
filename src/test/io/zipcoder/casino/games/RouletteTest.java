package io.zipcoder.casino.games;

import io.zipcoder.casino.games.Roulette;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.RoulettePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {
    private Roulette roulette;


    @Before //it will get invoked before each test method
    public void setup() {
        RoulettePlayer roulettePlayer = new RoulettePlayer("Player", 20d);
        this.roulette = new Roulette(roulettePlayer);
    }





    @Test
    public void calcPaymentTest() {

        Integer actual = this.roulette.calcPayment(1, 35);
        Assert.assertEquals(36,actual.intValue());
    }

    @Test
    public void updateAccountTest() {
        this.roulette.updateAccount(10);
        Double actual = this.roulette.roulettePlayer.getAccount();
        Assert.assertEquals(10,actual.doubleValue(),0.0);

    }


    @Test
    public void calcPaymentDoubleTest(){
        Double actual = this.roulette.calcPayment(2.5,2d);
        Assert.assertEquals(7.5,actual.doubleValue(),0.0);

    }


    @Test
    public void isWinnerEvenTest() {
     boolean actual = this.roulette.isWinner("even",2);
     Assert.assertEquals(true,actual);

    }

    @Test
    public void isWinnerOddTest() {
        boolean actual = this.roulette.isWinner("odd",3);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void isWinnerRedTest() {
        boolean actual = this.roulette.isWinner("red",12);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void isWinnerBlackTest() {
        boolean actual = this.roulette.isWinner("black",35);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void isFirstTwelveTest() {
        boolean actual = this.roulette.isWinner("1st12",12);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void isSecondTwelveTest() {
        boolean actual = this.roulette.isWinner("2nd12",13);
        Assert.assertEquals(true,actual);

    }
    @Test
    public void isThirdTwelveTest() {
        boolean actual = this.roulette.isWinner("3rd12",35);
        Assert.assertEquals(true,actual);

    }

}
