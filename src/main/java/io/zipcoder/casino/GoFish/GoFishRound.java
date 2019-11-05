package io.zipcoder.casino.GoFish;

import java.util.Scanner;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Utilities.Console;
import sun.lwawt.macosx.CInputMethod;

import javax.swing.*;
import java.util.ArrayList;
public class GoFishRound {

    private Console console = new Console(System.in, System.out);
    private ArrayList<Card> newSuites;
    private GoFishPlayer player;
    private NPCGoFishRound opponent;
    private CardSet playersCards;
    private CardSet opponentsCards;

    public GoFishRound(GoFishPlayer player, Card card1, Card card2, Card card3, Card card4, Card card5, Card card6, Card card7) {
        this.player = player;
        this.console = new Console(System.in, System.out);
        this.playersCards = new CardSet(0);
        this.playersCards.addCard(card1);
        this.playersCards.addCard(card2);
        this.playersCards.addCard(card3);
        this.playersCards.addCard(card4);
        this.playersCards.addCard(card5);
        this.playersCards.addCard(card6);
        this.playersCards.addCard(card7);

    }

    public GoFishRound(NPCGoFishRound opponent, Card card8, Card card9, Card card10, Card card11, Card card12, Card card13, Card card14) {
        this.opponent = opponent;
        this.console = new Console(System.in, System.out);
        this.opponentsCards = new CardSet(0);
        this.opponentsCards.addCard(card8);
        this.opponentsCards.addCard(card9);
        this.opponentsCards.addCard(card10);
        this.opponentsCards.addCard(card11);
        this.opponentsCards.addCard(card12);
        this.opponentsCards.addCard(card13);
        this.opponentsCards.addCard(card14);
    }




    public String prompt(GoFishPlayer player) {
        String cardChoice = console.getCardRankInput("");
       /* //removeCard(cardChoice);
        //if(removeCard()){
            scanForSuites();
            prompt(player);
        }else{
        }
        //if(cardChoice ==*/
        return null;

    }

    public void searchHand(){
        for (int i = 0; i < opponentsCards.size(); i++) {


        }
    }


    //Fish for card from opponent
    public boolean requestCard(CardSet cardToHand, CardSet cardFromHand, String cardChoice) {
        return false;
    }
    public CardSet getPlayersCards(){
        return playersCards;
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
