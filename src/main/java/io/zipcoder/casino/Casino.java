package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class Casino {
    public static void main(String[] args) {
        // write your tests before you start fucking with this
        Console menu = new Console(System.in,System.out);

        menu.getIntegerInput("Please Select Game");
    }
}
