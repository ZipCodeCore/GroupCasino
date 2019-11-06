package io.zipcoder.casino.CardGames;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;


public class DeckTest {


    @Test
    public void testDealCards(){
        Deck newDeck = new Deck(1);
        List<Card> cardList = new ArrayList<>();
        cardList = newDeck.dealCards(2);

        int expected = 2;
        int actual = cardList.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testShuffleDeck(){
        Deck newDeck = new Deck(1);
        Card cardStack = new Card();
        Stack<Card> newStack= new Stack<>();

        newStack = newDeck.shuffleDeck();

        for (int i = 0; i < newStack.size(); i++) {
            System.out.println(newStack.get(i));
        }

        int expected = 52;
        int actual = newStack.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testDrawCard(){
        Deck newDeck = new Deck(1);
        Card newCard = new Card();
        Stack<Card> cardStack = new Stack<>();

        cardStack = newDeck.shuffleDeck();

        newCard = newDeck.drawCard();
        int expected = 51;
        int actual = cardStack.size();

        Assert.assertEquals(expected,actual);
    }

}