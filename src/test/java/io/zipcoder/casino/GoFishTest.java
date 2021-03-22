package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GoFishTest {

    GoFish go;
    Player p;

    @Before
    public void setUp() {
        p = new Player("Theresa", 500.00);
        go = new GoFish(p);
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
        String expected = "2 of Diamonds\n3 of Spades\n4 of Clubs\n7 of Hearts\nQueen of Hearts\n";

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
    public void testGetRankToAskFor_Computer() {
        // Given
        go.setDealersHand(new ArrayList<String>(Arrays.asList("Ace of Hearts", "2 of Spades", "6 of Diamonds")));

        // When
        String actual = go.getRankToAskFor_Computer();

        // Then
        Assert.assertTrue(actual.equals("Ace") || actual.equals("2") || actual.equals("6"));
    }

    @Test
    public void testCheckIfRankInPlayersHand() {
        // Given
        go.setPlayersHand(new ArrayList<String>(Arrays.asList("King of Diamonds", "4 of Spades")));

        // When
        go.setRankRequested("King");
        boolean actual = go.checkIfRankInHand(go.getPlayersHand());
        go.setRankRequested("4");
        boolean actual2 = go.checkIfRankInHand(go.getPlayersHand());

        // Then
        Assert.assertTrue(actual);
        Assert.assertTrue(actual2);
    }

    @Test
    public void testTakeCardFromOtherPlayer() {
        // Given
        go.setPlayersHand(new ArrayList<String>(Arrays.asList("2 of Clubs")));
        go.setDealersHand(new ArrayList<String>(Arrays.asList("Ace of Diamonds")));

        // When
        go.takeCardFromOtherPlayer(go.getPlayersHand(), go.getDealersHand(), "Ace");

        // Then
        ArrayList<String> expectedPlayer = new ArrayList<String>(Arrays.asList("2 of Clubs", "Ace of Diamonds"));
        ArrayList<String> expectedDealer = new ArrayList<String>();

        ArrayList<String> actualPlayer = go.getPlayersHand();
        ArrayList<String> actualDealer = go.getDealersHand();

        Assert.assertEquals(expectedPlayer, actualPlayer);
        Assert.assertEquals(expectedDealer, actualDealer);
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
    public void testCheckPairInHand() {
        // Given
        go.setPlayersHand(new ArrayList<String>(Arrays.asList("King of Hearts", "King of Diamonds", "Queen of Spades")));

        // When
        String pair = go.checkPairInHand(go.getPlayersHand());

        // Then
        Assert.assertEquals("King", pair);
    }

    @Test
    public void testRemovePairFromHand() {
        // Given
        go.setPlayersHand(new ArrayList<String>(Arrays.asList("King of Hearts", "King of Diamonds", "2 of Clubs", "Queen of Spades", "2 of Spades")));

        // When
        String actual = go.removePairFromHand(go.getPlayersHand());

        // Then
        Assert.assertEquals("2King", actual);
    }

    @Test
    public void checkGameOverTrue() {
        // Given
        ArrayList<String> actualDeck = new ArrayList<String>();
        go.setDeck(actualDeck);

        // When
        boolean actual = go.checkGameOver();

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkGameOverFalse() {
        // Given
        ArrayList<String> actualDeck = new ArrayList<String>(Arrays.asList("Jack of Clubs"));
        go.setDeck(actualDeck);

        // When
        boolean actual = go.checkGameOver();

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckWinner() {
        // Given
        go.setPairCounts(10, 3);
        String expected = "Player";

        // When
        String actual = go.checkForWinner();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
