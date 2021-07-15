package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.Beetle;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.Beetle.BeetlePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BeetleGameTest {
    @Test
    public void constructorTest(){
        BeetleGame beetleGame = new BeetleGame();
        Beetle game = beetleGame.getGame();
        Boolean actual = game instanceof Beetle;

        Assert.assertTrue(actual);

    }

    @Test
    public void addTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        Boolean expected = true;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        beetleGame.remove(player);
        Boolean expected = false;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void runTest(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setDemo(true);
        beetleGame.run();
        Integer actual = beetleGame.getBetAmt();
        Integer expected = null;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printBeetleCards(){
        BeetleGame beetleGame = new BeetleGame();
        String expected = "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                          "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  ";
        String actual = beetleGame.printBeetleCards();


        Assert.assertEquals(expected, actual);
    }



}
