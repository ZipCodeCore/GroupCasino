package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class KenoGame extends RandomNumberGenerator implements GameInterface {

    IOConsole console = new IOConsole(AnsiColor.CYAN);
    Set<PlayerInterface> players = new HashSet<>();
    Set<Integer> chosenNumbers = new HashSet<>();
    Set<Integer> randomNumbers = generateRandomNumbers();
    Integer prizeMoney;

    public KenoGame() {
        super(1,80, 20);
    }

    @Override
    public void add(PlayerInterface player) {
        players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

    @Override
    public void run() {

    }

    public PlayerInterface getPlayer(String playerUsername) {
        for (PlayerInterface player : players) {
            if (player.getArcadeAccount().getUsername().equals(playerUsername)) {
                return player;
            }
        }
        return null;
    }

    public Set<PlayerInterface> getPlayers() {
        return players;
    }

    public Set<Integer> getChosenNumbers() {
        console.println("Input up to 10 numbers 1 by 1");
        while (chosenNumbers.size() <= 10) {
            Integer numberInput = console.getIntegerInput("Input a number");
            chosenNumbers.add(numberInput);
        }
        return chosenNumbers;
    }

    public Integer checkHowManyMatch() {
        Integer numberOfMatches = 0;
        for (Integer chosenNumber : chosenNumbers) {
            if (randomNumbers.contains(chosenNumber)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    public void outcomeOfGame(Integer amountBet) {
        Integer numberOfMatches = checkHowManyMatch();
        switch (numberOfMatches) {
            case 1:
                console.println("You got 1 match! You win $%s", amountBet * 2);
                prizeMoney = amountBet * 2;
                break;

            case 2:
                console.println("You got 2 matches! You win $%s", amountBet * 5);
                prizeMoney = amountBet * 5;
                break;

            case 3:
                console.println("You got 3 matches! You win $%s", amountBet * 10);
                prizeMoney = amountBet * 10;
                break;

            case 4:
                console.println("You got 4 matches! You win $%s", amountBet * 20);
                prizeMoney = amountBet * 20;
                break;

            case 5:
                console.println("You got 5 matches! You win $%s", amountBet * 40);
                prizeMoney = amountBet * 40;
                break;

            case 6:
                console.println("You got 6 matches! You win $%s", amountBet * 80);
                prizeMoney = amountBet * 80;
                break;

            case 7:
                console.println("You got 7 matches! You win $%s", amountBet * 200);
                prizeMoney = amountBet * 200;
                break;

            case 8:
                console.println("You got 8 matches! You win $%s", amountBet * 500);
                prizeMoney = amountBet * 500;
                break;

            case 9:
                console.println("You got 9 matches! You win $%s", amountBet * 4000);
                prizeMoney = amountBet * 4000;
                break;

            case 10:
                console.println("You got 10 matches! You win $%s", amountBet * 10000);
                prizeMoney = amountBet * 10000;
                break;
        }
    }

    public Integer getBet() {
        Integer amountToBet = console.getIntegerInput("How much do you want to bet?");
        return amountToBet;
    }
}
