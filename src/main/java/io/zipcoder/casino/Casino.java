package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;
import java.util.Date;

import java.util.ArrayList;

public class Casino {
    private Player currentPlayer;
    Console console = new Console(System.in, System.out);
    boolean running = true;

    public void runCasinoMenu(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        while(running) {
            displayCasinoMenu();
            Integer playerInput = getPlayerInput();
            casinoMenuLogic(playerInput);
        }
    }

    public void displayCasinoMenu(){
        console.println(String.format("Welcome to Big 3 Casino, %s!",currentPlayer.getName()));
        console.println("What would you like to do?");
        console.println("(1) - Display Game Menu");
        console.println("(2) - Check your Balance");
        console.println("(3) - See your History");
        console.println("(4) - Return to Player Menu");
    }

    public void goToGameMenu(){
        GameMenu gameMenu = new GameMenu();
        gameMenu.runGameMenu(currentPlayer);
    }

    public void exitCasino(){
        console.print("Thank you for visiting Big 3!");

    }

    public Integer getPlayerInput(){
        Integer playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public String printHistory(){
        StringBuilder sb = new StringBuilder();
        Integer historyCounter = 0;
        for(String result : currentPlayer.getHistory()){
            sb.append(currentPlayer.getHistory().get(historyCounter)).append("\n");
            historyCounter++;
        }
        return sb.toString();
    }

    public void casinoMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                GameMenu gameMenu = new GameMenu();
                gameMenu.runGameMenu(currentPlayer);
                break;
            case 2:
                console.println(String.format("Your current balance is $%d.00", currentPlayer.getBalance()));
            case 3:
                if(currentPlayer.getHistory().isEmpty()){
                    console.println("Sorry! You do not yet have a gaming history. Play some games to get one!\n");
                } else {
                    console.println(printHistory());
                }
                break;
            case 4:
                running = false;
                break;
        }
    }
}
