package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;

public class Craps extends DiceGame implements GamblingGame {

    private int pointNumber;
    private int comePointNumber;
    private CrapsPlayer crapsPlayer;
    Console crapsConsole;
    private ArrayList<Dice> rolledDice;
    private Integer summedRoll;
    private Boolean pointOn;

    private double passLinePot;
    private double passLineOddsPot;
    private double comeLinePot;
    private double comeLineOddsPot;
    private double hardWaysPot;
    private double fieledPot;
    private double placePot;

    ArrayList<Integer> fieldNumbers = new ArrayList<Integer>();
    ArrayList<Integer> pointNumbers = new ArrayList<Integer>();
    ArrayList<Integer> winningPointLineNumbers = new ArrayList<Integer>();
    ArrayList<Integer> losingPointNumbers = new ArrayList<Integer>();


    public Craps(Player player) {
        this.crapsPlayer = new CrapsPlayer(player);
        this.rolledDice = new ArrayList<>();
        this.summedRoll = 0;
        this.passLinePot = 0.0;
        this.fieledPot = 0.0;

        Collections.addAll(fieldNumbers, 2, 3, 4, 9, 10, 11, 12);
        Collections.addAll(pointNumbers, 4, 5, 6, 8, 9, 10);
        Collections.addAll(winningPointLineNumbers, 7, 11);
        Collections.addAll(losingPointNumbers, 2, 3, 12);
    }



    public void play() {
        boolean playing = false;
        pointOn = false;
        boolean comeLine = false;
        boolean startPromt = false;
        boolean roll = false;
        crapsConsole = Console.getInstance();
        String input = "";

        String phase1Options = "Type 'pass line' to place a pass line bet.\n" +
                "Type 'field' to place field bet.\n" +
                "Type roll to roll the dice";

        String phase2Options = "Type 'pass line odds' to place pass line odds bet.\n" +
                "Type 'come line' to place a come line bet. \n" +
                "Type 'field' to place a field bet.\n" +
                "Type 'hardway' to plce a hardway bet. \n" +
                "Type 'place' to choose a place bet\n" +
                "Type roll to roll the dice";

        while (!startPromt) {
            input = crapsConsole.getStringInput("\nHello %s!  Welcome to Craps!  Type 'Start' to begin!", crapsPlayer.getName());

            if (input.toLowerCase().equals("start")) {
                startPromt = true;
                playing = true;
            }
        }


        while (playing) {

            if (!pointOn && !comeLine) {

                while (!roll) {
                    roll = askForRoll(roll, phase1Options);
                }
                summedRoll = rollDice();

                checkFieldBetWinner(summedRoll, fieledPot);
                checkPassLineBetWinner(summedRoll, passLinePot);
                roll = false;
                summedRoll = 0;

            }

            if (pointOn && !comeLine) {
                while (!roll) {
                    roll = askForRoll(roll, phase2Options);


                    summedRoll = rollDice();
                    checkPassLineBetPhase2(summedRoll, passLinePot);
                    checkFieldBetWinner(summedRoll, fieledPot);
                    summedRoll = 0;
                }
            }
        }
    }

    private boolean askForRoll(boolean roll, String phase1Options) {
        String input;
        input = crapsConsole.getStringInput(phase1Options).toUpperCase().replaceAll(" ", "_");

        if (input.equals("ROLL")) {
            roll = true;
        } else {
            CrapsActions.valueOf(input).perform(this, askForBet());
        }
        return roll;
    }


    public void walkAway() {

    }

    public double payout() {
        return 0;
    }


    public void passLineBet(Double amount) {
        crapsPlayer.bet(amount);
        passLinePot += amount;
    }

//    public void passLineOddsBet(Double amount) {
//        crapsPlayer.bet(amount);
//        passLineOddsPot += amount;
//    }
//
//    public void comeLineBet(Double amount) {
//        crapsPlayer.bet(amount);
//        comeLinePot += amount;
//    }
//
//    public void comeLineOddsBet(Double amount) {
//        crapsPlayer.bet(amount);
//        comeLineOddsPot += amount;
//    }
//
//    public void hardWayBet(Double amount) {
//        crapsPlayer.bet(amount);
//        hardWaysPot += amount;
//    }
//
    public void fieldBet(Double amount) {
        crapsPlayer.bet(amount);
        fieledPot += amount;
    }

    public void placeLineBet(Double amount) {
        crapsPlayer.bet(amount);
        placePot += amount;
    }

    public Double askForBet() {
        Double inputBetAmount = crapsConsole.getDoubleInput("\nPlease enter your bet amount.");
        return inputBetAmount;
    }

    public void clearPassLinePot() {
        this.passLinePot = 0;
    }

    public void clearfieldPot() {
        this.fieledPot = 0;
    }

    public void clearComeLinePot() {
        this.comeLinePot = 0;
    }

    private void clearPassLineOddsPot() {
        this.passLineOddsPot = 0;
    }


    public void printWallet() {
        System.out.println(crapsPlayer.getWallet());
    }

    public Double getPassLinePot(){
        return passLinePot;
    }

    public Double getFieldBet(){
        return fieledPot;
    }

    public void checkFieldBetWinner(int sumofRoll, Double betAmount) {
        if (fieldNumbers.contains(sumofRoll) && betAmount > 0) {
            System.out.println("You won " + fieledPot + " on your Field bet");
            crapsPlayer.collectCraps(fieledPot, 2);
        } else if (!fieldNumbers.contains(sumofRoll) && betAmount > 0) {
            System.out.println("You lost " + fieledPot + " on your field bet");
        }
        clearfieldPot();
    }

    public void checkPassLineBetWinner(int sumofRoll, Double betAmount) {
        if (winningPointLineNumbers.contains(sumofRoll) && betAmount > 0) {
            System.out.println("You won " + passLinePot + " on your Pass Line bet");
            crapsPlayer.collectCraps(passLinePot, 2);
            clearPassLinePot();
        } else if (pointNumbers.contains(sumofRoll)) {
            System.out.println("The point is now set at " + sumofRoll);
            pointOn = true;
            pointNumber = sumofRoll;
        } else {
            System.out.println("You lost " + passLinePot + " on you Pass Line bet");
        }
        clearPassLinePot();
    }

    public void checkPassLineBetPhase2(int sumofRoll, Double betAmount) {
        if (sumofRoll == pointNumber) {
            System.out.println("You won " + passLinePot + " on your Pass Line bet");
            crapsPlayer.collectCraps(passLinePot, 2.0);
            clearPassLinePot();
            pointOn = false;
        } else if (sumofRoll == 7) {
            System.out.println("You lost " + passLinePot + " on your Pass Line bet");
            clearPassLinePot();
            pointOn = false;
        }
    }

    public Integer rollDice() {
        rolledDice = (crapsPlayer.rollDice(2));
        summedRoll += crapsPlayer.sumOfRoll(rolledDice);
        System.out.println("You rolled " + summedRoll);
        return summedRoll;
    }

    public CrapsPlayer getCrapsPlayer() {
        return this.crapsPlayer;
    }

    public int getPointNumber() {
        return this.pointNumber;
    }

    public void setPointNumber(int numberRolled){
        pointNumber = numberRolled;
    }

    public boolean getPointOn() {
        return pointOn;
    }

    public void setPointOn() {
        this.pointOn = true;
    }

    public void setPointOff() {
        this.pointOn = false;
    }

}
