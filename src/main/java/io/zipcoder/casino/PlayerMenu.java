package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

public class PlayerMenu {
    Console console = new Console(System.in,System.out);

    Player currentPlayer ;
    PlayerRepository playerRepo;
    Casino casino;

    public PlayerMenu( ) {


    }

    public void displayPlayerMenu(){
        console.println("Welcome stranger! Have I seen you before?");
        console.println("(1) - Yes, My name is :");
        console.println("(2) - No it is my first time!");
        console.println("(3) - Never mind, forgot my wallet T^T");
        getPlayerInput();
    }

    public Integer getPlayerInput(){
        Integer playerInput = console.getIntegerInput(":");
        return getPlayerInput();
    }


    public String playerMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                console.print("should be taking you to existing player repository");
                return "should be taking you to existing player repository";
            case 2:
                console.print("should be taking you to create a player menu");
                return "should be taking you to create a player menu";

            case 3:
                console.print("thank you come again!");
                return "thank you come again!";

                //System.exit(0);

        }





return null;
    }











}
