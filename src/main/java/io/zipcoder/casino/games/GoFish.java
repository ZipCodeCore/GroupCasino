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
//    private GoFishPlayer computer = new GoFishPlayer();
    private Player test = new Player("Computer");
    GoFishPlayer computer = new GoFishPlayer(test);
    private GoFishPlayer currentPlayer;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private boolean isPlaying = true;
    private boolean breakTheGame = false;

    private Deck deck = new Deck();
    Integer computerScore = 0;

    public GoFish() {}

    public GoFish(GoFishPlayer player, Console console) {
        super();
        this.goFishPlayer = player;
        this.console = console;

    }

    public void runGame () {
        console.println("Hey " + goFishPlayer.getName() + "! \nWelcome to GO FISH GAME\n");
        while (isPlaying) {
            dealHands();
            currentPlayer = goFishPlayer;
            while (deck.getDeck().size() > 0) {
                if (currentPlayer == goFishPlayer) {
                    playerTurn();
                } else {
                    compTurn();
                }
            }
            getWinner();
            String choice = console.getStringInput("would you like to play again?");
            isPlaying = playAgain(choice);
        }

    }

    public boolean playAgain(String choice) {

        if (choice.equalsIgnoreCase("yes")) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkForFour (GoFishPlayer player) {
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
                return true;
            }
        }
        return false;
    }


    public boolean checkProperPick (String userInput, GoFishPlayer player) {
        for (Card card: player.getHand()
             ) {
            if (card.getCardValue().name().equals(userInput)) {
                return true;
            }
        }
        return false;
    }


    public void removeFour (String stringValue, ArrayList<Card> hand) {
        ArrayList<Card> cardsToRemove = new ArrayList<Card>();
        for (Card card : hand
             ) {
            if (card.getCardValue().name().equals(stringValue)) {
                cardsToRemove.add(card);
            }
        }
        hand.removeAll(cardsToRemove);

    }
    public void getWinner() {
        if (goFishPlayer.getScore() > computerScore) {
            console.println(goFishPlayer.getName() + "is the winner!\n Congratulations!");
        }
        if (goFishPlayer.getScore() < computerScore) {
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
        hand = goFishPlayer.getHand();

        console.println( goFishPlayer.getName() + " your turn now! Your score is " + goFishPlayer.getScore() + "\n");

        console.println(seeHand(hand));

        String input = searchFor();
        if (!breakTheGame) {
            while (!checkProperPick(input, goFishPlayer)) {
                console.println("no such card in your hand, impossible move, try again");
                input = searchFor();
            }
            ArrayList temp = checkHand(input, computer);

            while (!temp.isEmpty()) {
                removeFromHand(temp, computer);
                addToHand(temp, goFishPlayer);
                console.println("You got card/s from computer");
                console.println(seeHand(temp));
                console.getStringInput("");

                if (checkForFour(goFishPlayer)) {
                    console.println(goFishPlayer.getName() + ", look at this!!! Boomoooooooom! 4 of the kind\n");
                    removeFour(input, hand);
                    goFishPlayer.setHand(hand);
                    updateScore(goFishPlayer);
                }

                console.println("your hand: \n" + seeHandByPlayer(goFishPlayer));

                input = searchFor();
                temp = checkHand(input, computer);

            }
            goFishAction(goFishPlayer);

            if (checkForFour(goFishPlayer)) {
                console.println(goFishPlayer.getName() + ", look at this!!! Boomoooooooom! 4 of the kind\n");
                removeFour(input, hand);
                goFishPlayer.setHand(hand);
                updateScore(goFishPlayer);
            }
            currentPlayer = computer;
        }
    }

    public void compTurn() {
        console.println("computers turn");
        Integer compValueInt = compPickValue();
        String compValueString = getCardValue(compValueInt);

        while (!checkProperPick(compValueString,computer)) {
            compValueInt = compPickValue();
            compValueString = getCardValue(compValueInt);
        }

        console.println("Computer picking " + compValueString);
        ArrayList<Card> temp = checkHand(compValueString, goFishPlayer);

        while (!temp.isEmpty()) {
            removeFromHand(temp, goFishPlayer);
            addToHand(temp, computer);
            console.println("Comp got this card/s from you");
            console.println(seeHand(temp));
            if (checkForFour(goFishPlayer)) {
                console.println( "Boomoooooooom! 4 of the kind for COMPUTERMAN\n");
                removeFour(compValueString, hand);
                computer.setHand(hand);
                computerScore++;
            }

            compValueInt = compPickValue();
            compValueString = getCardValue(compValueInt);
            temp = checkHand(compValueString, goFishPlayer);

        }
        console.getStringInput("");
        goFishAction(computer);
        if (checkForFour(goFishPlayer)) {
            console.println( "Boomoooooooom! 4 of the kind for COMPUTERMAN\n");
            removeFour(compValueString, hand);
            computer.setHand(hand);
            computerScore++;
        }
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

    public String seeHand(ArrayList<Card> hand) {
        String result = "";
        for (Card c: hand
        ) {
            result += c.getCardValue() + " of "  + c.getSuit() + "\n";
        }
        return result;
    }

    public String seeHandByPlayer(GoFishPlayer player) {
        String hand = "";
        for (Card c: player.getHand()
             ) {
            hand += c.getCardValue() + " of "  + c.getSuit() + "\n";
        }
        return hand;
    }


    public String searchFor() {
        String userInput = console.getStringInput("What are you looking for?");
        if (userInput.equalsIgnoreCase("exit")) {
            console.println("Good bye!");
            breakTheGame = true;
        }
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
    public void goFishAction(GoFishPlayer player) {
        console.println("no such card in the hand!\nYOU GO FISH!");
        deck.dealSingleCard(player);
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

}
