package java.io.zipcoder.casino.games;

import io.zipcoder.casino.games.Roulette;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {
    private Roulette roulette;


    @Before //it will get invoked before each test method
    public void setup() {
        this.roulette = new Roulette();
    }



    @Test
    public void endGameTest() {

    }

    @Test
    public void getResultsTest() {

    }
    @Test
    public void displayTest() {

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






}
