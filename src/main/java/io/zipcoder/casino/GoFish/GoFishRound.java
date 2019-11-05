package io.zipcoder.casino.GoFish;

import java.util.Scanner;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Utilities.Console;

import java.util.ArrayList;

public class GoFishRound {

    private Console console = new Console(System.in, System.out);
    private ArrayList<Card> newSuites;
    private GoFishPlayer player;
    private GoFishPlayer opponent;

    private CardSet cards;

    public GoFishRound(GoFishPlayer player, Card card1, Card card2, Card card3, Card card4, Card card5, Card card6, Card card7) {
        this.player = player;
        this.opponent = opponent;
        this.console = new Console(System.in, System.out);
    }


    public String prompt(GoFishPlayer player) {
        String cardChoice = console.getCardRankInput("");
        return null;

    }




    //Fish for card from opponent
    public boolean requestCard(CardSet cardToHand, CardSet cardFromHand, String cardChoice) {
        return false;
    }
    public CardSet getCards(){
        return cards;
    }

    public GoFishPlayer getPlayer(){
        return player;
    }
    public ArrayList<Card> playRound(){

        return null;
    }





    //Performed after successful callout
    //if card retrieved matches card drawn, player repeats chooseCard
    public ArrayList<Card> retrieveCards (String requestedCard, CardSet cardFromHand){


        return null;
    }

    public Card removeCard(){
        return null;
    }
    //Performed after unsuccessful callout
    //if card retrieved matches card drawn, player repeats chooseCard

    public Card drawCard(){
        return null;
    }

    //Checks hands for four of a kind. Performed after each retrieveCard and draw Card
    public Card scanForSuites(){

        return null;
    }

    //Creates suit from four of a kind
    public void createSuite(){

    }





}
