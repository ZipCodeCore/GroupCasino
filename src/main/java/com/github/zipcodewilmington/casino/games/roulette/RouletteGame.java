package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Random;


public class RouletteGame implements GameInterface {
    private Integer[] red;
    private Integer[] black;
    private Integer choice;
    private Integer wins;
    private Integer loses;
    private Integer spins;
    private Double betAmount;
    private Double balance;
    private Integer rouletteNumber;


    private final IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    // private final IOConsole console2 = new IOConsole(AnsiColor.GREEN);

    public RouletteGame() {
        this.rouletteNumber = new Random().nextInt((36 - 1) + 1) + 1;
        this.red = new Integer[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        this.black = new Integer[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
    }

    public void evenChoice() {

        System.out.println("Roulette Number: " + this.rouletteNumber);
        String result = "";

        if (rouletteNumber % 2 == 0) {

            result = "you won";


        } else {

            result = "you lost";
        }

        consoleRed.println(result);
    }

    public void oddChoice() {
        String result = "";

        System.out.println("Roulette Number: " + this.rouletteNumber);
        if (rouletteNumber % 2 == 1) {
            result = "you won";

        } else {
            result = "you lost";
        }
        consoleRed.print(result);
    }

    public void redChoice() {
        String result = "";
        System.out.println("Roulette Number: " + this.rouletteNumber);
        for (Integer num : this.red) {
            if (num == this.rouletteNumber) {

                result = "you won";
                break;
            } else {
                result = "you lost";
            }
        }
        consoleRed.println(result);
    }

    public void blackChoice() {
        String result = "";
        System.out.println("Roulette Number: " + this.rouletteNumber);
        for (Integer num : this.black) {
            if (num == this.rouletteNumber) {

                result = "you won";
                break;
            } else {
                result = "you lost";
            }
        }
        consoleRed.println(result);
    }

    public void pickNumberChoice(){
        String result = "";
        //System.out.println(this.rouletteNumber); // to test if number matches
        Integer number = consoleRed.getIntegerInput("Place your bet on number(1-36): ");

        if(this.rouletteNumber == number){
            result = "you won";

        } else {

            result = "you lost";
        }
     consoleRed.println(result);
    }


    public Integer rouletteMenu() {
        consoleRed.println("Welcome to the Roulette Game!!!");
        this.betAmount = consoleRed.getDoubleInput("Please enter amount you would like to bet");
        consoleRed.println("PLease choose from the options below");
        this.choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6) 1 to 18  (7) 19 to 36");
        return choice;
    }


    public Double rouletteGame(int choice) {
        while (choice < 0 || choice > 7) {
            consoleRed.println("PLease choose from the options below");
            choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6) 1 to 18  (7) 19 to 36");

        }

        if (choice == 1) {

            redChoice();

        } else if (choice == 2) {
            blackChoice();

        } else if (choice == 3) {
            evenChoice();

        } else if (choice == 4) {
            oddChoice();

        } else if (choice == 5) {
            pickNumberChoice();

        } else if (choice == 6) {
            consoleRed.println("1 to 18 Chosen");

        } else if (choice == 7) {
            consoleRed.println("19 to 36 Chosen");
        }


        return null;
    }

    public Integer[] getRed() {
        return red;
    }

    public Integer[] getBlack() {
        return black;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Integer getSpins() {
        return spins;
    }

    public void setSpins(Integer spins) {
        this.spins = spins;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getRouletteNumber() {
        return rouletteNumber;
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        RouletteGame rouletteGame = new RouletteGame();
        Integer choice = rouletteGame.rouletteMenu();
        Double money = rouletteGame.rouletteGame(choice);
    }
}
