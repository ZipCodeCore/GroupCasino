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

    private Deck deck;
    private WarPlayer player1;
    private WarPlayer player2;
    private Integer cardIndex = 0;
    private boolean isRunning;
    public Scanner input;



    public void startGame() {

        System.out.println("War - Collect all cards to win!"); //opening title

        //set players
        Scanner console = new Scanner(System.in);
        this.player1 = new WarPlayer();
        this.player2 = new WarPlayer();

        //make deck
        Deck deck = new Deck();
        deck.buildDeck();

        //shuffle deck
        deck.shuffle();

//        //create players hands
//        player1.setWarHand(new Hand());
//        player2.setWarHand(new Hand());
//
//        //deal cards (26 each hand/ (deck))
//        public void dealHand(){
//            for (int i = 0; i < 26; i++) {
//
//                 = array[i];
//
//            }
//        }
//
//        dealHand(player1.getWarHand());
//        dealHand(player2.getWarHand());



        //initial game winner
        WarPlayer winner = null;

//          public void dealWarHands() {
//            for (int i = 0; i < 26; i++) {
//                if (i % 2 == 0) {
//                    playerDeck[i / 2] = deck;
//                } else {
//                    dealerDeck[i / 2] = deck;
//            }
//        }
//
//        }






    }

    //implement interface and all methods associated w it
    public void add(PlayerInterface player){};

    public void remove(PlayerInterface player){};

    public void run(){
        //while loop exit conition game ends
    };
}
