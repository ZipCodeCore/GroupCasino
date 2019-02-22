package io.zipcoder.casino.Interfaces;


import io.zipcoder.casino.Players.Player;

public interface GamblingGame extends Game{

    public void receiveBetFromPlayer(Double bet);
    public void giveWinningsToPlayer(Double winnings);
    public Double checkPlayersBalance(Player currentPlayer);
    public boolean enoughMoneyForBet(Double bet, Player currentPlayer);

}
