package models.games;

import models.people.players.Player;

abstract class DiceGame {
    Player player;

    public DiceGame() {
    }

    public DiceGame(Player player) {
        this.player = player;
    }

    public void startGame() {

    }

    public Boolean determineWin() {
        return null;
    }

    public void quitGame() {

    }

    public void getMenu() {

    }


}
