package io.zipcoder.casino;

public class GoFishEngine {

    private GoFish g;
    private GoFishDisplay d;

    public GoFishEngine(Player currentPlayer) {
        this.g = new GoFish(currentPlayer);
        this.d = new GoFishDisplay();
    }

    public void playGame() {
        g.startGame();
        this.playGameLoop();
        g.checkForWinner();
    }

    public void playGameLoop() {
        while (!g.checkGameOver()) {
            if (g.getTurn().equals("Player")) {
                d.printTurnSeparator(g.getDeck().size(), "You!");
                this.playHumansTurn();

            } else if (g.getTurn().equals("Computer")) {
                d.printTurnSeparator(g.getDeck().size(), "Computer");
                this.playComputer();
            }
        }
    }

    public void playHumansTurn() {
        d.printPlayersHand(g.displayPlayersHand(g.getPlayersHand()));
        g.removePairFromHand(g.getPlayersHand());

        if (g.getRankToAskFor_Player()) {
            g.stealOrGoFish(g.getPlayersHand(), g.getDealersHand(), g.getRankRequested());
        }
    }

    public void playComputer() {
        if(g.getDealersHand().size() == 0 && g.getDeck().size() != 0) {g.drawCardFromDeck(g.getDealersHand());}

        g.removePairFromHand(g.getDealersHand());

        g.getRankToAskFor_Computer();
        d.printComputerAskedFor(g.getRankRequested());
        g.stealOrGoFish(g.getDealersHand(), g.getPlayersHand(), g.getRankRequested());
    }
}

