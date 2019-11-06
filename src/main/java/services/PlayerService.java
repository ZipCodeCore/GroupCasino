package services;

import models.hands.Hand;
import models.people.players.Player;


public static class PlayerService {
    Player player1 = new Player();
    Double balance;

    public PlayerService(Player player1) {
        this.player1 = player1;
        balance = 0.0;
    }

    public static Double getBalance(Player player) {

        return player.getBalance();
    }

    public static Double depositMoney(Double depositAmt)
    {

        balance = player1.getBalance();
        balance += depositAmt;

        return balance;
    }

    public static Double withdrawMoney(Double withdrawAmt) {
        Player player1 = new Player();
        Double balance = player1.getBalance();
        balance -= withdrawAmt;

        return balance;
    }

    public static Hand resetPlayerHands(Player player) {
        return  null;

    }

}
