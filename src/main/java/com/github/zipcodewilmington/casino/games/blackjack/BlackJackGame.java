package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;


public class BlackJackGame implements GameInterface, PlayerInterface {
    private Boolean isRunning = false;
    private PlayerInterface player;
    Integer userBet;
    IOConsole input = new IOConsole();
    Integer totalWinnings = 0;


    public void add(PlayerInterface player) {
        this.player = player;
    }


    public void remove(PlayerInterface player) {

    }

    public void run() {
        while(!isRunning) {
            // include betting range
            BlackJack bj = new BlackJack();
            Integer userInput = input.getIntegerInput("1. Start A Hand" + "\n" + "2. Quit" + "\n");

            switch (userInput) {
                case 1:

                    this.userBet = (input.getIntegerInput("How much would you like to bet?"));
                    // include betting forum in case 1
                    startGame();
                    break;
                case 2:
                    // include the subtractWinnings when players leave table
                    isRunning = true;
            }
        }
    }

    public void startGame () {
        boolean isWinner = false;
        BlackJack bj = new BlackJack();
        bj.givePlayerCard();
        System.out.println("Your starting card : " + bj.playersCurrentValue());
        System.out.println("Your second next card : " + bj.givePlayerCard());
        System.out.println("Hand value : " + bj.playersCurrentValue());

        while (!isWinner) {
            Integer userChoice = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
                switch (userChoice) {
                    case 1:
                        bj.givePlayerCard();
                        System.out.println(bj.playersCurrentValue());
                        if(bj.playersCurrentValue() > 21) {
                            System.out.println("Sorry bud, you got " + bj.playersCurrentValue() +
                                    ", better luck next time");
                            subtractBetFromBalance(userBet);
                            isWinner = true;
                        } else if (bj.playerHitsBlackJack()) {
                            System.out.println("BLACK JACK!!");
                            calculateWinnings(3, userBet);
                            isWinner = true;
                        }
                        break;
                    case 2:
                        bj.giveDealerCard();
                        System.out.println("The dealers first card : " + bj.dealersCurrentValue());
                        bj.giveDealerCard();
                        bj.dealersGame();
                        isWinner = true;
                        break;
                }
            }
        }


    public CasinoAccount getArcadeAccount() {
        return null;
    }


    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        totalWinnings = multiplier * betAmount;
        return totalWinnings;
    }


    public void subtractBetFromBalance(Integer betAmount) {

    }


    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }
}
