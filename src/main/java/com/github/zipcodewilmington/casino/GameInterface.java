package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    void add(PlayerInterface player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(PlayerInterface player);


    int getNumberOfPlayers();

    boolean playerWins();  //player or house wins


    boolean playerLoses(); //player or house loses

    void clearGame(); //Garbage collection, clearing the balance of wagers and setting players to null




}
