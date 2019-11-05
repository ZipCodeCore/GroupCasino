package io.zipcoder.casino;

import io.zipcoder.casino.Utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class CardSetTest {

    private CardSet empty;
    private CardSet oneDeck;
    private CardSet fiveDecks;

    @Before
    public void setUp() throws Exception {
        empty = new CardSet(0);
        oneDeck = new CardSet(1);
        fiveDecks = new CardSet(5);
    }

    @Test
    public void getCardsTest1() {
        Assert.assertEquals(new ArrayList<Card>(),empty.getCards());
    }
    @Test
    public void getCardsTest2() {
        Assert.assertEquals(52,oneDeck.getCards().size());
    }
    @Test
    public void getCardsTest3() {
        Assert.assertEquals(260,fiveDecks.getCards().size());
    }
    @Test
    public void getCardsTest4() {
        int count = 0;
        for (Card card: oneDeck.getCards()) {
            if (card.equals(new Card("A","C"))) {
                count++;
            }
        }
        Assert.assertEquals(4, count);
    }
    @Test
    public void getCardsTest5() {
        int count = 0;
        for (Card card: fiveDecks.getCards()) {
            if (card.equals(new Card("A","C"))) {
                count++;
            }
        }
        Assert.assertEquals(20, count);
    }
    @Test
    public void getCardsTest6() {
        int count = 0;
        for (Card card: fiveDecks.getCards()) {
            if (card.strictEquals(new Card("A","C"))) {
                count++;
            }
        }
        Assert.assertEquals(5, count);
    }

    @Test
    public void sizeTest1() {
        Assert.assertEquals(0,empty.size());
    }
    @Test
    public void sizeTest2() {
        Assert.assertEquals(52,oneDeck.size());
    }
    @Test
    public void sizeTest3() {
        Assert.assertEquals(260,fiveDecks.size());
    }

    @Test
    public void removeFirstCard() {
        Assert.assertTrue(new Card("2","S").strictEquals(oneDeck.removeFirstCard()));
        Assert.assertEquals(51,oneDeck.size());
        Assert.assertTrue(new Card("2","C").strictEquals(oneDeck.removeFirstCard()));
        Assert.assertEquals(50,oneDeck.size());
    }

    @Test
    public void removeCard() {
        Assert.assertTrue(oneDeck.removeCard(new Card("K","C")));
        Assert.assertEquals(51,oneDeck.size());
        Assert.assertFalse(oneDeck.removeCard(new Card("K","C")));
        Assert.assertEquals(51,oneDeck.size());
        Assert.assertFalse(empty.removeCard(new Card("K","C")));
    }

    @Test
    public void addCard() {
        oneDeck.addCard(new Card("K","C"));
        Assert.assertTrue(oneDeck.removeCard(new Card("K","C")));
        Assert.assertEquals(52,oneDeck.size());
        Assert.assertTrue(oneDeck.removeCard(new Card("K","C")));
        Assert.assertEquals(51,oneDeck.size());
        Assert.assertFalse(oneDeck.removeCard(new Card("K","C")));
        Assert.assertEquals(51,oneDeck.size());

    }

    @Test
    public void clearTest() {
        Assert.assertEquals(52,oneDeck.size());
        oneDeck.clear();
        Assert.assertEquals(0,oneDeck.size());
    }

    @Test
    public void clearTest2() {
        Assert.assertEquals(0,empty.size());
        oneDeck.clear();
        Assert.assertEquals(0,empty.size());
    }

    @Test
    public void addCard2() {
        empty.addCard(new Card("A","D"));
        empty.addCard(new Card("4","H"));
        empty.addCard(new Card("7","S"));
        empty.addCard(new Card("5","C"));
        empty.addCard(new Card("2","D"));
        Assert.assertEquals(5,empty.size());
        Assert.assertTrue(new Card("A","D").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("4","H").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(empty.removeCard(new Card("7","S")));
        Assert.assertTrue(new Card("5","C").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("2","D").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(null == empty.removeFirstCard());
    }

    @Test
    public void sortTest() {
        empty.addCard(new Card("A","D"));
        empty.addCard(new Card("4","H"));
        empty.addCard(new Card("7","S"));
        empty.addCard(new Card("5","C"));
        empty.addCard(new Card("2","D"));

        empty.sort();
        Assert.assertTrue(new Card("2","D").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("4","H").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("5","C").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("7","S").strictEquals(empty.removeFirstCard()));
        Assert.assertTrue(new Card("A","D").strictEquals(empty.removeFirstCard()));
    }

    @Test
    public void shuffleTest() {
        Assert.assertTrue(new Card("2","S").strictEquals(fiveDecks.getCards().get(0))
         && new Card("2","C").strictEquals(fiveDecks.getCards().get(1))
         && new Card("2","D").strictEquals(fiveDecks.getCards().get(2))
         && new Card("2","H").strictEquals(fiveDecks.getCards().get(3)));

        fiveDecks.shuffle();
        Assert.assertFalse(new Card("2","S").strictEquals(fiveDecks.getCards().get(0))
                && new Card("2","C").strictEquals(fiveDecks.getCards().get(1))
                && new Card("2","D").strictEquals(fiveDecks.getCards().get(2))
                && new Card("2","H").strictEquals(fiveDecks.getCards().get(3)));
    }

    @Test
    public void sortandShuffleTest() {
        ArrayList<Card> fiveDecksClone = (ArrayList<Card>) fiveDecks.getCards().clone();
        Collections.sort(fiveDecksClone);
        fiveDecks.sort();
        Assert.assertTrue("one",fiveDecksClone.equals(fiveDecks.getCards()));
        fiveDecks.shuffle();
        Assert.assertFalse("two",fiveDecksClone.equals(fiveDecks.getCards()));
        fiveDecks.sort();
        // the card objects are in a different order, so we have to loop to test if they're isomorphic
        for (int i = 0; i < fiveDecks.getCards().size(); i++) {
            Assert.assertTrue(fiveDecks.getCards().get(i).equals(fiveDecksClone.get(i)));
        }
    }

    @Test
    public void toASCIItest() {
        CardSet cards = new CardSet(0);
        cards.addCard(new Card("A","H"));
        cards.addCard(new Card("K","D"));
        cards.addCard(new Card("Q","S"));
        cards.addCard(new Card("J","C"));
        cards.addCard(new Card("10","H"));
        cards.addCard(new Card("9","D"));
        cards.addCard(new Card("8","S"));
        cards.addCard(new Card("7","C"));

        Console console = new Console(System.in, System.out);
        console.println(cards.toASCII());
    }
}