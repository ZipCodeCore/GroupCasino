package io.zipcoder.casino.Utilities;


import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public boolean cardCheck (String input) {
        ArrayList<String> choices = new ArrayList<String>(Arrays.asList(new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"}));
        return choices.contains(input);
    }

    public String getCardRankInput(String prompt) {
        print(prompt);
        String input = getInput("Choose a card to take (2-10,J,Q,K,A): ").toUpperCase();
        while (true) {
            if (cardCheck(input)) break;
            else {
                println("Invalid card rank");
                print(prompt);
                input = getInput("Choose a card: ");
            }
        }
        return input;
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
        this.output.printf(output, args);
    }

    public void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public String getInput() {
        print("> ");

        String input = this.input.nextLine(); //get input from user

        return input;
    }

    public String getInput(String prompt) {
        print(prompt);

        String input = this.input.nextLine(); //get input from user

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

    public Double getCurrency(String prompt, double min, double max) {
        print(prompt);
        String input = getInput("$");
        while (true) {
            if (input.equals("")) {
                return null;
            }
            if (currencyCheck(input)) {
                double amount = Double.parseDouble(input);
                if (amount >= min && amount <= max) {
                    break;
                } else {
                    println(String.format("Enter a number between %.2f and %.2f", min, max));
                    print(prompt);
                    input = getInput("$");
                }
            }
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

    public Integer getInteger(String prompt) {
        String input = getInput(prompt);
        while (true) {
            if (integerCheck(input)) break;
            else {
                println("Enter a number.");
                input = getInput(prompt);
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

    public Integer menuChoice(int max) {
        print("\nMenu choice: \n");
        return getInteger(max);
    }

    //Makes a type writer effect on screen
    public void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    public void getInput(String s, TimeUnit milliseconds, int i) {
    }
}

