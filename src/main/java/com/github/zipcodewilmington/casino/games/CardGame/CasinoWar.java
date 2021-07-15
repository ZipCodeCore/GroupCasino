package com.github.zipcodewilmington.casino.games.CardGame;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class CasinoWar extends Deck implements GameInterface {

   private CardHand playerHand;
   private CardHand dealerHand;
   Deck deck = new Deck(1);

    public CasinoWar(int numberOfDecks) {
        super(numberOfDecks);
    }

    public CasinoWar() {
        super();
    }

    public void playCasinoWarHands() {
        IOConsole input = new IOConsole(AnsiColor.YELLOW);
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
                if (determineWinner().equals("playerwon")) {
                    input.println("Congratulations!!! You won!!");
                } else if(determineWinner().equals("dealerwon")) {
                    input.println("So sad, you lost!!");
                }else
                {
                    input.println("Its a tie!! Draw another card!");
                }
            } else{
                return;
            }
        }
        while (true);
    }

    public String determineWinner() {
        String result = "playerwon";
        //Integer play = playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue();
        if (playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue() <
                dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue()) {
            result = "dealerwon";
        }
        else if(playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue() ==
                dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue()){
            result = "tie";
        }
        return result;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }


//    public Boolean tieBetweenPlayerAndDealer() {
//        Boolean result = playerWins();
//        if (playerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue() ==
//                dealerHand.userHand.get(0).faceValueOfCard.getCardIntegerValue()) {
//            result = playerWins();
//        }
//        return result;
//    }

}



