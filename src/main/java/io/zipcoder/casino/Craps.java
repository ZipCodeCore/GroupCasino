package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Craps extends DiceGame{

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

    public Craps(Player player){
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

        for(int i = 0; i < 21; i++){
            outcomes[i] = false;
        }

        for(int i = 0; i < 21; i++){
            bets[i] = false;
        }

        for(int i = 0; i < 21; i++){
            betAmounts[i] = 0.0;
        }
    }

    /* *** Here is the index of every ***
       *** bet in the boolean arrays. ***
    0- pass
    1- don't pass
    2- come
    3- don't come
    4- field
    5- place bet 4
    6- place bet 5
    7- place bet 6
    8- place bet 8
    9- place bet 9
    10- place bet 10
    11- one-roll 7
    12- one-roll craps
    13- one-roll 6
    14- one-roll 8
    15- one-roll 4
    16- one-roll 10
    17- one-roll 3
    18- one-roll 11
    19- one-roll 2
    20- one-roll 12 */

    public void crapsEngine(){

        this.initialRulesPrompt();

        Boolean noPointSet = true;
        Boolean firstRoll = true;
        Boolean decisionUnmade = true;
        Boolean notSevenedOut = true;

        while(noPointSet){
            while(decisionUnmade) {
                cd.printSetTypeOfBet();
                input = c.getIntegerInput("Type 0 for no bet, 2 for 'pass,' 3 for 'don't pass,' or 4 for a proposition.");
                switch(input){
                    case 1:
                        cd.printRulesMenu1();
                        cd.printRulesMenuMid();
                        innerInput = c.getIntegerInput("Type 1 for yes, 2 for no.");
                        switch(innerInput){
                            case 1:
                                cd.printRulesMenu2();
                                break;
                            case 2:
                                break;
                            default:
                                cd.printErrorMessage();
                                continue;
                        }
                        break;
                    case 2:
                        chooseBetAmountAndMakeBet(0);
                        break;
                    case 3:
                        chooseBetAmountAndMakeBet(1);
                        break;
                    case 0:
                        decisionUnmade = false;
                        break;
                    case 4:
                        furtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 7, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                        switch(furtherInput){
                            case 1:
                                chooseBetAmountAndMakeBet(12);
                                break;
                            case 2:
                                chooseBetAmountAndMakeBet(19);
                                break;
                            case 3:
                                chooseBetAmountAndMakeBet(17);
                                break;
                            case 4:
                                chooseBetAmountAndMakeBet(15);
                                break;
                            case 6:
                                chooseBetAmountAndMakeBet(13);
                                break;
                            case 7:
                                chooseBetAmountAndMakeBet(11);
                                break;
                            case 8:
                                chooseBetAmountAndMakeBet(14);
                                break;
                            case 10:
                                chooseBetAmountAndMakeBet(16);
                                break;
                            case 11:
                                chooseBetAmountAndMakeBet(18);
                                break;
                            case 12:
                                chooseBetAmountAndMakeBet(20);
                                break;
                            default:
                                cd.printErrorMessage();
                                continue;
                        }
                        break;
                    default:
                        cd.printErrorMessage();
                        continue;
                }
                if(decisionUnmade) {
                    cd.youCanBetAgain();
                }
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



        while(notSevenedOut){
            while(decisionUnmade){
                cd.printSetTypeOfBet();
                input = c.getIntegerInput("Type 0 for no bet, 2 for 'come,' 3 for 'don't come,' or 4 for a proposition.");
                switch(input) {
                    case 1:
                        cd.printRulesMenu1();
                        cd.printRulesMenuMid();
                        innerInput = c.getIntegerInput("Type 1 for yes, 2 for no.");
                        switch (innerInput) {
                            case 1:
                                cd.printRulesMenu2();
                                break;
                            case 2:
                                break;
                            default:
                                cd.printErrorMessage();
                                continue;
                        }
                    case 2:
                        chooseBetAmountAndMakeBet(2);
                        break;
                    case 3:
                        chooseBetAmountAndMakeBet(3);
                        break;
                    case 0:
                        decisionUnmade = false;
                        break;
                    case 4:
                        furtherInput = c.getIntegerInput("Type 1 to bet the field, 2 for a place bet, or 3 for a one-roll bet.");
                        switch(furtherInput){
                            case 1:
                                chooseBetAmountAndMakeBet(4);
                                break;
                            case 2:
                                yetFurtherInput = c.getIntegerInput("Type the number you want to make your place bet on (4, 5, 6, 8, 9, or 10, but not the point.");
                                if(yetFurtherInput == point){
                                    cd.printErrorMessage();
                                    continue;
                                }
                                switch(yetFurtherInput){
                                    case 4:
                                        chooseBetAmountAndMakeBet(5);
                                        break;
                                    case 5:
                                        chooseBetAmountAndMakeBet(6);
                                        break;
                                    case 6:
                                        chooseBetAmountAndMakeBet(7);
                                        break;
                                    case 8:
                                        chooseBetAmountAndMakeBet(8);
                                        break;
                                    case 9:
                                        chooseBetAmountAndMakeBet(9);
                                        break;
                                    case 10:
                                        chooseBetAmountAndMakeBet(10);
                                        break;
                                    default:
                                        cd.printErrorMessage();
                                        continue;
                                }
                            case 3:
                                yetFurtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 7, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                                switch(yetFurtherInput) {
                                    case 1:
                                        chooseBetAmountAndMakeBet(12);
                                        break;
                                    case 2:
                                        chooseBetAmountAndMakeBet(19);
                                        break;
                                    case 3:
                                        chooseBetAmountAndMakeBet(17);
                                        break;
                                    case 4:
                                        chooseBetAmountAndMakeBet(15);
                                        break;
                                    case 6:
                                        chooseBetAmountAndMakeBet(13);
                                        break;
                                    case 7:
                                        chooseBetAmountAndMakeBet(11);
                                        break;
                                    case 8:
                                        chooseBetAmountAndMakeBet(14);
                                        break;
                                    case 10:
                                        chooseBetAmountAndMakeBet(16);
                                        break;
                                    case 11:
                                        chooseBetAmountAndMakeBet(18);
                                        break;
                                    case 12:
                                        chooseBetAmountAndMakeBet(20);
                                        break;
                                    case 0:
                                        continue;
                                    default:
                                        cd.printErrorMessage();
                                        continue;
                                }
                        }
                        break;
                    default:
                        cd.printErrorMessage();
                        continue;
                }
            }
            decisionUnmade = true;
            Integer x = diceRollSum(2);
            cd.printShooterRolled(x);
            checkBetsPostPoint(x, point);
            oneRollReset();
            if(x == 7){
                notSevenedOut = false;
                d.setPrintCurrentDisplay(endGame());
            }

        }


    }

    public void initialRulesPrompt(){
        cd.initalRulesAsk();
        Boolean haventAnswered = true;
        while(haventAnswered){
            input = c.getIntegerInput("Type 1 for yes, 2 for no.");
            switch(input) {
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
    }

    public void chooseBetAmountAndMakeBet(Integer x){
        Double middleMan;
        middleMan = c.getDoubleInput("How much money are you going to bet?");
        lastBet = player.makeBet(middleMan);
        betAmounts[x] = lastBet;
        bets[x] = true;
    }

    public void oneRollReset(){
        bets[4] = false;
        betAmounts[4] = 0.0;
        for(int i = 11; i < 21; i++){
            bets[i] = false;
            betAmounts[i] = 0.0;
        }
    }

    public void checkBetsPrePoint(Integer x){
        if(x == 2 && bets[19]){
            player.setWallet(betAmounts[19] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[19] * 60);
        }
        if(x == 2 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 2 && bets[1]){ //pass
            player.setWallet(betAmounts[1] * 2);
            cd.printCraps();
            cd.printWinnings(betAmounts[1] * 2);
        }
        if(x == 3 && bets[17]){
            player.setWallet(betAmounts[17] * 30);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[17] * 30);
        }
        if(x == 3 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 3 && bets[1]){ //pass
            player.setWallet(betAmounts[1] * 2);
            cd.printCraps();
            cd.printWinnings(betAmounts[1] * 2);
        }
        if(x == 4 && bets[15]){
            player.setWallet(betAmounts[15] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[15] * 14);
        }
        if(x == 6 && bets[13]){
            player.setWallet(betAmounts[13] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[13] * 18);
        }
        if(x == 7 && bets[11]){
            player.setWallet(betAmounts[11] * 8);
            cd.printNatural();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[11] * 8);
        }
        if(x == 7 && bets[0]){ //pass
            player.setWallet(betAmounts[0] * 2);
            cd.printNatural();
            cd.printWinnings(betAmounts[0] * 2);
        }
        if(x == 8 && bets[14]){
            player.setWallet(betAmounts[14] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[14] * 18);
        }
        if(x == 10 && bets[16]){
            player.setWallet(betAmounts[16] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[16] * 14);
        }
        if(x == 11 && bets[18]){
            player.setWallet(betAmounts[18] * 30);
            cd.printOneRollBetWin();
            cd.printNatural();
            cd.printWinnings(betAmounts[18] * 30);
        }
        if(x == 11 && bets[0]){ //pass
            player.setWallet(betAmounts[0] * 2);
            cd.printNatural();
            cd.printWinnings(betAmounts[0] * 2);
        }
        if(x == 12 && bets[20]){
            player.setWallet(betAmounts[20] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[20] * 60);
        }
        if(x == 12 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 12 && bets[1]){ //pass
            player.setWallet(betAmounts[1]);
            cd.printCraps();
            cd.printPush();
        }
    }

    public void checkBetsPostPoint(Integer x, Integer point){
        if(x == 2 && bets[19]){
            player.setWallet(betAmounts[19] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[19] * 60);
        }
        if(x == 2 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 3 && bets[17]){
            player.setWallet(betAmounts[17] * 30);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[17] * 30);
        }
        if(x == 3 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == 4 && bets[15]){
            player.setWallet(betAmounts[15] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[15] * 14);
        }
        if(x == 6 && bets[13]){
            player.setWallet(betAmounts[13] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[13] * 18);
        }
        if(x == 7 && bets[11]){
            player.setWallet(betAmounts[11] * 8);
            cd.printNatural();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[11] * 8);
        }
        if(x == 8 && bets[14]){
            player.setWallet(betAmounts[14] * 18);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[14] * 18);
        }
        if(x == 10 && bets[16]){
            player.setWallet(betAmounts[16] * 14);
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[16] * 14);
        }
        if(x == 11 && bets[18]){
            player.setWallet(betAmounts[18] * 30);
            cd.printOneRollBetWin();
            cd.printNatural();
            cd.printWinnings(betAmounts[18] * 30);
        }
        if(x == 12 && bets[20]){
            player.setWallet(betAmounts[20] * 60);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[20] * 60);
        }
        if(x == 12 && bets[12]){
            player.setWallet(betAmounts[12] * 14);
            cd.printCraps();
            cd.printOneRollBetWin();
            cd.printWinnings(betAmounts[12] * 14);
        }
        if(x == point){
            bets[3] = false;
            betAmounts[3] = 0.0;
        }
        if(x == 7){
            bets[2] = false;
            betAmounts [2] = 0.0;
        }
        if(x == point && bets[2]){
            player.setWallet(betAmounts[2]);
            cd.printShooterScores();
            cd.printWinnings(betAmounts[2]);
        }
        if(x == 7 && bets[3]){
            player.setWallet(betAmounts[3] * 2);
            cd.printShooterSevenedOut();
            cd.printWinnings(betAmounts[3] * 2);
        }
        if(x == 3 && bets[4] || x == 4 && bets[4] || x == 9 && bets[4] || x == 10 && bets[4] || x == 11 && bets[4]){
            player.setWallet(betAmounts[4] * 2);
            cd.printWinnings(betAmounts[4] * 2);
        }
        if(x == 2 && bets[4] || x == 12 && bets[4]){
            player.setWallet(betAmounts[4] * 4);
            cd.printWinnings(betAmounts[4] * 4);
        }
        if(x == 4 && bets[5]){
            player.setWallet(betAmounts[5] * 2);
            cd.printWinnings(betAmounts[5] * 2);
        }
        if(x == 5 && bets[6]){
            player.setWallet(betAmounts[6] * 2);
            cd.printWinnings(betAmounts[6] * 2);
        }
        if(x == 6 && bets[7]){
            player.setWallet(betAmounts[7] * 2);
            cd.printWinnings(betAmounts[7] * 2);
        }
        if(x == 8 && bets[8]){
            player.setWallet(betAmounts[8] * 2);
            cd.printWinnings(betAmounts[8] * 2);
        }
        if(x == 9 && bets[9]){
            player.setWallet(betAmounts[9] * 2);
            cd.printWinnings(betAmounts[9] * 2);
        }
        if(x == 10 && bets[10]){
            player.setWallet(betAmounts[10] * 2);
            cd.printWinnings(betAmounts[10] * 2);
        }
    }

    public String startGame() {
        return "Alright! Let's play Craps!";
    }

    public Double setPurse(Double betAmount) {
        return null;
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







