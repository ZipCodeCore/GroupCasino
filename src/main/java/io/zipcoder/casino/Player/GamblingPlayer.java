package io.zipcoder.casino.Player;

public class GamblingPlayer implements io.zipcoder.casino.Interfaces.GamblingPlayer {

    Player gambler;
    Double pot = 0.0;

    public GamblingPlayer(Player user){
        this.gambler = user;
    }

    public Boolean placeWager(double wagerAmount) {
        if(gambler.balance < wagerAmount) {return false;}
        else {gambler.balance -= wagerAmount;
            this.pot += wagerAmount;
       return true;}
    }

    public void getWinnings(){
        gambler.balance += pot * 2;
    }
}
