package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Cards.Games.Macao;
import org.junit.Assert;
import org.junit.Test;
import io.zipcoder.casino.utilities.Console;

import java.io.*;
import java.util.Scanner;

public class MacaoTest {

    private Macao macao = new Macao();
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Console console = new Console(System.in, new PrintStream(outputStream));

    @Test
    public void ConstructorTest() {
        // Given macao data
        boolean expectedIsOver = false;
        boolean expectedGuestIsPlaying = true;
        boolean expectedDealerIsPlaying = true;

        // When the data is retrieved from the game instance
        boolean actualIsOver = macao.getIsOver();
        boolean actualGuestIsPlaying = macao.getGuestStillPlaying();
        boolean actualDealerIsPlaying = macao.getDealerStillPlaying();

        // Then you expect the given data to match the retrieved data
        Assert.assertEquals(expectedIsOver, actualIsOver);
        Assert.assertEquals(expectedGuestIsPlaying ,actualGuestIsPlaying);
        Assert.assertEquals(expectedDealerIsPlaying, actualDealerIsPlaying);
    }

    @Test
    public void getIsOverTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'is over' is set to the expected value
        macao.setIsOver(expected);

        // When we retrieve the variable for 'is over' from the game
        boolean actual = macao.getIsOver();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setIsOverTest() {
        // Given an initial variable for 'is Over' (which is false upon construction)
        boolean initial = macao.getIsOver();

        // When we set the 'is Over' variable to true
        macao.setIsOver(true);

        // When we retrieve the 'is Over' variable from the game
        boolean changed = macao.getIsOver();

        // Then we expect the initial to be false and the changed variable to be true
        Assert.assertFalse(initial);
        Assert.assertTrue(changed);
    }

    @Test
    public void getGuestStillPlayingTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'guest still playing' is set to the expected value
        macao.setGuestStillPlaying(expected);

        // When we retrieve the variable for 'guest still playing' from the game
        boolean actual = macao.getGuestStillPlaying();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setGuestStillPlayingTest() {
        // Given an initial variable for 'guest still playing' (which is true upon construction)
        boolean initial = macao.getGuestStillPlaying();

        // When we set the 'guest still playing' variable to true
        macao.setGuestStillPlaying(false);

        // When we retrieve the 'guest still playing' variable from the game
        boolean changed = macao.getGuestStillPlaying();

        // Then we expect the initial to be true and the changed variable to be false
        Assert.assertTrue(initial);
        Assert.assertFalse(changed);
    }

    @Test
    public void getDealerStillPlayingTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'dealer still playing' is set to the expected value
        // 
        macao.setDealerStillPlaying(expected);

        // When we retrieve the variable for 'dealer still playing' from the game
        boolean actual = macao.getDealerStillPlaying();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setDealerStillPlayingTest() {
        // Given an initial variable for 'dealer still playing' (which is true upon construction)
        boolean initial = macao.getDealerStillPlaying();

        // When we set the 'dealer still playing' variable to true
        macao.setDealerStillPlaying(false);

        // When we retrieve the 'dealer still playing' variable from the game
        boolean changed = macao.getDealerStillPlaying();

        // Then we expect the initial to be true and the changed variable to be false
        Assert.assertTrue(initial);
        Assert.assertFalse(changed);
    }

    @Test
    public void printGameInstructionsTest() {
        // Given the expected string
        String expected = "Rules:\nThe object of this game is to roll the die enough times to reach a total of 9 without going over.\nGood luck!";

        // When the console is changed to the test console
        macao.setConsole(console);

        // When the print game instructions method is called (trim has to be called also to fix new line error)
        macao.printGameInstructions();
        String actual = outputStream.toString();
        actual = actual.trim();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void beginGameTest1() {
        // Given user input = 'y' and the console is set to our console
        String userInput = "y";
        byte[] inputBytes = userInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console ioconsole = new Console(new Scanner(inputByteArray), new PrintStream(outputStream));
        macao.setConsole(ioconsole);

        // When begin game is called
        boolean retrieved = macao.beginGame();

        // Then the retrieved boolean should be true (i.e. the game should begin)
        Assert.assertTrue(retrieved);
    }

    @Test
    public void beginGameTest2() {
        // Given user input = 'x' and the console is set to our console
        String userInput = "x";
        byte[] inputBytes = userInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console ioconsole = new Console(new Scanner(inputByteArray), System.out);
        macao.setConsole(ioconsole);

        // Given the expected string output
        String expected = "Try again.";

        // When begin game is called & the output stored in a variable
        boolean retrieved = macao.beginGame();
        String actual = outputStream.toString();

        // Then the retrieved boolean should be false (i.e. the game should not start) & the given string should match the actual string
        Assert.assertFalse(retrieved);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showInitialRollsTest() {
        // Given we set the guest's roll to 3 and the dealer's roll to 4
        macao.getMacaoGuest().setRoll(3);
        macao.getMacaoDealer().setRoll(4);

        // Given the expected string
        String expected = "YOUR ROLL: 3 | DEALER'S ROLL: 4";

        // When we set the console to the test console
        macao.setConsole(console);

        // When we print out the initial rolls and store the string output in a variable
        macao.showInitialRolls();
        String actual = outputStream.toString();
        actual = actual.trim();

        // Then we expect the given and the retrieved data to match
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void youWentOverTest() {
        // Given the expected string
        String expected = "Sorry, you went over. You lose!";

        // When we set the console to the test console
        macao.setConsole(console);

        // When we call the you went over method & store the string output in a variable
        macao.youWentOver();
        String actual = outputStream.toString().trim();

        // Then we expect the given string to match the retrieved string.
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void didGuestGoOverTest1() {
        // Given the guest has a cumulative roll of 10
        int cumuRoll = 10;
        macao.getMacaoGuest().setCumulativeRoll(cumuRoll);

        // When we call the 'did guest go over method'
        Boolean guestWentOver = macao.didGuestGoOver();

        // Then we expect guestWentOver to be true since 10 is over 9
        Assert.assertTrue(guestWentOver);
    }

    @Test
    public void didGuestGoOverTest2() {
        // Given the guest has a cumulative roll of 7
        int cumuRoll = 7;
        macao.getMacaoGuest().setCumulativeRoll(cumuRoll);

        // When we call the 'did guest go over method'
        Boolean guestWentOver = macao.didGuestGoOver();

        // Then we expect guestWentOver to be false since 7 under 9
        Assert.assertFalse(guestWentOver);
    }

    @Test
    public void dealerStillPlayingTest1() {
        // Given the dealers cumulative roll is 7 and the guest's cumulative roll is 6
        macao.getMacaoDealer().setCumulativeRoll(7);
        macao.getMacaoGuest().setCumulativeRoll(6);

        // When we call the 'dealer still playing function'
        Boolean dealerStillPlaying = macao.isDealerStillPlaying();

        // Then we expect it to return false because the dealers roll is both over 7 and over the guests cumulative roll
        Assert.assertFalse(dealerStillPlaying);
    }

    @Test
    public void dealerStillPlayingTest2() {
        // Given the dealer's cumulative roll is 4 and the guest's cumulative roll is 8
        macao.getMacaoDealer().setCumulativeRoll(4);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // When we call the 'dealer still playing function'
        Boolean dealerStillPlaying = macao.isDealerStillPlaying();

        // Then we expect it to return true because the dealers roll is both less than 9 and less than the guests cumulative roll
        Assert.assertTrue(dealerStillPlaying);
    }

    @Test
    public void dealerStillPlayingTest3() {
        // Given the dealer's cumulative roll is 4 and the guest's cumulative roll is 8
        macao.getMacaoDealer().setCumulativeRoll(9);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // When we call the 'dealer still playing function'
        Boolean dealerStillPlaying = macao.isDealerStillPlaying();

        // Then we expect it to return false because the dealers roll is 9
        Assert.assertFalse(dealerStillPlaying);
    }

    @Test
    public void evaluateTest1() {
        // Given the dealers cumulative roll is 10, the console is our test console, and we expect 'the dealer went over' to print
        macao.getMacaoDealer().setCumulativeRoll(10);
        macao.setConsole(console);
        String expected = "The dealer went over. You win!";

        // When we call the evaluate function & we store the output in a string variable
        macao.evaluate();
        String actual = outputStream.toString().trim();

        // When we retrieve the 'is Over' variable
        boolean retrieved = macao.getIsOver();

        // Then we expect 'is Over' to be true and the given/retrieved strings to match
        Assert.assertTrue(retrieved);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void evaluateTest2() {
        // Given neither the guest nor dealer are still playing
        macao.setGuestStillPlaying(false);
        macao.setDealerStillPlaying(false);

        // Given the dealers cumulative roll is 7 and the guests cumulative roll is 8
        macao.getMacaoDealer().setCumulativeRoll(7);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // Given the game console is set to our test console
        macao.setConsole(console);

        // Given the expected string output
        String expected = "Your total is 8 and the dealer's total is 7. You win!";

        // When we call the evaluate method
        macao.evaluate();

        // When we retrieve the 'is Over' variable
        boolean gameOver = macao.getIsOver();

        // When we retrieve the string output (& trim it)
        String actual = outputStream.toString().trim();

        // Then we expect the 'is Over' variable to be true and the given string to match the retrieved string
        Assert.assertTrue(gameOver);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void evaluateTest3() {
        // Given neither the guest nor dealer are still playing
        macao.setGuestStillPlaying(false);
        macao.setDealerStillPlaying(false);

        // Given the dealers cumulative roll is 9 and the guests cumulative roll is 8
        macao.getMacaoDealer().setCumulativeRoll(9);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // Given the game console is set to our test console
        macao.setConsole(console);

        // Given the expected string output
        String expected = "Your total is 8 and the dealer's total is 9. Sorry, you lose!";

        // When we call the evaluate method
        macao.evaluate();

        // When we retrieve the 'is Over' variable
        boolean gameOver = macao.getIsOver();

        // When we retrieve the string output (& trim it)
        String actual = outputStream.toString().trim();

        // Then we expect the 'is Over' variable to be true and the given string to match the retrieved string
        Assert.assertTrue(gameOver);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void evaluateTest4() {
        // Given neither the guest nor dealer are still playing
        macao.setGuestStillPlaying(false);
        macao.setDealerStillPlaying(false);

        // Given the dealers cumulative roll is 9 and the guests cumulative roll is 9
        macao.getMacaoDealer().setCumulativeRoll(9);
        macao.getMacaoGuest().setCumulativeRoll(9);

        // Given the game console is set to our test console
        macao.setConsole(console);

        // Given the expected string output
        String expected = "You both rolled 9. It's a tie!";

        // When we call the evaluate method
        macao.evaluate();

        // When we retrieve the 'is Over' variable
        boolean gameOver = macao.getIsOver();

        // When we retrieve the string output (& trim it)
        String actual = outputStream.toString().trim();

        // Then we expect the 'is Over' variable to be true and the given string to match the retrieved string
        Assert.assertTrue(gameOver);
        Assert.assertEquals(expected, actual);
    }


}
