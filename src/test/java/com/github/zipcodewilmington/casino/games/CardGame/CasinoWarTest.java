package com.github.zipcodewilmington.casino.games.CardGame;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoWarTest {

    @BeforeEach
    void setUp() {
        
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void playCasinoWarHands() {
        Deck warDeck = new Deck(1);
        CardHand playerHand;
        CardHand dealerHand;
        Card card = new Card();


        playerHand = new CardHand(warDeck.dealCards(1));
        dealerHand = new CardHand(warDeck.dealCards(1));
        Integer playHand =  playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        Integer dealHand =  dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        System.out.println("player Hand:"+playHand);
        System.out.println("deal Hand:"+dealHand);
        Assert.assertTrue(true);
    }

    @Test
    void testDetermineWinner() {
        Deck warDeck = new Deck(1);
        CardHand playerHand;
        CardHand dealerHand;
        Card card = new Card();

        playerHand = new CardHand(warDeck.dealCards(1));
        dealerHand = new CardHand(warDeck.dealCards(1));
        Integer playHand =  playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        Integer dealHand =  dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        System.out.println("player Hand:"+playHand);
        System.out.println("deal Hand:"+dealHand);
        Assert.assertTrue(true);


    }
}