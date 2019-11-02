package io.zipcoder.casino.GoFish;

import java.util.Scanner;
import io.zipcoder.casino.Card;
import io.zipcoder.casino.Utilities.Console;

import java.util.ArrayList;

public class GoFishRound {
    public Console console;

    private GoFishPlayer currentPlayer;
    private ArrayList<Card> newSuites;
    private GoFishPlayer player;
    private GoFishPlayer opponent;

    public GoFishRound(GoFishPlayer player, GoFishPlayer opponent) {
        this.player = player;
        this.opponent = opponent;
        this.console = new Console(System.in, System.out);

    }
    public ArrayList<Card> playRound(){
        return null;
    }

    //Fish for card from opponent
    public String chooseCard(){
        System.out.println();
        console.getStringInput("Choose a card to take! (2-10, J, Q, K, or A)");
        ;
    }
    //Performed after successful callout
    //if card retrieved matches card drawn, player repeats chooseCard
    public Card retrieveCard (String requestedCard){
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
