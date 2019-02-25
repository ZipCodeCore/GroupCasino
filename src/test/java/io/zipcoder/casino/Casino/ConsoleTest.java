package io.zipcoder.casino.Casino;

import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleTest {

    @Test
    public void testPrint1() {

        // Given
        String input = "Welcome to the number 1 casino!";
        String expected = String.format(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));

        // When
        console.print(input);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrint2() {

        // Given
        String input = "Welcome to the number %s casino!";
        String[] arguments = {"1"};
        String expected = String.format(input, arguments);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));

        // When
        console.print(input, arguments);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintLn1() {
        // Given
        String input = "Welcome to the number 1 casino!";
        String expected = String.format(input + "\n");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));

        // When
        console.println(input);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintLn2() {
        // Given
        String input = "Welcome to the number %s casino!";
        String[] arguments = {"1"};
        String expected = String.format(input + "\n", arguments);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(System.in, new PrintStream(outputStream));

        // When
        console.println(input, arguments);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStringInput1() {
        // Given
        String expectedInput = "I want to play blackjack";
        byte[] inputBytes = expectedInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStringInput("What do you want to play?");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetStringInput2() {
        // Given
        String expectedInput = "test answer";
        byte[] inputBytes = expectedInput.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStringInput("testPrompt");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetStandardInput() {
        // Given
        String input = "test answer";
        byte[] inputBytes = input.getBytes();
        String expectedInput = input.toLowerCase().trim();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStandardInput(" ");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetStandardInput2() {
        // Given
        String input = "adfs;jafdsjpafjpi";
        byte[] inputBytes = input.getBytes();
        String expectedInput = input.toLowerCase().trim();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStandardInput(" ");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetStandardInputCaps() {
        // Given
        String input = "test answer";
        byte[] inputBytes = input.getBytes();
        String expectedInput = input.toUpperCase().trim();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStandardInputCaps(" ");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetStandardInputCaps2() {
        // Given
        String input = "adfs;jafdsjpafjpi";
        byte[] inputBytes = input.getBytes();
        String expectedInput = input.toUpperCase().trim();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Console console = new Console(new Scanner(inputByteArray), System.out);

        // When
        String actualInput = console.getStandardInputCaps(" ");

        // Then
        Assert.assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testGetIntegerInput1() {
        // Given
        byte[] inputBytes = "0".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Integer actual = console.getIntegerInput("");
        Integer expected = 0;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIntegerInput2() {
        // Given
        byte[] inputBytes = "9000".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Integer actual = console.getIntegerInput("What are you over?");
        Integer expected = 9000;

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test(expected=NoSuchElementException.class)
    public void testGetIntegerInput3()  {
        // Given
        byte[] inputBytes = "Somethingelse".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        String expected = String.format("[ %s ] is an invalid user input!", "Somethingelse");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(scanner, new PrintStream(outputStream));

        // When
        console.getIntegerInput("Don't type in words");
    }

    @Test
    public void testGetLongInput1() {
        // Given
        byte[] inputBytes = "0".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Long actual = console.getLongInput("");
        Long expected = 0L;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLongInput2() {
        // Given
        byte[] inputBytes = "9000".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Long actual = console.getLongInput("What are you over?");
        Long expected = 9000L;

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test(expected=NoSuchElementException.class)
    public void testGetLongInput3()  {
        // Given
        byte[] inputBytes = "Somethingelse".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        String expected = String.format("[ %s ] is an invalid user input!", "Somethingelse");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(scanner, new PrintStream(outputStream));

        // When
        console.getLongInput("Don't type in words");
    }

    @Test
    public void testGetDoubleInput1() {
        // Given
        byte[] inputBytes = "0".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Double actual = console.getDoubleInput("");
        Double expected = 0.0;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDoubleInput2() {
        // Given
        byte[] inputBytes = "9000".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        Console console = new Console(scanner, System.out);

        // When
        Double actual = console.getDoubleInput("What are you over?");
        Double expected = 9000.0;

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test(expected=NoSuchElementException.class)
    public void testGetDoubleInput3()  {
        // Given
        byte[] inputBytes = "Somethingelse".getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        String expected = String.format("[ %s ] is an invalid user input!", "Somethingelse");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Console console = new Console(scanner, new PrintStream(outputStream));

        // When
        console.getDoubleInput("Don't type in words");
    }

}
