package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.*;

public class GoFish implements Game {


    //------------------------------------------------------------------------------------------------------------------
    // Fields ----------------------------------------------------------------------------------------------------------

    private Console newConsole = new Console(System.in, System.out);
    private Random random = new Random();
    private Player player;
    private Deck goFishDeck;
    private CardHand playerHand;
    private CardHand computerHand;
    private ArrayList<Card> winnings;
    boolean winGame = false;


    //------------------------------------------------------------------------------------------------------------------
    // Constructor  and Initializing game ------------------------------------------------------------------------------

    public GoFish(Player player) {
        this.player = player;

    }

    public void initializeGame(){

        //initialize and shuffle deck
        this.goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));

    }

    //------------------------------------------------------------------------------------------------------------------
    // Method called to play the game ----------------------------------------------------------------------------------

    public void startGame() {

        initializeGame();

        newConsole.getStringInput("\n\n\n\n\nPress Enter to start the game\n\n\n\n\n\n" );

        do {

            newConsole.println("\n>>>>>> %s's turn <<<<<<\n\n", this.player.getID());
            playerTurn();

            winGame = checkIfWinner(playerHand);

            if (winGame){
                newConsole.println("\n" + player.getID() + " is the winner with : \n");
                displayResults();
                break;
            }

            newConsole.println("\n>>>>>> Computer's Turn <<<<<<\n");
            computerTurn();

            winGame = checkIfWinner(computerHand);
            if (winGame){
                newConsole.println("\n Computer is the winner with : \n");
                displayResults();
                break;
            }

        } while (!false);

        promptLeaveGame();
    }


    //------------------------------------------------------------------------------------------------------------------
    // Player's and Computers turn -------------------------------------------------------------------------------------

    public void playerTurn() {

        newConsole.println("--- Your Cards ---\n\n");
        newConsole.println(playerHand.displayHand());
        newConsole.println("------------------");

        String cardWanted = newConsole.getStringInput("\nWhich value would you like to ask for? \n ").toUpperCase();

        //If Player asked for a card that is in hand
        if (haveCard(playerHand, cardWanted)) {

            if (haveCard(computerHand, cardWanted)) {
                newConsole.println("\nThe computer has this card\n");
                newConsole.println("\nNEW CARD(S) ADDED >>> " + tradeCards(computerHand, cardWanted, playerHand).toString()
                        .replace("[", "").replace("]", "").replace(", ", ""));

            } else {
                newConsole.println("\nGo Fish!!!\n");
                newConsole.println("\nNEW CARD ADDED >>> " + goFishForCard(playerHand).toString().replace("[", "")
                        .replace("]", ""));
            }

            newConsole.println("--- Your Cards ---\n\n");
            newConsole.println(playerHand.displayHand());
            newConsole.println("------------------\n");

        }else{
            newConsole.println("\n\nYou don't have this card. Try a different card.\n\n");
            playerTurn();
        }

        newConsole.getStringInput("\nPress Enter to continue\n");
    }

    public void computerTurn() {

        String newCard = getCompCard().toString();
        newConsole.println("\nComputer asked for " + newCard);

        newConsole.getStringInput("\nPress Enter to continue\n" );

        if (haveCard(playerHand, newCard)) {
            tradeCards(playerHand, newCard, computerHand);
            newConsole.println("\nYou have this card, the computer will take it");

        } else {
            newConsole.println("\nGo Fish!!!!");
            goFishForCard(computerHand);
        }

        newConsole.getStringInput("\nPress Enter to continue\n" );

    }


    //------------------------------------------------------------------------------------------------------------------
    // Check if other play has card and trading ------------------------------------------------------------------------

    public boolean haveCard(CardHand opponent, String wantedCard) {

        for (Card card : opponent.userHand)
            if (card.getRank().toString().equals(wantedCard))
                return true;

        return false;
    }

    public ArrayList tradeCards(CardHand givingHand, String wantedCard, CardHand receivingHand){

        ArrayList<Card> tradingCards = new ArrayList<Card>();

        for (Card card : givingHand.userHand) {
            if (card.getRank().toString().equals(wantedCard))
                tradingCards.add(card);
        }

        givingHand.userHand.removeAll(tradingCards);
        receivingHand.userHand.addAll(tradingCards);

        return tradingCards;

    }


    //------------------------------------------------------------------------------------------------------------------
    // Getting card from deck ------------------------------------------------------------------------------------------

    public Card goFishForCard(CardHand hand) {

        Card newCard = goFishDeck.drawCard();
        hand.userHand.add(newCard);

        return newCard;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Check if player's hand is winner --------------------------------------------------------------------------------

    public boolean checkIfWinner(CardHand hand) {
        int counter;

        for (Card checkCard : hand.userHand) {
            winnings = new ArrayList<>();
            counter = 0;

            for (Card card : hand.userHand) {
                if (checkCard.getRank() == card.getRank()) {
                    winnings.add(card);
                    counter++;
                }
            }

            if (counter == 4) {
                return true;
            }


        }

        return false;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Gets a random rank from computer's hand -------------------------------------------------------------------------

    public Rank getCompCard() {

        Card newCard = computerHand.userHand.get(random.nextInt(computerHand.userHand.size()));
        return newCard.getRank();
    }


    //------------------------------------------------------------------------------------------------------------------
    //


    public void promptLeaveGame() {
        String exitOrNo;
        boolean c = false;
        while (!c) {

            exitOrNo = newConsole.getStringInput("Would you like to play again?\n1. Play again\n2. Exit");

            if(exitOrNo.equals("")){
                exitOrNo = " ";
            }

            switch (exitOrNo.charAt(0)) {
                case '1':
                    startGame();
                    c = true;
                    break;
                case '2':
                    break;
                default:
                    newConsole.println("Please choose one of the options.");
                    break;
            }
        }


    }

    public void displayResults() {

        newConsole.println(winnings.toString().replace("[", "").replace("]", "")
                                        .replace(", ", ""));

    }

}

