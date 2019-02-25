package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.GamblingGame;
import io.zipcoder.casino.GamblingPlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class Craps extends DiceGame implements GamblingGame {

    private int buttonNumber;
    private CrapsPlayer crapsPlayer;
    Console crapsConsole;
    private ArrayList<Dice> rolledDice;
    private Integer summedRoll;

    private double passLinePot;
    private double passLineOddsPot;
    private double comeLinePot;
    private double comeLineOddsPot;
    private double hardWaysPot;
    private double fieledPot;
    private double placePot;



    public Craps(Player player) {
        this.crapsPlayer = new CrapsPlayer(player);
        this.rolledDice = new ArrayList <>();
        this.summedRoll = 0;
        this.passLinePot = 0.0;
        this.fieledPot = 0.0;
    }

    public void play() {
        boolean playing = false;
        boolean pointOn = false;
        boolean comeLine = false;

        crapsConsole = Console.getInstance();
        String input = crapsConsole.getStringInput("\nHello %s!  Welcome to Craps!  Type 'roll' to begin!", crapsPlayer.getName());
        playing = true;

        //while playing, if the point is off and there is no come line bet (beginning of game)

        if (playing && !pointOn && !comeLine) {

            Boolean roll = false;

            while (!roll) {

                String allOptions = "Type 'pass line' to place a pass line bet.\n" +
                        "Type 'field' to place field bet.\n" +
                        "Type roll to roll the dice";

                switch (input.toLowerCase()){

                    case "pass line":
                        passLineBet(askForBet());
                        break;
                    case "field":
                        fieldBet(askForBet());
                        break;
                    case "roll":
                        roll = true;
                        break;
                }
            }
             rolledDice = (crapsPlayer.rollDice(2));
             summedRoll += crapsPlayer.sumOfRoll(rolledDice);

             if((summedRoll == 2) || (summedRoll == 3) || (summedRoll == 12)) {
                 if(passLinePot > 0){
                     System.out.println("You lost" + passLinePot + "on your Pass Line bet");
                     clearPassLinePot();
                     pointOn = true;
                 }
                 if(fieledPot > 0) {
                     System.out.println("You won " + fieledPot +" on your Field bet");
                 }



             }

             }

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

    public void comeLineBet(Double amount) {
        crapsPlayer.bet(amount);
        comeLinePot += amount;
    }

    public void comeLineOddsBet(Double amount) {
        crapsPlayer.bet(amount);
        comeLineOddsPot += amount;
    }

    public void hardWayBet(Double amount) {
        crapsPlayer.bet(amount);
        hardWaysPot += amount;
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

    public void clearPassLinePot(){
        this.passLinePot = 0;
    }


}
