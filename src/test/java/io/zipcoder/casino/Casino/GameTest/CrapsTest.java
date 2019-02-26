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
         ByteArrayInputStream byteStream = new ByteArrayInputStream(userInput.getBytes());
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         Console testConsole = new Console(new Scanner(byteStream), new PrintStream(outputStream));
         Craps craps = new Craps(testConsole);
         return craps;
    }


    @Test
    public void promptBetTest1() {
        Craps craps = helperFunction("50\npass");
       // String userInput = "50\npass";
        // Given
        boolean isFirstRoll = true;
       // userInput = "50\npass";

        // When
        craps.promptBet();
        boolean toWinPassBet = craps.getToWinPassBet();
        Map<String, Boolean> betMap = craps.getBetMap();

        // Then
        Assert.assertTrue(toWinPassBet);
        Assert.assertTrue(betMap.get("Pass Bet"));

    }
}
