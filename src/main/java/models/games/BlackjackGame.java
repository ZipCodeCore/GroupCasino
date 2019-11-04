package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.people.dealers.Dealer;
import models.people.players.Player;

public class BlackjackGame extends CardGame implements Game, GamblingGame {

    Double minimumBet;
    Double betAmount;


    public BlackjackGame(){

    }

    public Double addToBet() {
        return null;
    }

    public Double payOut() {
        return null;
    }

    public void setMinimumBet(Double minimumBet) {
        this.minimumBet = minimumBet;
    }

    public Boolean playerTurn(Player blackjackPlayer) {
        return null;
    }

    public Boolean dealerTurn(Dealer blackjackDealer) {
        return null;
    }

}
