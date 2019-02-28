package io.zipcoder.casino.casino.GameTest;

import io.zipcoder.casino.casino.games.dicegames.diceutilities.Dice;
import io.zipcoder.casino.casino.games.dicegames.diceutilities.LoadedDice;
import io.zipcoder.casino.casino.games.dicegames.Craps;
import io.zipcoder.casino.casino.utilities.Console;
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
    //    boolean toWinPassBet = craps.getToWinPassBet();
        Map<String, Boolean> betMap = craps.getBetMap();

        // Then
//        Assert.assertTrue(toWinPassBet);
        Assert.assertTrue(betMap.get("Pass Bet"));
    }

    @Test
    public void promptBetTest2() {
        // Given
        Craps craps = helperFunction("100\nDon't pass");
        craps.setIsFirstRoll(true);

        // When
        craps.promptBet();
        craps.setBetInBetMap("Pass Bet", false);

        // Then
        Assert.assertFalse(craps.getBetInBetMap("Pass Bet"));
    }

    @Test
    public void promptBetTest3() {
        // Given
        Craps craps = helperFunction("2\n5");
        craps.setIsFirstRoll(false);
        craps.clearBets();
        craps.setBetInBetMap("Pass Bet", true);
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
    public void setBetInBetMapTest() {
        // Given
        Craps craps = new Craps();

        // When
        craps.setBetInBetMap("Pass Bet", true);
        boolean retrieved = craps.getBetInBetMap("Pass Bet");

        // Then
        Assert.assertTrue(retrieved);
    }

    @Test
    public void currentBetListTest() {
        // Given
        Craps craps = new Craps();
        craps.setBetInBetMap("Place Bet", true);
        craps.setBetInBetMap("Lay Bet", true);
        craps.setBetInBetMap("Hardways", true);
        // When
        List<String> actualBets = craps.currentBetList(true);

        // Then
        Assert.assertTrue(actualBets.contains("Place Bet"));
        Assert.assertTrue(actualBets.contains("Lay Bet"));
        Assert.assertTrue(actualBets.contains("Hardways"));
    }

    /*@Test
    public void evaluateFirstRollTest1() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(2);
        craps.setBetInBetMap("Pass Bet", true);
        String expectedOutput = "You lost your bet!\n" +
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
        craps.setBetInBetMap("Pass Bet", true);
        String expectedOutput = "Your bet paid off!\n" +
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
        craps.setBetInBetMap("Pass Bet", false);
        String expectedOutput = "You lost your bet!\n" +
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
        craps.setBetInBetMap("Pass Bet", false);
        String expectedOutput = "You lost your bet!\n" +
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
*/
    @Test
    public void evaluateFirstRollTest5() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setRollSum(5);
        int expectedPoint = 5;
        String expectedOutput = "The point is now 5.";

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
        craps.setBetInBetMap("Place Bet", false);

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertTrue(craps.getBetInBetMap("Place Bet"));
    }

    @Test
    public void makeBetTest2() {
        // Given
        Craps craps = helperFunction("place\n7\n5");
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to make a Place Bet for?\n" +
                "Stick to the Place numbers, buddy! Pick from 4, 5, 6, 8, 9 or 10";
        craps.setBetInBetMap("Place Bet", false);

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertTrue(craps.getBetInBetMap("Place Bet"));
    }

    @Test
    public void makeBetTest3() {
        // Given
        Craps craps = helperFunction("lay");
        craps.setBetInBetMap("Lay Bet", false);

        // When
        craps.makeBet();

        // Then
        Assert.assertTrue(craps.getBetInBetMap("Lay Bet"));
    }

    @Test
    public void makeBetTest4() {
        // Given
        Craps craps = helperFunction("anycraps");
        craps.setBetInBetMap("Any Craps", false);

        // When
        craps.makeBet();

        // Then
        Assert.assertTrue(craps.getBetInBetMap("Any Craps"));
    }

    @Test
    public void makeBetTest5() {
        // Given
        Craps craps = helperFunction("hardways\n10");
        craps.setBetInBetMap("Hardways", false);
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to place a Hardways Bet on?\n" +
                "Excellent choice!";

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(craps.getBetInBetMap("Hardways"));
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void makeBetTest6() {
        // Given
        Craps craps = helperFunction("hardways\n2\n8");
        craps.setBetInBetMap("Hardways", false);
        String expectedOutput = "What bet would you like to place?\n" +
                "What number do you want to place a Hardways Bet on?\n" +
                "Stick to the Place numbers, buddy! Pick from 4, 6, 8, or 10";

        // When
        craps.makeBet();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(craps.getBetInBetMap("Hardways"));
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
    public void rollTest1() {
        // Given
        Craps craps = helperFunctionNoInput();
        Dice diceRoll2 = new LoadedDice(2);
        craps.setDie1(diceRoll2);
        craps.setDie2(diceRoll2);
        craps.setRollSum(0);
        craps.setRollSumHardways(false);
        int expectedRollSum = 4;
        String expectedOutput = "HERE ARE YOUR DIE:\n" +
                "┏━━━━━━━━┓┏━━━━━━━━┓\n" +
                "┃     ⬤ ┃┃     ⬤ ┃\n" +
                "┃        ┃┃        ┃\n" +
                "┃ ⬤     ┃┃ ⬤     ┃\n" +
                "┗━━━━━━━━┛┗━━━━━━━━┛";
        int expectedReturn = expectedRollSum;


        // When
        int actualReturn = craps.roll();
        int actualRollSum = craps.getRollSum();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedRollSum, actualRollSum);
        Assert.assertTrue(craps.getRollSumHardways());
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedReturn, actualReturn);
    }

    @Test
    public void rollTest2() {
        // Given
        Craps craps = helperFunctionNoInput();
        Dice diceRoll5 = new LoadedDice(5);
        Dice diceRoll2 = new LoadedDice(2);
        craps.setDie1(diceRoll5);
        craps.setDie2(diceRoll2);
        craps.setRollSum(0);
        craps.setRollSumHardways(true);
        int expectedRollSum = 7;
        String expectedOutput = "HERE ARE YOUR DIE:";
        int expectedReturn = expectedRollSum;

        // When
        int actualReturn = craps.roll();
        int actualRollSum = craps.getRollSum();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedRollSum, actualRollSum);
        Assert.assertFalse(craps.getRollSumHardways());
        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedReturn, actualReturn);
    }

    public static void main(String[] args)
    {
  /*      Craps craps = new Craps();
        craps.setBetInBetMap("Lay Bet", true);
        craps.setBetAmount(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + craps.getBetAmount();
        String expectedOutput = "Your Lay bet paid off!\n" +
                "\n" +
                "You're on a roll and 100 NUCs richer!";

        // When
        craps.evaluate();

        // Then*/
    }

    /*@Test
    public void evaluateTest1() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("Lay Bet", true);
        craps.setBetAmount(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + craps.getBetAmount();
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 100 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then

        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }

    @Test
    public void evaluateTest2() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("Lay Bet", false);
        craps.setBetInBetMap("Pass Bet", false);
        craps.setBetAmount(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + craps.getBetAmount();
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 100 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then

        Assert.assertTrue( actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }

    @Test
    public void evaluateTest3() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("Lay Bet", false);
        craps.setBetInBetMap("Pass Bet", true);
        craps.setBetAmount(100);
        int expectedTotalBalance = craps.getAdjustedBalance() - craps.getBetAmount();
        String expectedOutput = "Sorry shooter, it looks like your hot streak has come to an end!\n" +
                "\n" +
                "-100 NUCs gone already? Play again to win that back and more!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then

        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }

    @Test
    public void evaluateTest4() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setIsFirstRoll(false);
        craps.setBetInBetMap("Any Craps", true);
        craps.setRollSum(2);
        craps.setBetAmount(50);
        int expectedTotalBalance = craps.getAdjustedBalance() + craps.getBetAmount();
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 50 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }

    @Test
    public void evaluateTest5() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setIsFirstRoll(false);
        craps.setBetInBetMap("Any Craps", true);
        craps.setRollSum(5);
        craps.setBetAmount(50);
        int expectedTotalBalance = craps.getAdjustedBalance() - craps.getBetAmount();
        String expectedOutput = "You lost your bet!\n" +
                "\n" +
                "-50 NUCs gone already? Play again to win that back and more!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }

    @Test
    public void evaluateTest6() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", true);
        craps.setRollSum(3);
        craps.setBetAmount(80);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "You won your Field bet!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
        Assert.assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void evaluateTest7() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", true);
        craps.setRollSum(2);
        craps.setBetAmount(80);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
        Assert.assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void evaluateTest8() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", false);
        craps.setBetInBetMap("Hardways", true);
        craps.setHardwaysRoll(4);
        craps.setRollSum(4);
        craps.setBetAmount(80);
        craps.setAdjustedBalance(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
        Assert.assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void evaluateTest9() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", false);
        craps.setBetInBetMap("Hardways", false);
        craps.setBetInBetMap("Lay Bet", true);
        craps.setRollSum(7);
        craps.setBetAmount(80);
        craps.setAdjustedBalance(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
        Assert.assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void evaluateTest10() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", false);
        craps.setBetInBetMap("Hardways", false);
        craps.setBetInBetMap("Lay Bet", false);
        craps.setPoint(4);
        craps.setRollSum(4);
        craps.setBetInBetMap("Pass Bet", true);
        craps.setBetAmount(80);
        craps.setAdjustedBalance(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "Lucky number 4! You hit the point!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
        Assert.assertTrue(actualOutput.contains(expectedOutput));
    }
*/
    @Test
    public void evaluateTest11() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", false);
        craps.setBetInBetMap("Hardways", false);
        craps.setBetInBetMap("Lay Bet", false);
        craps.setPoint(4);
        craps.setRollSum(5);

        // When
        craps.evaluate();

        // Then
    }

   /* @Test
    public void evaluateTest12() {
        // Given
        Craps craps = helperFunction("yes\nno");
        craps.setBetInBetMap("The Field", false);
        craps.setBetInBetMap("The Horn", false);
        craps.setBetInBetMap("Hardways", false);
        craps.setBetInBetMap("Lay Bet", true);
        craps.setPlaceBetChoice(5);
        craps.setRollSum(5);
        craps.setBetAmount(80);
        craps.setAdjustedBalance(100);
        int expectedTotalBalance = craps.getAdjustedBalance() + 80;
        String expectedOutput = "Your bet paid off!\n" +
                "\n" +
                "You're on a roll and 80 NUCs richer!";

        // When
        craps.evaluate();
        int actualTotalBalance = craps.getAdjustedBalance();
        String actualOutput = outputStream.toString().trim();

        // Then
        Assert.assertTrue(actualOutput.contains(expectedOutput));
        Assert.assertEquals(expectedTotalBalance, actualTotalBalance);
    }*/

    @Test
    public void adjustBalanceTest() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setAdjustedBalance(300);
        craps.setBetAmount(100);
        int expected = 400;

        // When
        craps.adjustBalance(craps.getBetAmount());
        int actual = craps.getAdjustedBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void promptQuitTest() {
        // Given
        Craps craps = helperFunction("no");
        String expected = "Would you like to quit while you're ahead?\n" +
                "Okay, you're a responsible adult, and you know your limits";

        // When
        craps.promptQuit();
        String actual = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cashOutTest1() {
        // Given
        Craps craps = helperFunction("no");
        int usersInitialBalance = craps.getUser().getProfile().getBalance();
        craps.setInitialBalance(usersInitialBalance);
        craps.setAdjustedBalance(usersInitialBalance + 400);
        String expectedOutput = "Wouldn't you rather continue playing?\n" +
                "You won 400 NUCs!";
        int expectedUserBalance = usersInitialBalance + 400;

        // When
        craps.cashOut();
        String actualOutput = outputStream.toString().trim();
        int actualUserBalance = craps.getUser().getProfile().getBalance();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
        Assert.assertEquals(expectedUserBalance, actualUserBalance);
    }

    @Test
    public void cashOutTest2() {
        // Given
        Craps craps = helperFunction("yes");
        String expected = "Wouldn't you rather continue playing?";

        // When
        craps.cashOut();
        String actual = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareBalanceTest1() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setAdjustedBalance(200);
        craps.setInitialBalance(100);
        String expected = "You won 100 NUCs!";

        // When
        craps.compareBalance();
        String actual = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareBalanceTest2() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setAdjustedBalance(0);
        craps.setInitialBalance(100);
        String expected = "You're 100 NUCs poorer!";

        // When
        craps.compareBalance();
        String actual = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareBalanceTest3() {
        // Given
        Craps craps = helperFunctionNoInput();
        craps.setAdjustedBalance(100);
        craps.setInitialBalance(100);
        String expected = "You broke even!";

        // When
        craps.compareBalance();
        String actual = outputStream.toString().trim();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
