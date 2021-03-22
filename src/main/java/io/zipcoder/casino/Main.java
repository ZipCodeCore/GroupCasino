package io.zipcoder.casino;

public class Main {

    public static void main(String args[]) {
        //Casino casino = new Casino();
        //casino.run();
        Player p = new Player("Theresa", 500.0);
        GoFishEngine goFish = new GoFishEngine(p);
        goFish.playGame();
    }
}
