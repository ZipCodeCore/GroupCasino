package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

public class PlayerMenu {
    Console console = new Console(System.in,System.out);
    private PlayerRepository playerRepo;
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
        console.println("  _______ _            _   _       _             _                   ____   _____   _____     ____     _____          _             \n" +
                " |__   __| |          | \\ | |     | |           (_)                 |  _ \\ |_   _| / ____|   |___ \\   / ____|        (_)            \n" +
                "    | |  | |__   ___  |  \\| | ___ | |_ ___  _ __ _  ___  _   _ ___  | |_) |  | |  | |  __      __) | | |     __ _ ___ _ _ __   ___  \n" +
                "    | |  | '_ \\ / _ \\ | . ` |/ _ \\| __/ _ \\| '__| |/ _ \\| | | / __| |  _ <   | |  | | |_ |    |__ <  | |    / _` / __| | '_ \\ / _ \\ \n" +
                "    | |  | | | |  __/ | |\\  | (_) | || (_) | |  | | (_) | |_| \\__ \\ | |_) | _| |_ | |__| |_   ___) | | |___| (_| \\__ \\ | | | | (_) |\n" +
                "    |_|  |_| |_|\\___| |_| \\_|\\___/ \\__\\___/|_|  |_|\\___/ \\__,_|___/ |____(_)_____(_)_____(_) |____/   \\_____\\__,_|___/_|_| |_|\\___/ \n" +
                "                                                                                                                                    \n" +
                "                                                                                                                                    ");
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
