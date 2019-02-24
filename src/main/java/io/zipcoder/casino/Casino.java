package io.zipcoder.casino;


import io.zipcoder.casino.DiceGame.Yahtzee;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    private static Player player;
    private static Game game;

    public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Casino.player = player;
    }

    public static void setGame(Game game) {
        Casino.game = game;
    }

    public static void main(String[] args) {
        Console temp = Console.getInstance();

        String name = temp.getStringInput("What is your name?");
        Double wallet = temp.getDoubleInput("How much money would you like to bring?");
        Casino.setPlayer(new Player(name, wallet));
        String gameToPlay = temp.getStringInput("What game would you like to play?");

        if (gameToPlay.toLowerCase().equals("yahtzee")){
            Casino.setGame(new Yahtzee(player));
        }

        Casino.game.play();
    }
}
