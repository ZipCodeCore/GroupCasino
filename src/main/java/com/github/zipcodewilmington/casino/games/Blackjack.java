package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GamblingInterface;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.card.Card;
import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.player.BlackJackDealer;
import com.github.zipcodewilmington.casino.player.BlackJackPlayer;
import com.github.zipcodewilmington.casino.player.Player;
import com.github.zipcodewilmington.utils.IOConsole;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;


public class Blackjack implements GameInterface {

    private static String displayWelcome = "Welcome to BLackJack!";
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private Deck deck;
    Deck bJPlayerDeck = new Deck();
    Deck bJDealerDeck = new Deck();
    private int playerBet;
    private Boolean stay;
    private Boolean bust;
    private boolean roundOver = false;
    private ArrayList<Card> cards;
    Double playerCash = 1000.00;
    Hand hand = new Hand();


    public Blackjack() {



    }

    public static void welcomeDisplay() {
        System.out.println(displayWelcome);
        System.out.println("\n ================BLACK JACK=================");
        System.out.println(" -------  -------   -------  -------  -------");
        System.out.println("|A     | |K     |  |Q     |  |J     | |Zipcode|");
        System.out.println("|      | |      |  |      |  |      | |       |");
        System.out.println("|     A| |     K|  |     Q|  |     J| |  7.1  |");
        System.out.println("-------- --------  --------  -------- --------\n");
    }


    public BlackJackPlayer getPlayer() {
        return player;
    }








    public Boolean getStay() {
        return stay;
    }

    public void setStay(Boolean stay) {
        this.stay = stay;
    }

    public void setBust(Boolean bust) {
        this.bust = bust;
    }

    public Boolean getBust() {
        return bust;
    }

    public void setBet(Integer cash) {
        playerBet = cash;

    }
    public void startGame(){


        Scanner userInput = new Scanner(System.in);

        while(playerCash > 0){
            System.out.println("You currently have $" + playerCash +", how much are you going to bet?");
            double bet = userInput.nextDouble();
            if(playerBet > playerCash){
                break;
            }

            //players card
            bJPlayerDeck.draw(deck);
            bJPlayerDeck.draw(deck);


            //dealers card
            bJDealerDeck.draw(deck);
            bJDealerDeck.draw(deck);

            while(true){
                System.out.println("Player Hand:");
                System.out.println(bJPlayerDeck.toString());
                System.out.println("Player hand is valued at: " + bJPlayerDeck.cardValue());
                System.out.println("Dealer Hand: " + bJDealerDeck.getCard(0).toString() + " [Hidden  card]");

                System.out.println("Hit or Stand?");
                String reply = userInput.nextLine();
                if(reply == "Hit"){
                    bJPlayerDeck.draw(deck);
                    System.out.println("Drew a: " + bJPlayerDeck.getCard(bJPlayerDeck.sizeOfDeck() - 1).toString());

                    if(bJPlayerDeck.cardValue() > 21){
                        System.out.println("Bust. " + bJPlayerDeck.cardValue());
                        playerCash -=playerBet;
                        roundOver = true;

                    }
                }
                if(reply == "Stand"){
                    break;
                }
            }
            System.out.println("Dealer's Cards: " + bJDealerDeck.toString());
            if(bJDealerDeck.cardValue() > bJPlayerDeck.cardValue() && roundOver == false){
                System.out.println("Dealer Wins!!");
                playerCash -= playerBet;
                roundOver = true;
            }
        }
        System.out.println("Leave my casino, you are out of money!");
    }
    public static void playBlackJack() {
        Scanner keyboardInput = new Scanner(System.in);
        welcomeDisplay();
        keyboardInput.nextLine();
        playBlackJack();
    }

    public void add(PlayerInterface player) {

}

    public void remove(PlayerInterface player) {

    }

    public void run() {playBlackJack();

    }

}
