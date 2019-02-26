package io.zipcoder.casino;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.CardGame.Cards.Suit;
import io.zipcoder.casino.CardGame.GoFish;
import io.zipcoder.casino.CardGame.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishTests {

    Card hA = new Card(Face.ACE, Suit.HEARTS);
    Card sA = new Card(Face.ACE, Suit.SPADES);
    Card cA = new Card(Face.ACE, Suit.CLUBS);
    Card dA = new Card(Face.ACE, Suit.DIAMONDS);
    Card h2 = new Card(Face.TWO, Suit.HEARTS);
    Card s2 = new Card(Face.TWO, Suit.SPADES);
    Card c2 = new Card(Face.TWO, Suit.CLUBS);
    Card d2 = new Card(Face.TWO, Suit.DIAMONDS);
    Card h3 = new Card(Face.THREE, Suit.HEARTS);
    Card s3 = new Card(Face.THREE, Suit.SPADES);
    Card c3 = new Card(Face.THREE, Suit.CLUBS);
    Card d3 = new Card(Face.THREE, Suit.DIAMONDS);
    Card h4 = new Card(Face.FOUR, Suit.HEARTS);
    Card s4 = new Card(Face.FOUR, Suit.SPADES);
    Card c4 = new Card(Face.FOUR, Suit.CLUBS);
    Card d4 = new Card(Face.FOUR, Suit.DIAMONDS);
    Card h5 = new Card(Face.FIVE, Suit.HEARTS);
    Card s5 = new Card(Face.FIVE, Suit.SPADES);
    Card c5 = new Card(Face.FIVE, Suit.CLUBS);
    Card d5 = new Card(Face.FIVE, Suit.DIAMONDS);
    Card h6 = new Card(Face.SIX, Suit.HEARTS);
    Card s6 = new Card(Face.SIX, Suit.SPADES);
    Card c6 = new Card(Face.SIX, Suit.CLUBS);
    Card d6 = new Card(Face.SIX, Suit.DIAMONDS);
    Card h7 = new Card(Face.SEVEN, Suit.HEARTS);
    Card s7 = new Card(Face.SEVEN, Suit.SPADES);
    Card c7 = new Card(Face.SEVEN, Suit.CLUBS);
    Card d7 = new Card(Face.SEVEN, Suit.DIAMONDS);
    Card h8 = new Card(Face.EIGHT, Suit.HEARTS);
    Card s8 = new Card(Face.EIGHT, Suit.SPADES);
    Card c8 = new Card(Face.EIGHT, Suit.CLUBS);
    Card d8 = new Card(Face.EIGHT, Suit.DIAMONDS);
    Card h9 = new Card(Face.NINE, Suit.HEARTS);
    Card s9 = new Card(Face.NINE, Suit.SPADES);
    Card c9 = new Card(Face.NINE, Suit.CLUBS);
    Card d9 = new Card(Face.NINE, Suit.DIAMONDS);
    Card h10 = new Card(Face.TEN, Suit.HEARTS);
    Card s10 = new Card(Face.TEN, Suit.SPADES);
    Card c10 = new Card(Face.TEN, Suit.CLUBS);
    Card d10 = new Card(Face.TEN, Suit.DIAMONDS);
    Card hJ = new Card(Face.JACK, Suit.HEARTS);
    Card sJ = new Card(Face.JACK, Suit.SPADES);
    Card cJ = new Card(Face.JACK, Suit.CLUBS);
    Card dJ = new Card(Face.JACK, Suit.DIAMONDS);
    Card hQ = new Card(Face.QUEEN, Suit.HEARTS);
    Card sQ = new Card(Face.QUEEN, Suit.SPADES);
    Card cQ = new Card(Face.QUEEN, Suit.CLUBS);
    Card dQ = new Card(Face.QUEEN, Suit.DIAMONDS);
    Card hK = new Card(Face.KING, Suit.HEARTS);
    Card sK = new Card(Face.KING, Suit.SPADES);
    Card cK = new Card(Face.KING, Suit.CLUBS);
    Card dK = new Card(Face.KING, Suit.DIAMONDS);

    @Test
    public void getLastCardTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFish goFish = new GoFish(player);
        GoFishPlayer goFishPlayer = goFish.getGoFishPlayer();

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(dJ);
        cards.add(cK);
        cards.add(h9);

        goFishPlayer.getHand().addCardsToHand(cards);

        Card expected = h9;

        // When
        Card actual = goFish.getLastCard(goFishPlayer);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getCardOptionsTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFish goFish = new GoFish(player);

        String expected = "\n'Ace' 'Two' 'Three' 'Four' 'Five' 'Six' 'Seven' 'Eight' 'Nine ' Ten' 'Jack' 'Queen' 'King'\n";

        // When
        String actual = goFish.getCardOptions();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void updatePlayerScoreTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFish goFish = new GoFish(player);
        GoFishPlayer goFishPlayer = goFish.getGoFishPlayer();

        int expected = 5;
        goFishPlayer.setCounter4(expected);

        // When
        goFish.updatePlayerScore();
        int actual = goFish.getPlayersScoreCounter();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateDealerScoreTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFish goFish = new GoFish(player);
        GoFishPlayer dealer = goFish.getDealer();

        int expected = 5;
        dealer.setCounter4(expected);

        // When
        goFish.updateDealerScore();
        int actual = goFish.getDealersScoreCounter();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
