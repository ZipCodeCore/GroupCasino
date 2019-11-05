package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.people.dealers.Dealer;
import models.people.players.Player;

public class KlondikeGame extends DiceGame implements Game, GamblingGame {
    Double betAmount = 0.00;
    Double minimumBet;
    Dealer dealer;


    public KlondikeGame(Player player, Dealer klondikeDealer) {
        this.player = player;

    }

    public String dealerRoll() {
        return null;
    }

    public String playerRoll() {
        return null;
    }

    public Double payOut() {
        return null;
    }

    public Double addToBet() {
        return null;
    }

    public void setMinimumBet(Double minimumBet) {
        this.minimumBet = minimumBet;
    }


}
