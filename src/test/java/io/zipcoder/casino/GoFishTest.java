package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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

    @Test
    public void testGetRankOnCard() {
        // Given
        String given = "2 of Diamonds";
        String expected = "2";

        String givenCase2 = "Ace of Hearts";
        String expectedCase2 = "Ace";

        String givenCase3 = "10 of Clubs";
        String expectedCase3 = "10";

        // When
        String actual = go.getRankOnCard(given);
        String actualCase2 = go.getRankOnCard(givenCase2);
        String actualCase3 = go.getRankOnCard(givenCase3);

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedCase2, actualCase2);
        Assert.assertEquals(expectedCase3, actualCase3);
    }

    @Test
    public void testGetValueOnCard() {
        // Given
        int expectedRank = 10;
        int expectedRank2 = 9;
        String inputRank = "Ace";
        String inputRank2 = "9";

        // When
        int actualRank = go.getValueOfCard(inputRank);
        int actualRank2 = go.getValueOfCard(inputRank2);

        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedRank2, actualRank2);
    }

    @Test
    public void testDisplayPlayersHand() {
        // Given
        ArrayList<String> playersHand = new ArrayList<String>(Arrays.asList("2 of Diamonds", "Queen of Hearts", "3 of Spades", "4 of Clubs", "7 of Hearts"));
        go.setPlayersHand(playersHand);
        String expected = "2 of Diamonds\nQueen of Hearts\n3 of Spades\n4 of Clubs\n7 of Hearts\n";

        // When
        String actual = go.displayPlayersHand(go.getPlayersHand());

        // Then
        Assert.assertEquals(expected, String.valueOf(actual));
    }

    @Test
    public void TestGetValueOfCard() {
        String given = "Ace of Hearts";
        String given1 = "2 of Clubs";
        String given2 = "7 of Diamonds";
        String given3 = "King of Diamonds";

        System.out.println(go.getValueOfCard(go.getRankOnCard(given)));
        System.out.println(go.getValueOfCard(go.getRankOnCard(given1)));
        System.out.println(go.getValueOfCard(go.getRankOnCard(given2)));
        System.out.println(go.getValueOfCard(go.getRankOnCard(given3)));

    }

    @Test
    public void testGetRankToAskFor_Human() {

    }

    @Test
    public void testGetRankToAskFor_Computer() {

    }

    @Test
    public void testCheckIfRankInPlayersHand() {

    }

    @Test
    public void testTakeCardFromOtherPlayer() {

    }

    @Test
    public void testDrawCardFromDeck() {
        // Given
        int expectedPlayerHand = 6;
        int expectedDeckSize = 41;
        go.setupGame(5);

        // When
        go.drawCardFromDeck(go.getPlayersHand());
        int actualPlayerHand = go.getPlayersHand().size();
        int actualDeckSize = go.getDeck().size();

        // Then
        Assert.assertEquals(expectedPlayerHand, actualPlayerHand);
        Assert.assertEquals(expectedDeckSize, actualDeckSize);
    }

    @Test
    public void testCheckFullBookInHand() {

    }

    @Test
    public void testCheckWinner() {

    }

}
