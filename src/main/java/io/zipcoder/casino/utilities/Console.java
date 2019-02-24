package io.zipcoder.casino.utilities;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * You are advised against modifying this class.
 */

public final class Console {
    private final Scanner input;
    private final PrintStream output;
    private static Console console = null;

    // Console to be a Singleton outside of testing
    public static Console getConsole()
    {
        if (console == null)
            console = new Console();
        return console;
    }
    private Console() {
        this(System.in, System.out);
    }

    // Public Constructors for testing
    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }
    public Console(Scanner scanner, PrintStream out) {
        this.input = scanner;
        this.output = out;
    }


    public void print(String val, Object... args) {
        output.format(val, args);
    }

    public void println(String val, Object... args) {
        print(val + "\n", args);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public String getStandardInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine().trim().toLowerCase();
    }

    public String getStandardInputCaps(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine().trim().toUpperCase();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Double doubleInput = Double.parseDouble(stringInput);
            return doubleInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getDoubleInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }


}

