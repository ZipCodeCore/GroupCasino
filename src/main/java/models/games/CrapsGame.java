package models.games;

import Interfaces.GamblingGame;
import Interfaces.Game;
import models.people.players.Player;

public class CrapsGame extends DiceGame implements Game, GamblingGame {
    Double minimumBet;
    Double betAmount = 0.00;
    public CrapsGame(){
    }

    public CrapsGame(Player player) {
        this.player = player;
    }

    public Integer firstRoll(){
        return null;

    }

    public Integer subsequentRolls(){
        return null;
    }

    public Integer setPointNumber(){
        return null;
    }

    public Double payOut() {
        return null;
    }

    public Double addToBet() {
        return null;
    }

}
