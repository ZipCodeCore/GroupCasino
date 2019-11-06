package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.*;

public class GoFish implements Game {

    Console newConsole = new Console(System.in, System.out);
    Random random = new Random();

    private Player user;
    private Deck goFishDeck;
    private CardHand playerHand;
    private CardHand computerHand;
    boolean winGame = false;

    public GoFish(Player player) {
        this.user = player;

        //initialize deck and shuffle
        this.goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));


    }


    public void startGame() {

        newConsole.println("\n\nLoading Go Fish.... \n\n");

        do {

            newConsole.println("%s's turn \n\n", this.user.getID());
            playerTurn();
            //evaluateHand(playerHand);


            newConsole.println("Computer's Turn \n\n");
            computerTurn();
            //evaluateHand(computerHand);

        } while (!winGame);


        promptLeaveGame();
    }


    public void playerTurn() {

        newConsole.println(playerHand.displayHand());

        String cardWanted = newConsole.getStringInput("Which value would you like to ask for? ").toUpperCase();

        //If Player asked for a card that is in hand
        if (haveCard(playerHand, cardWanted)) {

            if (haveCard(computerHand, cardWanted)) {
                newConsole.println("\nThe computer has this card\n");
                newConsole.println("New Card(s) >> " + tradeCards(computerHand, cardWanted, playerHand).toString()
                        .replace("[", "").replace("]", ""));

            } else {
                newConsole.println("\nGo Fish!!!\n");
                newConsole.println("New Card >> " + goFishForCard(playerHand).toString());
            }

            System.out.println(playerHand.displayHand());



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

    public boolean evaluateHand(CardHand hand) {

        ArrayList<Card> winnings;
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
                hand.userHand.removeAll(winnings);
                return true;
            }


        }

        return false;
    }


    public void promptLeaveGame() {

    }

    public void displayResults() {
    }


    //Computer Play
    public Rank getCompCard() {

        Card newCard = computerHand.userHand.get(random.nextInt(computerHand.userHand.size()));
        return newCard.getRank();
    }

}
