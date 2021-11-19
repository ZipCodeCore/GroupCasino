package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Assert;
import org.junit.Test;

public class RouletteTest {

    @Test
    public void testEvenWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $200.0\n" +
                "Your balance is: $1200.0";

        //When
        String actual = rouletteGame.evenChoice(2, 100.0);

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testEvenLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $100.0\n" +
                "Your balance is: $900.0";
        //When
        String actual = rouletteGame.evenChoice(3, 100.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOddWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $400.0\n" +
                "Your balance is: $1400.0";

        //When
        String actual = rouletteGame.oddChoice(9, 200.0);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testOddLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $200.0\n" +
                "Your balance is: $800.0";
        //When
        String actual = rouletteGame.oddChoice(10, 200.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRedWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $800.0\n" +
                "Your balance is: $1800.0";
        //When
        String actual = rouletteGame.redChoice(14, 400.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRedLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $300.0\n" +
                "Your balance is: $700.0";
        //When
        String actual = rouletteGame.redChoice(26, 300.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBlackWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $1000.0\n" +
                "Your balance is: $2000.0";
        //When
        String actual = rouletteGame.blackChoice(11, 500.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBlackLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $400.0\n" +
                "Your balance is: $600.0";
        //When
        String actual = rouletteGame.blackChoice(5, 400.0);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testPickNumberWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $3500.0\n" +
                "Your balance is: $4500.0";
        //When
        String actual = rouletteGame.pickNumberChoice(5, 100.0, 5);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPickNumberLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $500.0\n" +
                "Your balance is: $500.0";

        //When
        String actual = rouletteGame.pickNumberChoice(10, 500.0, 9);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLowWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.);
        String expected = "you won $800.0\n" +
                "Your balance is: $1800.0";

        //When
        String actual = rouletteGame.betweenOneAndEighteen(5, 400.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLowLoss() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you lost $500.0\n" +
                "Your balance is: $500.0";
        //When
        String actual = rouletteGame.betweenOneAndEighteen(19, 500.0);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHighWin() {
        //Given
        RouletteGame rouletteGame = new RouletteGame();
        rouletteGame.setBalance(1000.0);
        String expected = "you won $800.0\n" +
                "Your balance is: $1800.0";
        //When
String actual = rouletteGame.betweenNineteenAndThirtySix(21,400.0);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testHighLoss(){
     //Given
     RouletteGame rouletteGame = new RouletteGame();
     rouletteGame.setBalance(1000.0);
     String expected = "you lost $700.0\n" +
             "Your balance is: $300.0";
     //When
     String actual = rouletteGame.betweenNineteenAndThirtySix(18,700.0);
     //Then
        Assert.assertEquals(expected, actual);
    }

}
