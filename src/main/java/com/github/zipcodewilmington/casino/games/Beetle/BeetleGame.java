package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class BeetleGame implements GameInterface {
    private ArrayList<PlayerInterface> players = new ArrayList<PlayerInterface>();
    private Beetle game;
    private Boolean isRunning = false;
    private PlayerInterface player;
    private IOConsole console = new IOConsole();
    private Integer betAmt;

    public BeetleGame(){
        this.game = new Beetle(2);
    }

    public void add(PlayerInterface player){
        players.add(player);
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    public void remove(PlayerInterface player){
        players.remove(player);
    }

    /**
     * specifies how the game will run
     */
    public void run(){
        printWelcome();
        console.newLine();
        this.setBetAmt(console.getIntegerInput("Place your bet"));
        Integer turnCount = 0;
        game.setCurrentPlayer(-1);
        this.isRunning = true;
        while(isRunning){
            turnCount++;
            this.nextPlayer();
            //game.getDice().tossAndSum();
            executeTurn();
             isGameOver(game.checkWinner(game.getCurrentPlayer()));
        }
        System.out.println("game over after, player " + game.getCurrentPlayer() + " wins");
    }

    public void isGameOver(boolean playerWon){
        if(playerWon){
            isRunning = false;
        }
    }
    public void nextPlayer(){
        game.nextPlayer();
    }

    public void executeTurn(){
        Integer currentPlayer = game.getCurrentPlayer();
        game.setPlayerBeetles(currentPlayer, game.getDice().tossAndSum());
    }

    /**
     * Calculate player's winning payout amount of bet x multiplier
     * @return (double) amount of money winnings
     */
    public Integer calculateWinnings(Integer multiplier, Integer betAmount){
        return 0;
    }

    /**
     * Subtract the bet amount from player's balance
     */
    public void subtractBetFromBalance(Integer betAmount){

    }


    /**
     * Add winnings amount to player's balance
     */
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings){

    }

    public void initGame(Integer players){
        this.game = new Beetle(this.players.size());
        this.isRunning = true;
        this.run();
    }

    public Boolean getIsRunning(){
        return this.isRunning;
    }

    public Integer getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(Integer betAmt) {
        this.betAmt = betAmt;
    }

    public void printWelcome() {
        console.print(
                "\u001B[33m***********************************\n" +
                        "***                             ***\n" +
                        "******   WELCOME TO BEETLE   ******\n" +
                        "***                             ***\n" +
                        "***********************************");
    }


    public void printBalanceAndBetText(){
        console.newLine();
        console.println("\u001B[35m Current account balance:        " + this.player.getArcadeAccount().getAccountBalance());
        console.newLine();
        
    }

}
