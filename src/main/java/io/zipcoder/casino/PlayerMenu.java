package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

public class PlayerMenu {
    Console console = new Console(System.in,System.out);

    Player currentPlayer ;
    PlayerRepository playerRepo;
    Casino casino;
    private Integer playerInput;

    public void runPlayerMenu( ) {
       displayPlayerMenu();
       Integer playerInput = getPlayerInput();
       playerMenuLogic(playerInput);


    }

    public void displayPlayerMenu(){
        console.println("Welcome stranger! Have I seen you before?");
        console.println("(1) - Yes, My name is :");
        console.println("(2) - No it is my first time!");
        console.println("(3) - Never mind, forgot my wallet T^T");
    }

    public Integer getPlayerInput(){
        this.playerInput = console.getIntegerInput(":");
        return playerInput;
    }


    public String playerMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                console.println("Please enter your name.");
                PlayerRepository playerRepository = new PlayerRepository();
                String playerName = console.getStringInput(":");
                currentPlayer = playerRepository.findPlayer(playerName);
                Player testPlayer = new Player("testPlayer", 2000);
                //Player CurrentPlayer = //player repository result
                currentPlayer = testPlayer;
                Casino casino = new Casino();
                casino.runCasinoMenu(testPlayer);
                break;
            case 2:
                //takes you to player creation
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
