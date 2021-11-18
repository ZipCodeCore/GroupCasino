package com.github.zipcodewilmington.casino.games.cardGames;

import java.util.Collections;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();

        System.out.println(blackJack.rules());

        do {
            blackJack.callDeck();
            //dealCards();
            //dealersHand();
            //usersHand();
            //userAction();
            //checkWinner();
            //continuePlaying();
        } while (blackJack.continuePlaying());
    }

    public String rules() {
        return "Blackjack is played with one or more standard 52-card decks, with each denomination assigned a\n " +
                "point value. The cards 2 through 10 are worth their face value. Kings, queens, and jacks are each\n" +
                " worth 10, and aces may be used as either 1 or 11. The object for the player is to draw cards\n" +
                " totaling closer to 21, without going over, than the dealer's cards.";
    }

    public void callDeck() {
        createDeck deck = new createDeck();
        Collections.shuffle(deck.cardsStack);
        for (Cards card : deck.cardsStack) {
            System.out.println(card.toString());
        }
    }

    public void dealCards() {
        System.out.println("How many people are playing?");

    }

    public void dealersHand() {

    }

    public void usersHand() {

    }

    public void userAction() {
        String action = "";

        switch (action) {
            case "hit":
                System.out.println("you said hit");
                break;
            case "stand":
                System.out.println("you said stand");
                break;
            case "double down":
                System.out.println("you said double down");
                break;
            case "split":
                System.out.println("you said split");
                break;
            case "insurance":
                System.out.println("you said insurance");
                break;
            default:
                System.out.println("Please choose a valid option.");
        }
    }

    public void checkWinner() {

    }

    public boolean continuePlaying() {
        boolean answer = false;
        //System.out.println("Would you like to keep playing?");

        return answer;
    }
}

