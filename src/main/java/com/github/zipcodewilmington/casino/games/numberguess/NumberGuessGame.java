package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame {
    private Integer maxNumber;

    public NumberGuessGame(){
        this.maxNumber = 20;
    }

    public void setMaxNumber(Integer number){
        this.maxNumber = number;
    }

    public Integer getGuessRange(Integer guessedNumber, Integer actualNumber){
        return Math.abs(guessedNumber - actualNumber);
    }

    public Double guessRangePercentage(Integer range){
        return range.doubleValue() / this.maxNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }
}