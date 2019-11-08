package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.CardValue;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.GamePieces.Suit;
import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BlackJackTest {



    @Test
    public void initialHand() {

        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();
        assertTrue(blackJack.dealerHand[1]!=null);
        assertTrue(blackJack.dealerHand[0]!=null);

    }


    @Test
   public void placeBet() {
        String input = "45";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
     Player currentPlayer = new Player("Tidus" , 500);
        BlackJack blackJack = new BlackJack();
       blackJack.deck = new Deck();
       blackJack.placeBet(currentPlayer);
       assertTrue(blackJack.pot == 45);

   }



    @Test
    public void hitOrStay() {
        String input = "stay";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BlackJack blackJack = new BlackJack();
       blackJack.deck = new Deck();
        blackJack.initialHand();
        blackJack.hitOrStay();
        assertTrue(blackJack.playerHand[2]==null);


        }

    @Test
    public void hit() {

        String input = "stay";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();
       blackJack.hit();
       assertTrue(blackJack.playerHand[2]!=null);
    }

    @Test
    public void notBusted() {
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        assertTrue(blackJack.notBusted(20));
        assertTrue(blackJack.notBusted(16));
        assertFalse(blackJack.notBusted(30));
    }

    @Test
    public void stay() {
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();
        blackJack.stay();
        assertTrue(blackJack.dealerHand[1]!=null);
        assertTrue(blackJack.dealerHand[0]!=null);

    }



    @Test
    public void isLoser() {
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();
        blackJack.isLoser();
        assertTrue(blackJack.getWinner().equals(blackJack.dealer));

    }

    @Test
    public void checkHand() {

        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();
        assertTrue(blackJack.checkHand(blackJack.dealerHand).equals(blackJack.checkHand(blackJack.dealerHand)));
    }





    @Test
    public void dealerMove() {
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        Card card = new Card(CardValue.TEN, Suit.HEARTS) ;
        Card card1 = new Card(CardValue.SIX, Suit.HEARTS) ;
        blackJack.dealerHand[0] = card;
        blackJack.dealerHand[1] = card1;
        blackJack.dealerMove();
        assertTrue(blackJack.checkHand(blackJack.dealerHand)== 16);


    }

    @Test
    public void getWinner() {
        BlackJack blackJack = new BlackJack();
        blackJack.deck = new Deck();
        blackJack.initialHand();

        blackJack.isLoser();
        assertTrue(blackJack.getWinner().equals(blackJack.dealer));
    }
}