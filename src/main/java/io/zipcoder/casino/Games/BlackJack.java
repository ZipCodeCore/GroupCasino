package io.zipcoder.casino.Games;

import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Models.Card;
import io.zipcoder.casino.Players.Player;

public class BlackJack extends CardGame implements GamblingGame {

    private final Integer max = 21;
    private final Double mindBet = 15.0;
    private BlackJackPlayer oppositePlayer;
    private Double pot;

    public void split(){

    }

    public void hit(){

    }

    public Integer getHandTotal(){
        return null;
    }

    public Card deal() {
        return null;
    }

    public Double giveWinnings(){
        return 0.0;
    }

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
