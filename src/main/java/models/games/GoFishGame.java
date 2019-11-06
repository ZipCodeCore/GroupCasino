package models.games;

import Interfaces.Game;
import models.people.dealers.Dealer;
import models.people.players.Player;

public class GoFishGame extends CardGame implements Game {
    Player player;
    Dealer dealer;



    public GoFishGame(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public Boolean playerTurn(Player goFishPlayer) {
        return null;
    }

    public Boolean dealerTurn(Dealer goFishDealer) {
        return null;
    }
    public void getMenu() {
        Integer input2 = console.getIntegerInput(
                "\nDo you need instructions for this game?\n\n" +
                        "1. Yes, I don't want to lose my money that easy\n" +
                        "2. Heck no, I'm a baller.\n");
    }

    public void startGame() {

    }


}
