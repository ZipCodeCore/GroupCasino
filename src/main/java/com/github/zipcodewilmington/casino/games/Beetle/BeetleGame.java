package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BeetleGame implements GameInterface {
    private PlayerInterface[] players;
    private Beetle game;
    private Boolean isRunning = false;
    public void add(PlayerInterface player){

    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    public void remove(PlayerInterface player){

    }

    /**
     * specifies how the game will run
     */
    public void run(){
        if(isRunning){

        }
    }

    /**
     * Calculate player's winning payout amount of bet x multiplier
     * @return (double) amount of money winnings
     */
    public Double calculateWinnings(Double betAmount){
        return 0.00;
    }

    /**
     * Subtract the bet amount from player's balance
     */
    public void subtractBetFromBalance(Double betAmount){}


    /**
     * Add winnings amount to player's balance
     */
    public void addMoneyToBalance(PlayerInterface Player, Double winnings){

    }

    public void initGame(){
        this.game = new Beetle(this.players.length);
    }



}
