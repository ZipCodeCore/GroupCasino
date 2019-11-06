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
            Console.clearScreen();
            console.println(art.getCasinoArt(CasinoArt.Art.PLAYERMENU));
            Console.displayPlayerMenu();
            Integer playerInput = getPlayerInput();
            playerMenuLogic(playerInput);
        }
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
                    console.println("I don't know you!\n\n");
                    console.getStringInput("Press Enter to return to menu");
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
