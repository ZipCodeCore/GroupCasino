package io.zipcoder.casino.Player;

public class GamblingPlayer implements io.zipcoder.casino.Interfaces.GamblingPlayer {

    Player gambler;
    Double pot;

    public GamblingPlayer(Player user){
        this.gambler = user;
    }

    public Boolean placeWage(double wageAmount) {
        if(gambler.balance < wageAmount) {return false;}
        else {gambler.balance -= wageAmount;
            this.pot = wageAmount;
        return true;}
    }

    public void getWinnings(){
        gambler.balance += pot * 2;
    }
}
