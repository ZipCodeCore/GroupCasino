package com.github.zipcodewilmington.casino.games.CardGame;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {


    @Test
    void testShuffle(){
        Deck deck= new Deck(1);
        Card card= new Card();
        Stack<Card> cardStack = new Stack<>();
        cardStack = deck.cardDeck;
        for (int i = 0; i < cardStack.size(); i++) {
            System.out.println(cardStack.get(i));
        }
        Assert.assertEquals(52,cardStack.size());

    }

    @Test
    void testDealCards() {
        List<Card> cardList=new ArrayList<>();
        Deck deck= new Deck(1);
        cardList=deck.dealCards(3);

        Assert.assertEquals(3,cardList.size());
    }

    @Test
    void drawCard() {
        Deck deck= new Deck(1);
        Card card= new Card();
        Stack<Card> cardStack = new Stack<>();

        cardStack = deck.cardDeck;

        card = deck.drawCard();
        int expected = 51;
        int actual = cardStack.size();

        Assert.assertEquals(51,cardStack.size());
    }


}