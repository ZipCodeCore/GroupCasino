package io.zipcoder.casino.Games;


import io.zipcoder.casino.CardsAndDice.Card;
import io.zipcoder.casino.CardsAndDice.Deck;
import io.zipcoder.casino.CardsAndDice.Rank;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Casino.Greeter;
import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.utilities.Console;


import java.util.ArrayList;
import java.util.List;


public class BlackJack implements Game {

    private BlackJackPlayer dealer = new BlackJackPlayer(new Profile());
    private BlackJackPlayer user = new BlackJackPlayer(Casino.getProfile());
    private Deck currentDeck = new Deck();
    private int userTotal;
    private int dealerTotal;
    private Integer userBet;
    private boolean isOver = false;
    private Console blackJackConsole;

    public BlackJack(){
        this(Console.getConsole());
    }

    public BlackJack(Console testConsole) {
        blackJackConsole = testConsole;
    }

    public BlackJackPlayer getUser(){
        return this.user;
    }
    public BlackJackPlayer getDealer(){
        return this.dealer;
    }

    public Integer getUserBetAsInteger(){
        return userBet;
    }
    public void setUserTotal(int total){
        this.userTotal = total;
    }
    public void setDealerTotal(int total) {this.dealerTotal = total;}
    public void setUserBet(Integer userBet) {
        this.userBet = userBet;
    }


    public void play() {
        blackJackConsole.println(Greeter.getBlackJackName());
        getUserBet();
        playFirstTurn();

        while (!isOver) {
            evaluateUserHitOrStay();
        }
    }

    public void getUserBet() {
        blackJackConsole.println("Your current balance is $" + user.getBalance());
        userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");

        while(userBet > user.getBalance()){
            tellUserDeyPoor();
            userBet = blackJackConsole.getIntegerInput("Place a bet if you DARE");
            }
        decreaseBalance();
    }

    public void tellUserDeyPoor(){
        blackJackConsole.println("Your broke ass has insufficient funds..");
    }


    private void playFirstTurn() {
        dealFirstHand();
        blackJackConsole.print(Card.printAllCards(user.getHand()));
        displayUserTotal(userTotal);
        isOver = (userTotal == 21);
        if(isOver){
        celebrateUser();
        } else {
            displayDealersFirstHand();
            checkIfUserWantsToDoubleDown();
        }
    }

    public void dealFirstHand(){
        user.setHand(currentDeck.drawMultipleCards(2));
        dealer.setHand(currentDeck.drawMultipleCards(2));
        userTotal = getTotal(user.getHand());
        dealerTotal = getTotal(dealer.getHand());
    }

    public void displayDealersFirstHand(){
        List<Card> printingCards = new ArrayList<>();
        blackJackConsole.println("Dealer's hand is showing: ");
        printingCards.add(dealer.getHand().get(0));
        printingCards.add(Deck.getCardBack());
        blackJackConsole.println(Card.printAllCards(printingCards));
    }

    public void checkIfUserWantsToDoubleDown(){
        String doubleDownChoice = blackJackConsole.getStringInput(
                "Would you like to Double Down? Please enter Yes or No");
        while(!doubleDownChoice.toLowerCase().equals("yes") && !doubleDownChoice.toLowerCase().equals("no") ){
            blackJackConsole.println("Please enter a valid option of Yes or No");
            doubleDownChoice = blackJackConsole.getStringInput(
                    "Would you like to Double Down? Please enter Yes or No");
            }
        if (doubleDownChoice.toLowerCase().equals("yes") && userBet <= user.getBalance()) {
            doubleDown();
        } else if (doubleDownChoice.toLowerCase().equals("yes") && userBet > user.getBalance()){
            tellUserDeyPoor();
        }
    }

    public void evaluateUserHitOrStay() {

        String userChoice = getUserInput().toLowerCase();
        if(!userChoice.equals("hit") && !userChoice.equals("stay") ){
            blackJackConsole.println("Please enter a valid option of Hit or Stay");
        }
        else if (userChoice.equals("hit")) {
            hit();
            checkGameOverByBust();
            isOver = (userTotal == 21);
        } else  {
            takeDealersTurn();
        }
    }

    private void doubleDown() {
        decreaseBalance();
        userBet = userBet * 2;

        blackJackConsole.println("Bet is now $" + userBet);

        user.getHand().add(currentDeck.drawCard());
        userTotal = getTotal(user.getHand());

        blackJackConsole.print("Your next card is \n" + Card.printAllCards(user.getHand().get(2)));

        displayUserTotal(userTotal);
        checkGameOverByBust();

        if (!isOver) {
            isOver = (userTotal == 21);
            takeDealersTurn();
            }
    }

    public void hit() {
        user.getHand().add(currentDeck.drawCard());
        userTotal = getTotal(user.getHand());
        blackJackConsole.println("Your next card is \n" + Card.printAllCards(user.getHand().get(user.getHand().size()-1)) +
                "Your total hand is " + userTotal);
    }

    public String getUserInput() {

        String userChoice = blackJackConsole.getStringInput("Would you like to Hit or Stay?");
        return userChoice;
    }

    public int getTotal(List<Card> hand) {
        int sum = 0;
        int acesCounter = 0;

        for (Card card : hand) {
            if(card.getRank() == Rank.ACE){
                acesCounter++;
            }
            sum += card.getRank().returnPrimaryRankValue();
            while(sum > 21 && acesCounter>0){
                sum -= 10;
                acesCounter--;
            }
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
        blackJackConsole.println("Your balance is: $" + user.getBalance());
    }

    public void displayDealerHand() {
        blackJackConsole.println("Dealer's hand is now: \n" + Card.printAllCards(dealer.getHand()));
    }

    public boolean checkGameOverByBust() {
        if (userTotal > 21) {
            blackJackConsole.println("You Bust. Dealer wins!");
            displayUserBalance();
            isOver = true;
        }
        return isOver;
    }


    public void celebrateUser(){
        blackJackConsole.println("You are the Winner!!!!");
        addWinningsBalance();
        displayUserBalance();

    }

    private void takeDealersTurn() {
        blackJackConsole.println("Dealer card is: \n" + Card.printAllCards(dealer.getHand().get(1)));
        displayDealerHand();
        displayDealerTotal(dealerTotal);
        while (dealerTotal < 17) {
            dealer.getHand().add(currentDeck.drawCard());
            blackJackConsole.println("The dealer drew \n" + Card.printAllCards(dealer.getHand().get(dealer.getHand().size() - 1)));
            dealerTotal = getTotal(dealer.getHand());
            displayDealerHand();
            displayDealerTotal(dealerTotal);
        }
        checkWinner();
    }

    public void checkWinner() {
        if (dealerTotal > 21) {
            blackJackConsole.print("Dealer Busts.");
            celebrateUser();
            isOver = true;

        } else if (dealerTotal == userTotal) {
            blackJackConsole.println("It's a Push. Ehh");
            user.setBalance(user.getBalance() + userBet);
            displayUserBalance();
            isOver = true;
        } else {
            String result = (dealerTotal > userTotal) ? "Dealer is the winner!" : "You are the winner" ;
            if (result.equals("You are the winner")){
                addWinningsBalance();
            }
            blackJackConsole.println(result);
            displayUserBalance();
            isOver = true;
            }
        }

    private void addWinningsBalance() {
         user.setBalance(user.getBalance() + (userBet * 2));
    }

    private void decreaseBalance() {
        user.setBalance(user.getBalance() - userBet);
       displayUserBalance();
    }
 }




