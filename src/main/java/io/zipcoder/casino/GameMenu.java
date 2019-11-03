package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class GameMenu {
    Console console = new Console(System.in, System.out);

    public void runGameMenu(){
        displayGameMenu();
        Integer playerInput = getPlayerInput();
        gameMenuLogic(playerInput);
    }

    public void displayGameMenu(){
        console.print("Hi! Welcome to the game menu!\nHere are the games you can play:");
        console.print("(1) - Go Fish");
        console.print("(2) - Blackjack");
        console.print("(3) - Craps");
        console.print("(4) - Chutes & Ladders");
        console.print("(5) - Roulette");
        console.print("(6) - Slots");
        console.print("(7) - Return to Casino");
        getPlayerInput();
    }

    public Integer getPlayerInput(){
        Integer playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public void gameMenuLogic(Integer playerInput){
        switch(playerInput){
            case 1:
                console.print("You would be playing Go Fish now.")
                /*GoFish goFish = new GoFish();
                goFish.launchGoFish;*/
                break;
            case 2:
                console.print("You would be playing blackjack now.");
                /*Blackjack blackjack = new blackjack();
                blackjack.launchBlackjack;*/
                break;
            case 3:
                console.print("You would be playing craps now");
                /*Craps craps = new Craps*/
                craps.

        }
    }
}
