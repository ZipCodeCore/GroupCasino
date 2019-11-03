package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

public class PlayerMenu {
    Console console = new Console(System.in,System.out);

    Player currentPlayer ;
    PlayerRepository playerRepo;
    Casino casino;

    public PlayerMenu( ) {
       displayPlayerMenu();

    }

    public void displayPlayerMenu(){
        console.print("Welcome stranger! Have I seen you before?");
        console.print("(1) - Yes, My name is :");
        console.print("(2) - No it is my first time!");
        console.print("(3) - Never mind, forgot my wallet T^T");
        getPlayerInput();
    }

    public Integer getPlayerInput(){
        Integer playerInput = console.getIntegerInput(":");
        return getPlayerInput();
    }


    public void playerMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
            console.print("should be taking you to existing player repository");
            break;
            case 2:
            console.print("should be taking you to create a player menu");
            break;
            case 3:
                console.print("thank you come again!");
                System.exit(0);

        }






    }











}
