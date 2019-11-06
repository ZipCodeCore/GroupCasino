package services;

import models.hands.Hand;
import models.people.players.Player;


public class PlayerService {
    static Player player1 = new Player();
    static Double balance;

    public PlayerService(Player player1) {
        this.player1 = player1;
        balance = 0.0;
    }

    public Double getBalance(Player player) {
        return null;
    }

    public Double depositMoney(Double depositAmt, Player player) {
        return null;
    }

    public Double withdrawMoney(Double withdrawAmt, Player player) {
        return null;
    }

    public static Double getBalance2(Player player) {

        return player.getBalance();
    }

    public static Double depositMoney(Double depositAmt) {

        balance = player1.getBalance();
        balance += depositAmt;

        return balance;
    }

    public static Double withdrawMoney(Double withdrawAmt) {

        balance = player1.getBalance();
        balance -= withdrawAmt;

        return balance;
    }

    public Hand resetPlayerHands(Player player) {
        return  null;

    }

    public Integer getId() {
        return null;
    }





}
