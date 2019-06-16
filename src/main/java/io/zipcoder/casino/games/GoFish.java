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
    ArrayList<Card> hand = new ArrayList<Card>();
    private boolean isPlaying = true;
    private Deck deck = new Deck();

    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.goFishPlayer = player;
        this.console = console;
    }

    public void runGame () {
        console.println("Hey " + goFishPlayer.getName() + "! \nWelcome to GO FISH GAME\n");
            dealHands();
            currentPlayer = goFishPlayer;
            while (deck.getDeck().size() > 0) {
                if (currentPlayer == goFishPlayer) {
                    playerTurn();
                }
                else {
                    compTurn();
                }
                checkForFour(currentPlayer);
        }
            getWinner();
    }

    public void checkForFour (GoFishPlayer player) {
        hand = player.getHand();
        String valueString;
        Integer value;
        int [] cardCount = new int[15];
        for (Card card : hand
             ) {
            valueString = card.getCardValue().name();
            value = cardValueToIntValue(valueString);
            cardCount[value]++;
            if (cardCount[value] == 4) {
                console.println(player.getName() + " got 4 of the kind\n");
                removeFour(cardCount[value], hand);
                player.setHand(hand);
                updateScore(player);
            }
        }
    }


    public void removeFour (Integer value, ArrayList<Card> hand) {
        for (Card card : hand
             ) {
            if (card.getCardValue().getCardIntegerValue() == value) {
                hand.remove(card);
            }
        }
    }
    public void getWinner() {
        if (goFishPlayer.getScore() > computer.getScore()) {
            console.println(goFishPlayer.getName() + "is the winner!\n Congratulations!");
        }
        if (goFishPlayer.getScore() < computer.getScore()) {
            console.println("Sorry " + goFishPlayer.getName() + "! You lost this game\n Would you like to play again?");
        }
        else {
            console.println("DRAW!\n Hey "+ goFishPlayer.getName() + "! Would you like to play again?");

        }
    }

    public void updateScore(GoFishPlayer player) {
        player.setScore(player.getScore() + 1);
        console.println("You score is " + player.getScore());
    }

    public void playerTurn() {
        console.println( goFishPlayer.getName() + " your turn now! Your score is " + goFishPlayer.getScore() + "\n");

        console.println(seeHand(goFishPlayer));

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
        console.println("computers turn");
        Integer compValueInt = compPickValue();
        String compValueString = getCardValue(compValueInt);
        console.println("Computer picking " + compValueString);
        ArrayList<Card> temp = checkHand(compValueString, goFishPlayer);

        while (!temp.isEmpty()) {

            removeFromHand(temp, goFishPlayer);
            addToHand(temp, computer);
            console.println("Comp got this card/s from you");
            for (Card card: temp
                 ) {
                console.println(card.getCardValue() + " of "  + card.getSuit() + "\n");
            }

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


    public String searchFor() {
        String userInput = console.getStringInput("What are you looking for?");
        return userInput.toUpperCase();
    }

    public Integer cardValueToIntValue (String string) {
        if (string.equals("TWO")) {return 2;}
        else if (string.equals("THREE")) {return 3;}
        else if (string.equals("FOUR")) {return 4;}
        else if (string.equals("FIVE")) {return 5;}
        else if (string.equals("SIX")) {return 6;}
        else if (string.equals("SEVEN")) {return 7;}
        else if (string.equals("EIGHT")) {return 8;}
        else if (string.equals("NINE")) {return 9;}
        else if (string.equals("TEN")) {return 10;}
        else if (string.equals("JACK")) {return 11;}
        else if (string.equals("QUEEN")) {return 12;}
        else if (string.equals("KING")) {return 13;}
        else if (string.equals("ACE")) {return 14;}
        else return null;
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

}
