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

}
