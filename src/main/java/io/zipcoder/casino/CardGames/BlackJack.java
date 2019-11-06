package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Player.GamblingPlayer;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.utilities.Console;




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
    public void startGame() {
        playBlackJack();
    }

    public void playBlackJack() {
        initializeBlackJackHands();
        checkHandValue(gamblingPlayerHand);
        checkHandForAces(gamblingPlayerHand);
        refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand));
        checkHandValue(computerHand);
        checkHandForAces(computerHand);
        refactorAndCalculateHandValue(checkHandValue(computerHand), checkHandForAces(computerHand));
        displayHandsAndCurrentScore()



        do {
            displayHandsAndCurrentScore();
            promptHitOrStay();
            hitOrStayAction(gamblingPlayerHand, promptHitOrStay());
            refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand));

        }
        while (refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand)) < 21 || promptHitOrStay() == 0);


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


    //takes arrayList of cards from hand and separates them by card and totals point based on default Ace value of 11.
    public Integer checkHandValue(CardHand hand) {
        Integer handValueForDefaultAce11 = 0;
        for (int i = 0; i < hand.userHand.size(); i++) {
            handValueForDefaultAce11 += card.blackJackCardRank.get(i);
        }
        return handValueForDefaultAce11;
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

        //evaluates score of blackjack hand and determines whether or not the value of each Ace should remain at 11 points or be reassigned to 1 point. Returns new hand value.
    public Integer refactorAndCalculateHandValue(Integer handValueForDefaultAce11, Integer numberOfAces) {
        Integer refactoredHandValue = handValueForDefaultAce11;     //default set to no changes.
        if (numberOfAces == 1 && handValueForDefaultAce11 > 21) {
            refactoredHandValue = handValueForDefaultAce11 - 10;        //one Ace value changed to 1 point.
        } else if (numberOfAces == 2 && handValueForDefaultAce11 > 21) {
            if (handValueForDefaultAce11 - 10 <= 21) {
                refactoredHandValue = handValueForDefaultAce11 - 10;    //one Ace value changed to 1 point.
            } else {
                refactoredHandValue = handValueForDefaultAce11 - 20;    //two Ace values changed to 1 point.
            }
        } else if (numberOfAces == 3 && handValueForDefaultAce11 > 21) {
            if (handValueForDefaultAce11 - 20 <= 21) {
                refactoredHandValue = handValueForDefaultAce11 - 20;
            } else {
                refactoredHandValue = handValueForDefaultAce11 - 30;        //three Ace values change to 1 point.
            }
        }
        return refactoredHandValue;
    }

    public void checkForBlackJackAndDisplayScore() {
        if(refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand)) == 21
                && (refactorAndCalculateHandValue(checkHandValue(computerHand), checkHandForAces(computerHand))) == 21)  {
            input.print(" You and Dealer both got BlackJack!\n" +
                    "Your hand: " + gamblingPlayerHand.toString() + "\n" +
                    "Dealer hand: " + computerHand.toString() + "\n");
        }   else if(refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand)) == 21
                && (refactorAndCalculateHandValue(checkHandValue(computerHand), checkHandForAces(computerHand))) != 21) {
            input.print(" You got BlackJack!\n" +
                    "Your hand: " + gamblingPlayerHand.toString() + "\n" +
                    "Dealer hand: " + computerHand.toString() + "\n");
        }

    }

    public void displayHandsAndCurrentScore() {
        input.print(gamblingPlayerHand.toString() + "Your score is " + refactorAndCalculateHandValue(checkHandValue(gamblingPlayerHand), checkHandForAces(gamblingPlayerHand))),
                computerHand.toString() + "Dealer score is " + refactorAndCalculateHandValue(checkHandValue(computerHand), checkHandForAces(computerHand)));
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
