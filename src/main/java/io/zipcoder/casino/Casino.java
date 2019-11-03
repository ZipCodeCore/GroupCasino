package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

public class Casino {

    Console console = new Console(System.in, System.out);

    public void runCasinoMenu(){
        displayCasinoMenu();
        Integer playerInput = getPlayerInput();

    }

    public void displayCasinoMenu(){
        console.print("Welcome to Big 3 casino!");
        console.print("What would you like to do?");
        console.print("(1) - Return to Player Menu");
        console.print("(2) - Display Game Menu");
        console.print("(3) - Exit Casino");

    }

    public void goToGameMenu(){
        GameMenu gameMenu = new GameMenu();
        gameMenu.runGameMenu();
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
                console.print("You will go to Player Menu");
            //PlayerMenu playerMenu = new PlayerMenu();
                //playerMenu.launchPlayerMenu;
                break;
            case 2:
                console.print("This will display Game Menu");
                GameMenu gameMenu = new GameMenu();
                gameMenu.runGameMenu();
                break;
            case 3:
                console.print("You will exit casino");
        }
    }
}
