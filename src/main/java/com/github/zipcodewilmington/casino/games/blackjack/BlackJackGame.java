package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


public class BlackJackGame implements GameInterface {
    private Boolean isRunning = false;
    private PlayerInterface playerInt;
    private Boolean isDemo = false;
    Integer userBet;
    Integer splitBet;
    IOConsole input = new IOConsole();
    IOConsole blue = new IOConsole(AnsiColor.BLUE);
    IOConsole red = new IOConsole(AnsiColor.RED);
    IOConsole cyan = new IOConsole(AnsiColor.CYAN);
    IOConsole green = new IOConsole(AnsiColor.GREEN);
    IOConsole purple = new IOConsole(AnsiColor.PURPLE);
    Integer winnings = 0;
    Integer splitWinnings = 0;
    BlackJack bj;


    /*
        reorder the 'helper' methods for more clarity
    * need formatting on splitHand
    * need refinement on formatting the beginning
    * make it flashy
    */

    public BlackJackGame () {
    }

    public void run() {
        printWelcome();
        while(!isRunning) {
            // include betting range
            playerInt.getArcadeAccount().alterAccountBalance(splitWinnings);
            playerInt.getArcadeAccount().alterAccountBalance(winnings);
            cyan.println("Your current balance is... " +  playerInt.getArcadeAccount().getAccountBalance() + "\n");
            Integer userInput = input.getIntegerInput("\u001B[32m1. Start A Hand" + "\n" + "\u001B[31m2. Quit" + "\n");
            switch (userInput) {
                case 1:
                    BlackJack freshHand = new BlackJack();
                    bj = freshHand;
                    userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?" + "\n"));
                    userBetCondition();
                    playerInt.getArcadeAccount().alterAccountBalance(userBet * (-1));
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    public void printWelcome () {
        blue.println("============================================================" + "\n" +
                "=====                                                  =====" + "\n" +
                "=====                     WELCOME                      =====" + "\n" +
                "=====                       TO                         =====" + "\n" +
                "=====                    B L A C K                     =====" + "\n" +
                "=====                     J A C K                      =====" + "\n" +
                "=====                                                  =====" + "\n" +
                "============================================================");
    }

    public void startGame () {
            bj.givePlayerCard();
            cyan.println("\n" + "Your starting card : " + bj.playersCurrentValue() + "\n");
            cyan.println("Your second next card : " + bj.givePlayerCard() + "\n");
            cyan.println("Hand value : " + bj.playersCurrentValue() + "\n");
            if (twoCardBlackJack()) {
                green.println("BLACK JACK!!!" + "\n");
                calculateWinnings(3, userBet);
            } else if(isDemo){
                return;
            } else if (bj.playersHand.get(0).equals(bj.playersHand.get(1))) {  // include conditional on starting blackjack!
                splitPlayer();

            } else {
                standardGame();
        }
    }

    public boolean twoCardBlackJack () {
        if ((bj.playersHand.get(0) + bj.playersHand.get(1)) == 21) {
            calculateWinnings(3, userBet);
            return true;
        }
        return false;
    }

    public void standardGame () {
        boolean isWinner = false;
        while (!isWinner) {
            cyan.println("With the value of  " + bj.playersCurrentValue() + "..." + "\n");
            Integer userChoice = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
            switch (userChoice) {
                case 1:
                    bj.givePlayerCard();
                    if (checkStandardWinner()) {
                        isWinner = true;
                    }
                    break;
                case 2:
                    bj.giveDealerCard();
                    red.println("The dealers first card : " + bj.dealersCurrentValue());
                    bj.giveDealerCard();
                    dealersGame();
                    isWinner = true;
                    break;
            }
        }
    }

    public void splitPlayer () {
        Integer choice = input.getIntegerInput("1. Split" + "\n" + "2. No, I'll play this hand");
        if (choice.equals(2)) {
            standardGame();
        } else {    // include another betting portion for this hand
            splitHandRound();
        }
    }


    public CasinoAccount getArcadeAccount() {
        return null;
    }


    public Integer calculateWinnings(Integer multiplier, Integer userBet) {
            winnings = multiplier * userBet;
            return winnings;
    }

    public Integer calculateWinningsSplitHand(Integer multiplier, Integer splitBet) {
        splitWinnings = multiplier * splitBet;
        return splitWinnings;
    }


    private void splitPlayerHitsBlackJack(Integer splitBet) {
        green.println("BLACK JACK!!");
        calculateWinningsSplitHand(3, splitBet);
        standardGame();
    }

    private void splitPlayerBust(Integer splitBet) {
        red.println("Sorry bud, you got " + bj.splitPlayersCurrentValue() +
                ", you still have one more hand!");
        calculateWinningsSplitHand(0, splitBet);
        standardGame();
    }

    private boolean checkStandardWinner() {
        boolean playerWon;
        cyan.println("Current hand value " + bj.playersCurrentValue() + "\n");
        if(bj.playersCurrentValue() > 21) {
            playerBustButHasAces();
            if (bj.playersCurrentValue() > 21) {
                red.println("Sorry bud, you got " + bj.playersCurrentValue() +
                        ", better luck next time" + "\n");
                calculateWinnings(0, userBet);
                playerWon = true;
            } else {
                playerWon = false;
            }
        } else if (playerHitsBlackJack()) {
            green.println("BLACK JACK!!" + "\n");
            calculateWinnings(3, userBet);
            playerWon = true;
        } else {
            playerWon = false;
        }
        return playerWon;
    }


    private Integer secondHandBet() {
        Integer splitValue = bj.playersHand.get(1);
        bj.playersHandOnSplit.add(splitValue);
        bj.playersHand.set(1, 0);
        Integer splitBet = input.getIntegerInput("\u001B[32mPlease place your bet for the second hand" + "\n");
        if (splitBet > playerInt.getArcadeAccount().getAccountBalance()) {
            splitHandBetConditions();
        }
            playerInt.getArcadeAccount().alterAccountBalance(splitBet * (-1));
            cyan.println("Your hand has been split! Current value " + bj.splitPlayersCurrentValue() + "\n" + "\n");
        return splitBet;
    }

    private void splitHandRound() {
        boolean isWinnerSecondHand = false;
        Integer splitBet = secondHandBet();
        while (!isWinnerSecondHand) {
            Integer userInput = input.getIntegerInput("1. Hit" + "\n" + "2. Stay" + "\n");
            switch (userInput) {
                case 1:
                    bj.givePlayerCardOnSplit();
                    cyan.println("Current hand value " + bj.splitPlayersCurrentValue());
                    if (bj.splitPlayersCurrentValue() > 21) {
                        splitHandBustHasAces();
                        if (bj.splitPlayersCurrentValue() > 21) {
                            splitPlayerBust(splitBet);
                            isWinnerSecondHand = true;
                        } else {
                            isWinnerSecondHand = false;
                        }
                    } else if (splitPlayerHitsBlackJack()) {
                        splitPlayerHitsBlackJack(splitBet);
                        isWinnerSecondHand = true;
                    }
                    break;
                case 2:
                    standardGame();
            }
        }
    }
    public void dealersGame() {
        boolean gameEnd = false;
        while (!gameEnd) {
            red.println("The dealer has : " + bj.dealersCurrentValue());
            if (bj.dealersCurrentValue() > 21) {
                green.println("You win!" + "\n");
                calculateWinnings(2, userBet);
                gameEnd = true;
            } else if (bj.dealersCurrentValue() == 21) {
                red.println("The dealer has won!" + "\n");
                calculateWinnings(0, userBet);
                gameEnd = true;
            } else if (bj.dealersCurrentValue() > bj.playersCurrentValue()) {
                red.println("The dealer has won!" + "\n");
                calculateWinnings(0, userBet);
                gameEnd = true;
            } else {
                bj.giveDealerCard();
            }
        }
    }

    public void playerBustButHasAces () {
        for (int i = 0; i < bj.playersHand.size(); i++) {
            if (bj.playersHand.get(i).equals(11)) {
                bj.playersHand.set(i, 1);
                purple.println("***You had an Ace - we reduced that 11 to a 1! Keep going!***" + "\n" );
                break;
            }
        }
    }

    public void dealerBustButHasAces () {
        for (int i = 0; i < bj.dealersHand.size(); i++) {
            if (bj.dealersHand.get(i).equals(11)) {
                bj.dealersHand.set(i, 1);
                break;
            }
        }
    }

    public void splitHandBustHasAces () {
        for (int i = 0; i < bj.playersHandOnSplit.size(); i++) {
            if (bj.playersHandOnSplit.get(i).equals(11)) {
                bj.playersHandOnSplit.set(i, 1);
                purple.println("***You had an Ace - we reduced that 11 to a 1! Keep going!***" + "\n" );
                break;
            }
        }
    }

    public boolean splitPlayerHitsBlackJack () {
        if (bj.splitPlayersCurrentValue() == 21) {
            calculateWinningsSplitHand(3, splitBet);
            return true;
        } else {
            return false;
        }
    }

    public boolean playerHitsBlackJack() {
        if (bj.playersCurrentValue() == 21) {
            calculateWinnings(3, userBet);
            return true;
        } else {
            return false;
        }
    }

    public void userBetCondition () {
        while (userBet > playerInt.getArcadeAccount().getAccountBalance()) {
            red.println("Oh no! You're trying to place a bet with more money than you have...");
            userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?" + "\n"));
        }
    }

    public void splitHandBetConditions () {
        while (splitBet > playerInt.getArcadeAccount().getAccountBalance()) {
            red.println("You don't have enough money for that, Silly!" + "\n");
            splitBet = (input.getIntegerInput("\u001B[32mPlease place your bet for the second hand" + "\n"));
        }
    }

    public void subtractBetFromBalance(Integer betAmount) {
        this.getPlayer().getArcadeAccount().alterAccountBalance(betAmount * -1);
    }


    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }

    public void add(PlayerInterface player) {
        this.playerInt = player;
    }


    public void remove(PlayerInterface player) {
        this.playerInt = null;
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public void setRunning(Boolean running) {
        isRunning = running;
    }

    public Integer getUserBet() {
        return userBet;
    }

    public void setUserBet(Integer userBet) {
        this.userBet = userBet;
    }

    public PlayerInterface getPlayer() {
        return playerInt;
    }

    public Boolean getDemo() {
        return isDemo;
    }

    public void setDemo(Boolean demo) {
        isDemo = demo;
    }

    public BlackJack getGame() {
        return bj;
    }

    public void setGame(){
        bj = new BlackJack();
    }

    public Integer getSplitBet() {
        return splitBet;
    }

    public void setSplitBet(Integer splitBet) {
        this.splitBet = splitBet;
    }
}
