package io.zipcoder.casino;

public class Main {

    public static void main(String args[]) {
        Display d = new Display();
        Player p = new Player("Theresa", 500.00);
        GoFishEngine play = new GoFishEngine(p);
        play.startGame();
    }
}
