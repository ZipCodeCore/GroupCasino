package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Iterator;

public class GoFish extends Games {
    Console console;
    private GoFishPlayer mainPlayer;
    private GoFishPlayer otherPlayer = new GoFishPlayer();
    private GoFishPlayer activePlayer = new GoFishPlayer();
    private GoFishPlayer passivePlayer = new GoFishPlayer();
    Boolean switchP = true;

    private boolean isPlaying = true;



    private Deck deck = new Deck();


    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.mainPlayer = player;
        this.console = console;

    }
    public void runGame () {
        console.println("Hey " + mainPlayer.getName() + "! \nWelcome to GO FISH GAME");
        String userInput = console.getStringInput("Do you want to play?");
        if (readyToPlay(userInput)) {
            dealHands();
            while (deck.getDeck().size() > 0) {
                    setActivePlayer(switchP);



                console.println(seeHand(activePlayer));

                console.println(seeHand(passivePlayer) + "other");


                String input = searchFor();
                ArrayList temp = checkHand(input, passivePlayer);

                if (!temp.isEmpty()) {
                    removeFromHand(temp, passivePlayer);
                    addToHand(temp, activePlayer);
                }
                else {
                    deck.dealSingleCard(activePlayer);
                }
            }
        }
    }

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

    public void setActivePlayer (Boolean isActive) {
        if (isActive) {
            this.mainPlayer = activePlayer;
            this.otherPlayer = passivePlayer;
        }
        else {
            this.mainPlayer = passivePlayer;
            this.otherPlayer = activePlayer;
        }
    }

    public void update(Double amount) {
        Double result = mainPlayer.getAccount() + amount;
        mainPlayer.setAccount(result);
    }

    public void dealHands () {
        deck.deal(5, mainPlayer);
        deck.deal(5, otherPlayer);
    }


    public String seeHand (GoFishPlayer player) {
        String hand = "";
        for (Card c: player.getHand()
             ) {
            hand += c.getCardValue() + " of "  + c.getSuit() + " ==== ";
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
