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


        Console blackJackConsole = Console.getConsole();

    public static void main(String[] args)
    {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

    public int play() {
        getUserBet();
        takeFirstTurn();

        while (!isOver) {
        //evaluate();

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

            blackJackConsole.println("Your first card is " + userHand.get(0));
            blackJackConsole.println("Your second card is " + userHand.get(1));
            blackJackConsole.println("You've been dealt " + userTotal);

            if(userTotal == 21){
                 blackJackConsole.println("You are the Winner");
                 isOver = true;
            } else {
                blackJackConsole.println("The dealer's hand is showing " + dealerHand.get(0));
                getUserInput();
            }
        }
/*
    private void evaluate(List<Card> hand ){
        String userChoice =  getUserInput().toLowerCase();
        if (userChoice.equals("hit")){
            hit(userHand);

        } else if (userChoice.equals("double down")){
            doubleDown(userHand);

        }


    }*/

    private void doubleDown(List<Card> hand) {
        userBet = userBet*2;
        hand.add(currentDeck.drawCard());
       blackJackConsole.println(Double.toString(userBet));
       blackJackConsole.println("Your next card is " + userHand.get(2));
       blackJackConsole.println("Dealer card is " + dealerHand.get(1) + ". Dealer total is " + dealerTotal);

    }

    public void hit(List<Card> hand ) {
        hand.add(currentDeck.drawCard());
        userTotal = getTotal(userHand);
        blackJackConsole.println("Your next card is " + userHand.get(2) + ". Your total hand is " + userTotal);
    }

    public String getUserInput(){

          String userChoice = blackJackConsole.getStringInput("Would you like to Hit, Stand, or Double Down?");
          return userChoice;

}
    public void dealTwoCards(List<Card> hand) {
            hand.add(currentDeck.drawCard());
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




    }


