package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.card.Card;
import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.player.BlackJackPlayer;
import com.github.zipcodewilmington.casino.player.Player;
import com.github.zipcodewilmington.utils.IOConsole;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;


public class Blackjack {
//    private static String displayWelcome = "Welcome to BLackJack!";
//    private BlackJackPlayer player;
//    private BlackJackPlayer dealer;
//    private Deck deck;
//    Deck bJPlayerDeck = new Deck();
//    Deck bJDealerDeck = new Deck();
//    private int playerBet;
//    private Boolean stay;
//    private Boolean bust;
//    private ArrayList<Card> cards;
//    Double playerCash = 1000.00;
//
//
//    public void welcomeDisplay() {
//        System.out.println(displayWelcome);
//        System.out.println("\n ================BLACK JACK=================");
//        System.out.println(" -------  -------   -------  -------  -------");
//        System.out.println("|A     | |K     |  |Q     |  |J     | |Zipcode|");
//        System.out.println("|      | |      |  |      |  |      | |       |");
//        System.out.println("|     A| |     K|  |     Q|  |     J| |  7.1  |");
//        System.out.println("-------- --------  --------  -------- --------\n");
//    }
//
//    public Blackjack() {
//        deck.buildDeck();
//        deck.shuffle();
//        player = new BlackJackPlayer(player);
//        dealer = new BlackJackPlayer(dealer);
//
//
//    }
//
//    public BlackJackPlayer getPlayer() {
//        return player;
//    }
//
//    public BlackJackPlayer getDealer() {
//        return dealer;
//    }
//
//    public void welcomeGame() {
//        System.out.println(displayWelcome);
//        welcomeDisplay();
//
//
//    }
//
//    public Deck buildDeck() {
//        this.deck = new Deck();
//        return deck;
//    }
//
//    public int cardValue() {
//        int totalValue = 0;
//        int aces = 0;
//
//        for (Card c : this.cards) {
//            switch (c.getCardValue()) {
//                case TWO:
//                    totalValue += 2;
//                    break;
//                case THREE:
//                    totalValue += 3;
//                    break;
//                case FOUR:
//                    totalValue += 4;
//                    break;
//                case FIVE:
//                    totalValue += 5;
//                    break;
//                case SIX:
//                    totalValue += 6;
//                    break;
//                case SEVEN:
//                    totalValue += 7;
//                    break;
//                case EIGHT:
//                    totalValue += 8;
//                    break;
//                case NINE:
//                    totalValue += 9;
//                    break;
//                case TEN:
//                    totalValue += 10;
//                    break;
//                case JACK:
//                    totalValue += 10;
//                    break;
//                case QUEEN:
//                    totalValue += 10;
//                    break;
//                case KING:
//                    totalValue += 10;
//                    break;
//                case ACE:
//                    totalValue += 1;
//                    break;
//
//            }
//        }
//        for (int i = 0; i < aces; i++) {
//            if (totalValue > 10) {
//                totalValue += 1;
//            }else{
//                totalValue += 11;
//            }
//        }
//        return totalValue;
//    }
//
//
//
//    public Boolean getStay() {
//        return stay;
//    }
//
//    public void setStay(Boolean stay) {
//        this.stay = stay;
//    }
//
//    public void setBust(Boolean bust) {
//        this.bust = bust;
//    }
//
//    public Boolean getBust() {
//        return bust;
//    }
//
//    public void setBet(Integer cash) {
//        playerBet = cash;
//
//    }
//    public void startGame(){
//        buildDeck();
//
//        Scanner userInput = new Scanner(System.in);
//
//        while(playerCash > 0){
//            System.out.println("You currently have $" + playerCash +", how much are you going to bet?");
//            double bet = userInput.nextDouble();
//            if(playerBet > playerCash){
//                break;
//            }
//            bJPlayerDeck.draw(deck);
//            bJPlayerDeck.draw(deck);
//            bJDealerDeck.draw(deck);
//            bJDealerDeck.draw(deck);
//
//
//        }
//        System.out.println("Leave my casino, you are out of money!");
//    }


}
