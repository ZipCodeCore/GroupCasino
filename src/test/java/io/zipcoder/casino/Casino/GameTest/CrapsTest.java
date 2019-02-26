package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.utilities.Console;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CrapsTest {

    private static String userInput;
    private ByteArrayInputStream byteStream = new ByteArrayInputStream(userInput.getBytes());
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Console testConsole = new Console(new Scanner(byteStream), new PrintStream(outputStream));
    private Craps craps = new Craps(testConsole);


    @Test
    public void promptBetTest1() {
        // Given
        boolean isFirstRoll = true;
        userInput = "50\npass";

        // When
        craps.promptBet();
        
    }
}
