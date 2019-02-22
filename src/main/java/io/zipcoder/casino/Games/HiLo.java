package io.zipcoder.casino.Games;

import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Models.Card;
import io.zipcoder.casino.Players.Player;

public class HiLo extends CardGame implements GamblingGame {

    private Card currentCard;
    private Card nextCard;

    public Card deal(){
        return null;
    }

    public boolean isLess(Card currentCard, Card nextCard){
        return false;
    }

    public boolean isMore(Card currentCard, Card nextCard){
        return false;
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
