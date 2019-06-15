package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.RoulettePlayer;

import java.util.*;

public class Roulette extends Games implements GamblerGameInterface {
    String betType; //   red/back - odd / even / number
    private RoulettePlayer roulettePlayer;
    private Double currentBet;

    String[] redArray = {"2","4","6","8","10","12","14","16","18","20","22","24","26","28","30","32","34","36"};
    String[] blackArray = {"1","3","5","7","9","11","13","15","17","19","21","23","25","27","29","31","33","35"};
    //List<String> list = new ArrayList<String>();
    List<String> redList = Arrays.asList(redArray);
    List<String> blackList = Arrays.asList(blackArray);

    public Roulette(RoulettePlayer roulettePlayer) {
        this.roulettePlayer = roulettePlayer;
    }

    @Override
    void nextTurn() {

    }

    @Override
    void endGame() {
        // end game and go back to main menu

    }

    @Override
    boolean getResults() {
        // determine win or loose
        return false;
    }

    @Override
    public void display(String output) {

        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        //calculate payment amount to be payed based on the position
        return bet + odds * bet;
    }

    public void updateAccount(Integer num) {
        //add or remove money from the balance
        this.roulettePlayer.setAccount((double)(num));
    }

    public Double getCurrentBet() {

        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double calcPayment(Double bet, Double odds) {
        //no of odds aganist = n(1 + odds)

        return bet + odds * bet;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

    public void play() {

        // Get Bet Amount
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bet Amount : ");
        int enterBet = sc.nextInt();
        sc.nextLine();

        // Set Current Bet on a bettable place like 0,1,2,3,... or Even/Odd or Red/Black or 1st/2nd/3rd 12, etc
        System.out.println("Bet position : ");
        String betPosition = sc.nextLine();

        // Calculate the odds based on the position.
        if(betPosition.equalsIgnoreCase("red") || betPosition.equalsIgnoreCase("Black") || betPosition.equalsIgnoreCase("even") || betPosition.equalsIgnoreCase("odd")) {
            odds = 1d;

        }
        else if(betPosition.equalsIgnoreCase("1st12") || betPosition.equalsIgnoreCase("2nd12") || betPosition.equalsIgnoreCase("3rd12")) {
            odds = 2d;
        }
        else {
            odds = 35d;
        }

        // Deduct the current bet from the account balance
        this.updateBalance(enterBet * (-1d));

        // Generate a random number where the ball is going to fall - Range should be 0 to 36
        int random = (int)(Math.random() * 36 + 1);
        System.out.println(" Winning Number " +random);
        //System.out.println("Even " +);

        // Identify if the position of bet is winning position
        if(isWinner(betPosition, random)) {
            System.out.println("You Won.....");
            double d = calcPayment((double)enterBet,odds );
            updateBalance(d);
        }
        else {
            System.out.println("You Lose.....");
        }
        System.out.println("Game Over \n");
        System.out.println("Your Balance is : " +this.roulettePlayer.getAccount());
        // Update the Account Balance


    }
    public void updateBalance(Double amount) {
        Double d = this.roulettePlayer.getAccount();
        Double add = d + amount;
        this.roulettePlayer.setAccount(add);

    }

    public boolean isWinner(String betPosition,int random  ) {
        if(betPosition.equalsIgnoreCase("even") && random % 2 == 0) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("odd") && random % 2 != 0) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("red") && redList.contains(random)) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("black") && blackList.contains(random)) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("1st12") && random <= 12 && random >=1) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("2nd12") && random <=24 && random >=13) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase("3rd12") && random <= 36 && random >=14) {
            return true;
        }
        else if(betPosition.equalsIgnoreCase(Integer.toString(random))) {
            return true;
        }
        return false;
    }

}
