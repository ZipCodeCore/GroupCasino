package io.zipcoder.casino.Player;


//Class Starts
public class GamblingPlayer implements io.zipcoder.casino.Interfaces.GamblingPlayer {

    private Player gambler;
    private Double pot = 0.0;

    public GamblingPlayer(Player user) {
        this.gambler = user;
    }

    public Boolean placeWager(double wagerAmount) {
        if (gambler.balance < wagerAmount) {
            return false;
        } else {
            gambler.balance -= wagerAmount;
            this.pot += wagerAmount;
            return true;
        }
    }

    public void getWinnings() {
        gambler.balance += pot * 2;
    }
}
