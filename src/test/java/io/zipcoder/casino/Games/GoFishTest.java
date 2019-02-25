package io.zipcoder.casino.Games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Cards.Games.GoFish;
import io.zipcoder.casino.Cards.Games.Macao;
import io.zipcoder.casino.Cards.Rank;
import io.zipcoder.casino.Cards.Suit;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Casino.Greeter;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;

public class GoFishTest {

    @Test
    public void dealerTurnTest() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish goFish = new GoFish(console);

        // When
        goFish.dealerTurn();
        String actual = outputStream.toString();

        // Then
        Assert.assertTrue(actual.contains("I'm out of cards in my hand! I'll just draw"));
    }

    @Test
    public void dealerTurnTest2() {
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
        goFish.dealerTurn();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 3;
        Assert.assertTrue(actual.contains("J'accuse!"));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
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
        goFish.getDealer().addToHand(testCard);

        // When
        goFish.tryForUserCard();
        String actual = outputStream.toString();

        // Then
        int expectedNumberOfDealerCards = 2;
        Assert.assertTrue(actual.contains("Huh, it doesn't actually look like you do."));
        Assert.assertEquals(expectedNumberOfDealerCards, goFish.getDealer().getHandSize());
    }

    @Test
    public void tryForUserCardTest4() {
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

        // When
        goFish.tryForUserCard();

        // Then
        int expectedNumberOfDealerCards = 2;
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

    @Test
    public void playTest() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);

        // When
        testGoFish.setIsOver(true);
        int actual = testGoFish.play();
        String actualString = outputStream.toString();

        // Then
        int expected = -5;
        String expectedString = "The object of this game is to get the most books (4 of a kind) down";
        Assert.assertFalse(actualString.contains("Alright, I'm going to play these:"));
        Assert.assertTrue(actualString.contains(expectedString));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUserTurn() {
        // Given
        String input = "king\nace";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);

        // When
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.userTurn();

        // Then
        String actual = outputStream.toString();
        Assert.assertTrue(actual.contains("You can only ask for cards you have"));
    }

    @Test
    public void testUserTurn2() {
        // Given
        String input = "ace";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);

        // When
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.userTurn();

        // Then
        String actual = outputStream.toString();
        Assert.assertTrue(actual.contains("Go Fish!"));
    }

    @Test
    public void testUserTurn3() {
        // Given
        String input = "ace\nking";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.KING));
        testGoFish.getDealer().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.userTurn();

        // Then
        int expectedCards = 0;
        int actualCards = testGoFish.getDealer().getHandSize();
        String actual = outputStream.toString();
        Assert.assertTrue(actual.contains("You got me"));
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testUserTurnWithBook() {
        // Given
        String input = "ace\nyes\nace";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getDealer().addToHand(new Card(Suit.HEARTS, Rank.KING));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.userTurn();

        // Then
        int expectedCards = 1;
        int actualCards = testGoFish.getUser().getHandSize();
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testBookTurn0() {
        // Given
        String input = "ace\nyes\nking";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getDealer().addToHand(new Card(Suit.HEARTS, Rank.KING));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.bookTurn();

        // Then
        int expectedCards = 4;
        int actualCards = testGoFish.getUser().getHandSize();
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testBookTurn() {
        // Given
        String input = "no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.bookTurn();

        // Then
        int expectedCards = 4;
        int actualCards = testGoFish.getUser().getHandSize();
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testBookTurn2() {
        // Given
        String input = "yes\nace";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.bookTurn();

        // Then
        int expectedCards = 0;
        int actualCards = testGoFish.getUser().getHandSize();
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testBookTurn3() {
        // Given
        String input = "yes\nking\nace";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));

        // When
        testGoFish.bookTurn();

        // Then
        int expectedCards = 4;
        int actualCards = testGoFish.getUser().getHandSize();
        String actual = outputStream.toString();
        Assert.assertEquals(expectedCards, actualCards);
        Assert.assertTrue(actual.contains("That's not a book."));
    }

    @Test
    public void testBookTurn4() {
        // Given
        String input = "yes\nace\nyes\nthree";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));


        // When
        testGoFish.bookTurn();

        // Then
        int expectedCards = 0;
        int actualCards = testGoFish.getUser().getHandSize();
        Assert.assertEquals(expectedCards, actualCards);
    }

    @Test
    public void testGoFish() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getDeck().drawMultipleCards(52);

        // When
        testGoFish.goFish(testGoFish.getUser(), null);

        // Then
        String actual = outputStream.toString();
        Assert.assertTrue(actual.contains("There are no more cards in the deck"));
    }

    @Test
    public void testGoFish2() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        Collections.sort(testGoFish.getDeck().getPlayDeck());

        // When
        testGoFish.goFish(testGoFish.getUser(), "ace");

        // Then
        String actual = outputStream.toString();
        System.out.print(outputStream.toString());
        Assert.assertTrue(actual.contains("Fish, Fish, you got your wish!"));
    }

    @Test
    public void testDisplayStatus() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.ACE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));
        testGoFish.getUser().addToHand(new Card(Suit.HEARTS, Rank.THREE));

        // When
        testGoFish.displayStatus();

        //Then
        String expected = "3━━━┓3━━━┓3━━━┓3━━━┓A━━━┓A━━━┓A━━━┓A━━━┓\n" +
                "┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃\n" +
                "┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃┃ ♡ ┃\n" +
                "┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃\n" +
                "┗━━━3┗━━━3┗━━━3┗━━━3┗━━━A┗━━━A┗━━━A┗━━━A\n" +
                "YOU: 0 DEALER: 0\n";
        String actual = outputStream.toString();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testEvaluate() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);


        // When
        testGoFish.evaluate();

        //Then

        Assert.assertFalse(testGoFish.isOver());

    }

    @Test
    public void testEvaluate2() {
        // Given
        String input = "no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getDealer().addToHand(testGoFish.getDeck().drawMultipleCards(52));
        testGoFish.playBooks();


        // When
        testGoFish.evaluate();

        //Then
        String actual = outputStream.toString();
        String expected = "Alright, I'm going to play these:\n" +
                "K━━━┓K━━━┓K━━━┓K━━━┓Q━━━┓Q━━━┓Q━━━┓Q━━━┓J━━━┓J━━━┓J━━━┓J━━━┓10━━┓10━━┓10━━┓10━━┓9━━━┓9━━━┓9━━━┓9━━━┓8━━━┓8━━━┓8━━━┓8━━━┓7━━━┓7━━━┓7━━━┓7━━━┓6━━━┓6━━━┓6━━━┓6━━━┓5━━━┓5━━━┓5━━━┓5━━━┓4━━━┓4━━━┓4━━━┓4━━━┓3━━━┓3━━━┓3━━━┓3━━━┓2━━━┓2━━━┓2━━━┓2━━━┓A━━━┓A━━━┓A━━━┓A━━━┓\n" +
                "┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃\n" +
                "┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃┃ ♧ ┃┃ ♢ ┃┃ ♡ ┃┃ ♤ ┃\n" +
                "┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃┃   ┃\n" +
                "┗━━━K┗━━━K┗━━━K┗━━━K┗━━━Q┗━━━Q┗━━━Q┗━━━Q┗━━━J┗━━━J┗━━━J┗━━━J┗━━10┗━━10┗━━10┗━━10┗━━━9┗━━━9┗━━━9┗━━━9┗━━━8┗━━━8┗━━━8┗━━━8┗━━━7┗━━━7┗━━━7┗━━━7┗━━━6┗━━━6┗━━━6┗━━━6┗━━━5┗━━━5┗━━━5┗━━━5┗━━━4┗━━━4┗━━━4┗━━━4┗━━━3┗━━━3┗━━━3┗━━━3┗━━━2┗━━━2┗━━━2┗━━━2┗━━━A┗━━━A┗━━━A┗━━━A\n" +
                "\n" +
                "Looks like I beat you this time. Come back anytime!\n";
        Assert.assertTrue(testGoFish.isOver());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testEvaluate3() {
        // Given
        String input = "yes\nace\nyes\ntwo\nyes\nthree\nyes\nfour\nyes\nfive\nyes\nsix\nyes\nseven\nyes\neight\nyes\nnine\nyes\n10\nyes\njs\nyes\nqueen\nyes\nkings";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        GoFish testGoFish = new GoFish(console);
        testGoFish.getUser().addToHand(testGoFish.getDeck().drawMultipleCards(52));
        testGoFish.bookTurn();
        System.out.print(Card.printAllCards(testGoFish.getUser().getHand()));
        System.out.print(outputStream.toString());

        // When
        testGoFish.evaluate();

        //Then
        String actual = outputStream.toString();
        String expected = "You won! Great game.\n";
        Assert.assertTrue(testGoFish.isOver());
        Assert.assertTrue(actual.contains(expected));

    }
}
