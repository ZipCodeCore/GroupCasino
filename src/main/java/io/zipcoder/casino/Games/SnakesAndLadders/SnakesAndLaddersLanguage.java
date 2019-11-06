package io.zipcoder.casino.Games.SnakesAndLadders;

import java.util.HashMap;

public class SnakesAndLaddersLanguage {
    HashMap<Language,String> snakesHashMap = new HashMap<>();

    public enum Language {
        RULES,APPROACHTABLE,WELCOME,EXITMENU,DICEROLL,PLAYERWINS,AIWINS;
    }

    public String getSnakeLanguage(Language key) {
        return snakesHashMap.get(key);
    }

    public SnakesAndLaddersLanguage(){
        snakesHashMap.put(Language.RULES, "Snakes and Ladders finds its origins in Ancient India, where it\n" +
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
        snakesHashMap.put(Language.APPROACHTABLE, "You approach the Snakes and Ladders table. What would you like to do?\n" +
                "(1) - Play the game\n" +
                "(2) - Read the rules\n" +
                "(3) - Return to the game menu");
        snakesHashMap.put(Language.WELCOME, "Welcome to Snakes and Ladders, %s!\n" +
                "In this house, the player always goes first! Step on up!");
        snakesHashMap.put(Language.EXITMENU, "Would you like to play again?\n(1) - Yes\n(2) - No");
        snakesHashMap.put(Language.DICEROLL, "Press Enter to roll the dice.");
        snakesHashMap.put(Language.PLAYERWINS, "Congratulations! You won!");
        snakesHashMap.put(Language.AIWINS, "Oh, Too bad! I won! Better lucky next time!");
        }

}