package io.zipcoder.casino;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void PlayerConstructorTest() {
        //Given
        Player player1 = new Player("player1", 100.00);
        String actual = player1.getName();

        //When
        String expected = "player1";

        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void PlayerGetAccountBalanceTest() {
        //Given
        Player player2 = new Player("player1", 500.00);
        Double actual = player2.getWallet();
        //When
        Double expected = 500.00;

        //Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void PlayerSetAccountBalanceTest() {
        //Given
        Player player3 = new Player("player1", 500.00);
        player3.setWallet(100.00);
        Double actual = player3.getWallet();
        //When
        Double expected = 600.00;

        //Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void PlayerMakeBetTest() {
        //given
        Player player4 = new Player("player1", 50.00);
        Double expected = player4.makeBet(5.0);

        //when
        Double actual = 5.0;
        //assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void PlayerMakeBetTest2() {
        //given
        Player player5 = new Player("player1", 50.00);
        player5.makeBet(5.0);
        Double expected = player5.getWallet();

        //when
        Double actual = 45.0;
        //assert
        Assert.assertEquals(expected,actual);

    }

}
