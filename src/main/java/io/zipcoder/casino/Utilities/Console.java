package io.zipcoder.casino.Utilities;


import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.PrintStream;
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

//    public void print(String val, Object... args) {
//        output.format(val, args);
//    }
//
//    public void println(String val, Object... vals) {
//        print(val + "\n", vals);
//    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

//    public Double getDoubleInput(String prompt, Object... args) {
//        String stringInput = getStringInput(prompt, args);
//        try {
//            Double doubleInput = Double.parseDouble(stringInput);
//            return doubleInput;
//        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
//            println("[ %s ] is an invalid user input!", stringInput);
//            println("Try inputting a numeric value!");
//            return getDoubleInput(prompt, args);
//        }
//    }
//
//    public Long getLongInput(String prompt, Object... args) {
//        String stringInput = getStringInput(prompt, args);
//        try {
//            Long longInput = Long.parseLong(stringInput);
//            return longInput;
//        } catch (NumberFormatException nfe) { // TODO - Eliminate recursive nature
//            println("[ %s ] is an invalid user input!", stringInput);
//            println("Try inputting an integer value!");
//            return getLongInput(prompt, args);
//        }
//    }

//    public Integer getIntegerInput(String prompt, Object... args) {
//        return getLongInput(prompt, args).intValue();
//    }


    public void clearScreen() {
        for (int i = 0; i <100; i++) {
            println(" ");
        }
    }

    public void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public String getInput() {
        print("> ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //get input from user

        return input;
    }

    public String getInput(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //get input from user

        return input;
    }


    public Integer getInput(String[] options) {

        clearScreen();

        int numOptions = options.length;
        int numRows = (numOptions+1) >> 1; // this is how the cool kids divide by two
        String output = "";

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++){
            rows[i] = String.format("%d | %-30s", 2*i+1, options[2*i]);
            if (2*i + 1 < numRows) {
                rows[i] += String.format("%30s | %d", options[2*i + 1], 2*(i+1));
            }
            rows[i] += "\n";
        }

        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        println(output);

        return getInteger(numOptions);

    }

    public String getInput(String header, String[] options) {

        clearScreen();

        int numOptions = options.length;
        int numRows = (numOptions+1) >> 1; // this is how the cool kids divide by two
        String output = StringUtils.center(header,86) + "\n\n";

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++){
            rows[i] = String.format("%d | %-40s", 2*i+1, options[2*i]);
            if (2*i + 1 < numOptions) {
                rows[i] += String.format("%40s | %d", options[2*i + 1], 2*(i+1));
            }
            rows[i] += "\n";
        }

        for (int i = 0; i < numRows; i++) {
            output += rows[i];
        }

        println(output);

        return Integer.toString(getInteger(numOptions));

    }

    Boolean integerCheck(String input) {
        return input.matches("^\\d+$");
    }

    Boolean currencyCheck(String input) {
        return input.matches("^[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$");
    }

    public Double getCurrency() {
        String input = getInput("$");
        while (true) {
            if (currencyCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput("$");
            }
        }
        return Double.valueOf(input);
    }

    public Double getCurrency(String prompt) {
        print(prompt);
        String input = getInput("$");
        while (true) {
            if (currencyCheck(input)) break;
            else {
                println("Enter a valid number");
                print(prompt);
                input = getInput("$");
            }
        }
        return Double.valueOf(input);
    }

    public Integer getInteger() {
        String input = getInput();
        while (true) {
            if (integerCheck(input)) break;
            else {
                println("Enter a number");
                input = getInput();
            }
        }
        return Integer.valueOf(input);
    }

    public Integer getInteger(int max) {
        String input = getInput();
        while (true) {
            if (integerCheck(input)) {
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= max) {
                    break;
                } else {
                    println("Enter a number between 1 and " + Integer.toString(max));
                    input = getInput();
                }
            }
            else {
                println("Enter a number");
                input = getInput();
            }
        }
        return Integer.valueOf(input);
    }

}

