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
    private Random rouletteNumber = new Random();

    private final IOConsole consoleRed = new IOConsole(AnsiColor.RED);
    // private final IOConsole console2 = new IOConsole(AnsiColor.GREEN);

    public RouletteGame() {
        this.red = new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        this.black = new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
    }


    public Integer rouletteMenu() {
        consoleRed.println("Welcome to the Roulette Game!!!");
        this.betAmount = consoleRed.getDoubleInput("Please enter amount you would like to bet");
        consoleRed.println("PLease choose from the options below");
        this.choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6) 1 to 18  (7) 19 to 36");
        return choice;
    }


    public Double rouletteGame(int choice){
     while(choice < 0 || choice > 7) {
    consoleRed.println("PLease choose from the options below");
    choice = consoleRed.getIntegerInput("(1)Red  (2)Black  (3)Even  (4)Odd  (5)Pick Number (6) 1 to 18  (7) 19 to 36");

     }

        if(choice == 1){
         consoleRed.println("Red Chosen");

        }
        else if(choice == 2){
            consoleRed.println("Black Chosen");

        }
        else if(choice == 3){
            consoleRed.println("Even Chosen");

        }
        else if(choice == 4){
          consoleRed.println("Odd Chosen");
        }
        else if(choice == 5){
          consoleRed.println("Pick Number Chosen");
        }
        else if(choice == 6){
          consoleRed.println("1 to 18 Chosen");

        }
        else if(choice == 7){
          consoleRed.println("19 to 36 Chosen");
        }



       return null;
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
