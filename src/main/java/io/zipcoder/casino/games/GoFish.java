package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;

public class GoFish extends Games {
    Console console;
    private GoFishPlayer goFishPlayer;
    private GoFishPlayer computer = new GoFishPlayer();
    private GoFishPlayer currentPlayer = new GoFishPlayer();

    private boolean isPlaying = true;



    private Deck deck = new Deck();


    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.goFishPlayer = player;
        this.console = console;

    }
    public void runGame () {
        console.println("Hey " + goFishPlayer.getName() + "! \nWelcome to GO FISH GAME");
        //String userInput = console.getStringInput("Do you want to play?");
        //if (readyToPlay(userInput)) {
            dealHands();
            currentPlayer = goFishPlayer;

            while (deck.getDeck().size() > 0) {

                if (currentPlayer == goFishPlayer) {
                    playerTurn();
                }
                else {
                    compTurn();
                }




        //}
        }

    }

    public void setCurrentPlayer(GoFishPlayer player) {

    }

    public void playerTurn() {
        console.println(seeHand(goFishPlayer));

        console.println(seeHand(computer) + "comphand!");


        String input = searchFor();
        ArrayList temp = checkHand(input, computer);
        while (!temp.isEmpty()) {

            removeFromHand(temp, computer);
            addToHand(temp, goFishPlayer);
            console.println("You got card/s from computer");
            console.getStringInput("");
            console.println("your hand: \n" + seeHand(goFishPlayer));

            input = searchFor();
            temp = checkHand(input, computer);

        }
        deck.dealSingleCard(goFishPlayer);
        currentPlayer = computer;
    }

    public void compTurn() {
        Integer compValueInt = compPickValue();
        String compValueString = getCardValue(compValueInt);
        console.println("Computer picking " + compValueString);
        ArrayList<Card> temp = checkHand(compValueString, goFishPlayer);

        while (!temp.isEmpty()) {

            removeFromHand(temp, goFishPlayer);
            addToHand(temp, computer);
            console.println("Comp got card/s from you");
            console.getStringInput("");
            console.println("your hand" + seeHand(goFishPlayer));

            compValueInt = compPickValue();
            compValueString = getCardValue(compValueInt);
            temp = checkHand(compValueString, goFishPlayer);

        }
        deck.dealSingleCard(computer);
        currentPlayer = goFishPlayer;
    }



    public Integer compPickValue () {
        Random random = new Random();
        Integer value = random.nextInt(13);
        return value;
    }

    public String getCardValue (Integer input) {
        String result = "";
        CardValue[] cardValues = CardValue.values();
        for (CardValue c: cardValues
        ) {
            if (c.ordinal() == input) {
               result = c.name();
               break;
            }
        }
        return result;
    }

    public void checkForFour () {}







    public ArrayList<Card> checkHand (String value, GoFishPlayer player){

        ArrayList<Card> cards = new ArrayList<Card>(0);

        for (Card c : player.getHand()
             ) {
            if(c.getCardValue().equals(CardValue.valueOf(value))) {
                cards.add(c);
            }
        }
        return cards;
    }

    public void removeFromHand (ArrayList<Card> cards, GoFishPlayer player) {
        player.getHand().removeAll(cards);
    }

    public void addToHand (ArrayList<Card> cards, GoFishPlayer player) {
        ArrayList<Card> temp;
        temp = player.getHand();
        temp.addAll(cards);
        player.setHand(temp);
    }

    public void update(Double amount) {
        Double result = goFishPlayer.getAccount() + amount;
        goFishPlayer.setAccount(result);
    }

    public void dealHands () {
        deck.deal(5, goFishPlayer);
        deck.deal(5, computer);
    }


    public String seeHand (GoFishPlayer player) {
        String hand = "";
        for (Card c: player.getHand()
             ) {
            hand += c.getCardValue() + " of "  + c.getSuit() + "\n";
        }
        return hand;

    }

    public boolean readyToPlay(String userInput){
        if (userInput.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;}
    }

    public String searchFor() {
        String userInput = console.getStringInput("What are you looking for?");
        return userInput.toUpperCase();
    }


    @Override
    void nextTurn() {
    }

    @Override
    void endGame() { }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Card check (Integer query) {
        return null;
    };

    public Card goFishAction () {
        return null;
    }
}
