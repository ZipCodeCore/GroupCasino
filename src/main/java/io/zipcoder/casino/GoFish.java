package io.zipcoder.casino;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Collections;

public class GoFish extends CardGame {

    private Console c;
    private GoFishDisplay d;
    private Player p;
    private Integer pairCountHuman;
    private Integer pairCountComputer;
    private String rankRequested;
    private String turn;

    public GoFish(Player currentPlayer) {

        this.c = new Console(System.in, System.out);
        this.d = new GoFishDisplay();
        this.p = currentPlayer;

        this.pairCountHuman = 0;
        this.pairCountComputer = 0;
        this.turn = "Player";
        this.rankRequested = "";
    }

    // GETTERS
    public String getTurn() { return this.turn; }

    public int getPairCountHuman() { return this.pairCountHuman; }

    public int getPairCountComputer() {return this.pairCountComputer;}

    public String getRankRequested() { return this.rankRequested; }

    // SETTERS
    public void setTurn(String newTurn) { this.turn = newTurn; }

    public void setPairCounts(int pairCountPlayer, int pairCountDealer) {
        this.pairCountHuman = pairCountPlayer;
        this.pairCountComputer = pairCountDealer;
    }

    public void setRankRequested(String rank) { this.rankRequested = rank; }

    // GAME PLAY METHODS
    public String startGame() {
        d.printGoFishRules();
        d.printWelcomeMessage(p.getName(), p.getWallet());
        this.setupGame(5);
        return null;
    }

    public void setupGame(int numberOfCards) {
        this.createNewDeck();
        this.shuffleCards();
        this.dealCards(numberOfCards);
    }

    public boolean getRankToAskFor_Player() {
        d.printWhatRankYouWillAskFor();
        this.rankRequested = c.getStringInput("", (Object[]) null);
        if (!checkIfRankInHand(this.playersHand)) {
            d.printInvalidRankRequested();
            return false;
        }
        return true;
    }

    public String getRankToAskFor_Computer () {
        int pickCard = (int) Math.random() * (this.dealersHand.size() - 1);
        this.rankRequested = this.getRankOnCard(this.dealersHand.get(pickCard));
        return this.rankRequested;
    }

    public boolean checkIfRankInHand (ArrayList < String > handToCheck) {
        for (int i = 0; i < handToCheck.size(); i++) {
            if (getRankOnCard(handToCheck.get(i)).equals(this.rankRequested)) {
                return true;
            }
        }
        return false;
    }

    public void takeCardFromOtherPlayer (ArrayList < String > playerTakingCard, ArrayList < String > playerGivingCard, String rankAskedFor){
        for (int i = 0; i < playerGivingCard.size(); i++) {
            if (this.getRankOnCard(playerGivingCard.get(i)).equals(rankAskedFor)) {
                playerTakingCard.add(playerGivingCard.get(i));
                playerGivingCard.remove(i);
            }
        }

        if (this.turn.equals("Computer")) {
            d.printComputerTookCard();
        } else {
            d.printPlayerTookCard();
        }
    }

    public String stealOrGoFish(ArrayList<String> currentPlayer, ArrayList<String> opposingPlayer, String rankRequested) {
        if (checkIfRankInHand(opposingPlayer)) {
            this.takeCardFromOtherPlayer(currentPlayer, opposingPlayer, rankRequested);
            return "Take Card";
        } else {
            this.goFish(this.turn);
            return "Go Fish";
        }
    }

    public String goFish(String currentTurn) {
        if (currentTurn.equals("Computer")) {
            d.printTellComputerGoFish();
            if (!this.drawCardFromDeck(this.dealersHand).equals(this.rankRequested)) {
                this.setTurn("Player");
            } else {
                d.printAnotherTurn();
            };
        } else if (currentTurn.equals("Player")) {
            String cardDrawnRank = this.drawCardFromDeck(this.playersHand);
            d.printComputerSaysGoFish(cardDrawnRank);
            if (!cardDrawnRank.equals(this.rankRequested)) {
                this.setTurn("Computer");
            } else {
                d.printAnotherTurn();
            }
        }
        return this.turn;
    }

    public String drawCardFromDeck (ArrayList < String > playerHand) {
        String cardDrawnRank = this.getRankOnCard(this.deck.get(0));
        playerHand.add(this.deck.get(0));
        this.deck.remove(0);
        return cardDrawnRank;
    }

    public String checkPairInHand (ArrayList < String > currentPlayer) {
        Collections.sort(currentPlayer);
        int count = 1;
        for (int i = 1; i < currentPlayer.size(); i++) {
            if (this.getRankOnCard(currentPlayer.get(i - 1)).equals(this.getRankOnCard(currentPlayer.get(i)))) {
                count += 1;
                if (count == 2) {
                    return this.getRankOnCard(currentPlayer.get(i));
                }
            } else {
                count = 1;
            }
        }
        return null;
    }

    public String removePairFromHand (ArrayList < String > currentPlayer) {
        String rankToRemove = checkPairInHand(currentPlayer);
        while (rankToRemove != null) {
            if (rankToRemove != null) {
                int i = 0, count = 0;
                while (i < currentPlayer.size()) {
                    if (getRankOnCard(currentPlayer.get(i)).equals(rankToRemove) && count < 3) {
                        currentPlayer.remove(i);
                        count++;
                    } else {
                        i++;
                    }
                }
                this.incrementPairCount(rankToRemove);
                rankToRemove = checkPairInHand(currentPlayer);
            }
        }
        return rankToRemove;
    }

    // this method is ugly :( need to clean up
    public void incrementPairCount(String rankRemoved){
        if (this.turn.equals("Computer")) {
            this.pairCountComputer++;
            d.printNumPairsComputer(rankRemoved, this.pairCountComputer);
            // Draw card if hand is empty
            if (this.dealersHand.size() == 0 && this.deck.size() != 0) {
                this.drawCardFromDeck(this.dealersHand);
                d.printRanOutOfCards();
            } else if (this.dealersHand.size() == 0 && this.deck.size() == 0) {
                this.checkGameOver();
            };
        } else if (this.turn.equals("Player")) {
            this.pairCountHuman++;
            d.printNumPairsPlayer(rankRemoved, this.pairCountHuman);
            // Draw card if hand is empty
            if (this.playersHand.size() == 0 && this.deck.size() != 0) {
                this.drawCardFromDeck(this.playersHand);
                d.printRanOutOfCards();
            } else if (this.playersHand.size() == 0 && this.deck.size() == 0) {
                this.checkGameOver();
            }
            d.printPlayersHand(this.displayPlayersHand(this.playersHand));
        }
    }

    public boolean checkGameOver () {
        if (this.deck.size() == 0) {
            this.removePairFromHand(this.playersHand);
            this.removePairFromHand(this.dealersHand);
            return true;
        }
        return false;
    }

    public void checkForWinner () {
        d.printGameOver();
        System.out.println("Final No. Pairs Computer: " + this.pairCountComputer);
        System.out.println("Final No. Pairs Player: " + this.pairCountHuman);
        if (this.pairCountComputer > this.pairCountHuman) {
            d.printComputerWinner();
        } else if (this.pairCountComputer < this.pairCountHuman){
            d.printPlayerWinner();
        } else {
            d.printTiedGame();
        }
    }

}













