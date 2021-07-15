package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.objects.Deck;

import java.util.List;

public class Blackjack implements GameInterface {

    // Blackjack is a game that a player plays against a dealer
    // The first card is placed face down for the player and dealer
    // the second card is placed face up
    // the player has the option to (HIT, HOLD, or RAISE)
    // if the player goes past 21 then it is a BUST and they lose
    // if the player HOLDs and their total is higher than the dealer, then they win
    // if the player gets exactly 21 they win 2x the total bet

    Deck deck;

    public Blackjack(Deck deck, List<Integer> players) {
        this.deck = deck;
        this.players = players;
    }

    List<Integer> players;


    public Blackjack(Deck deck) {
        this.deck = deck;
    }

    public Blackjack() {

    }

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        Deck deck = new Deck(1);
        blackjack.run();
        deck.populateDeck();
        deck.shuffleDeck();
    }


    @Override
    public void run() {
        System.out.println("Welcome to the Sirius Blackjack table.");
        System.out.println("Have a seat and get ready for an adventure!");
        System.out.println("How much would you like to bet?");
        System.out.println("25 Chips || 50 Chips");





    }

    @Override
    public void add(PlayerInterface player) {
        players.add(0, 0);
    }

    @Override
    public void remove(PlayerInterface player) {

    }



    @Override
    public int getNumberOfPlayers() {
        return 1;
    }

    @Override
    public boolean playerWins() {

        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }


}
