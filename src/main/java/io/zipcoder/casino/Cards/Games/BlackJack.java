package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.CardPlayer;
import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.utilities.Console;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class BlackJack extends Game {

    private List<Card> userHand = new ArrayList<Card>();
    private List<Card> dealerHand = new ArrayList<Card>();

    private CardPlayer dealer = new CardPlayer(new Profile());
    //private CardPlayer user = new CardPlayer(Casino.getProfile()); //this will need to be uncommented for live version and line below will need to be removed
    private CardPlayer user = new CardPlayer(new Profile("testName",true));
    private Deck currentDeck = new Deck();

    private int userTotal;
    private int dealerTotal;
    private Integer userBet;
    private boolean isOver = false;

    Console blackJackConsole = Console.getConsole();


    public static void main(String[] args)
    {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

    public int play() {
        getUserBet();
        takeFirstTurn();

        while (isOver != true) {
            evaluate(userHand);
        }
        return -1;
    }

    private void getUserBet() {
        blackJackConsole.println("Your current balance is " + user.getBalance());
        userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");

        while(userBet > user.getBalance()){
            blackJackConsole.println("Your broke ass has insufficient funds..");
            userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");
            }
        user.setBalance(user.getBalance()-userBet);

    }

    public void takeFirstTurn() {
        dealTwoCards(userHand);
        dealTwoCards(dealerHand);

        user.setHand(userHand);
        dealer.setHand(dealerHand);

        userTotal = getTotal(userHand);
        dealerTotal = getTotal(dealerHand);

        blackJackConsole.println("Your first hand has a " + userHand.get(0) + " & " + userHand.get(1));
        displayUserTotal(userTotal);

        if (userTotal == 21) {
            blackJackConsole.println("You are the Winner");
            isOver = true;
        } else {
            blackJackConsole.println("The dealer's hand is showing " + dealerHand.get(0));
            String doubleDownChoice = blackJackConsole.getStringInput(
                    "Would you like to Double Down? Please enter Yes or No");
            while(!doubleDownChoice.equals("yes") && !doubleDownChoice.equals("no") ){
                blackJackConsole.println("Please enter a valid option of Yes or No");
                 doubleDownChoice = blackJackConsole.getStringInput(
                        "Would you like to Double Down? Please enter Yes or No");
                 }
            if (doubleDownChoice.toLowerCase().equals("yes")) {
                doubleDown(userHand);
            }
        }
    }

    private void evaluate(List<Card> hand) {

        String userChoice = getUserInput().toLowerCase();

        if(!userChoice.equals("hit") && !userChoice.equals("stay") ){
            blackJackConsole.println("Please enter a valid option of Hit or Stay");
        }
        else if (userChoice.equals("hit")) {
            hit(userHand);
            checkGameOverByBust();
            checkIfHandIs21(userHand);

        } else if (userChoice.equals("stay")) {
            takeDealersTurn();
        }

    }

    private void doubleDown(List<Card> hand) {

        userBet = userBet * 2;
        blackJackConsole.println("Bet is now " + Integer.toString(userBet));

        dealOneCard(hand);
        userTotal = getTotal(hand);

        blackJackConsole.print("Your next card is " + userHand.get(2) + ". ");

        displayUserTotal(userTotal);
        checkGameOverByBust();

        if (isOver == false) {
            checkIfHandIs21(userHand);
            takeDealersTurn();
            }

    }

    public void hit(List<Card> hand) {
        dealOneCard(hand);
        userTotal = getTotal(userHand);
        blackJackConsole.println("Your next card is " + userHand.get(user.getHand().size()-1) + ". Your total hand is " + userTotal);

    }

    public String getUserInput() {

        String userChoice = blackJackConsole.getStringInput("Would you like to Hit or Stay?");
        return userChoice;
    }

    public void dealTwoCards(List<Card> hand) {
        hand.add(currentDeck.drawCard());
        hand.add(currentDeck.drawCard());
    }

    public void dealOneCard(List<Card> hand) {
        hand.add(currentDeck.drawCard());
    }

    public int getTotal(List<Card> hand) {
        int sum = 0;

        for (Card card : hand) {
            sum += card.getRank().returnPrimaryRankValue();
        }
        return sum;
    }


    public void displayUserTotal(int userTotal) {
        blackJackConsole.println("Your total is " + userTotal);
    }

    public void displayDealerTotal(int dealerTotal) {
        blackJackConsole.println("Dealer total is " + dealerTotal);
    }

    public void checkGameOverByBust() {
        if (userTotal > 21) {
            blackJackConsole.println("You Bust. Dealer wins!");
            isOver = true;
        }
    }

    public void checkIfHandIs21(List<Card> hand) {
        if (userTotal == 21) {
            blackJackConsole.println("You are the Winner");
            isOver = true;
        }
    }

    public void takeDealersTurn() {
        blackJackConsole.print("Dealer card is " + dealerHand.get(1) + ". ");
        displayDealerTotal(dealerTotal);
        while (dealerTotal < 17) {
            dealOneCard(dealerHand);
            blackJackConsole.println("The dealer's hand is showing " + dealerHand.get(dealerHand.size() - 1));
            dealerTotal = getTotal(dealerHand);
            displayDealerTotal(dealerTotal);
        }
        checkWinner();
    }

    public void checkWinner() {

        if (dealerTotal > 21) {
            blackJackConsole.println("Dealer Busts. You Win!!");
            isOver = true;
        }else if (dealerTotal == userTotal) {
            blackJackConsole.println("It's a Push. Ehh");
            isOver = true;
        }
        else {
            String result = (dealerTotal > userTotal) ? "Dealer is the winner!" : "You are the winner";
            blackJackConsole.println(result);
            isOver = true;
            }

        }
    }




