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

    public void getMenu() {
        Integer input2 = console.getIntegerInput(
                "\nDo you need instructions for this game?\n\n" +
                        "1. Yes, I don't want to lose my money that easy\n" +
                        "2. Heck no, I'm a baller.\n");
    }

    public void getMenu2() {

    }

    public void startGame() {

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
