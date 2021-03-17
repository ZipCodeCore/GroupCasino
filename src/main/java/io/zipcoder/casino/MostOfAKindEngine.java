package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class MostOfAKindEngine {
    Console console = new Console(System.in, System.out);
    MostOfAKindScreens mScreens = new MostOfAKindScreens();
    Player player = new Player("gerg", 500);
    MostOfAKindGame moak = new MostOfAKindGame(player);

    public static void main(String[] args) {
        MostOfAKindEngine moak = new MostOfAKindEngine();
        moak.startMoakGame();
    }

    private void startMoakGame() {
        mScreens.welcomeMoakScreen();
        player.setChipBalance(100);
        while (true) {
            Integer input = console.getIntegerInput("");
            if (input == 1) {
                anteUpScreen();
            } else if (input == 2) {
                casinoLobby();
            } else {
                welcomeInvalidScreen();
            }
        }
    }

    //PLACEHOLDER
    private void casinoLobby() {
        System.exit(0);
    }

    private void welcomeInvalidScreen() {
        mScreens.welcomeInvalidMoakScreen();
    }

    private void anteUpScreen() {
        mScreens.anteUpScreen();
        while (true) {
            Integer input = console.getIntegerInput("");
            if (input == 1) {
                moak.anteUp();
                moak.makePlayerHand(5);
                firstRollScreen(moak.getPot(), moak.getPlayerHand());
            } else if (player.getChipBalance() <= 2) {
                needMoreChipsScreen();
            } else {
                System.out.println("Invalid Entry");
            }
        }
    }

    private void needMoreChipsScreen() {
        mScreens.needMoreChipsScreen();
        while (true) {
            Integer input = console.getIntegerInput("");
            if (input == 0) {
                casinoLobby();
            } else {
                System.out.println("Invalid Entry");
            }
        }
    }

    private void firstRollScreen(int pot, ArrayList<Integer> playerHand) {
    }
}
