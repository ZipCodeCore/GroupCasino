package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackTest {



    @Test
    public void initialHand() {
        BlackJack blackJack = new BlackJack();
        Card dealerHand [] = new Card[6];
        blackJack.initialHand();
        assertTrue(dealerHand[0]!=null);




    }
    @Test
    public void viewCurrentHand() {
    }

    @Test
    public void viewDealerHand() {
    }

    @Test
    public void placeBet() {
    }

    @Test
    public void returnWinnings() {
    }



    @Test
    public void hitOrStay() {
    }

    @Test
    public void hit() {
    }

    @Test
    public void notBusted() {
    }

    @Test
    public void stay() {
    }

    @Test
    public void isWinner() {
    }

    @Test
    public void isLoser() {
    }

    @Test
    public void checkHand() {
    }



    @Test
    public void specialFive() {
    }

    @Test
    public void exitGame() {
    }

    @Test
    public void dealerMove() {
    }
}