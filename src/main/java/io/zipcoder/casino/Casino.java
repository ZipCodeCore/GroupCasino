package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

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
        console.println(String.format("Welcome to Big 3 casino, %s",currentPlayer.getName()));
        console.println("What would you like to do?");
        console.println("(1) - Display Game Menu");
        console.println("(2) - Return to Player Menu");
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

    public void casinoMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                GameMenu gameMenu = new GameMenu();
                gameMenu.runGameMenu(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }
}
