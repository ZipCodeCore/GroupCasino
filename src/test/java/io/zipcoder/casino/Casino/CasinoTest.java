package io.zipcoder.casino.Casino;


import io.zipcoder.casino.Cards.Games.BlackJack;
import io.zipcoder.casino.Cards.Games.Game;
import io.zipcoder.casino.Cards.Games.GoFish;
import io.zipcoder.casino.Cards.Games.Macao;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Greeter;
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
    public void playGameWithUserTest() {
        // Given
        Game game = new Game();
        Casino.setProfile();
        int expectedBalance = Casino.getProfile().getBalance() - 13;
        // When
        Casino.playGameWithUser(game);
        int actualBalance = Casino.getProfile().getBalance();
                // Then
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void offerUserLeave() {
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
    public void offerUserLeave2() {
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
    public void offerUserLeave3() {
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
    public void seeUserOut() {
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
        Assert.assertEquals(expected, actual);
    }
}
