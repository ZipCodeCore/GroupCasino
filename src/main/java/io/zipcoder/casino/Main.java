package io.zipcoder.casino;

public class Main {

    public static void main(String args[]) {
        //Casino casino = new Casino();
        //casino.run();
        CrapsV2 crapsv2 = new CrapsV2(new Player("Hazel", 1000.0));
        crapsv2.crapsEngine();

    }
}
