package io.zipcoder.casino.Games.Roulette;

import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.Menus.Casino;
import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.GamePieces.RouletteSpinner;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Roulette implements Game, GamblingGame {
    Casino casino = new Casino();
    Console console = new Console(System.in, System.out);
    Player currentPlayer;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private boolean running = true;
    private boolean currentGame = true;
    private Integer pot;
    private Integer multiplier;
    private Integer spinNum;
    private Integer placeBetInt;
    private boolean isWinner;
    private Boolean isOddEvenGame;
    private Integer totalReturns;
    private CasinoArt art = new CasinoArt();
    public void runRoulette(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    public void approachTable(Player currentPlayer) {
        Console.clearScreen();

        console.println(art.getCasinoArt(CasinoArt.Art.ROULETTE));
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
    public void runGame(Player currentPlayer){
        while (running){
            placeBet(currentPlayer);
            playersPick(currentPlayer);
            winningNumber();
            if(isWinner()){
                returnWinnings(currentPlayer, winnings);
            }else {
                youLose(currentPlayer);
            }
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
//                casino.goToGameMenu();
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
        isOddEvenGame = false;
        console.println("Pick a number 0 - 36");
        Integer playerBet = console.getIntegerInput(":");
        if (playerBet < 0 || playerBet > 36) {
            console.println("Try again! Pick a number 0 - 36");
            playerBet = console.getIntegerInput(":");
        }
        placeBetInt = playerBet;
        multiplier = 6;
        return playerBet;
    }

    public void playerBetOddEven(Integer playerInput) {
        isOddEvenGame = true;
        console.println("Odds or Even?");
        console.println("(1) - Odd");
        console.println("(2) - Even");
        Integer playerBet = console.getIntegerInput(":");
        if (!(playerBet == 1 || playerBet == 2)) {
            console.println("Try again!");
            console.getIntegerInput(":");
        } else if (playerBet == 1) {
            placeBetInt = 1;
        } else if (playerBet == 2) {
            placeBetInt = 0;


        }
        multiplier = 2;
    }

    public Integer winningNumber (){
        spinNum = RouletteSpinner.winningNumber();
        console.println(spinNum.toString());
        return spinNum;
    }


    public boolean isWinner(){
        if(isOddEvenGame) {
            return spinNum % 2 == placeBetInt;
        }
        return spinNum.equals(placeBetInt);
    }

    // If we can I would like to find a way to return a higher odds for betting "number" vs. "odd/even"
    @Override
    public void returnWinnings(Player currentPlayer, Integer winnings) {
        if (isWinner()) {
            totalReturns = pot * multiplier;
            console.println("Congrats maybe you don't suck I'll give you $"+ totalReturns);
            //Need to change "totalReturns in line 172 to reflect player balance
            currentPlayer.changeBalance(totalReturns);
            console.println("Your new balance is : $" + currentPlayer.getBalance());
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You won $%d.00 at Roulette! ** ", totalReturns);
            currentPlayer.addHistory(addHistory + dtf.format(now));

        }

    }

    public boolean youLose(Player currentPlayer) {
        totalReturns = pot;
        console.println("You suck and you should feel bad. You lost: $" + totalReturns);
        currentPlayer.changeBalance(totalReturns);
        console.println("Your new balance is : $" + currentPlayer.getBalance());
        LocalDateTime now = LocalDateTime.now();
        String addHistory = String.format("You lost $%d.00 at Roulette! ** ", totalReturns);
        currentPlayer.addHistory(addHistory + dtf.format(now));
        return true;
    }
}



