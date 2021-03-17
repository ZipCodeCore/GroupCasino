package io.zipcoder.casino;

public class Casino {
    public static void main(String[] args) {
        // write your tests before you start
        Display display = new Display();
        System.out.println(display.helloMessage());
        display.getUserInput("Welcome whats your name?");
    }
}
