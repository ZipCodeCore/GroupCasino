package io.zipcoder.casino;


import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.Games.SnakesAndLadders;
import io.zipcoder.casino.Games.HighAndLow;
import io.zipcoder.casino.utilities.Console;

public class GameMenu {
    private Console console = new Console(System.in, System.out);
    private Integer playerInput;
    private Player currentPlayer;
    Casino casino = new Casino();
    private boolean running = true;

    public void runGameMenu(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        while(running) {
            displayGameMenu();
            Integer playerInput = getPlayerInput();
            gameMenuLogic(playerInput);
        }
    }

    public void displayGameMenu(){
        console.println("Hi! Welcome to the game menu!\nHere are the games you can play:");
        console.println("(1) - Go Fish");
        console.println("(2) - Blackjack");
        console.println("(3) - Craps");
        console.println("(4) - Snakes & Ladders");
        console.println("(5) - Roulette");
        console.println("(6) - Slots");
        console.println("(7) - High or Low");
        console.println("(8) - Return to Casino");
    }

    public Integer getPlayerInput(){
        this.playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public String gameMenuLogic(Integer playerInput){
        switch (playerInput) {
            case 1:
                console.print("You would be playing Go Fish now.");
                /*GoFish goFish = new GoFish();
                goFish.launchGoFish();*/
                return "You would be playing Go Fish now.";
            case 2:
                console.print("You would be playing Blackjack now.");
                /*Blackjack blackjack = new blackjack();
                blackjack.launchBlackjack();*/
                return "You would be playing Blackjack now.";
            case 3:
                Craps craps = new Craps();
                craps.approachTable(currentPlayer);
                return "You would be playing craps now.";
            case 4:
                SnakesAndLadders SnakesAndLadders = new SnakesAndLadders();
                SnakesAndLadders.runSnakesAndLadders(currentPlayer);
                return "You would be playing Snakes and Ladders now.";
            case 5:
                console.print("You would be playing Roulette now.");
                /*Roulette roulette = new Roulette;
                roulette.launchRoulette();
                 */
                return "You would be playing Roulette now.";
            case 6:
                console.print("You would be playing Slots now.");
                /*Slots slots = new Slots();
                slots.launchSlots();
                 */
                return "You would be playing Slots now";
            case 7:
                HighAndLow highAndLow = new HighAndLow();
                highAndLow.runHighOrLow(currentPlayer);
                return "You would be playing High and Low now.";
            case 8:
                running = false;
                break;

        }
        return null;
    }
}

