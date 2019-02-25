package io.zipcoder.casino;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.CardGame.Cards.Suit;
import io.zipcoder.casino.CardGame.GoFishPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishPlayerTest {


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
    public void goFishPlayerConstructorTest(){

        // Given
        String expectedName = "Cara";
        Player expectedPlayer = new Player(expectedName, 10000);

        // When
        GoFishPlayer goFishPlayer = new GoFishPlayer(expectedPlayer);
        Player actualPlayer = goFishPlayer.getPlayer();
        String actualName = goFishPlayer.getName();

        // Then
        Assert.assertEquals(expectedPlayer, actualPlayer);
        Assert.assertEquals(expectedName, actualName);
    }


    @Test
    public void addCardsToHandsTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);

        goFishPlayer.getHand().showMyCards().add(h3);
        goFishPlayer.getHand().showMyCards().add(d9);
        goFishPlayer.getHand().showMyCards().add(cK);

        ArrayList<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(sK);
        cardsToAdd.add(hK);
        cardsToAdd.add(dK);

        ArrayList<Card> expected = new ArrayList<>();
        expected.add(h3);
        expected.add(d9);
        expected.add(cK);
        expected.add(sK);
        expected.add(hK);
        expected.add(dK);

        // When
        goFishPlayer.getHand().addCardsToHand(cardsToAdd);
        ArrayList<Card> actual = goFishPlayer.getHand().showMyCards();

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getCardCountInHandTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(dA);
        cards.add(hA);
        cards.add(s3);
        cards.add(s4);
        cards.add(d4);
        cards.add(c4);
        cards.add(h4);
        cards.add(s6);
        cards.add(h8);
        cards.add(c8);
        cards.add(sQ);
        cards.add(hQ);

        goFishPlayer.getHand().addCardsToHand(cards);

        Integer[] expected = {2, 0, 1, 4, 0, 1, 0, 2, 0, 0, 0, 2, 0};

        // When
        Integer[] actual = goFishPlayer.getCardCountInHand();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }


/*
    @Test
    public void layDown4OfAKindTest(){
        // Given
        Player player = new Player("Cara", 1000);
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);

        ArrayList<Card> cards = new ArrayList<>();
        cards.add(dA);
        cards.add(hA);
        cards.add(s3);
        cards.add(s4);
        cards.add(d4);
        cards.add(c4);
        cards.add(h4);
        cards.add(s6);
        cards.add(h8);
        cards.add(c8);
        cards.add(sQ);
        cards.add(hQ);

        goFishPlayer.addCardsToHands(cards);

    }*/
}
