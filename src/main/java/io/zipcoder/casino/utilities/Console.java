package io.zipcoder.casino.utilities;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * You are advised against modifying this class.
 */
public final class Console {
    private final Scanner input;
    private final PrintStream output;

    public Console(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public void print(String val, Object... args) {
        output.format(val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        print(prompt, args);
        return input.nextLine();
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

    public void printFast(String val) {
        int count = 0;
        for (char c : val.toCharArray()) {
            output.print(c);
            count++;
            if ((count % 5) == 0) {
                delay(5);
            }
        }
    }

    public void printSlow(String val) {
        for (char c : val.toCharArray()) {
            output.print(c);
            delay(15);
        }
    }

    public void newln() {
        print("\n");
    }

    public void delay(Integer milliSeconds) {
        try { Thread.sleep(milliSeconds); }
        catch (InterruptedException e) {
            System.out.println("Error, Interrupted");
        }
    }

    public void dotDotDot() {
        delay(200); print(".");
        delay(300); print(".");
        delay(400); print(".");
    }

    public static void clearScreen() {
        for(int i = 0; i <= 1000; i++)
        System.out.print("\n");
    }
}

