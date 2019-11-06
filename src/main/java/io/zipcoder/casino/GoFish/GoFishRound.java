package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class GoFishRound {

    Console console;
    private GoFishPlayer currentPlayer;
    private ArrayList<Card> newSuites;
    private GoFishPlayer player;
    private GoFishPlayer opponent;
    String cardChoice;

    public GoFishRound(GoFishPlayer player, Card card1, Card card2, Card card3, Card card4, Card card5, Card card6, Card card7) {
        this.player = player;
        this.opponent = opponent;
        this.console = new Console(System.in, System.out);



    }
    public ArrayList<Card> playRound(){

        return null;
    }

    //Fish for card from opponent
    public void requestCard(String input){
        console.getCardRankInput(cardChoice);

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
