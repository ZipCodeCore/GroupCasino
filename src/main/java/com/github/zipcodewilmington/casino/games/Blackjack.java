package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.card.Card;
import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.player.BlackJackPlayer;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;


public class Blackjack {
    private static String displayWelcome = "Welcome to BLackJack!";
    private BlackJackPlayer player;
    private Deck deck = new Deck();
    private int bet;






    public void welcomeDisplay(){
        System.out.println(displayWelcome);
        System.out.println("\n ================BLACK JACK=================");
        System.out.println(" -------  -------   -------  -------  -------");
        System.out.println("|A     | |K     |  |Q     |  |J     | |Zipcode|");
        System.out.println("|      | |      |  |      |  |      | |       |");
        System.out.println("|     A| |     K|  |     Q|  |     J| |  7.1  |");
        System.out.println("-------- --------  --------  -------- --------\n");
    }
    public Blackjack(){
        this.bet = 0;
        deck.buildDeck();
        deck.shuffle();

    }

    public void startGame(){
        System.out.println(displayWelcome);
        welcomeDisplay();


    }


}
