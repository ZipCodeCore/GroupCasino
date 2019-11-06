package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.*;

public class GoFish implements Game {

    Console newConsole = new Console(System.in, System.out);
    Random random = new Random();

    private Player player;
    private Deck goFishDeck;
    private CardHand playerHand;
    private CardHand computerHand;
    boolean winGame = false;
    private ArrayList<Card> winnings;


    //Constructor
    public GoFish(Player player) {
        this.player = player;

        //initialize and shuffle deck
        this.goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));
    }


    public void startGame() {

        newConsole.println("\n\n\n\n\n\n\n");

        do {

            newConsole.println("%s's turn \n\n", this.player.getID());

            playerTurn();
            winGame = checkIfWinner(playerHand);
                if (winGame){
                    newConsole.println("\n"+ player.getID() + " is the winner with : \n");
                    displayResults();
                    break;
                }


            newConsole.println("Computer's Turn \n\n");

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


    public void playerTurn() {

        newConsole.println("======Your Cards======\n\n");
        newConsole.println(playerHand.displayHand());
        newConsole.println("======================");

        String cardWanted = newConsole.getStringInput("\nWhich value would you like to ask for? ").toUpperCase();

        //If Player asked for a card that is in hand
        if (haveCard(playerHand, cardWanted)) {

            if (haveCard(computerHand, cardWanted)) {
                newConsole.println("\nThe computer has this card\n");
                newConsole.println("\nNew Card(s) >> " + tradeCards(computerHand, cardWanted, playerHand).toString()
                        .replace("[", "").replace("]", "").replace(", ", ""));

            } else {
                newConsole.println("\nGo Fish!!!\n");
                newConsole.println("\nNew Card >> " + goFishForCard(playerHand).toString().replace("[", "")
                        .replace("]", ""));
            }

            newConsole.println("======Your Cards======\n\n");
            newConsole.println(playerHand.displayHand());
            newConsole.println("======================");

        }else{
            newConsole.println("\n\nYou don't have this card. Try it again.\n\n");
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
            newConsole.println("\nYou have this card, the computer will take it\n");

        } else {
            newConsole.println("\nGo Fish!!!!\n");
            goFishForCard(computerHand);
        }

        newConsole.getStringInput("\nPress Enter to continue\n" );

    }


    //Tools for Game

    public boolean haveCard(CardHand opponent, String wantedCard) {

        for (Card card : opponent.userHand)
            if (card.getRank().toString().equals(wantedCard))
                return true;

        return false;
    }

    public ArrayList tradeCards(CardHand givingHand, String wantedCard, CardHand receivingHand){

        ArrayList<Card> tradingCards = new ArrayList<>();

        for (Card card : givingHand.userHand) {
            if (card.getRank().toString().equals(wantedCard))
                tradingCards.add(card);
        }

        givingHand.userHand.removeAll(tradingCards);
        receivingHand.userHand.addAll(tradingCards);

        return tradingCards;

    }

    public Card goFishForCard(CardHand hand) {

        Card newCard = goFishDeck.drawCard();
        hand.userHand.add(newCard);

        return newCard;
    }

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


    public void promptLeaveGame() {

    }

    public void displayResults() {

        newConsole.println(winnings.toString().replace("[", "").replace("]", "")
                                        .replace(", ", ""));
    }


    //Computer Play
    public Rank getCompCard() {

        Card newCard = computerHand.userHand.get(random.nextInt(computerHand.userHand.size()));
        return newCard.getRank();
    }

}
