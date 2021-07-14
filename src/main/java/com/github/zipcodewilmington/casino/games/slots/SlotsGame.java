package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface {
    private Integer playerBetAmount;

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Slots slotMachine = new Slots();
        getBetAmount();
        Integer[] selectedBets = getBetSelections();
        slotMachine.spinSlots();
        String[] betResults =  slotMachine.compareBetVsWinningLines(selectedBets);
        calculateMultiplier(betResults);

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
        Integer count = 0;
        for(String outcome: betResults){
            if(outcome.equals("Win")){
                count++;
            } else {
                count--;
            }
        }
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }
}
