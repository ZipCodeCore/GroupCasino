package io.zipcoder.casino.games;

import io.zipcoder.casino.Casino;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.security.PrivateKey;

public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer;
    private Integer onNumber;
    private Double firstLineBet;
    private Double secondLineBet;
    private Double otherBet;
    private Double firstLineOdds = 2.0;
    private Double secondLineOdds = 2.0;
    private Integer stage;
    Console console = new Console(System.in, System.out);

    public Craps() {
    };

    public Craps(CrapsPlayer player) {
        this.crapsPlayer = player;
        this.stage = 0;
    }


    public void runGame() {
        display("Welcome to the table " + crapsPlayer.player.getName() + "! \n");
        while(crapsPlayer.player.getPlaying() == true) {

            switch (stage) {
                case 0:
                    stage0Play();
                    break;
                case 1:
                    stage1Play();
                    break;
                case 2:
                    stage2Play();
                    break;
                case 3:
                    stage3Play();
                    break;
            }
        }

    }

    public void stage0Play(){
        String input = console.getStringInput("A game has just ended would you like to play or exit? ");

        if(input.toLowerCase().equals("play")) {
            this.stage = 1;
        } else if (input.toLowerCase().equals("exit")){
            crapsPlayer.player.setPlaying(false);
        } else {
            display("Excuse me I didnt understand");
        }
    }

    public void stage1Play(){
        firstLineBet = console.getDoubleInput("Let's get started! \n Place Your bet!");
        withdraw(firstLineBet); //need to handle seeting account
        Integer roll = crapsPlayer.roll();

        if(roll.equals(2) || roll.equals(3) || roll.equals(12)) {
            display(" you rolled a " + roll +  "\n" + "Sorry you crapped out!");
            this.stage = 0;
        } else if (roll.equals(7) || roll.equals(11)) {
            display(" you rolled a " + roll +  "\n" + "you won!" +  calcPayment(firstLineOdds, firstLineBet));
            deposit(firstLineBet);
        } else{
            display(" you rolled a " + roll +  ".\n" + roll + " is now the on number!");
            setOnNumber(roll);
            this.stage = 2;
        }

    }

    public void stage2Play(){

    }
    public void stage3Play(){

    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
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

    public Double getOtherBet() {
        return otherBet;
    }

    public void setOtherBet(Double otherBet) {
        this.otherBet = otherBet;
    }

    public CrapsPlayer getCrapsPlayer() {
        return crapsPlayer;
    }

    public Double calcPayment(Double bet, Double odds) {
        return bet *odds;
    }

    @Override
    void nextTurn() {
    }



}
