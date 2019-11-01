package io.zipcoder.casino;

public class CrapsGame extends DiceGame implements GamblingGame {

    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
    private int numberOfRolls;      //an integer from 1-4
    private int firstRoll;          //saves your first roll to try to match with later rolls
    private int currentRoll;        //any roll after the first



    @Override
    //deduct from chip balance
    public double getWager() {
        return 0;
    }

    @Override
    //adds winnings (if any) to your chip balance
    public void payOut(double amount) {

    }

    @Override
    //creates dice and runs a roundOfPlay
    public void startPlay() {

    }

    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {

    }

    @Override
    //runs a new game of craps
    public void roundOfPlay() {

    }

    public boolean winOnFirst (int firstRoll){
        return false;
    }

    public boolean loseOnFirst (int firstRoll){
        return false;
    }

    public boolean winOnSubsequent (int firstRoll, int currentRoll){
        return false;
    }

    public boolean loseOnSubsequent (int firstRoll, int currentRoll){
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
