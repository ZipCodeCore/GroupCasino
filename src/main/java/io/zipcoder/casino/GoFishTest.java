package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GoFishTest {


    @Test
    public void constructorGameTest(){
        GoFish friendlyGame = new GoFish();
        Assert.assertTrue(friendlyGame instanceof GoFish);
    }

    @Test
    public void playerHandTest(){
        GoFish friendlyGame=new GoFish();
        friendlyGame.makeDeck();
        ArrayList<Card> oswald= new ArrayList<>();
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        Integer actual=friendlyGame.cardsInHand(oswald);
        Integer expected = 4;
        Assert.assertEquals(actual,expected);
    }


    



    @Test
    public void testShowCard(){
        GoFish friendlyGame=new GoFish();
        ArrayList<Card> oswald= new ArrayList<>();
        friendlyGame.makeDeck();
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        friendlyGame.dealCards(oswald);
        //String actual=friendlyGame.showCard();
        //String expected="4 of Spades";
        //Assert.assertEquals(actual,expected);
    }








}
