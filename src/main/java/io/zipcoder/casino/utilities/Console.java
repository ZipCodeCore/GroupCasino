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
        println(prompt, args);
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

    public Integer printMainMenu() {
        return getIntegerInput("What would you like to do?\n" +
                "1.) Log In\n" +
                "2.) Create Account\n" +
                "3.) Exit");
    }

    public Integer printSelectGame() {
        return getIntegerInput("Please select game to play\n" +
                "1.) Go Fish\n" +
                "2.) Yahtzee\n" +
                "3.) BlackJack\n" +
                "4.) Craps\n" +
                "5.) Go to Main Menu");
    }

    public void printWelcome(){
        String temp = "                                                                                         \n" +
                "  ,ad8888ba,                          88                                8888888888   88  \n" +
                " d8\"'    `\"8b                         \"\"                                88           88  \n" +
                "d8'                                                                     88  ____     88  \n" +
                "88             ,adPPYYba,  ,adPPYba,  88  8b,dPPYba,    ,adPPYba,       88a8PPPP8b,  88  \n" +
                "88             \"\"     `Y8  I8[    \"\"  88  88P'   `\"8a  a8\"     \"8a      PP\"     `8b  88  \n" +
                "Y8,            ,adPPPPP88   `\"Y8ba,   88  88       88  8b       d8               d8  \"\"  \n" +
                " Y8a.    .a8P  88,    ,88  aa    ]8I  88  88       88  \"8a,   ,a8\"      Y8a     a8P  aa  \n" +
                "  `\"Y8888Y\"'   `\"8bbdP\"Y8  `\"YbbdP\"'  88  88       88   `\"YbbdP\"'        \"Y88888P\"   88  \n" +
                "                                                                                         \n" +
                "                                                                                         ";

        println(temp);
    }

    public void printGameName(Integer game) {
        String gameName = "";

        switch (game) {

            case 1:

                gameName = "      ::::::::       ::::::::        ::::::::::       :::::::::::       ::::::::       :::    ::: \n" +
                        "    :+:    :+:     :+:    :+:       :+:                  :+:          :+:    :+:      :+:    :+:  \n" +
                        "   +:+            +:+    +:+       +:+                  +:+          +:+             +:+    +:+   \n" +
                        "  :#:            +#+    +:+       :#::+::#             +#+          +#++:++#++      +#++:++#++    \n" +
                        " +#+   +#+#     +#+    +#+       +#+                  +#+                 +#+      +#+    +#+     \n" +
                        "#+#    #+#     #+#    #+#       #+#                  #+#          #+#    #+#      #+#    #+#      \n" +
                        "########       ########        ###              ###########       ########       ###    ###       \n\n";
                break;

            case 2:

                gameName = "   :::   :::           :::        :::    :::   :::::::::::       :::::::::       ::::::::::       :::::::::: \n" +
                        "  :+:   :+:         :+: :+:      :+:    :+:       :+:                :+:        :+:              :+:         \n" +
                        "  +:+ +:+         +:+   +:+     +:+    +:+       +:+               +:+         +:+              +:+          \n" +
                        "  +#++:         +#++:++#++:    +#++:++#++       +#+              +#+          +#++:++#         +#++:++#      \n" +
                        "  +#+          +#+     +#+    +#+    +#+       +#+             +#+           +#+              +#+            \n" +
                        " #+#          #+#     #+#    #+#    #+#       #+#            #+#            #+#              #+#             \n" +
                        "###          ###     ###    ###    ###       ###           #########       ##########       ##########       \n\n";
                break;
            case 3:

                gameName = "      :::::::::       :::            :::        ::::::::       :::    :::      :::::::::::           :::        ::::::::       :::    ::: \n" +
                        "     :+:    :+:      :+:          :+: :+:     :+:    :+:      :+:   :+:           :+:             :+: :+:     :+:    :+:      :+:   :+:   \n" +
                        "    +:+    +:+      +:+         +:+   +:+    +:+             +:+  +:+            +:+            +:+   +:+    +:+             +:+  +:+     \n" +
                        "   +#++:++#+       +#+        +#++:++#++:   +#+             +#++:++             +#+           +#++:++#++:   +#+             +#++:++       \n" +
                        "  +#+    +#+      +#+        +#+     +#+   +#+             +#+  +#+            +#+           +#+     +#+   +#+             +#+  +#+       \n" +
                        " #+#    #+#      #+#        #+#     #+#   #+#    #+#      #+#   #+#       #+# #+#           #+#     #+#   #+#    #+#      #+#   #+#       \n" +
                        "#########       ########## ###     ###    ########       ###    ###       #####            ###     ###    ########       ###    ###       \n\n";
                break;
            case 4:

                gameName = "      ::::::::       :::::::::           :::        :::::::::       :::::::: \n" +
                        "    :+:    :+:      :+:    :+:        :+: :+:      :+:    :+:     :+:    :+: \n" +
                        "   +:+             +:+    +:+       +:+   +:+     +:+    +:+     +:+         \n" +
                        "  +#+             +#++:++#:       +#++:++#++:    +#++:++#+      +#++:++#++   \n" +
                        " +#+             +#+    +#+      +#+     +#+    +#+                   +#+    \n" +
                        "#+#    #+#      #+#    #+#      #+#     #+#    #+#            #+#    #+#     \n" +
                        "########       ###    ###      ###     ###    ###             ########       \n\n";
                break;
        }

        println(gameName);
    }

    public void clearScreen() {
        for (int i = 0; i < 100; i++) {
            println("\n");
        }

    }
}

