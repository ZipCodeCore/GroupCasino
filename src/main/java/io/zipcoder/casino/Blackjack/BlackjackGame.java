package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackjackGame extends CardGame implements Game {

    private String name = "Blackjack";
    public static final HashMap<String, Integer> cardMap = new HashMap<String,Integer>();
    static {
        for (int i = 2; i <= 10; i++) {
            cardMap.put(String.valueOf(i), i);
        }
        cardMap.put("J",10);
        cardMap.put("Q",10);
        cardMap.put("K",10);
        cardMap.put("A",11);
    }
    private Console console = new Console(System.in, System.out);

    private double minBet;
    private double maxBet;
    private BlackjackPlayer player;
    private BlackjackNPCPlayer dealer;
    private ArrayList<BlackjackHand> hands;
    private CardSet shoe;
    private int numDecks;

    public BlackjackGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new BlackjackPlayer(incomingPlayer);
        this.dealer = new BlackjackNPCPlayer(new Player("Mr.", "Roboto", 50, 1000000.00), 17, true);
        this.numDecks = 5;
        this.hands = new ArrayList<BlackjackHand>(0);
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public int getNumDecks() {
        return numDecks;
    }

    public CardSet getShoe() {
        return shoe;
    }

    public ArrayList<BlackjackHand> getHands() {
        return hands;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public BlackjackNPCPlayer getDealer() {
        return dealer;
    }

    public void startPlay() {
        new BlackjackMenu(this).displayMenu();
        roundStart();
    }

    public void roundStart() {
        Double betSize = betChoice();
        if (betSize != null) {
            initialDeal(betSize);
            displayTable(false);

            roundOfPlay();
            clearHands();
            roundStart();
        }

    }

    public Double betChoice () {
        return console.getCurrency("Bet size (Enter to stand up): ", this.minBet, this.maxBet);
    }



    public void initialDeal(double betSize) {

        checkShoe();
        BlackjackHand playerHand = new BlackjackHand(betSize, this.player, this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(playerHand);
        this.player.addHand(playerHand);

        NPCBlackjackHand dealerHand = new NPCBlackjackHand(0.00, (BlackjackPlayer) this.dealer, this.shoe.removeFirstCard(), this.shoe.removeFirstCard());
        this.hands.add(dealerHand);
        this.dealer.addHand(dealerHand);

    }

    public void roundOfPlay() {
        for (BlackjackHand hand : this.player.getHands()) {
            int value = -1;
            while (value < 0) {
                value = hand.playChoice(this.shoe);
                this.displayTable(false);
            }
            console.println("done:", value);
        }
        for (BlackjackHand hand : this.dealer.getHands()) {
            int value = -1;
            while (value < 0) {
                value = hand.playChoice(this.shoe);
                this.displayTable(false);
            }
            console.println("done:", value);
        }
        displayTable(true);
    }

    public void clearHands() {
        this.hands.clear();
        this.player.getHands().clear();
        this.dealer.getHands().clear();
    }

    public void endChoice() {

    }

    public void checkShoe() {
        if (this.shoe == null || this.shoe.size() < this.numDecks * 26) {
            this.shoe = getNewShoe();
        }
    }

    public CardSet getNewShoe() {
        CardSet newShoe = new CardSet(this.numDecks);
        newShoe.shuffle();
        return newShoe;
    }

    public void displayTable(boolean showWinnings) {
        //temporary
        console.clearScreen();

        console.println(String.format("***Blackjack***\nTable stakes: $%.2f min / $%.2f max\n", this.minBet, this.maxBet));
        console.println("Dealer");
        BlackjackHand dealerHand = this.dealer.getHands().get(0);
        for (Card card : dealerHand.getCards().getCards()) {
            console.print(card.toString() + " ");
        }
        console.println("");
        console.println(this.player.getPlayer().getFirstName());
        ArrayList<BlackjackHand> playerHands =  this.player.getHands();
        for (BlackjackHand hand : playerHands) {
            for (Card card : hand.getCards().getCards()) {
                console.print(card.toString() + " ");
            }
            console.println("  $%.2f", hand.getBet());
            if (showWinnings) {
                double winnings = calculateWinnings(hand);
                if (winnings == hand.getBet()) {
                    console.println("Push");
                } else if (winnings == 0.0) {
                    console.println("Dealer wins");
                } else {
                    console.println(String.format("Winnings: $%.2f",winnings));
                }
            }
        }

    }

    public Double initialWinnerCheck() { // looking for blackjacks
        BlackjackHand dealerHand = this.dealer.getHands().get(0); // dealer only ever has one hand
        BlackjackHand playerHand = this.player.getHands().get(0); // player starts with only one hand
        int dealerValue = dealerHand.getValue();
        int playerValue = playerHand.getValue();

        if (dealerValue == 21 && playerValue < 21) { //lose to blackjack
            return 0.0;
        } else if (dealerValue < 21 && playerValue == 21 ) { //win w/ blackjack
            return 2.5 * playerHand.getBet();
        } else if (dealerValue == 21 && 21 == playerValue) { //push w/blackjacks
            return playerHand.getBet();
        }
        return null;
    }

    // returns 0 if you lost, bet size if you pushed, 2x bet size if you won
    public double calculateWinnings (BlackjackHand handToEvaluate) {

        BlackjackHand dealerHand = this.dealer.getHands().get(0); // dealer only ever has one hand
        int dealerValue = dealerHand.getValue();
        int playerValue = handToEvaluate.getValue();
        if (playerValue > dealerValue) {
            return 2 * handToEvaluate.getBet();
        } else if (playerValue == dealerValue) {
            return handToEvaluate.getBet();
        } else {
            return 0.0;
        }
    }

}
