package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouletteGame {
    int ball;
    Integer[] red;
    Integer[] black;
    int winnings;
    int losings;
    int bet;

    public RouletteGame() {
        ball = (int) (Math.random() * 36 + 1);
        red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        bet = 0;
        winnings = 0;
        losings = 0;
    }

    public void bettingOnRed() {
        List<Integer> redNum = Arrays.asList(red);
        for (Integer num : redNum) {
            if (ball == num) {
                winnings = bet + bet;
            }
            losings = bet - bet;
        }
    }

    public void bettingOnBlack() {
        List<Integer> blackNum = Arrays.asList(black);
        for (Integer num : blackNum) {
            if (ball == num) {
                winnings = bet + bet;
            }
            losings = bet - bet;
        }
    }

    public void bettingOnOdd() {
        if (ball % 2 == 0) {
            losings = bet - bet;
        }
        winnings = bet + bet;
    }
    public void bettingOnEven() {
        if (ball % 2 == 0) {
            winnings = bet + bet;
        }losings = bet - bet;

    }
    public void bettingOnASpecificNumber(int num){
        if(ball==num){
            winnings = bet + bet*2;
        }losings = bet - bet;
        }
    }