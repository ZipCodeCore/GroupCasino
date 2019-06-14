package io.zipcoder.casino.games;

import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;
import java.util.TreeMap;

public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer;
    private Integer onNumber;
    private Double firstLineBet;
    private Double secondLineBet;
    private Double fieldBet;
    private Integer fieldBetType;
    private Double firstLineOdds = 2.0;
    private Double secondLineOdds = 2.0;
    private Double fieldBetodds = 12.0;
    private Integer currentRoll;
    //private HashMap<Integer , Integer> fieldOdds = new HashMap();





    private Integer stage;
    Console console = new Console(System.in, System.out);

    public Craps() {
    };

    public Craps(CrapsPlayer player) {
        this.crapsPlayer = player;
        crapsPlayer.player.setPlaying(true);
        this.stage = 0;

    }





    public void runGame() {
        display("Welcome to the table " + crapsPlayer.player.getName() + "! \n");
        while(crapsPlayer.player.getPlaying() == true) {

            switch (stage) {
                case 0:
                    String input = console.getStringInput("A game has just ended would you like to play or exit? ");
                    stage0Play(input);
                    break;
                case 1:
                    firstLineBet = (console.getDoubleInput("Let's get started! \n Place Your bet!"));
                    currentRoll = crapsPlayer.roll();
                    stage1Play(firstLineBet);
                    break;
                case 2:
                    secondLineBet = console.getDoubleInput("Bet your push number bets! \n Place Your bet!");
                    fieldBetType = console.getIntegerInput("What else do you want to bet?");
                    fieldBet = console.getDoubleInput("how much do you want to bet on this?");
                    currentRoll =crapsPlayer.roll();
                    stage2Play(secondLineBet, fieldBet, fieldBetType);
                    break;
            }
        }

        endGame();
    }


    public void stage0Play(String input){

        if(input.toLowerCase().equals("play")) {
            this.stage = 1;
        } else if (input.toLowerCase().equals("exit")){
            crapsPlayer.player.setPlaying(false);
        } else {
            display("Excuse me I didnt understand");
        }
    }

    public void stage1Play(Double firstLineBet){
        withdraw(firstLineBet);

        if(currentRoll.equals(2) || currentRoll.equals(3) || currentRoll.equals(12)) {
            display(" you rolled a " + currentRoll +  "\n" + "Sorry you crapped out!");
            this.stage = 0;
        } else if (currentRoll.equals(7) || currentRoll.equals(11)) {
            display(" you rolled a " + currentRoll +  "\n" + "you won!" +  calcPayment(firstLineOdds, firstLineBet));
            deposit(calcPayment(firstLineBet, firstLineOdds) + firstLineBet);
        } else{
            display(" you rolled a " + currentRoll +  ".\n" + currentRoll + " is now the on number!");
            setOnNumber(currentRoll);
            this.stage = 2;
        }

    }

    public void stage2Play(Double secondLineBet, Double fieldBet, Integer bet ){
//


//        if(currentRoll.equals(7)) {
//            display(" you rolled a " + currentRoll +  "\n" + "Sorry you crapped out!");
//            this.stage = 0;
//        } else if (currentRoll.equals(onNumber)) {
//            display(" you rolled a " + currentRoll +  "\n" + "you won!" +  (calcPayment(firstLineOdds, firstLineBet) + (calcPayment(secondLineBet,secondLineOdds))));
//            deposit(calcPayment(firstLineBet, firstLineOdds));
//            deposit(calcPayment(otherBet, otherBetodds ));
////        }   else if () {  if other bet
////            display("");
//        }
    }

    @Override
    void endGame() {
    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        System.out.println(output);
    }

    public void withdraw(Double num) {
        Double temp = crapsPlayer.player.getAccount();
        crapsPlayer.player.setAccount(temp - num);
    }

    public void deposit(Double num) {
        Double temp = crapsPlayer.player.getAccount();
        crapsPlayer.player.setAccount(temp + num);
    }

    public Double calcPayment(Double bet, Double odds) {
        return bet *odds;
    }


    public Boolean hasMoenytoBet(Double bet, Player player) {
        if (bet > player.getAccount()){
            return false;
        } else return  true;
    }


    /*----Getters/Setters------*/

    public Integer getOnNumber() {
        return onNumber;
    }

    public void setOnNumber(Integer onNumber) {
        this.onNumber = onNumber;
    }

    public Double getFirstLineBet() {
        return firstLineBet;
    }

    public void setFirstLineBet(Double firstLineBet) {
        this.firstLineBet = firstLineBet;
    }

    public Double getSecondLineBet() {
        return secondLineBet;
    }

    public void setSecondLineBet(Double secondLineBet) {
        this.secondLineBet = secondLineBet;
    }

    public Double getFieldBet() {
        return fieldBet;
    }

    public void setFieldBet(Double fieldBet) {
        this.fieldBet = fieldBet;
    }

//    public CrapsPlayer getCrapsPlayer() {
//        return crapsPlayer;
//    }

    public Integer getStage() {
        return stage;
    }

    public Integer getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(Integer num) {
        this.currentRoll = num;
    }

    @Override
    void nextTurn() {
    }

}
