package io.zipcoder.casino;

public class GoFishEngine {

    private GoFish g;
    private GoFishDisplay d;
    private Player p;

    public GoFishEngine(Player currentPlayer) {
        this.g = new GoFish();
        this.d = new GoFishDisplay();
        this.p = currentPlayer;
    }

    public void startGame() {
        d.printGoFishRules();
        d.printFreeGame();
        d.printHumansFirst();
        g.setupGame(5);
        this.playGame();
    }

    public void playGame() {

        while (g.checkGameOver() == false) {
            if (g.getTurn() == "player") {
                this.playHumansTurn();

            } else if (g.getTurn() == "dealer") {
                this.playComputer();
            }
        }

        System.out.println(g.checkWinner());
    }

    public void playHumansTurn() {
        this.printPlayersHand();
        this.checkForPairsHuman();

        g.getRankToAskFor_Human();

        boolean player = g.checkIfRankInHand(g.getPlayersHand());
        boolean dealer = g.checkIfRankInHand(g.getDealersHand());

        if (!player) {
            d.printRankNotInYourHand();
        } else if (player && dealer) {
            d.printOpponentHasCard();
            g.takeCardFromOtherPlayer(g.getPlayersHand(), g.getDealersHand(), g.getRankRequested());
        } else if (player && !dealer) {
            d.printGoFish();
            g.drawCardFromDeck(g.getPlayersHand());
            this.printPlayersHand();
            this.checkForPairsHuman();
            g.setTurn("dealer");
        }
    }

    public void playComputer() {
        this.checkForPairsComputer();
        g.getRankToAskFor_Computer();

        boolean player = g.checkIfRankInHand(g.getPlayersHand());
        boolean dealer = g.checkIfRankInHand(g.getDealersHand());

        d.printOpponentAskedFor();
        System.out.println(g.getRankRequested());

        if (player && dealer) {
            g.takeCardFromOtherPlayer(g.getDealersHand(), g.getPlayersHand(), g.getRankRequested());
            d.printOpponentTookCard();
        } else if (!player && dealer) {
            d.printTellComputerGoFish();
            g.drawCardFromDeck(g.getDealersHand());
            this.checkForPairsComputer();
            g.setTurn("player");
        }
    }

    public void printPlayersHand() {
        d.printPlayerHandHeader();
        System.out.println(g.displayPlayersHand(g.getPlayersHand()));
    }

    public void checkForPairsHuman() {
        int num = g.removePairFromHand(g.getPlayersHand());
        if (num == 1) {
            g.incrementPairCountPlayer(num);

            d.printMadePair();
            d.printPairsHuman();
            System.out.println(g.getPairCountPlayer());
            this.printPlayersHand();
        }
    }

    public void checkForPairsComputer() {
        int num = g.removePairFromHand(g.getDealersHand());
        if (num == 1) {
            g.incrementPairCountDealer(num);

            d.printMadePairOpponent();
            d.printPairsComputer();
            System.out.println(g.getPairCountDealer());
        }
    }
}

