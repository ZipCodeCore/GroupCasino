package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;

public class CrapsGame extends DiceGame implements Game {

    private String name = "Craps";
    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
//    private int numberOfRolls;      //an integer from 1-4
    private Integer setThePointRoll;    //saves your first roll to try to match with later rolls
    private Integer currentRoll;        //any roll after the first


    //Craps Game Constructor
    public CrapsGame (double minBet, double maxBet, Player player) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        CrapsPlayer newPlayer = new CrapsPlayer(player);
    }

    public String getName() {
        return name;
    }

    @Override
    //creates dice and runs a roundOfPlay
    public void startPlay() {
        new CrapsMenu(this).displayMenu();
        roundOfPlay();
    }

    @Override
    //runs a new game of craps
    public void roundOfPlay() {
        setThePointRoll = DiceGame.roll(2);
        if (winOnFirst(setThePointRoll) == true) {
            calculatePayout();  //write what happens
        }
        else if (loseOnFirst(setThePointRoll) == true) {
            calculatePayout();  //write what happens    I don't think we need this - we've already deducted our bet
            //and if we lose there is no payout to calculate
        }
        else {
            for (int i = 0; i < 3; i++) {
                currentRoll = DiceGame.roll(2);
                if (winOnSubsequent(currentRoll, setThePointRoll) == true) {
                    calculatePayout();
                    break;
                }
                else if (loseOnSubsequent(currentRoll) == true){
                    calculatePayout();  //again not sure if we need to calculate payout here if we've lost
                    break;
                }
            }
        }
    }
            //I think it would be cool to see a menu or display after each roll letting us know what we rolled
    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {

    }

    public boolean winOnFirst (Integer setThePointRoll){
        if (setThePointRoll == 7 || setThePointRoll == 11) {return true;}
        else {return false;}
    }

    public boolean loseOnFirst (Integer setThePointRoll){
        if (setThePointRoll == 2 || setThePointRoll == 3 || setThePointRoll == 12){return true;}
        else {return false;}
    }


    public boolean winOnSubsequent (Integer currentRoll, Integer setThePointRoll){
        if (currentRoll.equals(setThePointRoll)) {return true;}
        return false;

    }

    public boolean loseOnSubsequent (Integer currentRoll){
        if (currentRoll == 7) {return true;}
        return false;
    }

    public Integer calculatePayoutMultiplier (){
        //catch statements
        return null;
    }

    public double calculatePayout (){
        //multiplier * initial wager + initial wager
        return 0.0;
    }

}
