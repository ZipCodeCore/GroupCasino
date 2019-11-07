package io.zipcoder.casino.Games.GoFish;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.CardValue;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Random;

public class GoFish implements Game {

    Console console = new Console(System.in, System.out);
    CasinoArt casinoArt = new CasinoArt();
    private Player currentPlayer;
    boolean running = true;

    private Deck deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> aiHand;
    private Integer playerPairs;
    private Integer aiPairs;


    public GoFish() {
        deck = new Deck();

        playerHand = new ArrayList<>();
        aiHand = new ArrayList<>();

        playerPairs = 0;
        aiPairs = 0;
    }

    @Override
    public void approachTable(Player currentPLayer) {
        Console.clearScreen();
        console.printFast(casinoArt.getCasinoArt(CasinoArt.Art.GOFISH));
        console.printSlow("You see someone playing go fish against themselves");
        console.dotDotDot();
        console.newln();
        console.printSlow("Would you like to play?\n");
        console.delay(400);
        console.printSlow("(1) Yes\n");
        console.printSlow("(2) No\n");

        String input = console.getStringInput(":");

        switch (input) {
            case "1":
                runGame(currentPLayer);
                break;
            case "2":
                console.printSlow("Good Idea");
                console.newln();
                break;
            default:
                console.print("Invalid Input");
                console.dotDotDot();
                console.newln();
                console.delay(2000);
                approachTable(currentPLayer);
                break;
        }
    }

    @Override
    public void runGame(Player currentPlayer) {

        deck.shuffle();

        dealHands();

        while (running) {

            displayHand(playerHand);
            displayHand(aiHand);

            checkCard(playerGuess(), true);
            checkCard(aiGuess(), false);

        }
    }

    public void displayHand(ArrayList<Card> hand) {
        console.print("Your current hand is ");
        for (Card c : hand) {
            if (c.getCardValue().equals(CardValue.JACK)) {
                console.print("Jack ");
            } else if (c.getCardValue().equals(CardValue.QUEEN)) {
                console.print("Queen ");
            } else if (c.getCardValue().equals(CardValue.KING)) {
                console.print("King ");
            } else if (c.getCardValue().equals(CardValue.ACE)) {
                console.print("Ace ");
            } else {
                console.print(c.getCardValue().getValue() + " ");
            }
        }
        console.newln();
    }

    public void dealHands() {
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.draw());
            aiHand.add(deck.draw());
        }
    }

    public boolean hasCard(ArrayList<Card> hand, CardValue card) {
        for (Card c : hand) {
            if (c.getCardValue().equals(card)) {
                return true;
            }
        }
        return false;
    }

    public Card removeCard(ArrayList<Card> hand, CardValue card) {
        Card toRemove = null;
        for (Card c : hand) {
            if (c.getCardValue().equals(card)) {
                toRemove = c;
            }
        }
        if(toRemove != null) {
            hand.remove(toRemove);
        }
        return toRemove;
    }

    public void checkCard(CardValue card, boolean isPlayerGuess) {
        ArrayList<Card> hand;
        if(isPlayerGuess) hand = aiHand;
        else hand = playerHand;

        if(hasCard(hand, card)) {
            removeCard(playerHand, card);
            removeCard(aiHand, card);

            if(isPlayerGuess) {
                console.print("Good guess, you got a pair!");
            } else {
                console.print("Your opponent guessed your card!");
            }

        } else {
            console.println("Go fish!");
            fish(isPlayerGuess);
        }
    }

    public void fish(boolean isPlayer) {
        Card drawnCard = deck.draw();
        if (isPlayer) {
            playerHand.add(drawnCard);
        } else {
            aiHand.add(drawnCard);
        }
    }

    public CardValue aiGuess() {
        Random random = new Random();
        Integer guessVal = random.nextInt(aiHand.size());

        return aiHand.get(guessVal).getCardValue();
    }

    public CardValue playerGuess() {
        CardValue theCard = CardValue.TWO;
        boolean validInput = false;

        while (!validInput) {
            validInput = true;
            console.printSlow("Guess a card\n");
            String cardGuess = console.getStringInput("");

            if (cardGuess.equals("ace")) {
                theCard = CardValue.ACE;
            } else if (cardGuess.equals("king")) {
                theCard = CardValue.KING;
            } else if (cardGuess.equals("queen")) {
                theCard = CardValue.QUEEN;
            } else if (cardGuess.equals("jack")) {
                theCard = CardValue.JACK;
            } else {
                try {
                    Integer numInput = Integer.parseInt(cardGuess);
                    if (numInput > 1 && numInput < 11) {
                        theCard = CardValue.fromInt(numInput);
                        if(!hasCard(playerHand, theCard)) {
                            console.print(numInput + " ");
                            console.print(theCard.getValue() + " ");
                            console.printSlow("That card is not in your hand!\n");
                            validInput = false;
                        }
                    } else {
                        console.printSlow("That is not a card number! ");
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    console.printSlow("What?!\n");
                    validInput = false;
                }
            }
        }
        return theCard;
    }

    @Override
    public void exitGame(Player currentPlayer) {

    }
}
