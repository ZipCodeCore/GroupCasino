package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BeetleDisplayTests {
    Display d = new Display();
    BeetleDisplay bd = new BeetleDisplay();

    @Test
    public void welcomeTest() {
        bd.welcome(null);
        String actual = "WELCOME TO BEETLE!\n(1 dollar per player table minimum)\n";
        String expected = bd.welcome(null);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rulesTest() {
        bd.welcome(null);
        String actual = "WELCOME TO BEETLE!\n(1 dollar per player table minimum)\n";
        String expected = bd.welcome(null);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drewLegTest() {
        bd.drewLeg();
        String actual = "A leg was added to the beetle!";
        String expected = bd.drewLeg();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drewBodyTest() {
        bd.drewBody();
        String actual = "The beetle's body was drawn!";
        String expected = bd.drewBody();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drewHeadTest() {
        bd.drewHead();
        String actual = "This beetle has a head now!";
        String expected = bd.drewHead();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userBugIsCompleteTest() {
        bd.userBugIsComplete();
        String actual = "Your beetle is complete!\nYOU WIN!!!!";
        String expected = bd.userBugIsComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void opponentsBugisCompleteTest() {
        bd.opponentsBugisComplete();
        String actual = "Your opponents beetle is complete.\nYou lose.";
        String expected = bd.opponentsBugisComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bothBeetlesCompleteTest() {
        bd.bothBeetlesComplete();
        String actual = "You both drew beetles. The game is a tie.";
        String expected = bd.bothBeetlesComplete();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void repeatedRollResult() {
        bd.repeatedRollResult();
        String actual = "You already rolled that number.";
        String expected = bd.repeatedRollResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void border() {
        bd.border();
        String actual = "======================";
        String expected = bd.border();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void borderWithSpace() {
        bd.borderWithSpace();
        String actual = "\n======================\n";
        String expected = bd.borderWithSpace();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void yourBeetle() {
        bd.yourBeetleTitleLine();
        String actual = "YOUR BEETLE";
        String expected = bd.yourBeetleTitleLine();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void opponentsBeetle() {
        bd.opponentsBeetleTitleLine();
        String actual = "OPPONENTS BEETLE";
        String expected = bd.opponentsBeetleTitleLine();

        Assert.assertEquals(expected, actual);
    }
}