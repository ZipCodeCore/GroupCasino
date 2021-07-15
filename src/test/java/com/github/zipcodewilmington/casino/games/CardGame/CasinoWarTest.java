package com.github.zipcodewilmington.casino.games.CardGame;

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
    }

    @Test
    void playerWins() {
        CardHand playerHand;
        CardHand dealerHand;
        Deck warDeck = new Deck();
        playerHand = new CardHand(warDeck.dealCards(1));
        dealerHand = new CardHand(warDeck.dealCards(1));
    }
}