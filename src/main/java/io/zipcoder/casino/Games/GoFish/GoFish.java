package io.zipcoder.casino.Games.GoFish;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.CardValue;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.utilities.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GoFish implements Game {

    private Console console = new Console(System.in, System.out);
    private CasinoArt casinoArt = new CasinoArt();
    private boolean running = true;

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
        console.printSlow("\n\nYou see someone playing go fish against themselves");
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

        deck = new Deck();
        deck.shuffle();
        dealHands();

        while (running) {
            console.print("Your current hand is ");
            displayHand(playerHand);

            while (aiHand.size() > 0 && playerHand.size() > 0 && deck.cardsLeft() > 0 &&  checkCard(playerGuess(), playerHand, aiHand)) {
                console.printSlow("You guessed right!\n");
                checkBook(playerHand, true);
                if(playerHand.size() > 0) {
                    console.print("Your current hand is ");
                    displayHand(playerHand);
                }
            }

            if (!deck.cardsLeft().equals(0) && playerHand.size() != 0 && aiHand.size() != 0) {
                console.printSlow("Wrong guess! Go Fish!\n");
                console.printSlow("You draw a " + fish(playerHand).getCardValue().toString() + "!\n");
                checkBook(playerHand, true);

                console.printSlow("Your hand is now ");
                displayHand(playerHand);
                console.printSlow("Hit enter to continue\n");
                console.print("--------------------------------------------------------------");
                console.println(" You have " + playerHand.size() + " cards and " + playerPairs + " books");
                console.getStringInput("");


                while (aiHand.size() > 0 && playerHand.size() > 0 && deck.cardsLeft() > 0 && checkCard(aiGuess(), aiHand, playerHand)) {
                    console.printSlow("Your opponent guessed right!\n");
                }
            }


            if (deck.cardsLeft().equals(0) || playerHand.size() == 0 || aiHand.size() == 0) {
                running = false;
            } else {
                console.printSlow("Your opponent guessed wrong. They Go Fish!\n");
                fish(aiHand);
                checkBook(aiHand, false);
                console.printSlow("Hit enter to continue\n");
                console.print("--------------------------------------------------------------");
                console.println(" Your opponent has " + aiHand.size() + " cards and " + aiPairs + " books");
                console.getStringInput("");
            }
        }

        checkWinner(currentPlayer);
    }

    public void displayHand(ArrayList<Card> hand) {
        Collections.sort(hand);
        for (Card c : hand) {
            console.print(c.getCardValue().toString() + " ");
        }
        console.newln();
    }

    public void dealHands() {
        for (int i = 0; i < 5; i++) {
            playerHand.add(deck.draw());
            aiHand.add(deck.draw());
        }

        checkBook(aiHand, false);
        checkBook(playerHand, true);
    }

    public ArrayList<Card> removeCards(ArrayList<Card> hand, CardValue card) {
        ArrayList<Card> toRemove = new ArrayList<>();
        for (Card c : hand) {
            if (c.getCardValue().equals(card)) {
                toRemove.add(c);
            }
        }

        for (Card c : toRemove) {
            hand.remove(c);
        }

        return toRemove;
    }

    public boolean hasCard(ArrayList<Card> hand, CardValue card) {
        for (Card c : hand) {
            if (c.getCardValue().equals(card)) {
                return true;
            }
        }
        return false;
    }

    public void checkBook(ArrayList<Card> cards, boolean isPlayer) {
        for (int i = 2; i < 15; i++) {
            CardValue cardVal = CardValue.fromInt(i);
            int first = -1;
            int second = -1;
            int third = -1;
            int fourth = -1;

            for(int j = 0; j < cards.size(); j++) {
                if (cards.get(j).getCardValue().equals(cardVal)) {
                    if(first == -1) {
                        first = j;
                    } else if (second == -1){
                        second = j;
                    } else if (third == -1) {
                        third = j;
                    } else {
                        fourth = j;
                    }
                }
            }

            if (first != -1 && second != -1 && third != -1 && fourth != -1) {
                cards.remove(fourth);
                cards.remove(third);
                cards.remove(second);
                cards.remove(first);
                if(isPlayer) {
                    console.printSlow("You have a book of " + cardVal + "s!\n");
                    playerPairs++;
                } else {
                    console.printSlow("Your opponent has a book of " + cardVal + "s!\n");
                    aiPairs++;
                }
            }
        }
    }

    public boolean checkCard(CardValue card, ArrayList<Card> destHand, ArrayList<Card> askHand) {
        if(hasCard(askHand, card)) {
            destHand.addAll(removeCards(askHand, card));
        return true;
        } else {
            return false;
        }
    }

    public Card fish(ArrayList<Card> hand) {
        Card drawnCard = deck.draw();
        hand.add(drawnCard);
        return drawnCard;
    }

    public CardValue aiGuess() {
        Random random = new Random();
        Integer guessVal = random.nextInt(aiHand.size());
        CardValue guess = aiHand.get(guessVal).getCardValue();

        console.printSlow("Your opponent guesses " + guess + "\n");

        return guess;
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

    public void checkWinner(Player currentPLayer) {
        if (playerPairs > aiPairs) {
            console.printSlow("You won! with " + playerPairs + " books\n");
        } else if (playerPairs < aiPairs){
            console.printSlow("You lost!\n");
        } else {
            console.printSlow("It's a tie!\n");
        }

        console.printSlow("Would you like to play again?\n");
        console.printSlow("(1) yes\n");
        console.printSlow("(2) no\n");

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
    public void exitGame(Player currentPlayer) {

    }
}
