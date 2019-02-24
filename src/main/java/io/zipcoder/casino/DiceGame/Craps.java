package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.utilities.Console;

public class Craps extends DiceGame implements GamblingGame {

    private int buttonNumber;
    private CrapsPlayer crapsPlayer;
    private double passLinePot;
    private double passLineOddsPot;
    private double comeLinePot;
    private double comeLineOddsPot;
    private double hardWaysPot;
    private double fieledPot;
    private double placePot;

    public void play() {
        boolean play = false;
        Console crapsConsole = Console.getInstance();


    }

    public void walkAway() {

    }

    public double payout() {
        return 0;
    }


    public void passLineBet(Double amount){
        crapsPlayer.bet(amount);
        passLinePot += amount;
    }

    public void passLineOddsBet(Double amount){
        crapsPlayer.bet(amount);
        passLineOddsPot += amount;
    }

    public void comeLineBet(Double amount){
        crapsPlayer.bet(amount);
        comeLinePot += amount;
    }

    public void comeLineOddsBet(Double amount){
        crapsPlayer.bet(amount);
        comeLineOddsPot += amount;
    }

    public void hardWayBet(Double amount){
        crapsPlayer.bet(amount);
        hardWaysPot += amount;
    }

    public void fieldBet(Double amount){
        crapsPlayer.bet(amount);
        fieledPot += amount;
    }

    public void placeLineBet(Double amount){
        crapsPlayer.bet(amount);
        placePot += amount;
    }


}
