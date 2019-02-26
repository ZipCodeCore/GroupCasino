package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
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
    public void promptBetTest3() {
        // Given
        Craps craps = helperFunction("2\n5");
        craps.setIsFirstRoll(false);
        craps.setBetToTrueOnBetMap("Pass Bet");
        String expectedOutput = "You have five choices:\n" +
                "1) Explain Possible Bets\n" +
                "2) List Current Bets\n" +
                "3) List Available Bets\n" +
                "4) Make a Bet\n" +
                "5) Continue Rolling\n" +
                "You have the current bets: [Pass Bet]\n" +
                "\n" +
                "You have five choices:\n" +
                "1) Explain Possible Bets\n" +
                "2) List Current Bets\n" +
                "3) List Available Bets\n" +
                "4) Make a Bet\n" +
                "5) Continue Rolling";

        // When
        craps.promptBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void filteredBetListTest() {
        // Given
        Craps craps = helperFunctionNoInput();
        String betOptions = "always";
        String expectedOutput = "PLACE\n" +
                "LAY\n" +
                "HARDWAYS";

        // When
        craps.filteredBetList(betOptions);
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void listBetsTest() {
        // Given
        Craps craps = helperFunction("2");
        String expectedOutput = "Choose one of the follow:\n" +
                "1) List Bets always available\n" +
                "2) List one-off Bets\n" +
                "3) Go to previous Menu\n" +
                "ANYCRAPS\n" +
                "FIELD\n" +
                "HORN";

        // When
        craps.listBets();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void makeBetTest1() {
        // Given
        Craps craps = helperFunction("place\n6");
        String expectedOutput = "What bet would you like to place?" +
                "\n" +
                "What number do you want to make a Place Bet for?" +
                "\n" +
                "Excellent choice!";
        craps.setIsPlaceBet(false);

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertTrue(craps.getIsPlaceBet());
    }

    @Test
    public void makeBetTest2() {
        // Given
        Craps craps = helperFunction("place\n7\n5");
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to make a Place Bet for?\n" +
                "Stick to the Place numbers, buddy! Pick from 4, 5, 6, 8, 9 or 10";
        craps.setIsPlaceBet(false);

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertTrue(craps.getIsPlaceBet());
    }

    @Test
    public void makeBetTest3() {
        // Given
        Craps craps = helperFunction("lay");
        craps.setIsLayBet(false);

        // When
        craps.makeBet();

        // Then
        Assert.assertTrue(craps.getIsLayBet());
    }

    @Test
    public void makeBetTest4() {
        // Given
        Craps craps = helperFunction("anycraps");
        craps.setIsAnyCrapsBet(false);

        // When
        craps.makeBet();

        // Then
        Assert.assertTrue(craps.getIsAnyCrapsBet());
    }

    @Test
    public void makeBetTest5() {
        // Given
        Craps craps = helperFunction("hardways\n10");
        craps.setIsHardwaysBet(false);
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to place a Hardways Bet on?\n" +
                "Excellent choice!";

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(craps.getIsHardwaysBet());
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void makeBetTest6() {
        // Given
        Craps craps = helperFunction("hardways\n2\n8");
        craps.setIsHardwaysBet(false);
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to place a Hardways Bet on?\n" +
                "Stick to the Place numbers, buddy! Pick from 4, 6, 8, or 10";

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(craps.getIsHardwaysBet());
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void makeBetTest7() {
        // Given
        Craps craps = helperFunction("doubledown\nanycraps");
        String expectedOutput = "What bet would you like to place?\n" +
                "Please enter an actual bet, pal\n" +
                "What bet would you like to place?";

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void betRulesListedTest() {
        // Given
        Craps craps = helperFunctionNoInput();
        String expectedOutput = "The Place bet wins if the chosen number is rolled before a 7\n" +
                "The Lay bet wins if a 7 is rolled before the point\n" +
                "Any Craps pays off on 2, 3 or 12 before rolling a 7\n" +
                "The Field wins if 4, 5, 6, 8, 9 or 10 hits before 7\n" +
                "The Horn wins on 2, 3, 11 or 12 before rolling a 7\n" +
                "Hardways involves two dice of the same face value, which must be hit before 7 or the corresponding sum thrown 'easy'";

        // When
        craps.betRulesListed();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void setBetToTrueOnBetMapTest() {
        // Given
        Craps craps = new Craps();

        // When
        craps.setBetToTrueOnBetMap("Pass Bet");
        boolean retrieved = craps.getBetMap().get("Pass Bet");

        // Then
        Assert.assertTrue(retrieved);
    }

    @Test
    public void currentBetListTest() {
        // Given
        Craps craps = new Craps();
        craps.setBetToTrueOnBetMap("Place Bet");
        craps.setBetToTrueOnBetMap("Lay Bet");
        craps.setBetToTrueOnBetMap("Hardways");

        // When
        List<String> actualBets = craps.currentBetList(true);

        // Then
        Assert.assertTrue(actualBets.contains("Place Bet"));
        Assert.assertTrue(actualBets.contains("Lay Bet"));
        Assert.assertTrue(actualBets.contains("Hardways"));
    }

    @Test
    public void evaluateFirstRollTest1() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(2);
        craps.setToWinPassSet(true);
        String expectedOutput = "Whomp, whomp, you crapped out\n" +
                "\n" +
                "-50 NUCs gone already? Play again to win that back and more!";
        craps.setBetAmount(50);
        int initialAdjustedBalance = craps.getAdjustedBalance();
        int expectedAdjustment = -50;

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
        int actualAdjustment = craps.getAdjustedBalance() - initialAdjustedBalance;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedAdjustment, actualAdjustment);
    }

    @Test
    public void evaluateFirstRollTest2() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(7);
        craps.setToWinPassSet(true);
        String expectedOutput = "You won the Pass bet, keep it up!\n" +
                "\n" +
                "You're on a roll and 50 NUCs richer!";
        craps.setBetAmount(50);
        int initialAdjustedBalance = craps.getAdjustedBalance();
        int expectedAdjustment = 50;

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
        int actualAdjustment = craps.getAdjustedBalance() - initialAdjustedBalance;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedAdjustment, actualAdjustment);
    }

    @Test
    public void evaluateFirstRollTest3() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(7);
        craps.setToWinPassSet(false);
        String expectedOutput = "You lost the Pass bet!\n" +
                "\n" +
                "-50 NUCs gone already? Play again to win that back and more!";
        craps.setBetAmount(50);
        int initialAdjustedBalance = craps.getAdjustedBalance();
        int expectedAdjustment = -50;

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
        int actualAdjustment = craps.getAdjustedBalance() - initialAdjustedBalance;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedAdjustment, actualAdjustment);
    }

    @Test
    public void evaluateFirstRollTest4() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(2);
        craps.setToWinPassSet(false);
        String expectedOutput = "You won the Don't Pass bet, keep it up!\n" +
                "\n" +
                "You're on a roll and 50 NUCs richer!";
        craps.setBetAmount(50);
        int initialAdjustedBalance = craps.getAdjustedBalance();
        int expectedAdjustment = 50;

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
        int actualAdjustment = craps.getAdjustedBalance() - initialAdjustedBalance;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedAdjustment, actualAdjustment);
    }

    @Test
    public void evaluateFirstRollTest5() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(5);
        int expectedPoint = 5;
        String expectedOutput = "The point is now 5.\nKeep on rollin', shooter!";

        // When
        craps.evaluateFirstRoll();
        String actualOutput = outputStream.toString().trim();
        int actualPoint = craps.getPoint();
        boolean isFirstRoll = craps.getIsFirstRoll();

        // Then
        Assert.assertEquals(expectedPoint, actualPoint);
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertFalse(isFirstRoll);
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
