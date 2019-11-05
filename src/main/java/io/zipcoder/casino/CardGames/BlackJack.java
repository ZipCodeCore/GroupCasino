package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;

import java.sql.SQLOutput;

//import javax.smartcardio.Card;



public class BlackJack implements GamblingGame {
    Console input = new Console(System.in, System.out);
    GamblingPlayer gamblingPlayer;
    CardHand gamblingPlayerHand;
    Deck blackJackDeck;
    CardHand computerHand;
    boolean winGame = false;


    private Player user;

    private int answerHitOrStay;
    private int wageBucket;
    private Card card;


    public BlackJack(Player user) {
        this.gamblingPlayer = new GamblingPlayer(user);
    }


    public void startGame() {
        promptUserForWagerAmount();
        initializeblackJackHands();

    }


    public void initializeblackJackHands() {

        blackJackDeck = new Deck(1);
        blackJackDeck.shuffleDeck();
        gamblingPlayerHand = new CardHand(blackJackDeck.dealCards(2));
        computerHand = new CardHand(blackJackDeck.dealCards(2));



    }


//    String placeWage(double wager){


    void promptUserForWagerAmount() {
        double userWageAmount = input.getDoubleInput("How much would you like to wager?");
        gamblingPlayer.placeWage(userWageAmount);
    }


    public Integer blackJackValueFromRank(Card card) {
        Integer blackJackValue = null;
        if (card.getRank() == Rank.JACK || card.getRank() == Rank.QUEEN || card.getRank() == Rank.KING) {
            blackJackValue = 10;
        } else if (card.getRank() == Rank.ACE) {
            blackJackValue = 11;
        } else {
            blackJackValue = Integer.valueOf(card.getRank().toString());
        }   return blackJackValue;
    }


    public void promptHitOrStay() {
        System.out.println(gamblingPlayerHand.displayHand());
        System.out.println(computerHand.displayHand());


        int userInput = input.getIntegerInput("Would you like to hit or stay?");


    }

    public void dealerHitOrStay() {
    }  //

    public void hit(Player deck, Player player) {
    }

    public void stay() {
    }

    public void distributeWinnings() {
    }

    public void checkCardValue(Card firstCard, Card secondCard) {
    }

    public void getWinner(CardHand dealer, CardHand player) {
    }

    public void promptLeaveGame() {
    }

    public void displayResults() {
    }


}
