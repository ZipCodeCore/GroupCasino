package io.zipcoder.casino.CardGame.BlackJack;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("name", 1000);
    }
    @Test
    public void constructorTest(){
        //Given
        Blackjack blackjack = new Blackjack(player);
        double expected = 0;

        //When
        double actual = blackjack.getPot();

        //Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testPush() {
    }


    @Test
    public void testValidateBet() {
        //Given
        Blackjack blackjack = new Blackjack(player);



        //When
        blackjack.setBet(100);
        boolean actual = blackjack.validateBet();

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testInvalidBet(){
        //Given
        Blackjack blackjack = new Blackjack(player);

        //When
        blackjack.setBet(2000);
        boolean actual = blackjack.validateBet();

        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void setBet() {
        //Given
        Blackjack blackjack = new Blackjack(player);
        double expected = 100;

        //When
       blackjack.setBet(100);
       double actual = blackjack.getBet();


        //Then
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void takeBet() {
        //Given
        Blackjack blackjack = new Blackjack(player);
        double expected = 100;

        //When
        blackjack.takeBet(100);
        double actual = blackjack.getPot();

        //Then
        Assert.assertEquals(expected, actual,0);



    }

    @Test
    public void payout() {
        //Given
        Blackjack blackjack = new Blackjack(player);
        double expected = 200;

        //When
        blackjack.takeBet(100);
        double actual = blackjack.payout();

        //Then
        Assert.assertEquals(expected, actual, 0);
    }
}