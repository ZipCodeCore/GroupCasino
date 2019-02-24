package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Players.CardPlayer;
import io.zipcoder.casino.utilities.Console;


import java.util.ArrayList;
import java.util.List;


public class BlackJack extends Game {

       private List<Card> userHand = new ArrayList<Card>();
       private List<Card> dealerHand = new ArrayList<Card>();

       private CardPlayer dealer = new CardPlayer();

       private CardPlayer user = new CardPlayer();
       private Deck currentDeck = new Deck();

       private int userTotal;
       private int dealerTotal;
       private double userBet;
       private boolean isOver = false;

       Console blackJackConsole = new Console();

    public static void main(String[] args)
    {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

    public int play() {
        getUserBet();
        takeFirstTurn();

        while (!isOver) {
        evaluate(userHand);

        }
            return -1;
        }

    private void getUserBet() {
      userBet =  blackJackConsole.getDoubleInput("Place your bet if you DARE");

    }

    public void takeFirstTurn(){
            dealTwoCards(userHand);
            dealTwoCards(dealerHand);

            user.setHand(userHand);
            dealer.setHand(dealerHand);

            userTotal = getTotal(userHand);
            dealerTotal = getTotal(dealerHand);

            blackJackConsole.println("Your first hand has a " + userHand.get(0)+ " & " +userHand.get(1));
            displayUserTotal(userTotal);

            if(userTotal == 21){
                 blackJackConsole.println("You are the Winner");
                 isOver = true;
            } else {
                blackJackConsole.println("The dealer's hand is showing " + dealerHand.get(0));
               String doubleDownChoice = blackJackConsole.getStringInput(
                       "Would you like to Double Down? Please enter Yes or No");
               if(doubleDownChoice.toLowerCase().equals("yes")){
                   doubleDown(userHand);
               }
            }
        }

    private void evaluate(List<Card> hand ){

        String userChoice = getUserInput().toLowerCase();

        if (userChoice.equals("hit")){
            hit(userHand);
            checkGameOverByBust();
            checkIfHandIs21(userHand);

        } else if (userChoice.equals("stay")){


        }


    }

    private void doubleDown(List<Card> hand) {

        userBet = userBet*2;
        blackJackConsole.println("Bet is now " + Double.toString(userBet));

        hand.add(currentDeck.drawCard());
        userTotal = getTotal(hand);

        blackJackConsole.print("Your next card is " + userHand.get(2)+ ". ");

        displayUserTotal(userTotal);
        checkGameOverByBust();

        if(isOver != true){
            checkIfHandIs21(userHand);
        } else {
            takeDealersTurn();
        }


    }

    public void hit(List<Card> hand ) {
        hand.add(currentDeck.drawCard());
        userTotal = getTotal(userHand);
        blackJackConsole.println("Your next card is " + userHand.get(2) + ". Your total hand is " + userTotal);

    }

    public String getUserInput(){

          String userChoice = blackJackConsole.getStringInput("Would you like to Hit or Stay?");
          return userChoice;

}
        public void dealTwoCards(List<Card> hand) {
            hand.add(currentDeck.drawCard());
            hand.add(currentDeck.drawCard());

        }
        public void dealOneCard(List<Card> hand){
            hand.add(currentDeck.drawCard());
        }

        public int getTotal(List<Card> hand) {
            int sum = 0;

            for (Card card : hand) {
                // if(card.getRank().returnPrimaryRankValue() ==) {
                sum += card.getRank().returnPrimaryRankValue();
            }

            return sum;
        }


    public void displayUserTotal(int userTotal){
        blackJackConsole.println("Your total is " + userTotal);
    }

    public void displayDealerTotal(int dealerTotal){
       blackJackConsole.println( "Dealer total is " + dealerTotal);

    }

    public void checkGameOverByBust() {
        if (userTotal > 21) {
            blackJackConsole.println("You Bust. Dealer wins!");
            isOver = true;
        }
    }

     public void checkIfHandIs21(List<Card> hand) {
            if(userTotal == 21) {
                blackJackConsole.println("You are the Winner");
                isOver = true;
            }
        }

    public void takeDealersTurn(){
        blackJackConsole.print("Dealer card is " + dealerHand.get(1)+ ". ");
        displayDealerTotal(dealerTotal);
        while(dealerTotal < 17) {
            dealOneCard(dealerHand);
            dealerTotal = getTotal(dealerHand);
        }

        }
    }


