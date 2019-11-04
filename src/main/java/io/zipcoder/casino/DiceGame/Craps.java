package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Collections;

public class Craps extends DiceGame implements GamblingGame {

    Console crapsConsole = Console.getInstance();

    private CrapsPlayer crapsPlayer;
    private ArrayList<Dice> rolledDice;
    private Integer summedRoll;
    private Boolean pointOn;

    private int pointNumber;
    private int comePointNumber;
    private int hardwayNumber;

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
        this.hardWaysPot = 0.0;

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


        String input = "";

        String phase1Options = "Type 'pass line' to place a pass line bet.\n" +
                "Type 'field' to place field bet.\n" +
                "Type 'hardway' to place a hardway bet\n" +
                "Type roll to roll the dice \n";

        String phase2Options = "Type 'field' to place a field bet.\n" +
                "Type pass line odds to place odds on the pass line. \n" +
                "Type 'hardway' to place a hardway bet. \n" +
                "Type roll to roll the dice. \n";

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
                rolledDice = rollDice();
                summedRoll = rollDiceSum(rolledDice);

                checkFieldBetWinner(summedRoll, fieledPot);
                checkPassLineBetWinner(summedRoll, passLinePot);
                checkHardwayWinner(summedRoll,hardWaysPot,rolledDice);

                roll = false;
                summedRoll = 0;
                printWallet();

            }

            if (pointOn && !comeLine) {
                while (pointOn) {
                    askForRoll(roll, phase2Options);

                    rolledDice = rollDice();
                    summedRoll = rollDiceSum(rolledDice);

                    checkPassLineBetPhase2(summedRoll, passLinePot);
                    checkFieldBetWinner(summedRoll, fieledPot);
                    checkPassLineOddsWinner(summedRoll,passLineOddsPot);
                    checkHardwayWinner(summedRoll,hardWaysPot,rolledDice);

                    summedRoll = 0;
                    printWallet();
                    roll = false;
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

    public void passLineOddsBet(Double amount) {
        crapsPlayer.bet(amount);
        passLineOddsPot += amount;
    }
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
    public void hardWayBet(Double amount) {
        crapsPlayer.bet(amount);
        hardWaysPot += amount;
        hardwayNumber = crapsConsole.getIntegerInput("Please enter the number of the Hardway roll you would like to bet on");
    }

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

    public void clearHardwayPot() {
        this.hardWaysPot = 0;
    }

    private void clearPassLineOddsPot() {
        this.passLineOddsPot = 0;
    }


    public void printWallet() {
        System.out.println("Your current wallet is " + crapsPlayer.getWallet() + "\n");
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
            setPointOn();
            setPointNumber(sumofRoll);
        } else {
            System.out.println("You lost " + passLinePot + " on you Pass Line bet");
            clearPassLinePot();
        }
    }

    public void checkPassLineBetPhase2(int sumofRoll, Double betAmount) {
        if (sumofRoll == pointNumber && betAmount > 0) {
            System.out.println("You won " + passLinePot + " on your Pass Line bet");
            crapsPlayer.collectCraps(passLinePot, 2.0);
            clearPassLinePot();
            setPointOff();
        } else if (sumofRoll == 7) {
            System.out.println("You lost " + passLinePot + " on your Pass Line bet");
            clearPassLinePot();
            setPointOff();
        }
    }

    public void checkPassLineOddsWinner(int sumofRoll, Double betAmount) {
        if (sumofRoll == pointNumber && betAmount > 0) {
            System.out.println("You won " + passLineOddsPot + " on your Pass Line Odds");
            crapsPlayer.collectCraps(passLineOddsPot, 2.0);
            clearPassLineOddsPot();
            setPointOff();
        } else if (sumofRoll == 7) {
            System.out.println("You lost " + passLineOddsPot + " on your Pass Line Odds");
            clearPassLineOddsPot();
            setPointOff();
        }
    }

    public void checkHardwayWinner(int sumofRoll, Double betAmount, ArrayList<Dice> rolledDice) {
        if(sumofRoll == hardwayNumber && betAmount > 0) {
            if(areDiceTheSame(rolledDice)) {
                System.out.println("You won " + hardWaysPot + " on your hardway bet");
                clearHardwayPot();
            } else {
                System.out.println("You lost " + hardWaysPot + " on your hardway bet");
                clearHardwayPot();
            }
        }
    }

    public ArrayList<Dice> rollDice() {
        rolledDice = (crapsPlayer.rollDice(2));
        return rolledDice;
    }

    public Integer rollDiceSum(ArrayList<Dice> lastRoll) {
        summedRoll += crapsPlayer.sumOfRoll(lastRoll);
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

    public Double getPassLinePot(){
        return passLinePot;
    }

    public Double getFieldBet(){
        return fieledPot;
    }

    public Double getHardwayBet(){
        return hardWaysPot;
    }

    public void setPointOn() {
        this.pointOn = true;
    }

    public void setPointOff() {
        this.pointOn = false;
    }

    public void setHardWayPot(Double amount) {
        this.hardWaysPot = amount;
    }

    public boolean areDiceTheSame(ArrayList<Dice> diceRolled) {
        if (diceRolled.get(0).getValue() == diceRolled.get(1).getValue()){
            return true;
        } else {
            return false;
        }
    }

}
