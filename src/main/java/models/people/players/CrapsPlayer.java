package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Dice;

public class CrapsPlayer implements GamblingPlayer {
    Player crapsPlayer;

    public CrapsPlayer(Player player) {
        this.crapsPlayer = player;
    }

    public Double placeBet() {
        return null;
    }

    public Integer rollDice(Dice dice){
        return null;
    }


}

