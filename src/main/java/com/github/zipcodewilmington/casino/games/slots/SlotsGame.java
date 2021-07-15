package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface{
    private final IOConsole consoleR = new IOConsole(AnsiColor.RED);
    private final IOConsole consoleG = new IOConsole(AnsiColor.GREEN);
    private final IOConsole consoleY = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole consoleB = new IOConsole(AnsiColor.BLUE);
    private final IOConsole consoleP = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole consoleC = new IOConsole(AnsiColor.CYAN);
    private Integer playerBetAmount;
    private Integer betTotal;
    private Integer loseMultiplier;
    private Integer winMultiplier;
    private PlayerInterface currentPlayer;
    private Slots slotMachine;

    public SlotsGame(){
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.currentPlayer = null;
    }

    public Integer getLoseMultiplier() {
        return loseMultiplier;
    }

    public Integer getWinMultiplier() {
        return winMultiplier;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printWelcome();
        Slots newSlotMachine = new Slots();
        slotMachine = newSlotMachine;
        slotMachine.spinSlots();
        //Display first slots
        slotMachine.displaySlots();

        Boolean quitGame = false;
        while(!quitGame) {

            //print initial account balance
            consoleG.println("Current account balance:    $" + currentPlayer.getArcadeAccount().getAccountBalance() + "\n");

            getBetAmount();
            Integer[] selectedBets = getBetSelections();

            //take money from player account
            subtractBetFromBalance(betTotal);

            slotMachine.spinSlots();
            slotMachine.displaySlots();
            slotMachine.setWinningLines();
            String[] betResults = slotMachine.compareBetVsWinningLines(selectedBets);
            this.calculateMultiplier(betResults);
            Integer winnings = calculateWinnings(this.winMultiplier, playerBetAmount);
            consoleR.println("You won: " + winnings + " dollars!\n");
            //add winnings to player object
            addMoneyToBalance(currentPlayer, winnings);
            //show current balance
            consoleG.println("Current Account Balance:    $" + currentPlayer.getArcadeAccount().getAccountBalance());
            //Continue game?
            consoleC.println("\nWould you like to play again?\n" +
                    "1. Yes   2. No");
            Integer input = scanner.nextInt();
            if(input == 2){
                quitGame = true;
            }

        }
    }

    public void printWelcome() {
        consoleY.println(
                "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO SLOTS   ******\n" +
                "***                             ***\n" +
                "***********************************");
    }

    public void getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        consoleP.println("How much you do want to bet?");
        Integer input = scanner.nextInt();
        playerBetAmount = input;
    }

    public Integer[] getBetSelections() {
        Scanner scanner = new Scanner(System.in);
        consoleB.println("How many lines do you want to bet on?");
        Integer numberOfLines = scanner.nextInt();
        Integer totalCost = playerBetAmount * numberOfLines;
        consoleR.println("Total cost to play:       " + totalCost);
        setBetTotal(totalCost);

        consoleC.println(
        "************************************************************************\n" +
        "**                 Select the lines you want to bet on!               **\n" +
        "**   1. Top Horizontal  2. Middle Horizontal   3. Bottom Horizontal   **\n" +
        "**   4. Left Vertical    5. Middle Vertical      6. Right Vertical    **\n" +
        "**           7. Down Diagonal              8. Up Diagonal             **\n" +
        "************************************************************************");
        Integer count = 0;
        Integer[] selectedLines = new Integer[numberOfLines];
        while (count < numberOfLines){
            consoleB.println("Select your line #" + (count + 1));
            selectedLines[count] = scanner.nextInt();
            count++;
        }
        return selectedLines;
    }

    public void calculateMultiplier(String[] betResults) {
        Integer countWin = 0;
        Integer countLose = 0;
        for(String outcome: betResults){
            if(outcome == "WIN"){
                countWin++;
            } else {
                countLose++;
            }
        }
        this.winMultiplier = countWin;
        this.loseMultiplier = countLose;
    }

    public Integer calculateReturnTotal(Integer winnings, Integer losings){
          Integer returnTotal = this.betTotal + winnings - losings;
          return returnTotal;
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return multiplier * betAmount;
    }

    @Override
    public void subtractBetFromBalance(Integer losings) {
        currentPlayer.getArcadeAccount().alterAccountBalance(losings * (-1));
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }


    public Integer getPlayerBetAmount() {
        return playerBetAmount;
    }

    public void setPlayerBetAmount(Integer playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    public Integer getBetTotal() {
        return betTotal;
    }

    public void setBetTotal(Integer betTotal) {
        this.betTotal = betTotal;
    }


    public PlayerInterface getCurrentPlayer() {
        return currentPlayer;
    }

}
