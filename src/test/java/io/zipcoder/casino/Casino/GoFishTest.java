package io.zipcoder.casino.Casino;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Cards.Games.GoFish;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Greeter;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GoFishTest {

    @Test
    public void offerUserLeave4() {
        // Given
        String input = "yes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.setProfile();
        Casino.getProfile().setBalance(0);
        Casino.offerUserLeave();

        // Then
        Assert.assertTrue(Casino.isUserIsLeaving());
    }

    @Test
    public void dealerTurnTest() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        String expected = "Your current hand is: \n" +
                "\n" +
                "You currently have 0 books and the dealer has 0 books\n" +
                "I'm out of cards in my hand! I'll just draw\n";

        // When
        goFish.dealerTurn();
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tryForUserCardTest() {
        // Given
        String input = "no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getUser().addToHand(testCard);
        goFish.getUser().addToHand(testCard);

        // When
        goFish.tryForUserCard();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 3;
        Assert.assertTrue(actual.contains("J'accuse!"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void tryForUserCardTest2() {
        // Given
        String input = "yes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getUser().addToHand(testCard);
        goFish.getUser().addToHand(testCard);

        // When
        goFish.tryForUserCard();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 3;
        Assert.assertTrue(actual.contains("I'll take these:"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void tryForUserCardTest3() {
        // Given
        String input = "yes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        Card otherCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getUser().addToHand(otherCard);

        // When
        goFish.tryForUserCard();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 2;
        Assert.assertTrue(actual.contains("Huh, it doesn't actually look like you do."));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void playBooksTest() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);

        // When
        goFish.playBooks();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 0;
        Assert.assertTrue(actual.contains("Alright, I'm going to play these:"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void playBooksTest2() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        Card otherCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(otherCard);

        // When
        goFish.playBooks();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 1;
        Assert.assertTrue(actual.contains("Alright, I'm going to play these:"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void playBooksTest3() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);
        Deck deck = new Deck();
        Card testCard = deck.drawCard();
        Card otherCard = deck.drawCard();
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(testCard);
        goFish.getDealer().addToHand(otherCard);

        // When
        goFish.playBooks();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 3;
        Assert.assertFalse(actual.contains("Alright, I'm going to play these:"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

}
