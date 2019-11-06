package io.zipcoder.casino.Games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.GamePieces.RouletteSpinner;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Roulette implements Game, GamblingGame {
    Casino casino = new Casino();
    Console console = new Console(System.in, System.out);
    Player currentPlayer;
    private boolean running = true;
    private boolean currentGame = true;
    private Integer pot;
    private Integer spinNum;
    private Integer placeBetInt;

    public void runRoulette(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    public void approachTable(Player currentPlayer) {
        Console.clearScreen();
        console.println(" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                "▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                "▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌               ▐░▌          ▐░▌     ▐░▌          \n" +
                "▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░█▄▄▄▄▄▄▄▄▄      ▐░▌          ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░░░░░░░░░░░▌     ▐░▌          ▐░▌     ▐░░░░░░░░░░░▌\n" +
                "▐░█▀▀▀▀█░█▀▀ ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀      ▐░▌          ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                "▐░▌     ▐░▌  ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌               ▐░▌          ▐░▌     ▐░▌          \n" +
                "▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄      ▐░▌          ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ \n" +
                "▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌          ▐░▌     ▐░░░░░░░░░░░▌\n" +
                " ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀            ▀       ▀▀▀▀▀▀▀▀▀▀▀ \n" +
                "                                                                                                        \n\n");
        console.println("You approach the Roulette. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while (running) {
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    casino.goToGameMenu();
                    running = false;
                    break;
            }
        }
    }


    @Override
    public void runGame(Player currentPlayer) {
        while (running) {
            placeBet(currentPlayer);
            playersPick(currentPlayer);
            winningNumber();
            if (isWinner(currentPlayer)) {
                returnWinnings(currentPlayer);
            } else if (youLose(currentPlayer))

                exitGame(currentPlayer);
        }
        //prompting player to place bet
        // prompting to pick number
        //call spinner to generate winning number
        // if player number == winning number
        // return winnings
    }

    @Override
    public void exitGame(Player currentPlayer) {
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput) {
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                casino.goToGameMenu();
                running = false;
                break;
        }
    }

    @Override
    public void placeBet(Player currentPlayer) {
        console.println("How much would you like to bet?");
        pot = console.getIntegerInput(":");

    }

    public void playersPick(Player currentPlayer) {
        console.println("Where are you betting? Pick an option");
        console.println(("(1) - Would you like to pick a number?"));
        console.println("(2) - Pick Odd or Even");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput) {
            case 1:
                playerBetInt(playerInput);
                break;
            case 2:
                playerBetOddEven(playerInput);
                break;

        }

    }

    public Integer playerBetInt(Integer playerInput) {
        console.println("Pick a number 0 - 36");
        Integer playerBet = console.getIntegerInput(":");
        if (playerBet < 0 || playerBet > 36) {
            console.println("Try again! Pick a number 0 - 36");
            playerBet = console.getIntegerInput(":");
        }
        return playerBet;
    }

    public void playerBetOddEven(Integer playerInput) {
        String betPlacement = "";
        console.println("Odds or Even?");
        console.println("(1) - Odd");
        console.println("(2) - Even");
        Integer playerBet = console.getIntegerInput(":");
        if (!(playerBet == 1 || playerBet == 2)) {
            console.println("Try again!");
            console.getIntegerInput(":");
        } else if (playerBet == 1) {
            betPlacement = "Odd";
        } else if (playerBet == 2) {
            betPlacement = "Even";

        }
    }

    public Integer winningNumber() {
        Integer spinNum = RouletteSpinner.winningNumber();
        console.println(spinNum.toString());
        return spinNum;
    }

    public boolean isWinner(Player currentPlayer) {
        if (spinNum == placeBetInt) {
            return true;
        }
       return false;
    }

    @Override
    public void returnWinnings(Player currentPlayer) {
        if (isWinner(currentPlayer)) {
            Integer winnings = pot * 2;
            currentPlayer.changeBalance(winnings);
        }

    }

    public boolean youLose(Player currentPlayer) {
        console.println("You suck");
        return true;
    }
}



