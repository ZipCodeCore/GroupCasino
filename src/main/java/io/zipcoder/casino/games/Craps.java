package io.zipcoder.casino.games;

import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;
import java.util.TreeMap;

public class Craps extends Games implements GamblerGameInterface {
    private CrapsPlayer crapsPlayer;
    public CrapsDataHandler data = new CrapsDataHandler();
    private Integer stage;
    private Boolean comeFirstRound = true;
    private Boolean passFirstRound = true;



    public Craps() {}

    public Craps(CrapsPlayer player) {
        this.crapsPlayer = player;
        crapsPlayer.player.setPlaying(true);
        this.stage = 0;

    }

    public Craps(CrapsPlayer player, Console console) {
        this.crapsPlayer = player;
        data.setConsole(console);
        crapsPlayer.player.setPlaying(true);
        this.stage = 0;

    }

    public void runGame() {
        display("Welcome to the table " + crapsPlayer.player.getName() + "! \n");
        while(crapsPlayer.player.getPlaying() == true) {

            switch (stage) {
                case 0:
                    String input = data.getConsole().getStringInput("A game has just ended would you like to join the table? (play or exit?) ");
                    stage0Play(input);
                    break;
                case 1:
                    if (comeFirstRound) {
                        data.setFirstLineBet(data.getConsole().getDoubleInput("Let's get started! \n" + ""+"Place Your Come bets!"));
                    }
                    if(hasMoenytoBet(data.getFirstLineBet(), crapsPlayer.player)){
                        data.setCurrentRoll(crapsPlayer.roll());
                        stage1Play(data.getFirstLineBet());
                    }
                    break;
                case 2:
                    if(passFirstRound) {
                        data.setSecondLineBet(data.getConsole().getDoubleInput(" Make your passline bets!"));
                        data.setFieldBetType(data.getConsole().getIntegerInput("What prop number bet do you want to make?"));
                        data.setFieldBet(data.getConsole().getDoubleInput("how much do you want to bet on this?"));
                    }
                    if(hasMoenytoBet(data.getSecondLineBet() + data.getFieldBet(), crapsPlayer.player)){
                        data.setCurrentRoll(crapsPlayer.roll());
                        stage2Play(data.getSecondLineBet(), data.getFieldBet(), data.getFieldBetType());
                        }
                    break;
            }
        }
        endGame();
    }

/*----------------STAGE 0---------------*/

    public void stage0Play(String input){

        if(input.toLowerCase().equals("play")) {
            this.stage = 1;
        } else if (input.toLowerCase().equals("exit")){
            crapsPlayer.player.setPlaying(false);
        } else {
            display("Excuse me, I didnt understand");
        }
    }

/*----------------STAGE 1---------------*/


    public void stage1Play(Double firstLineBet){
        if (comeFirstRound)
        withdraw(firstLineBet);
        comeFirstRound= false;

        if(data.getCurrentRoll().equals(2) || data.getCurrentRoll().equals(3) || data.getCurrentRoll().equals(12)) {
            display(" you rolled a " + data.getCurrentRoll() +  "\n" + "Sorry you crapped out!  \n you now have " + crapsPlayer.player.getAccount());
            stage = 0;
            comeFirstRound = true;
            passFirstRound = true;
        } else if (data.getCurrentRoll().equals(7) || data.getCurrentRoll().equals(11)) {
            deposit(calcPayment(firstLineBet, data.getFirstLineOdds()));
            display(" you rolled a " + data.getCurrentRoll() +  "\n" + "you won " +  calcPayment(data.getFirstLineOdds(), firstLineBet) + "! you now have " + crapsPlayer.player.getAccount());
        } else if(!data.getCurrentRoll().equals(2) && !data.getCurrentRoll().equals(3) && !data.getCurrentRoll().equals(12) && !data.getCurrentRoll().equals(7) && !data.getCurrentRoll().equals(11)){
            display(" you rolled a " + data.getCurrentRoll() +  ".\n" + data.getCurrentRoll() + " is now the on number!");
            data.setOnNumber(data.getCurrentRoll());
            stage = 2;
        } else {
        display("Excuse me, I didnt understand");
        }
    }


/*-----------------STAGE 2----------------*/


    public void stage2Play(Double secondLineBet, Double fieldBet, Integer fieldBetNumber ){
        if(passFirstRound) {
            withdraw(secondLineBet);
            withdraw(fieldBet);
        }
        passFirstRound = false;
        if(data.getCurrentRoll().equals(7)) {
            display(" you rolled a " + data.getCurrentRoll() +  "\n" + "Sorry you crapped out!  \n you now have " + crapsPlayer.player.getAccount());
            stage = 0;
            comeFirstRound = true;
            passFirstRound = true;
        } else if (data.getCurrentRoll().equals(fieldBetNumber)) {
            Double wins = calcPayment(fieldBet, data.getfieldOdds(fieldBetNumber));
            deposit(wins);
            display(" you rolled a " + data.getCurrentRoll() + "\n" + "you won " + wins + "! you now have " + crapsPlayer.player.getAccount());
        }else if (data.getCurrentRoll().equals(data.getOnNumber())) {
            Double wins =  calcPayment(data.getfieldOdds(data.getOnNumber()), secondLineBet) + calcPayment(data.getfieldOdds(data.getOnNumber()), data.getFirstLineBet());
            deposit(wins);
            display(" you rolled a " + data.getCurrentRoll() + "\n" + "you won " + wins + "! you now have " + crapsPlayer.player.getAccount());
        } else {
            display("Excuse me, I didn't understand");
        }

    }

    @Override
    void endGame() {
        Handler handler = new Handler();
        handler.run();
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
        return bet * odds;
    }


    public Boolean hasMoenytoBet(Double bet, Player player) {
        if (bet > player.getAccount()){
            display("Not enought Money!!! \n you only have - " +
                    crapsPlayer.player.getAccount());
            return false;
        } else return  true;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Override
    void nextTurn() {
    }

}
