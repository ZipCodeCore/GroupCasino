package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class CardTest {

    private Card card1;

    @Before
    public void setUp() throws Exception {
        card1 = new Card("7","H");
    }

    @Test
    public void compareToTest() {
        Assert.assertTrue(card1.compareTo(new Card("8","H")) == -1);
    }

    @Test
    public void compareToTest2() {
        Assert.assertTrue(card1.compareTo(new Card("7","S")) == 1);
    }

    @Test
    public void compareToTest3() {
        Assert.assertTrue(card1.compareTo(new Card("3","C")) == 1);
    }

    @Test
    public void compareToTest4() {
        Assert.assertTrue(card1.compareTo(new Card("A","D")) == -1);
    }

    @Test
    public void compareToTest5() {
        Assert.assertTrue(card1.compareTo(new Card("A","D")) == -1);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("7\u2666", new Card("7","D").toString());
    }

    @Test
    public void testToString2() {
        Assert.assertEquals("7\u2665", card1.toString());
    }

    @Test
    public void testToString3() {
        Assert.assertEquals("3\u2663", new Card("3","C").toString());
    }

    @Test
    public void testToString4() {
        Assert.assertEquals("7\u2660", new Card("7","S").toString());
    }

    @Test
    public void sortToTestOrderingRulesTest() {
        Card[] cards = new Card[] {card1, new Card("3","C"), new Card("7","S"), new Card("A","D"), new Card("K","S"), new Card("J","C"), new Card("Q","D")};
        Card[] expected = new Card[] {new Card("3","C"),  new Card("7","S"), card1, new Card("J","C"), new Card("Q","D"), new Card("K","S"), new Card("A","D")};
        ArrayList<Card> cardAL = new ArrayList<Card>(Arrays.asList(cards));
        Collections.sort(cardAL);

        for (int i = 0; i < cards.length; i++) {
            Assert.assertTrue(expected[i].compareTo(cardAL.get(i)) == 0);
        }

    }

}