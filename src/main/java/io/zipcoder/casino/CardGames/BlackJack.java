package io.zipcoder.casino.CardGames;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;
import org.w3c.dom.ls.LSOutput;

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
        checkHandForAce(gamblingPlayerHand);
        checkHandForAce(computerHand);
        checkHandValue(gamblingPlayerHand);
        checkHandValue(computerHand);




    }

    public void promptUserForWagerAmount() {
        double userWagerAmount = input.getDoubleInput("How much would you like to wager?");
        boolean wagerAmountSuccessful = gamblingPlayer.placeWager(userWagerAmount);
        while (!wagerAmountSuccessful) {
            userWagerAmount = input.getDoubleInput("Wager exceeds your balance. Please wage a smaller amount.");
            wagerAmountSuccessful = gamblingPlayer.placeWager(userWagerAmount);
        }
    }

    public void initializeblackJackHands() {

        blackJackDeck = new Deck(1);
        blackJackDeck.shuffleDeck();
        gamblingPlayerHand = new CardHand(blackJackDeck.dealCards(2));
        computerHand = new CardHand(blackJackDeck.dealCards(2));
    }

    public Integer checkHandValue(CardHand hand) {
        Integer handValue = 0;
        for (int i = 0; i < hand.userHand.size(); i++) {
            handValue = handValue + translateBlackJackValueFromRank(hand.userHand.get(i));
        }
        return handValue;
    }

    public Integer translateBlackJackValueFromRank(Card card) {
        Integer blackJacHandValue = null;
        if (card.getRank() == Rank.JACK || card.getRank() == Rank.QUEEN || card.getRank() == Rank.KING) {
            blackJacHandValue = 10;
        } else if (card.getRank() == Rank.ACE) {
            blackJacHandValue = 11;
        } else {
            blackJacHandValue = Integer.valueOf(card.getRank().toString());
        }
        return blackJacHandValue;
    }

    public Integer checkScore(Integer blackJackHandValue)    {
        if(blackJackHandValue > 21 && checkHandForAce())    {
            if

        }

    }

    public boolean checkHandForAce(CardHand hand) {
        for (int i = 0; i < hand.userHand.size(); i++) {
            if(card.getRank() == Rank.ACE)  {
                return true;
            }
        }   return false;
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
