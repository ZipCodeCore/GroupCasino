package io.zipcoder.casino;

public class GoFishEngine {

    private GoFish g;
    private GoFishDisplay d;

    public GoFishEngine() {
        this.g = new GoFish();
        this.d = new GoFishDisplay();
    }

    public void startGame() {
        g.setupGame(5);
        this.playGame();
    }

    public void playGame() {
        while (g.checkGameOver() == false) {
            if (g.getTurn() == "player") {

                d.printYourHand();
                System.out.println(g.displayPlayersHand(g.getPlayersHand()));
                g.getRankToAskFor_Human();

            } else if (g.getTurn() == "dealer") {

                g.getRankToAskFor_Computer();
            }
        }


    }
}

