package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class CrapsTest {
    private ByteArrayInputStream byteStream;
    private ByteArrayOutputStream outputStream;
    private Console testConsole;//new PrintStream(outputStream));
    private Craps craps;

    private Craps helperFunction(String input) {
        String userInput = input;
        byteStream = new ByteArrayInputStream(userInput.getBytes());
        outputStream = new ByteArrayOutputStream();
        testConsole = new Console(new Scanner(byteStream), new PrintStream(outputStream));
        craps = new Craps(testConsole);
        return craps;
    }

    private Craps helperFunctionNoInput() {
        outputStream = new ByteArrayOutputStream();
        testConsole = new Console(System.in, new PrintStream(outputStream));
        craps = new Craps(testConsole);
        return craps;
    }



    @Test
    public void promptBetTest1() {
        // Given
        Craps craps = helperFunction("50\npass");
        craps.setIsFirstRoll(true);

        // When
        craps.promptBet();
        boolean toWinPassBet = craps.getToWinPassBet();
        Map<String, Boolean> betMap = craps.getBetMap();

        // Then
        Assert.assertTrue(toWinPassBet);
        Assert.assertTrue(betMap.get("Pass Bet"));
    }

    @Test
    public void promptBetTest2() {
        // Given
        Craps craps = helperFunction("100\nDon't pass");
        craps.setIsFirstRoll(true);

        // When
        craps.promptBet();
        boolean toWinPassBet = craps.getToWinPassBet();
        Map<String, Boolean> betMap = craps.getBetMap();

        // Then
        Assert.assertFalse(toWinPassBet);
        Assert.assertFalse(betMap.get("Pass Bet"));
    }

    @Test
    public void evaluateFirstRollTest1() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(2);
        craps.setToWinPassSet(true);
        String expectedOutput = "Whomp, whomp, you crapped out";
//        craps.setBetAmount(50);
//        int initialAdjustedBalance = craps.getAdjustedBalance();
//        int expectedAdjustment = initialAdjustedBalance - 50;

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
//        int actualAdjustment = craps.getAdjustedBalance() - initialAdjustedBalance;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
//        Assert.assertEquals(expectedAdjustment, actualAdjustment);
    }

    @Test
    public void resetPointAndRollTest() {
        // Given
        Craps craps = new Craps();
        craps.setPoint(5);
        craps.setIsFirstRoll(false);
        int expectedPoint = 0;

        // When
        craps.resetPointAndRoll();
        int actualPoint = craps.getPoint();

        // Then
        Assert.assertTrue(craps.getIsFirstRoll());
        Assert.assertEquals(expectedPoint, actualPoint);
    }
}
