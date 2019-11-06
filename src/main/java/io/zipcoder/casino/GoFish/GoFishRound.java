package io.zipcoder.casino.GoFish;

import java.util.Scanner;

import io.zipcoder.casino.Blackjack.BlackjackGame;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;
import sun.lwawt.macosx.CInputMethod;

import javax.swing.*;
import java.util.ArrayList;
public class GoFishRound {

    private Console console = new Console(System.in, System.out);
    private GoFishPlayer player;
    private GoFishNPC opponent;
    private CardSet playersCards;
    private CardSet opponentsCards;
    private CardSet playerSuites;
    private CardSet opponentSuites;
    private CardSet shoe;

    public GoFishRound(GoFishPlayer player, GoFishNPC opponent, CardSet shoe, Card card1, Card card2, Card card3, Card card4, Card card5, Card card6, Card card7, Card card8, Card card9, Card card10, Card card11, Card card12, Card card13, Card card14) {

        this.console = new Console(System.in, System.out);

        this.shoe = shoe;
        this.player = player;
        this.opponent = opponent;
        this.playersCards = new CardSet(0);
        this.opponentsCards = new CardSet(0);
        this.playersCards.addCard(card1);
        this.playersCards.addCard(card2);
        this.playersCards.addCard(card3);
        this.playersCards.addCard(card4);
        this.playersCards.addCard(card5);
        this.playersCards.addCard(card6);
        this.playersCards.addCard(card7);
        this.opponentsCards.addCard(card8);
        this.opponentsCards.addCard(card9);
        this.opponentsCards.addCard(card10);
        this.opponentsCards.addCard(card11);
        this.opponentsCards.addCard(card12);
        this.opponentsCards.addCard(card13);
        this.opponentsCards.addCard(card14);
        this.playerSuites = new CardSet(0);
        this.opponentSuites = new CardSet(0);
    }

    /*public GoFishRound(NPCGoFishRound opponent, Card card8, Card card9, Card card10, Card card11, Card card12, Card card13, Card card14) {
        this.opponent = opponent;
        this.console = new Console(System.in, System.out);
        this.opponentsCards = new CardSet(0);
        this.opponentsCards.addCard(card8);
        this.opponentsCards.addCard(card9);
        this.opponentsCards.addCard(card10);
        this.opponentsCards.addCard(card11);
        this.opponentsCards.addCard(card12);
        this.opponentsCards.addCard(card13);
        this.opponentsCards.addCard(card14);*/
    //}


    public String prompt(GoFishPlayer player) {
        displayStatus();

        String cardChoice = console.getCardRankInput("");

        ArrayList<Card>stolenCards = opponentsCards.removeRank(cardChoice);

        if(stolenCards.size()>0){
            String cardCheck = cardChoice;
            System.out.println("YOU HAVE SUCCESSFULLY TAKEN " + stolenCards.size() + stolenCards.get(0) + " FROM THE OPPONENT");

            playersCards.addCards(stolenCards);

            scanForSuites(cardCheck);

            prompt(player);

        }else{ prompt(player);
        }
        //if(cardChoice ==
        return null;
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
    public void displayStatus() {
        playersCards.sort();
        playerSuites.sort();
        displaySuite();
        console.println(playersCards.toASCII());
    }
    public void scanForSuites(String selectCard){
        ArrayList<Card> suiteChecker = playersCards.removeRank(selectCard);
        if (suiteChecker.size()==4) {
            console.println("YOU SUCCESFULLY MADE A SUITE OF " + suiteChecker.get(0));
            playerSuites.addCard(suiteChecker.get(0));
            ;
        }else{
            playersCards.addCards(suiteChecker);
        }
        playersCards.sort();
    }

    public void displaySuite(){
        console.println("***********************  PLAYER'S SUITES ************************\n"+ playerSuites.toASCII() +"\n"+"*****************************************************************" );


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


    //Creates suit from four of a kind





}
