package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;


/**
 * Authors: Zack, Nathan
 */

public class NumberGuessGame implements GameInterface {
    private Integer maxNumber;
    private PlayerInterface currentPlayer;

    public NumberGuessGame(){
        this.maxNumber = 20;
    }

    @Override
    public void run() {

    }

    public void setMaxNumber(Integer number){
        this.maxNumber = number;
    }

    public Double getGuessRange(Integer guessedNumber, Integer actualNumber){
        return guessRangePercentage(Math.abs(guessedNumber - actualNumber));
    }

    public Double guessRangePercentage(Integer range){
        return range.doubleValue() / this.maxNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {

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