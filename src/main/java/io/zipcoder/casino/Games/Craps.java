package io.zipcoder.casino.Games;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Models.Dice;
import io.zipcoder.casino.Players.Player;

public class Craps implements GamblingGame {

    private Dice dice1;
    private Dice dice2;
    private Long numberOfTurns;
    private Double pot;

    public void updateDisplay(){

    }

    public void setUp(){

    }

    public void takeTurn(){

    }

    public void quitGame(){

    }

    public void winning(){

    }

    public void losing(){

    }

    public void receiveBetFromPlayer(Double bet){

    }
    public void giveWinningsToPlayer(Double winnings){

    }
    public Double checkPlayersBalance(Player currentPlayer){
        return null;
    }
    public boolean enoughMoneyForBet(Double bet, Player currentPlayer){
        return false;
    }


}
