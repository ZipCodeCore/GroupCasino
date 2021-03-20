package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CrapsV2 extends DiceGame {

    private Console c;
    private Scanner s;
    private Display d;
    private InputStream in;
    private PrintStream out;
    private Player player;
    private CrapsDisplay cd;

    private Integer input;
    private Integer innerInput;
    private Integer furtherInput;
    private Integer yetFurtherInput;

    private Boolean[] outcomes;
    private Boolean[] bets;
    private Double[] betAmounts;
    private Double lastBet;
    private Integer point;

    Boolean haventAnswered;
    Boolean noPointSet;
    Boolean firstRoll;
    Boolean decisionUnmade;
    Boolean notSevenedOut;

    public CrapsV2(Player player) {
        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);
        this.d = new Display();
        this.player = player;
        this.cd = new CrapsDisplay();

        this.input = 0;
        this.innerInput = 0;
        this.furtherInput = 0;

        this.outcomes = new Boolean[21];
        this.bets = new Boolean[21];
        this.betAmounts = new Double[21];
        this.lastBet = 0.0;

        haventAnswered = true;
        noPointSet = true;
        firstRoll = true;
        decisionUnmade = true;
        notSevenedOut = true;

        for (int i = 0; i < 21; i++) {
            outcomes[i] = false;
        }

        for (int i = 0; i < 21; i++) {
            bets[i] = false;
        }

        for (int i = 0; i < 21; i++) {
            betAmounts[i] = 0.0;
        }
    }


    public void crapsEngine() {

        this.initialRulesPrompt();

        while (noPointSet) {
            while (decisionUnmade) {
                cd.printSetTypeOfBet();
                input = c.getIntegerInput("Type 0 for no bet, 2 for 'pass,' 3 for 'don't pass,' or 4 for a proposition.");
                prePointOuterSwitch(input);
            }
        }



    }



    public void initialRulesPrompt(){
        cd.initalRulesAsk();
        while(haventAnswered){
            input = c.getIntegerInput("Type 1 for yes, 2 for no.");
            initialRulesPromptSwitch(input);
        }
    }


    public void initialRulesPromptSwitch(Integer input) {
        switch (input) {
            case 1:
                cd.printRulesMenu1();
                cd.printRulesMenu2();
                d.setPrintCurrentDisplay(startGame());
                haventAnswered = false;
                break;
            case 2:
                d.setPrintCurrentDisplay(startGame());
                haventAnswered = false;
                break;
            default:
                d.setPrintCurrentDisplay("Invalid user input. Please reread instructions.");
        }
    }

    public void prePointOuterSwitch(Integer input) {
        switch(input){
            case 1:
                cd.printRulesMenu1();
                cd.printRulesMenuMid();
                innerInput = c.getIntegerInput("Type 1 for yes, 2 for no.");
                rulesMenuPt2(innerInput);
                break;
            case 2:
                acceptBetFrom(0.0);
                break;
            case 3:
                acceptBetFrom(1.0);
                break;
            case 0:
                decisionUnmade = false;
                break;
            case 4:
                furtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 7, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                oneRollPropSwitch(furtherInput);
                break;
            default:
                cd.printErrorMessage();
        }
        if(decisionUnmade) {
            cd.youCanBetAgain();
        }
    }

    public void rulesMenuPt2(Integer input) {
        switch(input){
            case 1:
                cd.printRulesMenu2();
                break;
            case 2:
                break;
            default:
                cd.printErrorMessage();
        }
    }

    public void oneRollPropSwitch(Integer input) {
        switch(input){
            case 1:
                acceptBetFrom(12.0);
                break;
            case 2:
                acceptBetFrom(19.0);
                break;
            case 3:
                acceptBetFrom(17.0);
                break;
            case 4:
                acceptBetFrom(15.0);
                break;
            case 6:
                acceptBetFrom(13.0);
                break;
            case 7:
                acceptBetFrom(11.0);
                break;
            case 8:
                acceptBetFrom(14.0);
                break;
            case 10:
                acceptBetFrom(16.0);
                break;
            case 11:
                acceptBetFrom(18.0);
                break;
            case 12:
                acceptBetFrom(20.0);
                break;
            default:
                cd.printErrorMessage();
        }
    }



    public String startGame() {
        return "Alright! Let's play Craps!";
    }

    public Double acceptBetFrom(Double betAmount) {
        Double middleMan;
        middleMan = c.getDoubleInput("How much money are you going to bet?");
        lastBet = player.makeBet(middleMan);
        Integer index = (int) Math.round(betAmount);
        betAmounts[index] = lastBet;
        bets[index] = true;
        return lastBet;
    }

    public Double calculateReward() {
        return null;
    }

    public Double calculateLoss() {
        return null;
    }

    public String endGame() {
        return "That's the end of the round!";
    }

}







