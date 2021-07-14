package com.github.zipcodewilmington.casino.games.Blackjack;
import com.github.zipcodewilmington.utils.IOConsole;

public class CasinoWar extends Deck {

    CardHand playerHand;
    CardHand dealerHand;
    Boolean Winner;
    //player numberOfPlayers;
    Deck deck = new Deck(1);

    public CasinoWar(int numberOfDecks) {
        super(numberOfDecks);
    }

    public CasinoWar() {
        super();
    }

    public void playCasinoWarHands() {
        IOConsole input = new IOConsole();
        Deck warDeck = new Deck(1);
        warDeck.shuffle();
        input.println("Welcome to Casino Wars!!!!");
        do {

            Integer i = input.getIntegerInput("Do you want to pick a card? - Yes 1. No 2.");
            if (i == 1) {
                playerHand = new CardHand(warDeck.dealCards(1));
                dealerHand = new CardHand(warDeck.dealCards(1));
                input.println("Player hand is " + playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue());
                input.println("Dealer hand is " + dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue());
                if (playerWins()) {
                    input.println("Congratulations!!! You won!!");
                } else {
                    input.println("So sad, you lost!!");
                }
            } else {
                return;
            }
        }
        while (true);
    }

    public Boolean playerWins() {
        Boolean result = true;
        //Integer play = playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        if (playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue() <
                dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue()) {
            result = false;
        }
        return result;
    }


    public Boolean tieBetweenPlayerAndDealer() {
        Boolean result = playerWins();
        if (playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue() ==
                dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue()) {
            result = playerWins();
        }
        return result;
    }
}


//playerHand.displayHand()
//if (playerHand.displayHand().equals(""))
c

