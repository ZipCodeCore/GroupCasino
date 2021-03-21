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

    private Integer input = 0;
    private Integer innerInput = 0;
    private Integer furtherInput = 0;
    private Integer yetFurtherInput = 0;

    private Boolean[] outcomes;
    private Boolean[] bets;
    private Double[] betAmounts;
    private Double lastBet = 0.0;
    private Integer point = 0;

    Boolean haventAnswered = true;
    Boolean noPointSet = true;
    Boolean firstRoll = true;
    Boolean decisionUnmade = true;
    Boolean notSevenedOut = true;

    public CrapsV2(Player player) {
        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);
        this.d = new Display();
        this.player = player;
        this.cd = new CrapsDisplay();

        this.outcomes = new Boolean[21];
        this.bets = new Boolean[21];
        this.betAmounts = new Double[21];

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
                outerSwitch(input);
            }
            decisionUnmade = true;
            if(firstRoll){
                cd.printComeOutRoll();
                firstRoll = false;
            }
            Integer x = diceRollSum(2);
            cd.printShooterRolled(x);
            checkBetsPrePoint(x);
            oneRollReset();
            if(x == 4 || x == 5 || x == 6 || x == 8 || x == 9 || x == 10){
                point = x;
                noPointSet = false;
                cd.printThatPoint();
            } else {
                cd.printNoPoint();
            }
        }

        while(notSevenedOut) {
            while (decisionUnmade) {
                cd.printSetTypeOfBet();
                input = c.getIntegerInput("Type 0 for no bet, 2 for 'come,' 3 for 'don't come,' or 4 for a proposition.");
                outerSwitch(input);
            }
            decisionUnmade = true;
            Integer x = diceRollSum(2);
            cd.printShooterRolled(x);
            checkBetsPostPoint(x);
            oneRollReset();
            if(x == 7){
                notSevenedOut = false;
                d.setPrintCurrentDisplay(endGame());
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

    public void outerSwitch(Integer input) {
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
                if (noPointSet) {
                    furtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 7, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                    oneRollPropSwitch(furtherInput);
                }
                else{
                    furtherInput = c.getIntegerInput("Type 1 to bet the field, 2 for a place bet, or 3 for a one-roll bet.");
                    postPointPropSwitch(furtherInput);
                }
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

    public void postPointPropSwitch(Integer x){
        switch(furtherInput) {
            case 1:
                acceptBetFrom(4.0);
                break;
            case 2:
                yetFurtherInput = c.getIntegerInput("Type the number you want to make your place bet on (4, 5, 6, 8, 9, or 10, but not the point.");
                if (yetFurtherInput == point) {
                    cd.printErrorMessage();
                }
                switch (yetFurtherInput) {
                    case 4:
                        acceptBetFrom(5.0);
                        break;
                    case 5:
                        acceptBetFrom(6.0);
                        break;
                    case 6:
                        acceptBetFrom(7.0);
                        break;
                    case 8:
                        acceptBetFrom(8.0);
                        break;
                    case 9:
                        acceptBetFrom(9.0);
                        break;
                    case 10:
                        acceptBetFrom(10.0);
                        break;
                    default:
                        cd.printErrorMessage();
                }
            case 3:
                yetFurtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 7, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                oneRollPropSwitch(yetFurtherInput);
        }
    }

    public void checkBetsPrePoint(Integer x){
        checkBetsConst(x);
        if(x == 2 && bets[1]){ //pass
            player.makeBet(betAmounts[1] * 2);
            cd.printCraps();
            cd.printWinnings(betAmounts[1] * 2);
        }
        if(x == 3 && bets[1]){ //pass
            player.makeBet(betAmounts[1] * 2);
            cd.printCraps();
            cd.printWinnings(betAmounts[1] * 2);
        }
        if(x == 7 && bets[0]){ //pass
            player.makeBet(betAmounts[0] * 2);
            cd.printNatural();
            cd.printWinnings(betAmounts[0] * 2);
        }
        if(x == 11 && bets[0]){ //pass
            player.makeBet(betAmounts[0] * 2);
            cd.printNatural();
            cd.printWinnings(betAmounts[0] * 2);
        }
        if(x == 12 && bets[1]){ //pass
            player.makeBet(betAmounts[1]);
            cd.printCraps();
            cd.printPush();
        }
    }

    public void checkBetsPostPoint(Integer x){
        checkBetsConst(x);
        if(x == point){
            bets[3] = false;
            betAmounts[3] = 0.0;
        }
        if(x == 7){
            bets[2] = false;
            betAmounts [2] = 0.0;
        }
        if(x == point && bets[2]){
            player.makeBet(betAmounts[2]);
            cd.printShooterScores();
            cd.printWinnings(betAmounts[2]);
        }
        if(x == 7 && bets[3]){
            player.makeBet(betAmounts[3] * 2);
            cd.printShooterSevenedOut();
            cd.printWinnings(betAmounts[3] * 2);
        }
        if(x == 3 && bets[4] || x == 4 && bets[4] || x == 9 && bets[4] || x == 10 && bets[4] || x == 11 && bets[4]){
            player.makeBet(betAmounts[4] * 2);
            cd.printWinnings(betAmounts[4] * 2);
        }
        if(x == 2 && bets[4] || x == 12 && bets[4]){
            player.makeBet(betAmounts[4] * 4);
            cd.printWinnings(betAmounts[4] * 4);
        }
        if(x == 4 && bets[5]){
            player.makeBet(betAmounts[5] * 2);
            cd.printWinnings(betAmounts[5] * 2);
        }
        if(x == 5 && bets[6]){
            player.makeBet(betAmounts[6] * 2);
            cd.printWinnings(betAmounts[6] * 2);
        }
        if(x == 6 && bets[7]){
            player.makeBet(betAmounts[7] * 2);
            cd.printWinnings(betAmounts[7] * 2);
        }
        if(x == 8 && bets[8]){
            player.makeBet(betAmounts[8] * 2);
            cd.printWinnings(betAmounts[8] * 2);
        }
        if(x == 9 && bets[9]){
            player.makeBet(betAmounts[9] * 2);
            cd.printWinnings(betAmounts[9] * 2);
        }
        if(x == 10 && bets[10]){
            player.makeBet(betAmounts[10] * 2);
            cd.printWinnings(betAmounts[10] * 2);
        }
    }

    public void checkBetsConst(Integer x){
        if(x == 2 && bets[19]){
            player.makeBet(betAmounts[19] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[19] * 60);
        }
        if(x == 2 && bets[12]){
            player.makeBet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 3 && bets[17]){
            player.makeBet(betAmounts[17] * 30);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[17] * 30);
        }
        if(x == 3 && bets[12]){
            player.makeBet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 4 && bets[15]){
            player.makeBet(betAmounts[15] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[15] * 14);
        }
        if(x == 6 && bets[13]){
            player.makeBet(betAmounts[13] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[13] * 18);
        }
        if(x == 7 && bets[11]){
            player.makeBet(betAmounts[11] * 8);
            cd.printNatural();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[11] * 8);
        }
        if(x == 8 && bets[14]){
            player.makeBet(betAmounts[14] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[14] * 18);
        }
        if(x == 10 && bets[16]){
            player.makeBet(betAmounts[16] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[16] * 14);
        }
        if(x == 11 && bets[18]){
            player.makeBet(betAmounts[18] * 30);
            cd.printOneRollBetWin();
            cd.printNatural();
            cd.printWinnings(betAmounts[18] * 30);
        }
        if(x == 12 && bets[20]){
            player.makeBet(betAmounts[20] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[20] * 60);
        }
        if(x == 12 && bets[12]){
            player.makeBet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
    }

    public void oneRollReset(){
        bets[4] = false;
        betAmounts[4] = 0.0;
        for(int i = 11; i < 21; i++){
            bets[i] = false;
            betAmounts[i] = 0.0;
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