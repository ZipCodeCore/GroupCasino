package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {


    @Test
    public void game() {

        GoFish newgame = new GoFish(new Player("John", "007"));

        newgame.startGame();

    }

    @Test
    public void haveCard() {
        boolean result = false;
        Player testPlayer = new Player("V","B");
        GoFish testHaveCard = new GoFish(testPlayer);
        Card newCard = new Card(Suit.HEARTS,Rank.KING);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(newCard);
        CardHand testHand = new CardHand(cards);
        result = testHaveCard.haveCard(testHand,"KING");

        Assert.assertTrue(result);
    }

    @Test
    public void tradeCards() {
        boolean result = false;
        Player testPlayer = new Player("V","G");
        GoFish testGame = new GoFish(testPlayer);

        Card firstCard = new Card(Suit.CLUBS,Rank.KING);
        Card secondCard = new Card(Suit.CLUBS,Rank.ACE);

        ArrayList<Card> giveHand = new ArrayList<>();
        giveHand.add(firstCard);
        giveHand.add(secondCard);
        CardHand handOne = new CardHand(giveHand);

//        ************

        Card cardThree = new Card(Suit.CLUBS,Rank.JACK);
        Card cardFour = new Card(Suit.CLUBS,Rank.QUEEN);

        ArrayList<Card> receiveHand = new ArrayList<>();
        receiveHand.add(cardThree);
        receiveHand.add(cardFour);
        CardHand handTwo = new CardHand(receiveHand);

        result = testGame.tradeCards(handOne,"KING",handTwo).size() > 0;
        Assert.assertTrue(result);

        result = testGame.tradeCards(handOne,"TEN",handTwo).size() > 0;
        Assert.assertFalse(result);
    }

    @Test
    public void goFishForCard() {
        boolean result = false;
        Player testPlayer = new Player("V","G");
        GoFish testGame = new GoFish(testPlayer);

        Card firstCard = new Card(Suit.CLUBS,Rank.KING);
        Card testCard;
        ArrayList<Card> giveHand = new ArrayList<>();
        giveHand.add(firstCard);
        CardHand handOne = new CardHand(giveHand);

        testCard = testGame.goFishForCard(handOne);
        giveHand.add(testCard);
        result = giveHand.size()>1;

        Assert.assertTrue(result);
    }

    @Test
    public void checkIfWinner() {
        boolean result = false;
        Player testPlayer = new Player("V","B");
        GoFish testWinner = new GoFish(testPlayer);
        Card cardOne = new Card(Suit.HEARTS,Rank.KING);
        Card cardTwo = new Card(Suit.CLUBS,Rank.KING);
        Card cardThree = new Card(Suit.DIAMONDS,Rank.KING);
        Card cardFour = new Card(Suit.SPADES,Rank.KING);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(cardOne);
        cards.add(cardTwo);
        cards.add(cardThree);
        cards.add(cardFour);
        CardHand testHand = new CardHand(cards);

        result = testWinner.checkIfWinner(testHand);
        Assert.assertTrue(result);

        // ************

        cards.remove(0);

        cardOne  = new Card(Suit.HEARTS, Rank.FIVE);
        cards.add(cardOne);
        testHand = new CardHand(cards);
        result = testWinner.checkIfWinner(testHand);

        Assert.assertFalse(result);
    }

    @Test
    public void getCompCard() {
    }
}