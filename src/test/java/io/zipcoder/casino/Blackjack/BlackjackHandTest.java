package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BlackjackHandTest {

    private BlackjackGame blackjackGame;
    private Player player;
    private BlackjackHand hand;
    private BlackjackPlayer bjp;

    @Before
    public void setUp() throws Exception {
        player = new Player("William", "Adama", 45, 300.00);
        blackjackGame = new BlackjackGame(0.0, 0.0, player);
        bjp = blackjackGame.getPlayer();
        blackjackGame.checkShoe();
        blackjackGame.initialDeal();
        hand = bjp.getHands().get(0);
    }

    @Test
    public void getCards() {
    }

    @Test
    public void getBet() {
    }

    @Test
    public void getValue() {
    }

    @Test
    public void getPlayer() {
    }

    @Test
    public void setCards() {
    }

    @Test
    public void setBet() {
    }

    @Test
    public void setValue() {
    }

    @Test
    public void setPlayer() {
    }

    @Test
    public void clearTest() {
        Assert.assertEquals(2,(int) hand.size());
        hand.clear();
        Assert.assertEquals(0,(int) hand.size());
        hand.clear();
        Assert.assertEquals(0,(int) hand.size());
    }

    @Test
    public void addCardTest() {
        Assert.assertEquals(2,(int) hand.size());
        Card card1 = new Card("4","D");
        hand.addCard(card1);
        Assert.assertEquals(3,(int) hand.size());
        hand.getCards().removeFirstCard();
        hand.getCards().removeFirstCard();
        Assert.assertEquals(card1, hand.getCards().removeFirstCard());
    }

    @Test
    public void arraySumTest() {
        ArrayList<Integer> array = new ArrayList(Arrays.asList(2,4,10,11));
        Assert.assertEquals(27,hand.arraySum(array));
        array = new ArrayList(Arrays.asList(2,3,10,31,0,11));
        Assert.assertEquals(57,hand.arraySum(array));
    }

    @Test
    public void mapCardsTest() {
        CardSet cards = new CardSet(0);
        cards.addCard(new Card("A","S"));
        cards.addCard(new Card("2","H"));
        cards.addCard(new Card("5","D"));
        cards.addCard(new Card("K","C"));

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual = hand.mapCardValues(cards);
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(11,10,5,2));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapCardsTest2() {
        CardSet cards = new CardSet(0);
        cards.addCard(new Card("3","S"));
        cards.addCard(new Card("Q","H"));
        cards.addCard(new Card("J","D"));
        cards.addCard(new Card("10","C"));

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual = hand.mapCardValues(cards);
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(10,10,10,3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void determineHandValueTest() {
        hand.clear();
        hand.addCard(new Card("3","S"));
        hand.addCard(new Card("Q","H"));
        hand.addCard(new Card("J","D"));
        hand.addCard(new Card("10","C"));

        Assert.assertEquals(0,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest2() {
        hand.clear();
        hand.addCard(new Card("A","S"));
        hand.addCard(new Card("3","H"));
        hand.addCard(new Card("5","D"));
        hand.addCard(new Card("4","C"));

        Assert.assertEquals(13,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest3() {
        hand.clear();
        hand.addCard(new Card("A","S"));
        hand.addCard(new Card("K","H"));


        Assert.assertEquals(21,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest4() {
        hand.clear();
        hand.addCard(new Card("2","S"));
        hand.addCard(new Card("K","H"));
        hand.addCard(new Card("5","D"));
        hand.addCard(new Card("4","C"));

        Assert.assertEquals(21,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest5() {
        hand.clear();
        hand.addCard(new Card("A","S"));
        hand.addCard(new Card("3","H"));
        hand.addCard(new Card("K","D"));
        hand.addCard(new Card("4","C"));

        Assert.assertEquals(18,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest6() {
        hand.clear();
        hand.addCard(new Card("3","H"));
        hand.addCard(new Card("K","D"));
        hand.addCard(new Card("4","C"));

        Assert.assertEquals(17,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest7() {
        hand.clear();

        Assert.assertEquals(0,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest8() {
        hand.clear();
        hand.addCard(new Card("A","H"));
        hand.addCard(new Card("A","D"));

        Assert.assertEquals(12,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest9() {
        hand.clear();
        for (int i = 0; i < 21; i++) {
            hand.addCard(new Card("A", "H"));
        }

        Assert.assertEquals(21,hand.determineHandValue());
    }

    @Test
    public void determineHandValueTest10() {
        hand.clear();
        for (int i = 0; i < 22; i++) {
            hand.addCard(new Card("A", "H"));
        }

        Assert.assertEquals(0,hand.determineHandValue());
    }
}