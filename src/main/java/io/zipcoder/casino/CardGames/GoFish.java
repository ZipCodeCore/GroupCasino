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

        newConsole.getStringInput("\n\n\n\n\n Press Enter to start the game! \n\n\n\n\n\n" );

        do {

            newConsole.println("\n >>>>>> %s's turn <<<<<< \n\n", this.player.getID());
            playerTurn();

            //Check if player has 4 of a kind
            if (checkIfWinner(playerHand)){
                newConsole.println("\n" + player.getID() + " is the winner with : \n");
                displayResults();
                break;
            }

            newConsole.println("\n >>>>>> Computer's Turn <<<<<< \n");
            computerTurn();

            //Check if computer has 4 of a kind
            if (checkIfWinner(computerHand)){
                newConsole.println("\n Computer is the winner with : \n");
                displayResults();
                break;
            }

        } while (!false);

        promptLeaveGame();
    }


    //------------------------------------------------------------------------------------------------------------------
    // Player's and Computer's turn -------------------------------------------------------------------------------------

    public void playerTurn() {

        displayPlayerHand();

        String cardWanted = newConsole.getStringInput("\n Which value would you like to ask for? \n ").toUpperCase();

        //If Player has the card asked in their hand
        if (haveCard(playerHand, cardWanted)) {

            if (haveCard(computerHand, cardWanted)) {
                newConsole.println("\n The computer has this card, you can take it! \n");
                newConsole.println("\n NEW CARD(S) ADDED >>> \n");

                printCards(tradeCards(computerHand, cardWanted, playerHand).toString());

            } else {
                newConsole.println("\n GO FISH!!! \n");
                newConsole.println("\n NEW CARD ADDED >>> \n" );
                printCards(goFishForCard(playerHand).toString());
            }

            displayPlayerHand();

        }else{
            newConsole.println("\n\n You don't have this card. Try a different card. \n\n");
            playerTurn();
        }

        newConsole.getStringInput("\n Press Enter to continue... \n");
    }

    public void computerTurn() {

        String newCard = getCompCard().toString();
        newConsole.println("\n Computer is asking for " + newCard);

        newConsole.getStringInput("\n Press Enter to continue... \n" );

        if (haveCard(playerHand, newCard)) {
            tradeCards(playerHand, newCard, computerHand);
            newConsole.println("\n You have this card, the computer will take it! ");

        } else {
            newConsole.println("\n GO FISH!!!!");
            goFishForCard(computerHand);
        }

        newConsole.getStringInput("\n Press Enter to continue... \n" );

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
    // Check if a hand has 4 of a kind --------------------------------------------------------------------------------

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
    //Printing Tools ---------------------------------------------------------------------------------------------------


    @Override
    public void displayResults() {

        printCards(winnings.toString());
    }

    public void printCards(String printString) {


        newConsole.println(printString.replace("[", "").replace("]", "")
                                        .replace(", ", ""));

    }

    public void displayPlayerHand(){

        newConsole.println("--- Your Cards ---\n\n");
        newConsole.println(playerHand.displayHand());
        newConsole.println("------------------");
    }



    public void promptLeaveGame() {
        String exitOrNo;

        exitOrNo = newConsole.getStringInput("Would you like to play again?\n" +
                "1. Play again\n" +
                "2. Exit");

        switch (exitOrNo.charAt(0)) {
            case '1':
                startGame();
                break;
            case '2':
                break;
            default:
                newConsole.println("Please choose one of the options.");
                break;
        }
    }

}

