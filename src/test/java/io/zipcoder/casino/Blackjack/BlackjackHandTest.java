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
}