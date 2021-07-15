package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouletteGame implements GameInterface {
    int ball;
    Integer[] red;
    Integer[] black;
    int money;
    int bet;
    String input;

    public RouletteGame() {
        ball = (int) (Math.random() * 36 + 1);
        red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        bet = 0;
        money = 0;
        input = "";
    }

    public void choosingABet() {
        IOConsole console = new IOConsole(AnsiColor.WHITE);
        console.println("Welcome to The Roulette Table!");
        console.println("Make your bets below <3");
        input = console.getStringInput("(Red) (Black) (Odds) (Even) (Specific Number)");
    }

    public int bettingOnRed(String input) {
        List<Integer> redNum = Arrays.asList(red);
        if (input == "(Red)") {
            for (Integer num : redNum) {
                if (ball == num) {
                    money = bet * 2;
                }
                money = bet - bet;
            }

        }
        return money;
    }

    public void bettingOnBlack() {
        List<Integer> blackNum = Arrays.asList(black);
        for (Integer num : blackNum) {
            if (ball == num) {
                money = bet + bet;
            }
            money = bet - bet;
        }
    }

    public void bettingOnOdd() {
        if (ball % 2 == 0) {
            money = bet - bet;
        }
        money = bet + bet;
    }

    public void bettingOnEven() {
        if (ball % 2 == 0) {
            money = bet + bet;
        }
        money = bet - bet;
    }

    public void bettingOnASpecificNumber(String input, int num) {
        num = 0;
        if (ball == num) {
            money = bet + bet * 2;
        }
        money = bet - bet;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }
}