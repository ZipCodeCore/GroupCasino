package io.zipcoder.casino.Games.SnakesAndLadders;

import java.util.HashMap;

public class SnakesAndLaddersLanguage {
    HashMap<String, String> snakesAndLaddersLanguage = new HashMap<>();


    public SnakesAndLaddersLanguage(){
        this.snakesAndLaddersLanguage.put("rules", "Snakes and Ladders finds its origins in Ancient India, where it\n" +
                "was first created under the name Moksha Patam.\n" +
                "It was used to teach children values, rewarding proper behavior with\n" +
                "a boost in point value, via climbing a ladder, or punishing a player\n" +
                "in point value for bad behavior, via sliding down the back of a snake.\n\n" +
                "Commercially known in the West as Chutes and Ladders, the game has been published by Milton Bradley\n" +
                "since the 1940's, and players compete by rolling dice and\n" +
                "and racing to the value of 100 points, the final spot on the board.\n" +
                "But beware! Certain spots on the board will send you down the backs of the Snakes!\n" +
                "Likewise, certain spots on the board will push you closer to your goal.\n" +
                "Roll the dice and see who gets there first!\n\n");
        this.snakesAndLaddersLanguage.put("approachTable", "You approach the Snakes and Ladders table. What would you like to do?\n" +
                "(1) - Play the game\n" +
                "(2) - Read the rules\n" +
                "(3) - Return to the game menu");
        this.snakesAndLaddersLanguage.put("welcome", "Welcome to Snakes and Ladders, %s!\n" +
                "In this house, the player always goes first! Step on up!");
        this.snakesAndLaddersLanguage.put("exitMenu", "Would you like to play again?\n(1) - Yes\n(2) - No");
        this.snakesAndLaddersLanguage.put("diceRoll", "Press Enter to roll the dice.");
        this.snakesAndLaddersLanguage.put("playerWins", "Congratulations! You won!");
        this.snakesAndLaddersLanguage.put("aiWins", "Oh, Too bad! I won! Better lucky next time!");


    }

    public String getSnakesAndLaddersLanguage(String game){
        return snakesAndLaddersLanguage.get(game);
    }
}
