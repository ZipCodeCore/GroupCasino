package io.zipcoder.casino.Casino;

import io.zipcoder.casino.Cards.Games.*;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Greeter;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GreeterTest {
    @Test
    public void testGetUserName() {
        // Given
        String expectedInput = "testName";
        byte[] inputBytes = expectedInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        String actualInput = greeter.getUserName();

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetUserName2() {
        // Given
        String expectedInput = "9990199User";
        byte[] inputBytes = expectedInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        String actualInput = greeter.getUserName();

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetUserName3() {
        // Given
        String expectedInput = "Jane Doe";
        byte[] inputBytes = "".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        String actualInput = greeter.getUserName();

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }
    @Test
    public void testDefaultConstructor() {
        // Given
        // When
        Greeter greeter = new Greeter();

        // Then
        Assert.assertTrue(greeter instanceof Greeter);
    }


    @Test
    public void testGetIfGambling() {
        // Given
        String input = "12";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isGambling = greeter.getIfGambling("Mary");

        // Then
        Assert.assertFalse(isGambling);
    }

    @Test
    public void testGetIfGambling2() {
        // Given
        String input = "21\nyes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isGambling = greeter.getIfGambling("Mary");

        // Then
        Assert.assertTrue(isGambling);
    }

    @Test
    public void testGetIfGambling3() {
        // Given
        String input = "21\n    no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isGambling = greeter.getIfGambling("Mary");

        // Then
        Assert.assertFalse(isGambling);
    }

    @Test
    public void testGetIfGambling4() {
        // Given
        String input = "21\n    asdfasdf";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isGambling = greeter.getIfGambling("Mary");

        // Then
        Assert.assertTrue(isGambling);
    }

    @Test
    public void testGetNextClean() {
        // Given
        String input = "blackjack";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextCleanGame();

        // Then
        Assert.assertTrue(game instanceof GoFish);
    }

    @Test
    public void testGetNextClean2() {
        // Given
        String input = "macao";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextCleanGame();

        // Then
        Assert.assertTrue(game instanceof Macao);
    }

    @Test
    public void testGetNextGame() {
        // Given
        String input = "blackjack";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextGame();

        // Then
        Assert.assertTrue(game instanceof BlackJack);
    }

    @Test
    public void testGetNextGame2() {
        // Given
        String input = "gofish";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextGame();

        // Then
        Assert.assertTrue(game instanceof GoFish);
    }

    @Test
    public void testGetNextGame3() {
        // Given
        String input = "djkldfsjklfadskl;";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextGame();

        // Then
        Assert.assertTrue(game instanceof GoFish);
    }

    @Test
    public void testGetNextGame4() {
        // Given
        String input = "craps";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextGame();

        // Then
        Assert.assertTrue(game instanceof Craps);
    }

    @Test
    public void testGetNextGame5() {
        // Given
        String input = "macao";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        Game game = greeter.getNextGame();

        // Then
        Assert.assertTrue(game instanceof Macao);
    }

    @Test
    public void getIfLeavingTest() {
        // Given
        String input = "no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isLeaving = greeter.getIfLeaving();

        // Then
        Assert.assertTrue(isLeaving);
    }

    @Test
    public void getIfLeavingTest2() {
        // Given
        String input = "asdfasdf";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isLeaving = greeter.getIfLeaving();

        // Then
        Assert.assertFalse(isLeaving);
    }

    @Test
    public void getIfLeavingTest3() {
        // Given
        String input = "yes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);
        Greeter greeter = new Greeter(console);

        // When
        boolean isLeaving = greeter.getIfLeaving();

        // Then
        Assert.assertFalse(isLeaving);
    }

    @Test
    public void balanceTooLowTest() {

        // Given
        String expected = String.format("Sorry, your balance is too low to keep playing.\n");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);

        // When
        greeter.balanceTooLow();
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void goodByeTest() {
        // Given
        String expected = String.format("Thank you so much for coming! Please come again!\n");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);

        // When
        greeter.goodBye();
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
