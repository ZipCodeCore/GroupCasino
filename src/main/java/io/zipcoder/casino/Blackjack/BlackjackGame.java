package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.CardGame;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.BlackjackMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utility.Music;
import io.zipcoder.casino.utilities.Console;

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
    private GameServices gameServices = new GameServices();

    private double minBet;
    private double maxBet;
    private BlackjackPlayer player;
    private BlackjackNPCPlayer dealer;
    private ArrayList<BlackjackHand> hands;
    private CardSet shoe;
    private int numDecks;
    private Music blackJackMusic = null;


    public BlackjackGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new BlackjackPlayer(incomingPlayer);
        this.dealer = new BlackjackNPCPlayer(new Player("Mr.", "Roboto", 50, 1000000.00), 17, true);
        this.numDecks = 5;
        this.hands = new ArrayList<BlackjackHand>(0);
    }

    public static void main(String[] args) { // for testing
        Player player = new Player ("Lem", "Jukes", 23,300.00);
        BlackjackGame blackjackGame = new BlackjackGame(0.0,0.0,player);
        blackjackGame.startPlay();
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
        //Starts playing music!
        try {
            Music.filePath = "src/music/(BlackJack) Glide with me.wav";
            blackJackMusic = new Music();
            blackJackMusic.play();
        } catch (Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }

        new BlackjackMenu(this).displayMenu();
        if (this.minBet != 0.0) {
            roundStart();
        }

        blackJackMusic.stop();

    }

    public void roundStart() {
        console.printWithDelays("");
        Double betSize = betChoice();
        if (betSize != null) {
            initialDeal(betSize);

            if (initialWinnerCheck()) {
                displayTable(true);
            } else {
                displayTable(false);

                roundOfPlay();
            }
            clearHands();
            roundStart();
        }

    }

    public Double betChoice () {
        Double wager;
        console.printWithDelays(String.format("\n[DEALER]: Current bankroll: $%.2f\n", this.player.getPlayer().getBalance()),10);
        wager = console.getCurrency("\n[DEALER]: Bet size (or press Enter to stand up) \n\n", this.minBet, this.maxBet);
        if (wager != null) {
            if (gameServices.wager(wager, this.player.getPlayer())) {
                return wager;
            } else {
                console.printWithDelays(String.format("\n[DEALER]: Your mouth is writing checks that your wallet can't cash, %s.", this.player.getPlayer().getLastName()));
                console.println("(\nGo to the Teller to pull out money)");
                return betChoice();
            }
        } else {
            return null;
        }
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
        int handNum = this.player.getHands().size();
        for (int i = 0; i < handNum; i++) {
            int value = -1;
            while (value < 0) {
                value = this.player.getHands().get(i).playChoice(this.shoe);
                handNum = this.player.getHands().size();
                this.displayTable(false);
            }
        }
        for (BlackjackHand hand : this.dealer.getHands()) {
            int value = -1;
            while (value < 0) {
                value = hand.playChoice(this.shoe);
                this.displayTable(false);
            }
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

        System.out.println(String.format(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |   ______     | || |   _____      | || |      __      | || |     ______   | || |  ___  ____   | || |     _____    | || |      __      | || |     ______   | || |  ___  ____   | |\n" +
                "| |  |_   _ \\    | || |  |_   _|     | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | || |    |_   _|   | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | |\n" +
                "| |    | |_) |   | || |    | |       | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | || |      | |     | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | |\n" +
                "| |    |  __'.   | || |    | |   _   | || |   / ____ \\   | || |  | |         | || |   |  __'.    | || |   _  | |     | || |   / ____ \\   | || |  | |         | || |   |  __'.    | |\n" +
                "| |   _| |__) |  | || |   _| |__/ |  | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || |  | |_' |     | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |\n" +
                "| |  |_______/   | || |  |________|  | || ||____|  |____|| || |   `._____.'  | || | |____||____| | || |  `.___.'     | || ||____|  |____|| || |   `._____.'  | || | |____||____| | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n" + "\n" + "\n" + "\n" +

                "\nTable stakes: $%.2f min / $%.2f max\n", this.minBet, this.maxBet));
        console.println("[Dealer's Hand]:");
        BlackjackHand dealerHand = this.dealer.getHands().get(0);

        console.print(dealerHand.getCards().toASCII());
        console.println("\n");
        console.println(String.format("[%s's Hand(s)]:",this.player.getPlayer().getFirstName()));
        ArrayList<BlackjackHand> playerHands =  this.player.getHands();
        for (BlackjackHand hand : playerHands) {
            console.print(hand.getCards().toASCII());
            console.print("  $%.2f", hand.getBet());
            if (showWinnings) {
                console.print(winningMessage(hand));
            }
            console.println("\n");
        }

    }

    public String winningMessage(BlackjackHand hand) {
        String message = " ----> ";
        double winnings = calculateWinnings(hand);
        if (winnings == hand.getBet()) {
            message += "Push";
        } else if (winnings == 0.0) {
            message += "((Dealer wins))";
        } else {
            message += String.format("Winnings: $%.2f",winnings);
        }
        return message;
    }

    public boolean initialWinnerCheck() { // looking for blackjacks
        BlackjackHand dealerHand = this.dealer.getHands().get(0); // dealer only ever has one hand
        BlackjackHand playerHand = this.player.getHands().get(0); // player starts with only one hand
        int dealerValue = dealerHand.getValue();
        int playerValue = playerHand.getValue();

        if (dealerValue == 21 && playerValue < 21  //lose to blackjack
            || dealerValue < 21 && playerValue == 21   //win w/ blackjack
            || dealerValue == 21 && 21 == playerValue) { //push w/blackjacks
            return true;
        }
        return false;
    }

    // returns 0 if you lost, bet size if you pushed, 2x bet size if you won
    public double calculateWinnings (BlackjackHand handToEvaluate) {

        BlackjackHand dealerHand = this.dealer.getHands().get(0); // dealer only ever has one hand
        int dealerValue = dealerHand.getValue();
        int playerValue = handToEvaluate.getValue();
        if (playerValue > dealerValue) {
            if (handToEvaluate.getCards().size() == 2 && handToEvaluate.getValue() == 21) {
                gameServices.payOut(2.5 * handToEvaluate.getBet(), this.player.getPlayer());
                return 2.5 * handToEvaluate.getBet();
            }
            gameServices.payOut(2 * handToEvaluate.getBet(), this.player.getPlayer());
            return 2 * handToEvaluate.getBet();
        } else if (playerValue == dealerValue) {
            gameServices.payOut(handToEvaluate.getBet(), this.player.getPlayer());
            return handToEvaluate.getBet();
        } else {
            return 0.0;
        }
    }

}
