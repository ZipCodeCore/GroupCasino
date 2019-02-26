package io.zipcoder.casino.Casino;


import io.zipcoder.casino.Games.BlackJack;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.Games.GoFish;
import io.zipcoder.casino.Games.Macao;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CasinoTest {
    @Test
    public void greetUserTest() {
        // Given
        String input = "testName\n18\nyes";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        String actual = Casino.getProfile().getName();

        // Then
        String expected = "testName";
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(Casino.getProfile().isGambler());
    }

    @Test
    public void greetUserTest2() {
        // Given
        String input = "name\n1";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        String actual = Casino.getProfile().getName();

        // Then
        String expected = "name";
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(Casino.getProfile().isGambler());
    }

    @Test
    public void greetUserTest3() {
        // Given
        String input = "othername\n45\nno";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        String actual = Casino.getProfile().getName();

        // Then
        String expected = "othername";
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(Casino.getProfile().isGambler());
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
    public void offerUserGames() {
        // Given
        String input = "othername\n45\nno\nmacao";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        Game game = Casino.offerUserGames();

        // Then
        Assert.assertTrue(game instanceof Macao);
    }

    @Test
    public void offerUserGames2() {
        // Given
        String input = "othername\n45\nyes\ngasdfasdf";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        Game game = Casino.offerUserGames();

        // Then
        Assert.assertTrue(game instanceof GoFish);
    }

    @Test
    public void offerUserGames3() {
        // Given
        String input = "othername\n45\nyes\nblackjack";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.greetUser();
        Game game = Casino.offerUserGames();

        // Then
        Assert.assertTrue(game instanceof BlackJack);
    }


    @Test
    public void offerUserLeaveTest() {
        // Given
        String input = "no";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.setProfile();
        Casino.offerUserLeave();

        // Then
        Assert.assertTrue(Casino.isUserIsLeaving());
    }

    @Test
    public void offerUserLeaveTest2() {
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
        Casino.offerUserLeave();

        // Then
        Assert.assertFalse(Casino.isUserIsLeaving());
    }

    @Test
    public void offerUserLeaveTest3() {
        // Given
        String input = "asdfasdf";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);

        // When
        Casino.setProfile();
        Casino.offerUserLeave();

        // Then
        Assert.assertFalse(Casino.isUserIsLeaving());
    }

    @Test
    public void offerUserLeaveTest4() {
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
    public void seeUserOutTest() {
        // Given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);
        String expected = "Thank you so much for coming! Please come again!\n";

        // When
        Casino.seeUserOut();

        // Then
        String actual = outputStream.toString();
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void entertainUserTest() {
        // Given
        String input = "testname\n1\ntestingcheatsenabledtrue\nno";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);

        Casino.setGreeter(greeter);

        // When
        Casino.setProfile();
        Casino.entertainUser();
        String actual = outputStream.toString();

        // Then
        Assert.assertTrue(Casino.isUserIsLeaving());
        Assert.assertTrue(actual.contains("Thank you so much for coming! Please come again!") &&
                actual.contains("Welcome to our Casino! What's your name?"));
    }

    @Test
    public void mainTest() {
        // Given
        String input = "testname\n1\ntestingcheatsenabledtrue\nno";
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        Greeter greeter = new Greeter(console);
        Casino.setGreeter(greeter);
        Casino.setProfile();

        // When
        Casino.main(new String[0]);
        String actual = outputStream.toString();

        // Then
        Assert.assertTrue(Casino.isUserIsLeaving());
        Assert.assertTrue(actual.contains("Thank you so much for coming! Please come again!") &&
                actual.contains("Welcome to our Casino! What's your name?"));
    }
}
