package io.zipcoder.casino.Casino;


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
    }
}
