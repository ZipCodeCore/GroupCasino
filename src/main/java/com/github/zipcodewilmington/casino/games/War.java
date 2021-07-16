package com.github.zipcodewilmington.casino.games;


import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.card.Card;
import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.player.Player;
import com.github.zipcodewilmington.casino.player.WarPlayer;


import java.util.ArrayList;
import java.util.Scanner;

public class War implements GameInterface {
    public static void main(String[] args) {

    }

    private Deck deck;
    private WarPlayer player;

    Card cpuCard;
    Card playerCard;
    private Integer cardIndex = 0;
    private boolean isRunning;
    public Scanner input;


    public void startGame() {

        System.out.println("War - Collect all cards to win!"); //opening title

        //set players
        Scanner console = new Scanner(System.in);
        this.player = new WarPlayer();
        this.player = new WarPlayer();

        //make deck
        Deck deck = new Deck();
        deck.buildDeck();

        //shuffle deck
        deck.shuffle();

        //split deck in half and deal to players
        Deck cpuHalf = deck.splitFirst();
        Deck playerHalf = deck.splitSecond();
        //System.out.println(cpuHalf);
        //System.out.println(cpuHalf.getSize());
        //System.out.println(playerHalf);
        //System.out.println(playerHalf.getSize());

        Hand cpuHand = new Hand();
        cpuHand.setHand(cpuHalf);
        Hand playerHand = new Hand();
        playerHand.setHand(playerHalf);
        int rounds = 0;

        //game start
        while (cpuHand.getHand().getSize() > 0 && playerHand.getHand().getSize() > 0 && rounds <= 26) {
            System.out.println("Game running currently on round: " + rounds);
            cpuCard = cpuHand.drawSingleCard();
            playerCard = playerHand.drawSingleCard();
            System.out.println("CPU draws... " + cpuCard);
            cpuHand.removeCard(cpuCard);
            System.out.println("Player draws... " + playerCard);
            playerHand.removeCard(playerCard);
            rounds++;

        }


    }

//    public void getWinner() {
//        if(playerCard.getCardValue() > cpuCard.getCardValue()) {
//
//        }
//    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        startGame();
    }
}