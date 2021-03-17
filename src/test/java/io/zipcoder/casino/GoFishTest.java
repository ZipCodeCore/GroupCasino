package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GoFishTest {

    GoFish go;

    @Before
    public void setUp() {
        go = new GoFish();
    }

    @Test
    public void testCreateNewDeck() {
        // Given
        int numberOfCards = 5;
        String expectedAtIdx0 = "Ace of Clubs";
        String expectedAtIdx1 = "2 of Clubs";
        String expectedAtIdx13 = "Ace of Diamonds";
        String expectedAtIdx28 = "3 of Hearts";
        String expectedAtIdx51 = "King of Spades";

        // When
        go.createNewDeck();
        ArrayList<String> actualDeck = go.getDeck();
        String actualAtIdx0 = actualDeck.get(0);
        String actualAtIdx1 = actualDeck.get(1);
        String actualAtIdx13 = actualDeck.get(13);
        String actualAtIdx28 = actualDeck.get(28);
        String actualAtIdx51 = actualDeck.get(51);

        // Then
        Assert.assertEquals(52, actualDeck.size());
        Assert.assertEquals(expectedAtIdx0,  actualAtIdx0);
        Assert.assertEquals(expectedAtIdx1,  actualAtIdx1);
        Assert.assertEquals(expectedAtIdx13,  actualAtIdx13);
        Assert.assertEquals(expectedAtIdx28,  actualAtIdx28);
        Assert.assertEquals(expectedAtIdx51,  actualAtIdx51);
    }

    @Test
    public void testShuffleCards() {
        // Given
        go.createNewDeck();
        ArrayList<String> unshuffledDeck = new ArrayList<String>(go.getDeck());

        // When
        go.shuffleCards();
        ArrayList<String> shuffledDeck = go.getDeck();

        // Then
        Assert.assertNotEquals(unshuffledDeck, shuffledDeck);

        //System.out.println(Arrays.toString(unshuffledDeck.toArray()));
        //System.out.println(Arrays.toString(shuffledDeck.toArray()));
    }

    @Test
    public void testDealCards() {
        // Given
        go.createNewDeck();
        ArrayList<String> actualDeck = go.getDeck();

        // When
        go.dealCards(5);
        ArrayList<String> actualPerson1 = go.getPlayersHand();
        ArrayList<String> actualPerson2 = go.getDealersHand();

        // Then
        Assert.assertEquals(5, actualPerson1.size());
        Assert.assertEquals(5, actualPerson2.size());
        Assert.assertEquals(42, actualDeck.size());

        //System.out.println(Arrays.toString(actualPerson1.toArray()));
        //System.out.println(Arrays.toString(actualPerson2.toArray()));
    }


}
