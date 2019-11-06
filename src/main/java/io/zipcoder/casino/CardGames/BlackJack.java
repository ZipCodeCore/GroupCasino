package io.zipcoder.casino.CardGames;

import com.sun.xml.internal.bind.v2.TODO;
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
    private int wageBucket;
    private Card card;


    public BlackJack(Player user) {
        this.gamblingPlayer = new GamblingPlayer(user);
    }

    public GamblingPlayer getGamblingPlayer() {
        return gamblingPlayer;
    }

    public void setGamblingPlayer(GamblingPlayer gamblingPlayer) {
        this.gamblingPlayer = gamblingPlayer;
    }

    public CardHand getGamblingPlayerHand() {
        return gamblingPlayerHand;
    }

    public void setGamblingPlayerHand(CardHand gamblingPlayerHand) {
        this.gamblingPlayerHand = gamblingPlayerHand;
    }

    public Deck getBlackJackDeck() {
        return blackJackDeck;
    }

    public void setBlackJackDeck(Deck blackJackDeck) {
        this.blackJackDeck = blackJackDeck;
    }

    public CardHand getComputerHand() {
        return computerHand;
    }

    public void setComputerHand(CardHand computerHand) {
        this.computerHand = computerHand;
    }

    public boolean isWinGame() {
        return winGame;
    }

    public void setWinGame(boolean winGame) {
        this.winGame = winGame;
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public int getWageBucket() {
        return wageBucket;
    }

    public void setWageBucket(int wageBucket) {
        this.wageBucket = wageBucket;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void playBlackJack() {
        initializeBlackJackHands();
        checkScore(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand));
        checkScore(checkHandValue(computerHand), checkHandForAces(computerHand));

        do {
            displayHandsAndCurrentScore();
            promptHitOrStay();
            hitOrStayAction(gamblingPlayerHand, promptHitOrStay());
            checkScore(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand));

        }
        while (checkScore(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand)) < 21 || promptHitOrStay() == 0);


    }


    public void promptUserForWagerAmount() {
        double userWagerAmount = input.getDoubleInput("How much would you like to wager?");
        boolean wagerAmountSuccessful = gamblingPlayer.placeWager(userWagerAmount);
        while (!wagerAmountSuccessful) {
            userWagerAmount = input.getDoubleInput("Wager exceeds your balance. Please wage a smaller amount.");
            wagerAmountSuccessful = gamblingPlayer.placeWager(userWagerAmount);
        }
    }

    public void initializeBlackJackHands() {

        blackJackDeck = new Deck(1);
        blackJackDeck.shuffleDeck();
        gamblingPlayerHand = new CardHand(blackJackDeck.dealCards(2));
        computerHand = new CardHand(blackJackDeck.dealCards(2));
    }


    //takes arrayList of cards from hand and separates them by card so translateBlackJackValueFromRank can assign a value to each card. Then calculates value of hand without considering
    public Integer checkHandValue(CardHand hand) {
        Integer handValue = 0;
        for (int i = 0; i < hand.userHand.size(); i++) {
            handValue = handValue + translateBlackJackValueFromRank(hand.userHand.get(i));
        }
        return handValue;
    }
    //takes cards passed from checkHandValue and sets a value based on card rank. Aces are defaulted to 11 points.
    public Integer translateBlackJackValueFromRank(Card card) {
        Integer blackJackHandValueofAceIs11Points = null;
        if (card.getRank() == Rank.JACK || card.getRank() == Rank.QUEEN || card.getRank() == Rank.KING) {
            blackJackHandValueofAceIs11Points = 10;
        } else if (card.getRank() == Rank.ACE) {
            blackJackHandValueofAceIs11Points = 11;
        } else {
            blackJackHandValueofAceIs11Points = Integer.valueOf(card.getRank().toString());
        }
        return blackJackHandValueofAceIs11Points;
    }


        //counts the number of Aces in cardHand.
    public Integer checkHandForAces(CardHand hand) {
        Integer aceCounter = 0;
        for (int i = 0; i < hand.userHand.size(); i++) {
            if (card.getRank() == Rank.ACE) {
                aceCounter++;
            }
        }
        return aceCounter;
    }

        //evaluates score of blackjack hand and determines whether or not the value of each Ace should remain at 11 points or be reassigned to 1 point. Returns
    public Integer checkScore(Integer blackJackHandValue, Integer numberOfAces) {
        if (numberOfAces == 1 && blackJackHandValue > 21) {
            blackJackHandValue = blackJackHandValue - 10;
        } else if (numberOfAces == 2 && blackJackHandValue > 21) {
            if (blackJackHandValue - 10 <= 21) {
                blackJackHandValue = blackJackHandValue - 10;
            } else {
                blackJackHandValue = blackJackHandValue - 20;
            }
        } else if (numberOfAces == 3 && blackJackHandValue > 21) {
            if (blackJackHandValue - 20 <= 21) {
                blackJackHandValue = blackJackHandValue - 20;
            } else {
                blackJackHandValue = blackJackHandValue - 30;
            }
        }
        return blackJackHandValue;
    }

    public void displayHandsAndCurrentScore() {
        input.print(gamblingPlayerHand.toString() + "Your score is " + checkScore(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand)),
                computerHand.toString() + "Dealer score is " + checkScore(checkHandValue(computerHand), checkHandForAces(computerHand)));
    }



    public Integer promptHitOrStay() {
        Integer hitOrStayUserInput = input.getIntegerInput("Press 1 to hit or 2 to stay.");
        while (hitOrStayUserInput != 1 || hitOrStayUserInput != 0) {
            hitOrStayUserInput = input.getIntegerInput("Invalid key, press 1 to hit or 2 to stay.");
        }
        return hitOrStayUserInput;
    }

    public void hitOrStayAction(CardHand hand, Integer hitOrStayUserInput) {
        if (hitOrStayUserInput == 1) {
            hand.userHand.add(blackJackDeck.drawCard());
        } else {

        }

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
