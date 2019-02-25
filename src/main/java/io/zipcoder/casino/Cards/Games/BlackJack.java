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

    Console blackJackConsole;

    public BlackJack(){
        this(Console.getConsole());
    }

    public BlackJack(Console testConsole) {
        blackJackConsole = testConsole;
    }

    public Integer getUserBetAsInteger(){
        return userBet;
    }

    public static void main(String[] args)
    {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

    public int play() {
        getUserBet();
        takeFirstTurn();

        while (isOver != true) {
            evaluate();
        }
        return -1;
    }

    public void getUserBet() {
        blackJackConsole.println("Your current balance is " + user.getBalance());
        userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");

        while(userBet > user.getBalance()){
            blackJackConsole.println("Your broke ass has insufficient funds..");
            userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");
            }
        decreaseBalance();

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
            addWinningsBalance();
            displayUserBalance();
            isOver = true;
        } else {
            blackJackConsole.println("The dealer's hand is showing " + dealerHand.get(0));
            String doubleDownChoice = blackJackConsole.getStringInput(
                    "Would you like to Double Down? Please enter Yes or No");
            while(!doubleDownChoice.toLowerCase().equals("yes") && !doubleDownChoice.toLowerCase().equals("no") ){
                blackJackConsole.println("Please enter a valid option of Yes or No");
                 doubleDownChoice = blackJackConsole.getStringInput(
                        "Would you like to Double Down? Please enter Yes or No");
                 }
            if (doubleDownChoice.toLowerCase().equals("yes") && userBet <= user.getBalance()) {
                doubleDown(userHand);
            } else if (doubleDownChoice.toLowerCase().equals("yes") && userBet > user.getBalance()){
                blackJackConsole.println("Your broke ass has insufficient funds.");
            }
        }
    }

    private void evaluate() {

        String userChoice = getUserInput().toLowerCase();

        if(!userChoice.equals("hit") && !userChoice.equals("stay") ){
            blackJackConsole.println("Please enter a valid option of Hit or Stay");
        }
        else if (userChoice.equals("hit")) {
            hit(userHand);
            checkGameOverByBust();
            checkIfHandIs21();

        } else if (userChoice.equals("stay")) {
            takeDealersTurn();
        }

    }

    private void doubleDown(List<Card> hand) {
        decreaseBalance();
        userBet = userBet * 2;

        blackJackConsole.println("Bet is now " + userBet);

        dealOneCard(hand);
        userTotal = getTotal(hand);

        blackJackConsole.print("Your next card is " + userHand.get(2) + ". ");

        displayUserTotal(userTotal);
        checkGameOverByBust();

        if (isOver == false) {
            checkIfHandIs21();
            takeDealersTurn();
            }

    }

    public void hit(List<Card> hand) {
        dealOneCard(hand);
        userTotal = getTotal(userHand);
        blackJackConsole.println("Your next card is " + userHand.get(user.getHand().size()-1) +
                ". Your total hand is " + userTotal);

    }

    public String getUserInput() {

        String userChoice = blackJackConsole.getStringInput("Would you like to Hit or Stay?");
        return userChoice;
    }

    public void dealTwoCards(List<Card> hand) {
        dealOneCard(hand);
        dealOneCard(hand);
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

    public void displayUserBalance(){
        blackJackConsole.println("Your balance is: " + user.getBalance());
    }

    public void displayDealerHand() {
        blackJackConsole.println("Dealer's hand is now: ");
        blackJackConsole.println(dealerHand.toString());
    }

    public void checkGameOverByBust() {
        if (userTotal > 21) {
            blackJackConsole.println("You Bust. Dealer wins!");
            displayUserBalance();
            isOver = true;
        }
    }

    public void checkIfHandIs21() {
        if (userTotal == 21) {
            blackJackConsole.println("You are the Winner");
            addWinningsBalance();
            displayUserBalance();
            isOver = true;
        }
    }

    public void takeDealersTurn() {
        blackJackConsole.println("Dealer card is " + dealerHand.get(1) + ". ");
        //blackJackConsole.println("Dealer's hand is now ");
        displayDealerHand();
        displayDealerTotal(dealerTotal);
        while (dealerTotal < 17) {
            dealOneCard(dealerHand);
            blackJackConsole.println("The dealer drew " + dealerHand.get(dealerHand.size() - 1));
            dealerTotal = getTotal(dealerHand);
            displayDealerHand();
            displayDealerTotal(dealerTotal);

        }
        checkWinner();
    }

    public void checkWinner() {

        if (dealerTotal > 21) {
            blackJackConsole.println("Dealer Busts. You Win!!");
            addWinningsBalance();
            displayUserBalance();
            isOver = true;

        }else if (dealerTotal == userTotal) {
            blackJackConsole.println("It's a Push. Ehh");
            user.setBalance(user.getBalance() + userBet);
            displayUserBalance();
            isOver = true;
        }
        else {
            String result = (dealerTotal > userTotal) ? "Dealer is the winner!" : "You are the winner" ;
            if (result.equals("You are the winner")){
                addWinningsBalance();
            }
            blackJackConsole.println(result);
            displayUserBalance();
            isOver = true;
            }

        }

    public void addWinningsBalance() {

         user.setBalance(user.getBalance() + (userBet * 2));

    }

    public void decreaseBalance() {
        user.setBalance(user.getBalance() - userBet);
       displayUserBalance();
    }




    }




