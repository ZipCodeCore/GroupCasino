package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Stack;
import static java.lang.System.in;

public class GoFish implements Game {

    private Player user;

    Console input = new Console(System.in, System.out);

    Deck goFishDeck;
    CardHand playerHand;
    CardHand computerHand;
    boolean winGame = false;

    public GoFish(Player player) {
        this.user = player;

        //initialize deck and shuffle
        goFishDeck = new Deck(1);
        goFishDeck.shuffleDeck();

        //initialize players' hand and deal cards
        playerHand = new CardHand(goFishDeck.dealCards(5));
        computerHand = new CardHand(goFishDeck.dealCards(5));

    }

    public void startGame(){


        System.out.println("Loading Go Fish....");

        do{

            System.out.println("Player's Turn");
            playerTurn();
            winGame = evaluateHand(playerHand);


            //System.out.println("Computer's Turn");
            //computerTurn();



        }while(winGame == false);

    }


    public void playerTurn(){

        System.out.println(displayHand(playerHand));

        String userInput = input.getStringInput("Which value would you like to ask for? ");
        userInput.toUpperCase();

        if(haveCard(computerHand, userInput) == true){

            System.out.println("The computer has this card");
            tradeCards(computerHand, userInput, playerHand);


        }else{
            System.out.println("Go Fish!");

            goFishForCard(playerHand);
        }

        System.out.println(displayHand(playerHand));

    }

    public void computerTurn(){

    }




    public void tradeCards(CardHand tradingHand, String cardToRemove, CardHand receivingHand){

        ArrayList<Card> tradingCards = new ArrayList<Card>();


        for(Card card : tradingHand.userHand) {
            if (card.toString().contains(cardToRemove)) {
                Card temp = card;
                tradingHand.userHand.remove(card);
                tradingCards.add(temp);
            }

        }

        receivingHand.userHand.addAll(tradingCards);

    }

    public boolean haveCard(CardHand opponent, String wantedCard){

        for(Card card : opponent.userHand) {
            if (card.toString().contains(wantedCard))
                return true;
        }

        return false;
    }

    public void goFishForCard(CardHand hand){

        hand.userHand.add(goFishDeck.drawCard());
    }

    public String displayHand(CardHand hand){

        return hand.userHand.toString();
    }

    public boolean evaluateHand(CardHand hand){
        int counter = 0;

        for(Card checkCard : hand.userHand){
            counter = 0;
            for (Card card : hand.userHand){
                if(checkCard.getRank() == card.getRank()){
                    counter++;
                }
            }

            if(counter == 2){
                return true;
            }


        }

        return false;
    }



    public void promptLeaveGame(){

    }

    public void displayResults (){
    }
}
