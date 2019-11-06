package io.zipcoder.casino.Player;

public class GamblingPlayer implements io.zipcoder.casino.Interfaces.GamblingPlayer {

    Player gambler;
    Boolean wageGood;
    Double pot = 0.0;

    public GamblingPlayer(Player user){
        this.gambler = user;
    }

    public void placeWage(double wageAmount) {
        if(gambler.balance < wageAmount) {this.wageGood = false;}
        else {gambler.balance -= wageAmount;
            this.pot += wageAmount;
        this.wageGood = true;}
    }

    public void getWinnings(){
        gambler.balance += pot * 2;
    }
}
