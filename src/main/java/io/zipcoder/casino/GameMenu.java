package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class GameMenu {
    Console console = new Console(System.in, System.out);
    private Integer playerInput;

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
        this.playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public String gameMenuLogic(Integer playerInput) {
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
                console.print("You would be playing craps now");
                /*Craps craps = new Craps;
                craps.launchCraps();*/
                break;
            case 4:
                console.print("You would be playing Chutes and Ladders now");
                /*ChutesAndLadders chutesAndLadders = new ChutesAndLadders;()
                chutesAndLadders.launchChutesAndLadders()*/
                break;
            case 5:
                console.print("You would be playing Roulette now.");
                /*Roulette roulette = new Roulette;
                roulette.launchRoulette();
                 */
                return "You would be playing Roulette now.";
            case 6:
                console.print("You would be playing Slots now");
                /*Slots slots = new Slots();
                slots.launchSlots();
                 */
                break;
            case 7:
                console.print("This will take you back to the Casino menu");
                /*Casino casino = new Casino();
                casino.launchCasinoMenu
                 */
                break;
        }
        return null;
    }
}

