package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Cards.Games.Macao;
import org.junit.Assert;
import org.junit.Test;
import io.zipcoder.casino.utilities.Console;

import java.io.*;

public class MacaoTest {

    private Macao macao = new Macao();
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Console console = new Console(System.in, new PrintStream(outputStream));

    @Test
    public void ConstructorTest() {
        // Given macao data
        boolean expectedIsOver = false;
        boolean expectedGuestIsPlaying = true;
        boolean expectedCompIsPlaying = true;

        // When the data is retrieved from the game instance
        boolean actualIsOver = macao.getIsOver();
        boolean actualGuestIsPlaying = macao.getGuestStillPlaying();
        boolean actualCompIsPlaying = macao.getComputerStillPlaying();

        // Then you expect the given data to match the retrieved data
        Assert.assertEquals(expectedIsOver, actualIsOver);
        Assert.assertEquals(expectedGuestIsPlaying ,actualGuestIsPlaying);
        Assert.assertEquals(expectedCompIsPlaying, actualCompIsPlaying);
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
    public void getComputerStillPlayingTest() {
        // Given an expected boolean exists
        boolean expected = true;

        // When the variable for 'computer still playing' is set to the expected value
        macao.setComputerStillPlaying(expected);

        // When we retrieve the variable for 'computer still playing' from the game
        boolean actual = macao.getComputerStillPlaying();

        // We expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void setComputerStillPlayingTest() {
        // Given an initial variable for 'computer still playing' (which is true upon construction)
        boolean initial = macao.getComputerStillPlaying();

        // When we set the 'computer still playing' variable to true
        macao.setComputerStillPlaying(false);

        // When we retrieve the 'computer still playing' variable from the game
        boolean changed = macao.getComputerStillPlaying();

        // Then we expect the initial to be true and the changed variable to be false
        Assert.assertTrue(initial);
        Assert.assertFalse(changed);
    }

    @Test
    public void printGameInstructionsTest() {
        // Given the expected string
        String expected = "GAME: MACAO\nThe object of this game is to roll the die enough times to reach a total of 9 without going over.\nGood luck!";

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
    public void showInitialRollsTest() {
        // Given we set the guest's roll to 3 and the computer's roll to 4
        macao.getMacaoGuest().setRoll(3);
        macao.getMacaoComputer().setRoll(4);

        // Given the expected string
        String expected = "YOUR ROLL: 3 | COMPUTER'S ROLL: 4";

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
    public void computerStillPlayingTest1() {
        // Given the computers cumulative roll is 7 and the guest's cumulative roll is 6
        macao.getMacaoComputer().setCumulativeRoll(7);
        macao.getMacaoGuest().setCumulativeRoll(6);

        // When we call the 'computer still playing function'
        Boolean computerStillPlaying = macao.isComputerStillPlaying();

        // Then we expect it to return false because the computers roll is both over 7 and over the guests cumulative roll
        Assert.assertFalse(computerStillPlaying);
    }

    @Test
    public void computerStillPlayingTest2() {
        // Given the computers cumulative roll is 4 and the guest's cumulative roll is 8
        macao.getMacaoComputer().setCumulativeRoll(4);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // When we call the 'computer still playing function'
        Boolean computerStillPlaying = macao.isComputerStillPlaying();

        // Then we expect it to return true because the computers roll is both less than 9 and less than the guests cumulative roll
        Assert.assertTrue(computerStillPlaying);
    }

    @Test
    public void computerStillPlayingTest3() {
        // Given the computers cumulative roll is 4 and the guest's cumulative roll is 8
        macao.getMacaoComputer().setCumulativeRoll(9);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // When we call the 'computer still playing function'
        Boolean computerStillPlaying = macao.isComputerStillPlaying();

        // Then we expect it to return false because the computers roll is 9
        Assert.assertFalse(computerStillPlaying);
    }

    @Test
    public void evaluateTest1() {
        // Given the computers cumulative roll is 10, the console is our test console, and we expect 'the computer went over' to print
        macao.getMacaoComputer().setCumulativeRoll(10);
        macao.setConsole(console);
        String expected = "The computer went over. You win!";

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
        // Given neither the guest nor computer are still playing
        macao.setGuestStillPlaying(false);
        macao.setComputerStillPlaying(false);

        // Given the computers cumulative roll is 7 and the guests cumulative roll is 8
        macao.getMacaoComputer().setCumulativeRoll(7);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // Given the game console is set to our test console
        macao.setConsole(console);

        // Given the expected string output
        String expected = "Your total is 8 and the computer's total is 7. You win!";

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
        // Given neither the guest nor computer are still playing
        macao.setGuestStillPlaying(false);
        macao.setComputerStillPlaying(false);

        // Given the computers cumulative roll is 9 and the guests cumulative roll is 8
        macao.getMacaoComputer().setCumulativeRoll(9);
        macao.getMacaoGuest().setCumulativeRoll(8);

        // Given the game console is set to our test console
        macao.setConsole(console);

        // Given the expected string output
        String expected = "Your total is 8 and the computer's total is 9. Sorry, you lose!";

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
        // Given neither the guest nor computer are still playing
        macao.setGuestStillPlaying(false);
        macao.setComputerStillPlaying(false);

        // Given the computers cumulative roll is 9 and the guests cumulative roll is 9
        macao.getMacaoComputer().setCumulativeRoll(9);
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
