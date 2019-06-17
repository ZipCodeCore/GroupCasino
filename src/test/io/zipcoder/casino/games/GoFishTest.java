package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Suit;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishTest {
    Console console = new Console(System.in, System.out);
    Player player = new Player("Aaaaa");
    GoFishPlayer goFishPlayer = new GoFishPlayer(player);
    GoFish goFish = new GoFish(goFishPlayer,console);




    @Test
    public void createOtherPlayersTest() {
        GoFish goFish = new GoFish();
        Integer expected = 2;
        //Integer actual = goFish.createOtherPlayers(expected).size();
        //Assert.assertEquals(expected,actual);
    }

    @Test
    public void runGoFishGameStart() {

    }

    @Test
    public void removeFourTest() {
        GoFish goFish = new GoFish();
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        goFish.removeFour("ACE",hand);
        Integer expected = 0;
        Integer actual = hand.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeFourTest1() {
        GoFish goFish = new GoFish();
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);

        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        goFish.removeFour("ACE",hand);
        Integer expected = 1;
        Integer actual = hand.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeFourTest2() {
        GoFish goFish = new GoFish();
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);

        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        goFish.removeFour("ACE",hand);
        Assert.assertTrue(hand.get(0).equals(card5));
    }


    @Test
    public void checkProperPickTest() {
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        goFishPlayer.setHand(hand);
        Assert.assertTrue(goFish.checkProperPick("TWO",goFishPlayer));
    }
    @Test
    public void checkProperPickTest1() {
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        goFishPlayer.setHand(hand);
        Assert.assertFalse(goFish.checkProperPick("SIX",goFishPlayer));
    }
    @Test (expected = NullPointerException.class)
    public void checkProperPickTest2() {
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        goFishPlayer.setHand(hand);
        goFish.checkProperPick("SIX",new GoFishPlayer());
    }

    @Test
    public void checkForFourTest() {
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        goFishPlayer.setHand(hand);
        goFish.checkForFour(goFishPlayer);
        Integer expected = 1;
        Integer actual = goFishPlayer.getHand().size();
        Assert.assertTrue(goFish.checkForFour(goFishPlayer));
    }
    @Test
    public void checkForFourTest1() {
        ArrayList<Card> hand = new ArrayList<Card>(4);
        Card card1 = new Card(CardValue.KING, Suit.CLUBS);
        Card card2 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card3 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card4 = new Card(CardValue.ACE, Suit.CLUBS);
        Card card5 = new Card(CardValue.TWO, Suit.CLUBS);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        goFishPlayer.setHand(hand);
        goFish.checkForFour(goFishPlayer);
        Integer expected = 1;
        Integer actual = goFishPlayer.getHand().size();
        Assert.assertFalse(goFish.checkForFour(goFishPlayer));
    }
    @Test
    public void RunGame() {
        goFish.runGame();
    }


    }

