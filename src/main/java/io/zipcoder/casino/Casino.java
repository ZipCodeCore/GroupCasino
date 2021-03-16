package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class Casino {
    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.run();
    }

    public void run() {
        CrapsScreens crapsScreens = new CrapsScreens();
        crapsScreens.crapsWelcomeScreen();
    }
}
