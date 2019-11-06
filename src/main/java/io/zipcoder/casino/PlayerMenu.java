package io.zipcoder.casino;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.Menus.Casino;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.PlayerRepository;
import io.zipcoder.casino.utilities.Console;

public class PlayerMenu {
    Console console = new Console(System.in,System.out);
    private PlayerRepository playerRepo;
    private CasinoArt art = new CasinoArt();
    boolean running;

    public PlayerMenu() {
        playerRepo = new PlayerRepository();
        running = true;

        playerRepo.addPlayer(new Player("Test", 500));
    }

    public void runPlayerMenu( ){
        while (running) {
            displayPlayerMenu();
            Integer playerInput = getPlayerInput();
            playerMenuLogic(playerInput);
        }
    }

    private void displayPlayerMenu(){
        Console.clearScreen();
        console.println(art.getCasinoArt(CasinoArt.Art.PLAYERMENU));
        console.println("Welcome stranger! Have I seen you before?");
        console.println("(1) - Yes, My name is...");
        console.println("(2) - No it is my first time!");
        console.println("(3) - Never mind, forgot my wallet T^T");
    }

    private Integer getPlayerInput(){
        return console.getIntegerInput(":");
    }

    private Player loadPlayer() {
        console.println("Please enter your name.");
        String playerName = console.getStringInput(":");
        return playerRepo.findPlayer(playerName);
    }

    private Player createPlayer() {
        console.println("Please enter your name.");
        String playerName = console.getStringInput(":");
        Player newPlayer = new Player(playerName, 500);

        if(playerRepo.addPlayer(newPlayer)) {
            return newPlayer;
        } else {
            return null;
        }
    }



    public String playerMenuLogic(Integer playerInput){
        Casino casino = new Casino();
        Player player = null;

        switch (playerInput) {
            case 1:

                player = loadPlayer();
                if (player != null) {
                    casino.runCasinoMenu(player);
                } else {
                    console.println("I don't know you!");
                }

                break;
            case 2:

                player = createPlayer();
                if (player != null) {
                    casino.runCasinoMenu(player);
                } else {
                    console.println("That User Already Exists");
                }

                break;
            case 3:
                console.println("thank you come again!");
                running = false;
                return "thank you come again!";
            default:
                console.print("Invalid Input");
                return "Invalid Input";
        }

        return "Success";
    }

}
