package io.zipcoder.casino.Player;

public class GamblingPlayer implements io.zipcoder.casino.Interfaces.GamblingPlayer {

    Player gambler;

    public GamblingPlayer(Player user){
        this.gambler = user;
    }

    public String placeWage(double wageAmount) {
        if(gambler.balance < wageAmount) {return "You can't afford that bet";}
        else {gambler.balance -= wageAmount;
        return "Betting done";}
    }

    public void getWinnings(double winnings){
        gambler.balance += winnings;
    }
}
