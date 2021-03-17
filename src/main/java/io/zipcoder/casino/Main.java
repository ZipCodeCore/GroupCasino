package io.zipcoder.casino;

public class Main {

    public static void main(String args[]) {
        Player x = new Player("Hazel", 100.0);
        Craps craps = new Craps(x);
        craps.crapsEngine();


    }
}
