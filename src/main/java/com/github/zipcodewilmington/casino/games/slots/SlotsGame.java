package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.net.Inet4Address;
import java.util.Scanner;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface{
    private Integer playerBetAmount;
    private Integer betTotal;
    private Integer loseMultiplier;
    private Integer winMultiplier;
    private PlayerInterface player;

    @Override
    public void add(PlayerInterface player) {
        this.player = player;

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Boolean quitGame = false;
        while(quitGame = false) {
            Slots slotMachine = new Slots();
            getBetAmount();
            Integer[] selectedBets = getBetSelections();
            //takeBetTotalFromPlayerBalance();
            slotMachine.spinSlots();
            String[] betResults = slotMachine.compareBetVsWinningLines(selectedBets);
            calculateMultiplier(betResults);
            Integer winnings = calculateWinnings(this.winMultiplier, playerBetAmount);
            Integer losings = calculateWinnings(this.loseMultiplier, playerBetAmount);
            Integer returnTotal = calculateReturnTotal(winnings, losings);
            //addMoneyToBalance(, returnTotal);
            
        }
    }


    private void getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much you do want to bet?");
        Integer input = scanner.nextInt();
        playerBetAmount = input;
    }

    private Integer[] getBetSelections() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many lines do you want to bet on?");
        Integer numberOfLines = scanner.nextInt();
        Integer totalCost = playerBetAmount * numberOfLines;
        System.out.println("The total cost to play is " + totalCost);

        System.out.println(
        "************************************************************************\n" +
        "**                 Select the lines you want to bet on!               **\n" +
        "**   1. Top Horizontal  2. Middle Horizontal   3. Bottom Horizontal   **\n" +
        "**   4. Left Vertical    5. Middle Vertical      6. Right Vertical    **\n" +
        "**           7. Down Diagonal              8. Up Diagonal             **\n" +
        "************************************************************************");
        Integer count = 0;
        Integer[] selectedLines = new Integer[numberOfLines];
        while (count < numberOfLines){
            System.out.println("Select your line #" + (count + 1));
            selectedLines[count] = scanner.nextInt();
            count++;
        }
        return selectedLines;
    }

    private void calculateMultiplier(String[] betResults) {
        Integer countWin = 0;
        Integer countLose = 0;
        //Integer[] winVsLose = new Integer[2];
        for(String outcome: betResults){
            if(outcome.equals("Win")){
                countWin++;
            } else {
                countLose--;
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
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

}
